package Arith;


/**
* Arith/OperacionesPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MathOperaciones.idl
* jueves 13 de octubre de 2016 08:41:43 PM CDT
*/

public abstract class OperacionesPOA extends org.omg.PortableServer.Servant
 implements Arith.OperacionesOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("suma", new java.lang.Integer (0));
    _methods.put ("resta", new java.lang.Integer (1));
    _methods.put ("multiplica", new java.lang.Integer (2));
    _methods.put ("divide", new java.lang.Integer (3));
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
       case 0:  // Arith/Operaciones/suma
       {
         double x = in.read_double ();
         double y = in.read_double ();
         double $result = (double)0;
         $result = this.suma (x, y);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 1:  // Arith/Operaciones/resta
       {
         double x = in.read_double ();
         double y = in.read_double ();
         double $result = (double)0;
         $result = this.resta (x, y);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 2:  // Arith/Operaciones/multiplica
       {
         double x = in.read_double ();
         double y = in.read_double ();
         double $result = (double)0;
         $result = this.multiplica (x, y);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 3:  // Arith/Operaciones/divide
       {
         double x = in.read_double ();
         double y = in.read_double ();
         double $result = (double)0;
         $result = this.divide (x, y);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Arith/Operaciones:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Operaciones _this() 
  {
    return OperacionesHelper.narrow(
    super._this_object());
  }

  public Operaciones _this(org.omg.CORBA.ORB orb) 
  {
    return OperacionesHelper.narrow(
    super._this_object(orb));
  }


} // class OperacionesPOA
