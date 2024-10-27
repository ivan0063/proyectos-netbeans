import Arith.MultiplicationPOA;

public class MultiplyServant extends MultiplicationPOA{
	public void multiply(double x,double y,org.omg.CORBA.DoubleHolder z){
		z.value=x*y;
    }
}