import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import Ejemplo.*; 
import java.util.*;

public class ConsultorioServlet extends HttpServlet{
   Consultorio mulRef = null;   
   NamingContextExt ncRef = null;  
   NameComponent nc = null;
   
   public void init(ServletConfig config)throws ServletException{
	 super.init(config);
	 try{
            String args[]={"-ORBInitialPort", "1111"};
            ORB orb=ORB.init(args,null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            ncRef = NamingContextExtHelper.narrow(objRef);
            nc = new NameComponent("Consultorio","");	 		
	 }catch(Exception e){}
    }
    
   public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	//variables
        String doctor;
        String horario;
        String resp = "";
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String pag = "<html><head><title>Consultorio Online :v</title><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'></head><body><center><h1>Consultorio :v</h1></center><hr><form action='ConsultorioServlet'><h4>Nombre del doctor:</h4><br><input type='text' name='doctor' /><br><h4>Fecha:</h4><br><input type='date' name='horario'><br><br><input type='submit' value='Agendar'></form></body></html>";
        out.println(pag);
        
        doctor = request.getParameter("doctor");
        horario = request.getParameter("horario");
        
        if(doctor != null && horario != null){
            try{
	 	NameComponent path[]={nc};
	 	mulRef = ConsultorioHelper.narrow(ncRef.resolve(path));
	 	resp = mulRef.agendarConsulta(doctor , horario);
            }catch (Exception e) {}
            
            out.println("<div><h1>" + resp +"</h1></div>");
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
