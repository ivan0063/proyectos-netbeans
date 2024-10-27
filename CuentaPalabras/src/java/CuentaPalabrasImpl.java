import Palabras.*;


public class CuentaPalabrasImpl extends CuentaPalabrasPOA{
    @Override
    public int cuentaPalabras(String palabra) {
        int count = 0;
        
       String[] pal = palabra.split(" ");
       
        for (int i = 0; i < pal.length; i++)
             count++;
        
        return count;
    }    
}
