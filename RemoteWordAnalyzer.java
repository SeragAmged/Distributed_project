import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RemoteWordAnalyzer extends UnicastRemoteObject implements WordAnalyzer {
    public RemoteWordAnalyzer() throws RemoteException {
        super();
    }
    public  String[] analyzeWords(String filename) throws RemoteException {

        int shortestLength = Integer.MAX_VALUE;
        int longestLength = Integer.MIN_VALUE;
        String shortestWord = "";
        String longestWord = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // Remove punctuation
                    word = word.replaceAll("[^a-zA-Z]", "");
                    if (!word.isEmpty() && word.length() > 3) {
                        if (word.length() < shortestLength) {
                            shortestLength = word.length();
                            shortestWord = word;
                        }
                        if (word.length() > longestLength) {
                            longestLength = word.length();
                            longestWord = word;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // System.out.println("Shortest word: " + shortestWord);
        // System.out.println("Longest word: " + longestWord);
        return new String[]{shortestWord, longestWord};
    }


}
