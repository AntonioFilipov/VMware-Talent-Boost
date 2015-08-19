import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {

   public static void echo(String hostname, int port) throws UnknownHostException, IOException {
      Socket client = new Socket(hostname, port);
      System.out.println("Creating socket to '" + hostname + "' on port " + port);
      Scanner inputReader = new Scanner(System.in);
      PrintWriter writer = new PrintWriter(client.getOutputStream());

      BufferedReader bf =new BufferedReader(new InputStreamReader(client.getInputStream()));

      while (inputReader.hasNextLine()) {
         String input = inputReader.nextLine();
         writer.println(input);
         writer.flush();
         System.out.println(bf.readLine());
      }

      inputReader.close();
      client.close();
   }
   
   public static void main(String[] args) throws UnknownHostException, IOException{
	   String host = "localhost";
	   int port = 8080;
	   echo(host, port);
   }

}
