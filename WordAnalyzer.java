import java.rmi.Remote;
import java.rmi.RemoteException;

public interface WordAnalyzer extends Remote {
    String findLongestWord(String filename) throws RemoteException;
    String findShortestWord(String filename) throws RemoteException;
    String[] analyzeWords(String filename) throws RemoteException;
}
