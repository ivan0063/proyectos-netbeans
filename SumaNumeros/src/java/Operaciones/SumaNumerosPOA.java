package Operaciones;


/**
* Operaciones/SumaNumerosPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from suma.idl
* mi�rcoles 12 de octubre de 2016 06:07:02 PM CDT
*/

public abstract class SumaNumerosPOA extends org.omg.PortableServer.Servant
 implements Operaciones.SumaNumerosOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("suma", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Operaciones/SumaNumeros/suma
       {
         int x = in.read_long ();
         int y = in.read_long ();
         int $result = (int)0;
         $result = this.suma (x, y);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Operaciones/SumaNumeros:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public SumaNumeros _this() 
  {
    return SumaNumerosHelper.narrow(
    super._this_object());
  }

  public SumaNumeros _this(org.omg.CORBA.ORB orb) 
  {
    return SumaNumerosHelper.narrow(
    super._this_object(orb));
  }


} // class SumaNumerosPOA
