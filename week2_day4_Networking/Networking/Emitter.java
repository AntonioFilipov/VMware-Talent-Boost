// Don't forget to change your package

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * This component should be responsible for processing user input
 * and dispatching messages to the server.
 */
public class Emitter implements Runnable {

   private Socket socket;

   public Emitter(Socket s) {
      this.socket = s;
   }

   public void run() {
      // your code goes here..
       try {
           Scanner in = new Scanner(this.socket.getInputStream());
           PrintWriter out = new PrintWriter(this.socket.getOutputStream());
        
           while (true) {
               if (in.hasNext()) {
                   String input = in.nextLine();
                   System.out.println("Client: "+input);
                   out.println("You said: "+input);
                   out.flush();
               }
           }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   }
}
