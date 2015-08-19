// Don't forget to change your package

import java.io.IOException;
import java.net.Socket;

public class Client {
   private Thread receiverThread;
   private Thread emitterThread;

   private Socket socket;

   public Client(Socket s) {
      // Feel free to add on top of this class and extend the constructor.
       this.socket = s;
   }

   public void start() {
      try {
         // Ask about the hostname and port :)
         socket = new Socket("hostname", 8080);

         // What the ... ?
         receiverThread = new Thread(new Receiver(socket));
         emitterThread = new Thread(new Emitter(socket));

         receiverThread.start();
         emitterThread.start();

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void stop() throws IOException {
      receiverThread.interrupt();
      emitterThread.interrupt();

      if (!socket.isClosed()) {
         socket.close();
      }
   }
}