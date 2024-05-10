// import java.rmi.Naming;
// import javax.swing.JFileChooser;
// import javax.swing.JFrame;
// import javax.swing.JOptionPane;

// public class WordAnalyzerClientGUI {
//     public static void main(String[] args) {
//         JFrame frame = new JFrame("Word Analyzer Client");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         JFileChooser fileChooser = new JFileChooser();
//         int result = fileChooser.showOpenDialog(frame);
//         if (result == JFileChooser.APPROVE_OPTION) {
//             try {
//                 WordAnalyzerInterface wordAnalyzer = (WordAnalyzerInterface) Naming.lookup("//localhost/WordAnalyzer");
//                 String filename = fileChooser.getSelectedFile().getAbsolutePath();
//                 String [] analysis = wordAnalyzer.analyzeWords(filename);
//                 JOptionPane.showMessageDialog(frame, "Shortest Word:: " + analysis[0] + "\nLongest Word:: " + analysis[1]+"\n");
//                 // String longestWord = obj.findLongestWord(filename);
//                 // String shortestWord = obj.findShortestWord(filename);
//                 // JOptionPane.showMessageDialog(frame, "Shortest Word: " + shortestWord + "\nLongest Word: " + longestWord);
//             } catch (Exception e) {
//                 JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                 e.printStackTrace();
//             }
//         } else {
//             JOptionPane.showMessageDialog(frame, "No file selected.", "Error", JOptionPane.ERROR_MESSAGE);
//         }

//         frame.pack();
//         frame.setVisible(true);
//     }
// }

//*********** */


import java.rmi.Naming;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;


public class WordAnalyzerClientGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Word Analyzer Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300); // Increased the frame size
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        JPanel panel = new JPanel(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel("Word Analyzer");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Increased font size
        titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JButton startButton = new JButton("Start Analysis");
        startButton.setFont(new Font("Arial", Font.PLAIN, 18)); // Increased font size

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performAnalysis(frame);
            }
        });

        centerPanel.add(Box.createVerticalStrut(40)); // Increased spacing
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createVerticalStrut(40));
        centerPanel.add(startButton);
        centerPanel.add(Box.createVerticalStrut(40));

        panel.add(centerPanel, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void performAnalysis(JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();
        
        // Set file filter to accept only .txt files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);
        
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                WordAnalyzer wordAnalyzer = (WordAnalyzer) Naming.lookup("//localhost/WordAnalyzer");
                String filename = fileChooser.getSelectedFile().getAbsolutePath();
                String[] analysis = wordAnalyzer.analyzeWords(filename);
                
                // Create two JLabels for each message
                JLabel shortestWordLabel = new JLabel("Shortest Word:: " + analysis[0]);
                JLabel longestWordLabel = new JLabel("Longest Word:: " + analysis[1]);
                
                // Set font size for messages
                Font messageFont = new Font("Arial", Font.BOLD, 24);
                shortestWordLabel.setFont(messageFont);
                longestWordLabel.setFont(messageFont);
                
                // Create a JPanel to hold the messages vertically
                JPanel messagePanel = new JPanel();
                messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
                messagePanel.add(shortestWordLabel);
                messagePanel.add(longestWordLabel);
                
                // Show the message panel in the dialog
                JOptionPane.showMessageDialog(frame, messagePanel, "Analysis Results", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "No file selected.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
