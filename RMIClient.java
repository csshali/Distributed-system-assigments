package rmitransformer;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import com.tlacaelelsoft.rmiexample.Calculator;


public class RMIClient {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(4099);
        Transformer transformer = (Transformer) registry.lookup("Transformer");
        
        
        List<char[]> strings = new ArrayList<char[]>();
		
		strings.add("Hello World".toCharArray());
		strings.add("1aaacdeadd".toCharArray());
		strings.add("Test String".toCharArray());
		strings.add("2ayeaye!".toCharArray());
		char[] s1 = "A987654321".toCharArray(); 
	        char[] a1 = s1;	
		strings.add(s1);
		strings.add("Bye World".toCharArray());
		char[] s2 = "AXVI".toCharArray(); 
	        char[] a2 = s2;	
		strings.add(s2);
		System.out.println("Original strings:");
		strings.forEach(s -> System.out.print(new String(s) + ","));
		System.out.println();
		TransformerImpl td = new TransformerImpl();
		int t = td.transform(strings);
		System.out.println("There were " + t + " transformations");
		System.out.println("Modified strings:");
		strings.forEach(s -> System.out.print(new String(s) + ","));
		System.out.println();
		System.out.println("al1 is " + new String(a1));
		System.out.println("al2 is " + new String(a2));
        System.out.println();

    }

}
