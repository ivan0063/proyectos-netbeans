import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import Palabras.*; 
import java.util.*;

public class PalabrasServlet extends HttpServlet{
   CuentaPalabras mulRef = null;   
   NamingContextExt ncRef = null;  
   NameComponent nc = null;
   
   public void init(ServletConfig config)throws ServletException{
	 super.init(config);
	 try{
            String args[]={"-ORBInitialPort", "1111"};
            ORB orb=ORB.init(args,null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            ncRef = NamingContextExtHelper.narrow(objRef);
            nc = new NameComponent("CuentaPalabras","");	 		
	 }catch(Exception e){}
    }
    
   public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	//variables
        int count = 0;
        String palabra = "";
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String pag = "<html><head><title>Palabras</title><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'></head><body><div><h1>CUENTA PALABRAS!!!!</h1><hr></div><form action='PalabrasServlet' method='Post'><p>Dame uan palabra:</p><br><input type='text' size='20' name='pal' /><br><input type='submit' name='submit' value='contar'><br></form>";
        out.println(pag);
        
        palabra = request.getParameter("pal");
        
        if(palabra != null){
            try{
	 	NameComponent path[]={nc};
	 	mulRef = CuentaPalabrasHelper.narrow(ncRef.resolve(path));
	 	count = mulRef.cuentaPalabras(palabra);
            }catch (Exception e) {}
            
            out.println("<div><p>El numero de palabras de: '" + palabra +"' es "+ count +"</p></div>");
        }
        
        out.println("</body>");
        out.println("</html>");
    }
	 
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
    {
        doGet(request, response);
    }
}
