// Don't forget to change your package

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * This component should be responsible for processing any incoming messages.
 */
public class Receiver implements Runnable {

    private Socket socket;

    public Receiver(Socket s) {
        socket = s;
    }

    public void run() {
        // your code goes here..
        try {
            Scanner in = new Scanner(this.socket.getInputStream());

            while (true) {
                if (in.hasNext()) {
                    String input = in.nextLine();
                    System.out.println(input);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
