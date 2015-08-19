package main;

import java.util.Scanner;

public class MainChatInCmdInterpreter {
    private static final int PORT = 8080;
    private static final String HOST = "127.0.0.1";

    // INFO: Note how we needed a class, which will understand when 'exit-chat'
    // is entered in the chat loop. We need to pass this to the chat client,
    // but make it as abstract as possible. Thus the ChatInputObserver interface
    // was added. From the Client's point of view the ExitTracker is just an
    // observer. In this way the Client has no idea about exit messages or
    // whatsoever. It only performs the low-level TCP management logic. By
    // extending
    // this observer interface you can add handling for system commands in the
    // chat client.
    
    /**
     * care for observing inputs
     * @author Antonio
     *
     */
    static class ExitTracker implements ChatInputObserver {
        /**
         * waiting for exit
         * @throws InterruptedException
         */
        void waitForExit() throws InterruptedException {
            synchronized (this) {
                this.wait();
            }
            ;
        }

        /**
         * waiting to enter exit-chat command
         */
        @Override
        public void observeInput(String inputLine) {
            if (inputLine.startsWith("exit-chat")) {
                synchronized (this) {
                    this.notify();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /**
         * Parse commands and execute them
         */
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
                    System.out.println(CmdInterpreter.reverse(rest));
                    break;
                case "count-words":
                    System.out.println(CmdInterpreter.countWords(rest));
                    break;
                case "reverse-words":
                    System.out.println(CmdInterpreter.reverseWords(rest));
                    break;
                case "chat-connect":
                    String[] params = rest.split("\\s+");
                    CmdInterpreter.chatConnect(HOST, PORT);
                case "exit":
                    return;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }
}
