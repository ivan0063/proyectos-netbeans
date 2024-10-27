package Compilador;

public class analizadorSintactico {
	private int[][] matriz;
	private char[] simbolos;
	private String[][] tabla;
	private int estadoIni;
	
	public analizadorSintactico(){
		matriz = new int[6][6];
		simbolos = new char[3];
		tabla = new String[6][3];
		estadoIni = 0;
		
		simbolos[0] = '<';
		simbolos[1] = '!';
		simbolos[2] = '-';
		
		//token
		tabla[0][0] = "no";
		tabla[0][1] = "no";
		tabla[0][2] = "no";
		tabla[0][3] = "no";
		tabla[0][4] = "no";
		tabla[0][5] = "comentario";
		
		//retrocesos
		tabla[1][0] = "no";
		tabla[1][1] = "no";
		tabla[1][2] = "no";
		tabla[1][3] = "no";
		tabla[1][4] = "si";
		tabla[1][5] = "no";
		
		//acepta
		tabla[2][0] = "no";
		tabla[2][1] = "no";
		tabla[2][2] = "no";
		tabla[2][3] = "no";
		tabla[2][4] = "no";
		tabla[2][5] = "si";
		
		matriz[0][0] = 2;
		matriz[0][1] = -1;
		matriz[0][2] = -1; 
		matriz[0][3] = -1;
		matriz[0][4] = -1;
		matriz[0][5] = -1;
		
		matriz[1][0] = -1;
		matriz[1][1] = 3;
		matriz[1][2] = -1;
		matriz[1][3] = -1;
		matriz[1][4] = -1;
		matriz[1][5] = -1;
		
		matriz[2][0] = -1;
		matriz[2][1] = -1;
		matriz[2][2] = 4;
		matriz[2][3] = -1;
		matriz[2][4] = -1;
		matriz[2][5] = -1;
		
		matriz[3][0] = -1;
		matriz[3][1] = -1;
		matriz[3][2] = -1; 
		matriz[3][3] = 5;
		matriz[3][4] = -1;
		matriz[3][5] = -1;
		
		matriz[4][0] = -1;
		matriz[4][1] = -1;
		matriz[4][2] = -1;
		matriz[4][3] = -1;
		matriz[4][4] = 5;
		matriz[4][5] = -1;
		
		matriz[5][0] = -1;
		matriz[5][1] = -1;
		matriz[5][2] = -1;
		matriz[5][3] = -1;
		matriz[5][4] = -1;
		matriz[5][5] = -1;
		
	}
	
	public int sigEstado(char caracter){
		int index = 0;
		boolean bandera = false;
		
		for (int i = 0; i < simbolos.length; i++){
			if(caracter == simbolos[i])
			{
				bandera = true;
				index = i;
				break;
			}
		}
		
		if(bandera)
			return index;
		else
			return -1;
		
	}
	
	public String analizadorLexico(String fuente){
		char[] caracteres = fuente.toCharArray();
		int estado = estadoIni;
		String seEsperaba = "";
		String salida = "Inicia Operacion\n";
		boolean error = false;
		int i = 0;
		int caracterActual;
		
		while(i != caracteres.length && error == false){
			caracterActual = sigEstado(caracteres[i]);
			
			if(caracterActual != -1)
			{
				estado = matriz[estado][caracterActual];
				if(tabla[estado][0] != "no"){
					salida = salida + " estado: " + estado + "se produce: " + tabla[estado][0] + "regresa a estado 1\n";
					estado = estadoIni;
				}else
					salida = salida + " estado: " + estado;
			}else{
				if()
			}
		}
		
		return salida;
	}
	
	public static void main(String[] args) {
		analizadorSintactico a = new analizadorSintactico();
		
		a.analizadorLexico("<!-- hola ke ase espacio");
	}
}
