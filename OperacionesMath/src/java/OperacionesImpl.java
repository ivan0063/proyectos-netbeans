import Arith.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class OperacionesImpl extends OperacionesPOA {

    @Override
    public double suma(double x, double y) {
        return x + y;
    }

    @Override
    public double resta(double x, double y) {
        return x - y;
    }

    @Override
    public double multiplica(double x, double y) {
        return x * y;
    }

    @Override
    public double divide(double x, double y) {
        return x / y;
    }
}
