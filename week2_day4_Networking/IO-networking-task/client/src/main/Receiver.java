package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Represents a receiver which has receive functionality via sockets
 * @author Antonio
 *
 */
public class Receiver implements Runnable {

   private Socket socket;
   private PrintStream out;

   public Receiver(Socket socket, PrintStream out) {
      this.socket = socket;
      this.out = out;
   }

   /**
    * Reads from socket input and visualize to he receiver output
    */
   public void run() {
      BufferedReader msgReader = null;

      try {
         msgReader = new BufferedReader(new InputStreamReader(socket.getInputStream()
			/*XXX the input stream from the socket*/));

         String msg = null;
         while ( (msg = msgReader.readLine()) != null) {
        	 //XXX Print msg as new line to the output PrintStream
             out.println(msg);
         }
      } catch (IOException e) {
         //ignore
          e.printStackTrace();
      }
   }
}
