import Operaciones.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

class SumaNumerosImpl extends SumaNumerosPOA {
    public int suma(int x , int y)
    {
      return x + y;
    }
}
