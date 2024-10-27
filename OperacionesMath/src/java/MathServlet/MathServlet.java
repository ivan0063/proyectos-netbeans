import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import Arith.*;
import java.util.*;

public class MathServlet extends HttpServlet{
   Operaciones mulRef = null;   
   NamingContextExt ncRef = null;  
   NameComponent nc = null;
   
   public void init(ServletConfig config)throws ServletException{
	 super.init(config);
	 try{
            String args[]={"-ORBInitialPort", "1111"};
            ORB orb=ORB.init(args,null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            ncRef = NamingContextExtHelper.narrow(objRef);
            nc = new NameComponent("Operaciones","");
	 		
	 }catch(Exception e){}
    }
    
   public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	double x=0.0;double y=0.0;
        double s = 0.0;
        double r = 0.0;
        double m = 0.0;
        double d = 0.0;
        
	//org.omg.CORBA.DoubleHolder z=new DoubleHolder();
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
	out.println("<title>Servlet <==> CORBA Communication</title>");
	out.println("</head>");
	out.println("<body bgcolor=\"#ffffcc\" text=\"006666\" >");
        
        String fn=request.getParameter("fn");
	String sn=request.getParameter("sn");
	   
        out.println("<form action=\"MathServlet\" method=\"POST\" >");
	out.println("Number 1: <input type=text size=10 name=\"fn\">");
	out.println("<br>");
	out.println("Number 2: <input type=text size=10 name=\"sn\">");
	out.println("<br>");
	out.println("<input type=submit value=\"MultiplyNumbers\">");
        out.println("</form>");
       
        if(fn!=null && sn!=null){
            try{
	 	x=(Double.valueOf(fn)).doubleValue();
	 	y=(Double.valueOf(sn)).doubleValue();
            }catch(NumberFormatException nfe){}
            
            try{
	 	NameComponent path[]={nc};
	 	mulRef = OperacionesHelper.narrow(ncRef.resolve(path));
	 	s = mulRef.suma(x, y);
                r = mulRef.resta(x, y);
                m = mulRef.multiplica(x, y);
                d = mulRef.divide(x, y);
            }catch (Exception e) {}

            out.println("<h3>La suma de "+ x + " + " + y + " = "+ s +"</h3>");
            out.println("<h3>La resta de "+ x + " - " + y + " = "+ r +"</h3>");
            out.println("<h3>La multiplicacion de "+ x + " * " + y + " = "+ m +"</h3>");
            out.println("<h3>La divicion de "+ x + " / " + y + " = "+ d +"</h3>");
	} else out.println("");
        
        out.println("</body>");
        out.println("</html>");
    }
	 
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
    {
        doGet(request, response);
    }
}
