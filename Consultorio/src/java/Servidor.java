import Ejemplo.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class Servidor
{
    public static void main(String[] args) {
        try{
          ORB orb = ORB.init(args, null);

          POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
          rootpoa.the_POAManager().activate();

          ConsultorioImpl consultorioImpl = new ConsultorioImpl();
          org.omg.CORBA.Object ref = rootpoa.servant_to_reference(consultorioImpl);
          Consultorio href = ConsultorioHelper.narrow(ref);

          org.omg.CORBA.Object objRef =orb.resolve_initial_references("NameService");
          NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

          String name = "Consultorio";
          NameComponent[] path = ncRef.to_name( name );
          ncRef.rebind(path, href);

          System.out.println("Servidor listo y a la espera de conexiones ...");

          orb.run();

        }catch(Exception e)
        {System.out.println("ERROR SERV: " + e);}
    }
}
