package Operaciones;


/**
* Operaciones/SumaNumerosHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from suma.idl
* mi�rcoles 12 de octubre de 2016 06:07:02 PM CDT
*/

abstract public class SumaNumerosHelper
{
  private static String  _id = "IDL:Operaciones/SumaNumeros:1.0";

  public static void insert (org.omg.CORBA.Any a, Operaciones.SumaNumeros that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Operaciones.SumaNumeros extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Operaciones.SumaNumerosHelper.id (), "SumaNumeros");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Operaciones.SumaNumeros read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_SumaNumerosStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Operaciones.SumaNumeros value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Operaciones.SumaNumeros narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Operaciones.SumaNumeros)
      return (Operaciones.SumaNumeros)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Operaciones._SumaNumerosStub stub = new Operaciones._SumaNumerosStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Operaciones.SumaNumeros unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Operaciones.SumaNumeros)
      return (Operaciones.SumaNumeros)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Operaciones._SumaNumerosStub stub = new Operaciones._SumaNumerosStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
