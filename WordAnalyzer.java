import java.rmi.Remote;
import java.rmi.RemoteException;

public interface WordAnalyzer extends Remote {
    String[] analyzeWords(String filename) throws RemoteException;

}
