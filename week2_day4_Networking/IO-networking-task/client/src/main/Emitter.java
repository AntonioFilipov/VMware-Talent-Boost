package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Represents an emitter which has send functionality via sockets
 * @author Antonio
 *
 */
public class Emitter implements Runnable {

   private Socket socket;
   private InputStream in;
   private ChatInputObserver cio;

   public Emitter(Socket socket, InputStream in, ChatInputObserver cio) {
      this.socket = socket;
      this.in = in;
      this.cio = cio;
   }

   public void run() {
      Scanner inputReader = new Scanner(in);
      try {
         PrintWriter writer = new PrintWriter(socket.getOutputStream());

         while (inputReader.hasNextLine() && !Thread.interrupted()) {
            String input = inputReader.nextLine();//XXX read next line
            if (cio != null) {
            	cio.observeInput(input);
            }
            writer.println(input);
            //XXX flush the writer
            writer.flush();
         }
      } catch (IOException e) {
         //ignore
          e.printStackTrace();
      }

      //XXX - how can we fix this? Remember those links in the IO lecture
	  //	about Scanner and System.in. The line bellow is commented out
	  //	because if we close the Scanner, it will close the input stream
      //inputReader.close();
   }
}
