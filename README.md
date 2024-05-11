# Word Analyzer

## Introduction

This project implements a Word Analyzer system using Java RMI (Remote Method Invocation). It provides functionalities to analyze words in a text file, including finding the longest word, the shortest word, and analyzing words based on certain criteria.

## How to Use

1. Clone the repository to your local machine.
2. Compile the Java files using a Java compiler.
3. Run the WordAnalyzerServer to start the RMI server.
4. Run the WordAnalyzerClientGUI to interact with the Word Analyzer system through a graphical user interface.

## Classes

### 1. RemoteWordAnalyzer

- Implements the WordAnalyzer interface and extends UnicastRemoteObject.
- Provides methods to find the longest word, the shortest word, and analyze words in a text file.

### 2. WordAnalyzer

- Remote interface defining methods for word analysis.

### 3. WordAnalyzerClientGUI

- Graphical User Interface (GUI) for interacting with the Word Analyzer system.
- Allows users to select a text file for analysis and displays the results.

### 4. WordAnalyzerServer

- RMI server that binds the RemoteWordAnalyzer object to the RMI registry.

## Usage

1. Compile the Java files:

   ```shell
   javac *.java
   ```

2. Start the RMI server:

   ```shell
   java WordAnalyzerServer
   ```

3. Run the client GUI:

   ```shell
   java WordAnalyzerClientGUI
   ```

4. Use the GUI to select a text file and start the analysis.

## Dependencies

- Java Development Kit (JDK) version 8 or above.

## Contribution

Contributions to this project are welcome. You can open an issue to report bugs or suggest improvements. Pull requests are also appreciated.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
