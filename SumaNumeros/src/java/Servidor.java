import Operaciones.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class Servidor{
  public static void main(String args[])
  {
    try{
      ORB orb = ORB.init(args, null);

      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      SumaNumerosImpl opImpl = new SumaNumerosImpl();
      //opImpl.setORB(orb);

      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(opImpl);
      SumaNumeros href = SumaNumerosHelper.narrow(ref);

      org.omg.CORBA.Object objRef =orb.resolve_initial_references("NameService");
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      String name = "Suma";
      NameComponent path[] = ncRef.to_name( name );
      ncRef.rebind(path, href);

      System.out.println("Servidor listo y a la espera de conexiones ...");

      orb.run();
    }catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
  }
}
