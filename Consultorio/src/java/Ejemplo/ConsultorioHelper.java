package Ejemplo;


/**
* Ejemplo/ConsultorioHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Consultorio.idl
* viernes 21 de octubre de 2016 09:35:16 AM CDT
*/

abstract public class ConsultorioHelper
{
  private static String  _id = "IDL:Ejemplo/Consultorio:1.0";

  public static void insert (org.omg.CORBA.Any a, Ejemplo.Consultorio that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Ejemplo.Consultorio extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Ejemplo.ConsultorioHelper.id (), "Consultorio");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Ejemplo.Consultorio read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ConsultorioStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Ejemplo.Consultorio value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Ejemplo.Consultorio narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Ejemplo.Consultorio)
      return (Ejemplo.Consultorio)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Ejemplo._ConsultorioStub stub = new Ejemplo._ConsultorioStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Ejemplo.Consultorio unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Ejemplo.Consultorio)
      return (Ejemplo.Consultorio)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Ejemplo._ConsultorioStub stub = new Ejemplo._ConsultorioStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
