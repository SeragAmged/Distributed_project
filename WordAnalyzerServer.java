import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class WordAnalyzerServer {
    public static void main(String[] args) {
        try {
            RemoteWordAnalyzer wordAnalyzer = new RemoteWordAnalyzer();//skelton
            LocateRegistry.createRegistry(1099);
            Naming.rebind("WordAnalyzer", wordAnalyzer);
            System.out.println("WordAnalyzer Server is ready.");
        } catch (Exception e) {
            System.err.println("WordAnalyzer Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
