package Arith;


/**
* arith/MultiplicationPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from arith.idl
* viernes 27 de septiembre de 2013 07:09:01 AM CDT
*/

public abstract class MultiplicationPOA extends org.omg.PortableServer.Servant
 implements Arith.MultiplicationOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("multiply", new java.lang.Integer (0));
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
       case 0:  // arith/Multiplication/multiply
       {
         double x = in.read_double ();
         double y = in.read_double ();
         org.omg.CORBA.DoubleHolder z = new org.omg.CORBA.DoubleHolder ();
         this.multiply (x, y, z);
         out = $rh.createReply();
         out.write_double (z.value);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:arith/Multiplication:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Multiplication _this() 
  {
    return MultiplicationHelper.narrow(
    super._this_object());
  }

  public Multiplication _this(org.omg.CORBA.ORB orb) 
  {
    return MultiplicationHelper.narrow(
    super._this_object(orb));
  }


} // class MultiplicationPOA
