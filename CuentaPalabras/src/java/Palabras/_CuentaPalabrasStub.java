package Palabras;


/**
* Palabras/_CuentaPalabrasStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CuentaPalabras.idl
* viernes 14 de octubre de 2016 09:29:44 AM CDT
*/

public class _CuentaPalabrasStub extends org.omg.CORBA.portable.ObjectImpl implements Palabras.CuentaPalabras
{

  public int cuentaPalabras (String palabra)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("cuentaPalabras", true);
                $out.write_string (palabra);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return cuentaPalabras (palabra        );
            } finally {
                _releaseReply ($in);
            }
  } // cuentaPalabras

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Palabras/CuentaPalabras:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _CuentaPalabrasStub
