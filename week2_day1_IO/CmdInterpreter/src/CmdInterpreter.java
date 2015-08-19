import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class CmdInterpreter {

    public static String reverse(String input) {
        if (input.length() == 0) {
            System.out.println("Invalid input");
            System.exit(0);

        }
        return new StringBuilder(input).reverse().toString();
    }

    public static int countWords(String input) {
        if (input.length() == 0) {
            System.out.println("Invalid input");
            System.exit(0);

        }
        String[] words = input.split("\\s+");
        return words.length;
    }

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

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String commandAndArgs = scanner.nextLine();

            if (!commandAndArgs.contains(" ")) {
                System.out.println("No arguments");
                System.exit(0);
            }

            int i = commandAndArgs.indexOf(' ');
            String command = commandAndArgs.substring(0, i);
            String rest = commandAndArgs.substring(i + 1);
            switch (command) {
                case "reverse":
                    System.out.println(reverse(rest));
                    break;
                case "count-words":
                    System.out.println(countWords(rest));
                    break;
                case "reverse-words":
                    System.out.println(reverseWords(rest));
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }

    }

}
