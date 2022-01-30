package rmitransformer;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Transformer extends Remote{
	public int transform(List<char[]> strings) throws RemoteException;
	
	

}
