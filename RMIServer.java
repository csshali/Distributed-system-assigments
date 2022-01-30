package rmitransformer;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.tlacaelelsoft.rmiexample.Calculator;
import com.tlacaelelsoft.rmiexample.CalculatorRemoteImpl;


public class RMIServer {
    public static void main(String [] args) throws RemoteException, AlreadyBoundException {
    	TransformerImpl transformer =new TransformerImpl();

        Registry registry = LocateRegistry.createRegistry(4099);
        registry.bind("Transformer",transformer);

        System.out.println("RMI Server started");

    }

}
