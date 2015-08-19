package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import main.Client;
import main.MainChatInCmdInterpreter.ExitTracker;

/**
 * Represent a command interpreter which executes commands
 * 
 * @author Antonio
 *
 */
public class CmdInterpreter {

    /**
     * reverse given input string
     * 
     * @param input
     *            input string
     * @return reversed string
     */
    public static String reverse(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("Invalid input");

        }
        return new StringBuilder(input).reverse().toString();
    }

    /**
     * count words in a string
     * 
     * @param input
     *            input string
     * @return number of words
     */
    public static int countWords(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        String[] words = input.split("\\s+");
        return words.length;
    }

    /**
     * reverse order of words in a string
     * 
     * @param input
     *            input string
     * @return reversed order of words
     */
    public static String reverseWords(String input) {
        if (input.length() == 0) {
            System.out.println("Invalid input");
            System.exit(0);

        }
        StringBuilder sb = new StringBuilder(input.length() + 1);
        String[] words = input.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(' ');
        }
        sb.setLength(sb.length() - 1); // Strip trailing space
        return sb.toString();
    }

    /**
     * perform operation to calculate number of lines, words and symbols in a
     * file
     * 
     * @param path
     *            path to file
     * @return string that contains number of lines, words and symbols in that
     *         file
     * @throws IOException
     */
    public static String wordCount(String path) throws IOException {
        FileInputStream fstream = new FileInputStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int linesCount = 0;
        int wordCount = 0;
        int symbolsCount = 0;
        // Read File Line By Line
        while ((strLine = br.readLine()) != null) {
            linesCount++;
            String[] parts = strLine.split(" ");
            for (String w : parts) {
                for (int i = 0; i < w.length(); i++) {
                    symbolsCount++;
                }
                wordCount++;
            }
            strLine = br.readLine();
        }
        // Close the input stream
        System.in.close();
        return linesCount + "" + wordCount + "" + symbolsCount;
    }

    /**
     * connect client to server
     * 
     * @param host name
     *            host name of the server
     * @param port
     *            port of host name
     */
    public static void chatConnect(String hostname, int port) {
        ExitTracker exitTracker = new ExitTracker();
        Client client = new Client(hostname, port, System.in, System.out, exitTracker);
        try {
            client.start();
            exitTracker.waitForExit();
        } catch (Exception e) { // ignore
            e.printStackTrace();
        } finally {
            try {
                client.stop();
            } catch (IOException e) { // Ignore
                e.printStackTrace();
            }
        }
        new Client(hostname, port, System.in, System.out).start();
    }

}
