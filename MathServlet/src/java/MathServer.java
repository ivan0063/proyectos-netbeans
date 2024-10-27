import org.omg.CORBA.ORB;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;
import org.omg.CORBA.ORB; 
import org.omg.CosNaming.NamingContextPackage.*;   
import java.util.*;
import Arith.*;

public class MathServer {
		public static void main(String [] args){
			org.omg.CORBA.Object arithCorba,ncCorba;
			
			try{
				ORB orb=ORB.init(args,null);
				POA raizPOA=POAHelper.narrow(orb.resolve_initial_references(("RootPOA")));
				raizPOA.the_POAManager().activate();
				MultiplyServant arithServant=new MultiplyServant();
				arithCorba=raizPOA.servant_to_reference(arithServant);
				ncCorba=orb.resolve_initial_references("NameService");
				NamingContextExt nc=NamingContextExtHelper.narrow(ncCorba);
				nc.rebind(nc.to_name("Multiply"),arithCorba);
				System.out.println("Servidor central en espera...");
    		    orb.run();
			}catch(Exception e){}
		}
}

