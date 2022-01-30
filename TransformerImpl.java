package rmitransformer;
import java.util.*;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class TransformerImpl extends UnicastRemoteObject implements Transformer{

	public int transform(List<char[]> strings) throws RemoteException{
		List<char[]> toRemove = new ArrayList<char[]>();
		int modified = 0;
		for (int i = 0; i < strings.size(); i++) {
			char[] chars = strings.get(i);	
			int c = chars[0];
			if (c >= '0' && c <= '9') { 	
				for (int j = 1; j < chars.length; j++)
					if (chars[j] == 'a')
						chars[j] = 'b';	
				modified++;	
			}
			else if (c == 'A') {
				int right = chars.length - 1;
				for (int left = 1; left < right; left++, right--) {
					char temp = chars[left];
					chars[left] = chars[right];
					chars[right] = temp;
				}
				toRemove.add(chars);
				modified++;	
			}	
		}
		for (char[] removal : toRemove)
			strings.remove(removal);
		return modified;	
	}	

	protected TransformerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
