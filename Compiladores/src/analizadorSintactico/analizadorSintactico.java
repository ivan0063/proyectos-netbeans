package analizadorSintactico;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class analizadorSintactico extends JFrame implements ActionListener{
		//variables del analizador sintactico
		private String[] estados;
		private String[] predictivos;
		private String[][] matriz;
		private String[] palabras;
		private pila pila;
		private String mensaje_pila , mensaje_accion;
		//variables de la interfaz
		private JLabel titulo_LB,cadena_LB,pila_LB,accion_LB;
		private JScrollPane pila_scroll , accion_scroll;
		private JTextArea cadena_txt , pila_txt , accion_txt;
		private JButton cargar_btn , comenzar_btn;
		private Font font;

		public analizadorSintactico(){
			super("Analizador Sintactico");

			mensaje_pila = "";
			mensaje_accion = "";
			estados = new String[7];
			predictivos = new String[7];
			matriz = new String[7][7];
			pila = new pila();

			estados[0] = "S";
			estados[1] = "A";
			estados[2] = "A'";
			estados[3] = "B";
			estados[4] = "C";
			estados[5] = "D";
			estados[6] = "E";

			predictivos[0] = "destinatario";
			predictivos[1] = "persona";
			predictivos[2] = "asunto";
			predictivos[3] = ",";
			predictivos[4] = "texto";
			predictivos[5] = "cuerpo";
			predictivos[6] = "$";

			for (int i = 0; i < 7; i++)
				for (int j = 0; j < 7; j++)
					matriz[i][j] = "error";

			matriz[0][0]="destinatario : A";
			matriz[1][1]="persona A'";
			matriz[2][2]="B";
			matriz[2][3]=", A";
			matriz[3][2]="asunto : C";
			matriz[4][4]="texto D";
			matriz[4][5]="D";
			matriz[5][5]="cuerpo : E";
			matriz[6][4]="texto";
			matriz[6][6]="";

			init();
		}

		public void init(){
			this.setVisible(true);
			this.setSize(1300, 800);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLayout(null);
			
			font = new Font("Arial Black" , 1 , 15);

			titulo_LB = new JLabel("ANALIZADOR SINTACTICO!!");
			titulo_LB.setVisible(true);
			titulo_LB.setBounds(20 , 20 , 300 , 50);
			this.add(titulo_LB);

			cadena_LB = new JLabel("CADENA:");
			cadena_LB.setVisible(true);
			cadena_LB.setBounds(50 , 100 , 300 , 20);
			this.add(cadena_LB);

			cadena_txt = new JTextArea();
			cadena_txt.setVisible(true);
			cadena_txt.setFont(font);
			cadena_txt.setBounds(25 , 150 , 320 , 500);
			this.add(cadena_txt);

			cargar_btn = new JButton("CARGAR");
			cargar_btn.setVisible(true);
			cargar_btn.addActionListener(this);
			cargar_btn.setBounds(50 , 670 , 100 , 20);
			this.add(cargar_btn);

			pila_LB = new JLabel("PILA:");
			pila_LB.setVisible(true);
			pila_LB.setBounds(400 , 100 , 300 , 15);
			this.add(pila_LB);

			pila_txt = new JTextArea();
			pila_txt.setVisible(true);
			pila_txt.setFont(font);
			pila_txt.setEditable(false);

			pila_scroll = new JScrollPane(pila_txt);
			pila_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			pila_scroll.setBounds(370 , 150 , 400 , 500);
			this.add(pila_scroll);

			accion_LB = new JLabel("ACCION");
			accion_LB.setVisible(true);
			accion_LB.setBounds(800 , 100 , 300 , 15);
			this.add(accion_LB);

			accion_txt = new JTextArea();
			accion_txt.setVisible(true);
			accion_txt.setEditable(false);
			accion_txt.setFont(font);

			accion_scroll = new JScrollPane(accion_txt);
			accion_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			accion_scroll.setBounds(800 , 150 , 400 , 500);
			this.add(accion_scroll);

			comenzar_btn = new JButton("COMENZAR");
			comenzar_btn.setVisible(true);
			comenzar_btn.addActionListener(this);
			comenzar_btn.setBounds(1120 , 50 , 100 , 50);
			comenzar_btn.setEnabled(false);
			this.add(comenzar_btn);

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cargar_btn)
			{
				JOptionPane.showMessageDialog(null, "LA CADENA SE A CARGADO YA PUEDE COMENZAR EL PROCESO");
				cargarCadena(cadena_txt.getText());
				cargar_btn.setEnabled(false);
				comenzar_btn.setEnabled(true);
			}else if(e.getSource() == comenzar_btn)
			{
				analizadorSintactico();
				cargar_btn.setEnabled(true);
				comenzar_btn.setEnabled(false);
				palabras = null;
				JOptionPane.showMessageDialog(null, "PROCESO TERMINADO...");
			}
		}

		//Carga la cadena para poder procesarla
		public void cargarCadena(String caden){
			String[] aux = caden.split("\n");
			String c_aux = "";

			for (int i = 0; i < aux.length; i++){
				if(i == 0)
					c_aux = c_aux + aux[i];
				else
					c_aux = c_aux + " " + aux[i];
			}

			palabras = c_aux.split(" ");


			for (int i = 0; i < palabras.length; i++)
				System.out.println("pos: " + i + " " + palabras[i] + "-->");
		}

		//Analizador lexico
		public void analizadorSintactico(){
			pila.push("$");
			pila.push("S");
			
			int i = 0;
			mensaje_pila = mensaje_pila + pila.muestraPila() + "\n";
			pila_txt.setText(mensaje_pila);

			//ciclo
			while(true)
			{
				if(i < palabras.length)
				{
					if(esNoTerminal(pila.peek()))
					{
						int index_estado = this.getIndexEstado(pila.peek());
						int index_predictivo = this.getIndexPredectivos(palabras[i]);
						
						if(!matriz[index_estado][index_predictivo].equals("error"))
						{
							String[] aux = matriz[index_estado][index_predictivo].split(" ");
							String a = pila.pop();
							
							for(int p = aux.length-1; p >= 0 ; p--)
								pila.push(aux[p]);
							
							mensaje_accion = mensaje_accion + a + "-->" + matriz[index_estado][index_predictivo] + "\n";
							mensaje_pila = mensaje_pila + pila.muestraPila() + "\n";
							pila_txt.setText(mensaje_pila);
							accion_txt.setText(mensaje_accion);
						}else
						{
							mensaje_accion = mensaje_accion + "------ERROR--"+ pila.peek() +" no puede producir " + palabras[i] + " :'v------\n";
							mensaje_accion = mensaje_accion + "SE ESPERABA:\n" + seEsperaba(index_estado) + "\n";
							mensaje_pila = mensaje_pila + "------ERROR--"+ pila.peek() +" no puede producir " + palabras[i] + ":'v------\n";
							pila_txt.setText(mensaje_pila);
							accion_txt.setText(mensaje_accion);
							break;
						}
					}else
					{
						if(pila.peek().equals(palabras[i]))
						{
							String aux = pila.pop();
							mensaje_accion = mensaje_accion + "**************emparejar(" + aux + ")**************\n";
							mensaje_pila = mensaje_pila + pila.muestraPila() + "\n";
							pila_txt.setText(mensaje_pila);
							accion_txt.setText(mensaje_accion);
							i++;
						}else
						{
							mensaje_accion = mensaje_accion + "------ERROR LA CADENA NO SE RECONOCE :'v------\n";
							mensaje_pila = mensaje_pila + "------ERROR LA CADENA NO SE RECONOCE :'v------\n";
							pila_txt.setText(mensaje_pila);
							accion_txt.setText(mensaje_accion);
							break;
						}
					}
				}else
				{
					if(pila.peek() == "$"){
						mensaje_pila = mensaje_pila + "Cadena aceptada!!!!! :v\n";
						mensaje_accion = mensaje_accion + "Cadena aceptada!!!!! :v\n";
						pila_txt.setText(mensaje_pila);
						accion_txt.setText(mensaje_accion);
						break;
					}else
					{
						mensaje_pila = mensaje_pila + "Cadena NO aceptada!!!!! :'v\n";
						mensaje_accion = mensaje_accion + "Cadena NO aceptada!!!!! :'v\n";
						pila_txt.setText(mensaje_pila);
						accion_txt.setText(mensaje_accion);
						break;
					}
				}
			}

		}

		public boolean esNoTerminal(String variable)
		{
			boolean aux = false;

			for (int i = 0; i < estados.length; i++) {
				if(estados[i].equals(variable))
				{
					aux = true;
					break;
				}
			}

			return aux;
		}

		public int getIndexEstado(String noTerminal){
			int index = -1;

			for (int i = 0; i < estados.length; i++) {
				if(estados[i].equals(noTerminal))
				{
					index = i;
					break;
				}
			}

			return index;
		}
		public int getIndexPredectivos(String terminal){
			int index = -1;

			for (int i = 0; i < predictivos.length; i++) {
				if(predictivos[i].equals(terminal))
				{
					index = i;
					break;
				}
			}

			return index;
		}
		
		public String seEsperaba(int index_estado)
		{
			String ret = "";
			
			for (int i = 1; i < predictivos.length; i++) {
				if(!matriz[index_estado][i].equals("error"))
					ret = ret + "\n*" +predictivos[i];
			}
			
			return ret;
		}

		public static void main(String[] args) {
			analizadorSintactico a = new analizadorSintactico();
		}
}
