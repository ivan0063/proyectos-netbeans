package analizadorLexico;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class analizadorLexico extends JFrame implements ActionListener{
	//variables del analizador
	private String[] variables;
	private String[] token;
	private int[][] matriz;
	private String cad,desc;
	private int index,estado , estado_aux;
	//variables de la interfaz
	private JLabel int_cad , proc;
	private JTextArea proceso , correo;
	private JTextField caracter;
	private JButton cargar , siguiente;
	private JScrollPane scroll;
	private Font font;
	
	
	public analizadorLexico(){
		super("Analizador Lexico");
		index = 0;
		estado = 0;
		estado_aux = 0;
		cad = "";
		desc = "";
		variables = new String[24];
		token= new String[52];
		matriz = new int[52][24];
		
		variables[0] = "h";
		variables[1] = "o";
		variables[2] = "t";
		variables[3] = "m";
		variables[4] = "a";
		variables[5] = "i";
		variables[6] = "l";
		variables[7] = "g";
		variables[8] = "y";
		variables[9] = "@";
		variables[10] = ".";
		variables[11] = "c";
		variables[12] = "u";
		variables[13] = "e";
		variables[14] = "r";
		variables[15] = "p";
		variables[16] = "s";
		variables[17] = "n";
		variables[18] = "d";
		variables[19] = ":";
		variables[20] = ",";
		variables[21] = "letras";
		variables[22] = "simbolos";
		variables[23] = "otro";
		
		token[0] = "no";
		token[1] = ",";
		token[2] = ":";
		token[3] = "no";
		token[4] = "no";
		token[5] = "no";
		token[6] = "no";
		token[7] = "no";
		token[8] = "no";
		token[9] = "no";
		token[10] = "no";
		token[11] = "no";
		token[12] = "no";
		token[13] = "no";
		token[14] = "destinatario";
		token[15] = "no";
		token[16] = "no";
		token[17] = "no";
		token[18] = "no";
		token[19] = "no";
		token[20] = "asunto";
		token[21] = "no";
		token[22] = "no";
		token[23] = "no";
		token[24] = "no";
		token[25] = "no";
		token[26] = "cuerpo";
		token[27] = "no";
		token[28] = "no";
		token[29] = "no";
		token[30] = ".com";
		token[31] = "no";
		token[32] = "texto";
		token[33] = "texto";
		token[34] = "texto@";
		token[35] = "no";
		token[36] = "no";
		token[37] = "no";
		token[38] = "no";
		token[39] = "no";
		token[40] = "no";
		token[41] = "hotmail";
		token[42] = "no";
		token[43] = "no";
		token[44] = "no";
		token[45] = "no";
		token[46] = "gmail";
		token[47] = "no";
		token[48] = "no";
		token[49] = "no";
		token[50] = "no";
		token[51] = "yahoo";
		
		for (int i = 0; i < 52; i++)
			for (int j = 0; j < 24; j++)
				matriz[i][j] = -1;
		
		//Estado 1
		matriz[0][0] = 35;
		matriz[0][4] = 15;
		matriz[0][7] = 42;
		matriz[0][8] = 47;
		matriz[0][10] = 27;
		matriz[0][11] = 21;
		matriz[0][18] = 3;
		matriz[0][19] = 2;
		matriz[0][20] = 1;
		matriz[0][21] = 31;
		matriz[0][22] = 31;
		//Estado 4
		matriz[3][13] = 4;
		matriz[3][21] = 31;
		matriz[3][22] = 31;
		//Estado 5
		matriz[4][16] = 5;
		matriz[4][21] = 31;
		matriz[4][22] = 31;
		//Estado 6
		matriz[5][2] = 6;
		matriz[5][21] = 31;
		matriz[5][22] = 31;
		//Estado 7
		matriz[6][5] = 7;
		matriz[6][21] = 31;
		matriz[6][22] = 31;
		//Estado 8
		matriz[7][17] = 8;
		matriz[7][21] = 31;
		matriz[7][22] = 31;
		//Estado 9
		matriz[8][4] = 9;
		matriz[8][21] = 31;
		matriz[8][22] = 31;
		//Estado 10
		matriz[9][2] = 10;
		matriz[9][21] = 31;
		matriz[9][22] = 31;
		//Estado 11
		matriz[10][4] = 11;
		matriz[10][21] = 31;
		matriz[10][22] = 31;
		//Estado 12
		matriz[11][14] = 12;
		matriz[11][21] = 31;
		matriz[11][22] = 31;
		//Estado 13
		matriz[12][5] = 13;
		matriz[12][21] = 31;
		matriz[12][22] = 31;
		//Estado 14
		matriz[13][1] = 14;
		matriz[13][21] = 31;
		matriz[13][22] = 31;
		//Estado 16
		matriz[15][16] = 16;
		matriz[15][21] = 31;
		matriz[15][22] = 31;
		//Estado 17
		matriz[16][12] = 17;
		matriz[16][21] = 31;
		matriz[16][22] = 31;
		//Estado 18
		matriz[17][17] = 18;
		matriz[17][21] = 31;
		matriz[17][22] = 31;
		//Estado 19
		matriz[18][2] = 19;
		matriz[18][21] = 31;
		matriz[18][22] = 31;
		//Estado 20
		matriz[19][1] = 20;
		matriz[19][21] = 31;
		matriz[19][22] = 31;
		//Estado 22
		matriz[21][12] = 22;
		matriz[21][21] = 31;
		matriz[21][22] = 31;
		//Estado 23
		matriz[22][13] = 23;
		matriz[22][21] = 31;
		matriz[22][22] = 31;
		//Estado 24
		matriz[23][14] = 24;
		matriz[23][21] = 31;
		matriz[23][22] = 31;
		//Estado 25
		matriz[24][15] = 25;
		matriz[24][21] = 31;
		matriz[24][22] = 31;
		//Estado 26
		matriz[25][1] = 26;
		matriz[25][21] = 31;
		matriz[25][22] = 31;
		//Estado 28
		matriz[27][11] = 28;
		matriz[27][21] = 31;
		matriz[27][22] = 31;
		//Estado 29
		matriz[28][1] = 29;
		matriz[28][21] = 31;
		matriz[28][22] = 31;
		//Estado 30
		matriz[29][3] = 30;
		matriz[29][21] = 31;
		matriz[29][22] = 31;
		//Estado 32
		matriz[31][10] = 32;
		matriz[31][21] = 31;
		matriz[31][22] = 31;
		matriz[31][9] = 34;
		//Estado 33
		matriz[32][23] = 33;
		matriz[32][21] = 31;
		matriz[32][22] = 31;
		//Estado 36
		matriz[35][1] = 36;
		matriz[35][21] = 31;
		matriz[35][22] = 31;
		//Estado 37
		matriz[36][2] = 37;
		matriz[36][21] = 31;
		matriz[36][22] = 31;
		//Estado 38
		matriz[37][3] = 38;
		matriz[37][21] = 31;
		matriz[37][22] = 31;
		//Estado 39
		matriz[38][4] = 39;
		matriz[38][21] = 31;
		matriz[38][22] = 31;
		//Estado 40
		matriz[39][5] = 40;
		matriz[39][21] = 31;
		matriz[39][22] = 31;
		//Estado 41
		matriz[40][6] = 41;
		matriz[40][21] = 31;
		matriz[40][22] = 31;
		//Estado 43
		matriz[42][3] = 43;
		matriz[42][21] = 31;
		matriz[42][22] = 31;
		//Estado 44
		matriz[43][4] = 44;
		matriz[43][21] = 31;
		matriz[43][22] = 31;
		//Estado 45
		matriz[44][5] = 45;
		matriz[44][21] = 31;
		matriz[44][22] = 31;
		//Estado 46
		matriz[45][6] = 46;
		matriz[45][21] = 31;
		matriz[45][22] = 31;
		//Estado 48
		matriz[47][4] = 48;
		matriz[47][21] = 31;
		matriz[47][22] = 31;
		//Estado 49
		matriz[48][0] = 49;
		matriz[48][21] = 31;
		matriz[48][22] = 31;
		//Estado 50
		matriz[49][1] = 50;
		matriz[49][21] = 31;
		matriz[49][22] = 31;
		//Estado 51
		matriz[50][1] = 51;
		matriz[50][21] = 31;
		matriz[50][22] = 31;
		
		init();
	}

	public void init(){
		this.setSize(950 , 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		font = new Font("Arial Black" , 1 , 13);
		
		int_cad = new JLabel("INGRESE SU CORREO:");
		int_cad.setVisible(true);
		int_cad.setBounds(50, 25, 150, 20);
		this.add(int_cad);
		
		correo = new JTextArea();
		correo.setVisible(true);
		correo.setFont(font);
		correo.setBounds(50 , 50 , 300 , 300);
		this.add(correo);
		
		cargar = new JButton("CARGAR");
		cargar.setVisible(true);
		cargar.setBounds(50 , 400 , 100 , 30);
		cargar.addActionListener(this);
		this.add(cargar);
		
		proc = new JLabel("PROCESO DE EJECUCION");
		proc.setVisible(true);
		proc.setBounds(400, 25, 150, 20);
		this.add(proc);
		
		
		proceso = new JTextArea();
		proceso.setVisible(true);
		proceso.setFont(font);
		scroll = new JScrollPane(proceso);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(400 , 50 , 300 , 300);
		this.add(scroll);
		
		caracter = new JTextField();
		caracter.setVisible(true);
		caracter.setEditable(false);
		caracter.setFont(font);
		caracter.setBounds(400, 400, 60, 30);
		this.add(caracter);
		
		siguiente = new JButton("SIGUIENTE");
		siguiente.setVisible(true);
		siguiente.setEnabled(false);
		siguiente.addActionListener(this);
		siguiente.setBounds(480 , 400 , 100 , 30);
		this.add(siguiente);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == cargar)
		{
			String aux = correo.getText();
			String[] aux1 , aux2;
			
			aux1 = aux.split(" ");
			aux = "";
			
			for (int i = 0; i < aux1.length; i++)
				aux = aux + aux1[i];
			
			aux2 = aux.split("\n");
			
			for (int i = 0; i < aux2.length; i++)
				cad = cad + aux2[i];
			
			siguiente.setEnabled(true);
			cargar.setEnabled(false);
			JOptionPane.showMessageDialog(null, "La cadena se a cargado\n ya puedes comenzar el proceso");
			caracter.setText(cad.charAt(index) + "");		
		}else if(event.getSource() == siguiente)
		{
			if(index < cad.length())
			{
				char c = cad.charAt(index);
				int index_variables = getIndexVariables(c + "");
				
				if(index_variables == -1 || matriz[estado_aux][index_variables] == -1)
				{
					desc = desc + "Estoy en estado: " + estado_aux + "\n  -->Me muevo al estado 31 con " + c + "\n";
					estado_aux = 31;
				}else
				{
					desc = desc + "Estoy en estado " + estado_aux + "\n";
					estado_aux = matriz[estado_aux][index_variables];
					desc = desc + "  -->Me muevo al estado " + estado_aux + " con " + c +"\n";
				}
				index++;
			}else{
				desc = desc + "*********************PROCESO TERMINADO!!!!!!!*******************\n";
				if(estado_aux != 0)
					desc = desc + "ERROR ME QUEDE EN ESTADO NO FINAL\n";
				estado_aux = 0;
				index = 0;
				cad = "";
				siguiente.setEnabled(false);
				cargar.setEnabled(true);
			}
			
			if(!token[estado_aux].equals("no"))
			{
				desc = desc + "SE PRODUJO " + token[estado_aux] + "\n";
				estado_aux = 0;
			}
			
			proceso.setText(desc);
			if(index >= cad.length())
				caracter.setText("");
			else
				caracter.setText(cad.charAt(index) + "");
		}
	}
	
	public int getIndexVariables(String var)
	{
		int j = -1;
		
		for (int i = 0; i < variables.length; i++){
			if(var.equals(variables[i])){
				System.out.println("Enontre " + variables[i] + " en indice: " + i);
				j = i;
				break;
			}
		}
		
		System.out.println("Voy a retornar " + j);
		return j;
	}
	
	public static void main(String[] args) {
		analizadorLexico a = new analizadorLexico();
	}
}
