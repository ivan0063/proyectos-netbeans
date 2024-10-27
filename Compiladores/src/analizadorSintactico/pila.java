package analizadorSintactico;

public class pila {
	private String[] pila;
	private int tope;
	
	public pila(){
		pila = new String[30];
		tope = -1;
	}
	
	public String peek()
	{
		if(tope > -1)
		{
			return pila[tope];
		}else
			return "No hay nada en la pila...";
	}
	
	public String pop(){
		int aux = tope;
		tope--;
		
		return pila[aux];
	}
	
	public void push(String nueva)
	{
		tope++;
		pila[tope] = nueva;
	}
	
	public String muestraPila()
	{
		String aux = "";
		for (int i = tope; i >=0; i--)
			aux = aux + pila[i];
		
		return aux;
	}
}
