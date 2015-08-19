import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {

	public static void echo(int port) throws IOException {
		ServerSocket echo = new ServerSocket(port);
		System.out.println("Creating server socket on port " + port);
		Socket client = null;
		boolean isStopped = false;
		while (!isStopped) {
			try {
				if (client == null || client.isClosed()) {
					client = echo.accept(); // dokato ne se vurje socket nadolu nishto ne stava
				}
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter writer = new PrintWriter(client.getOutputStream(),true);

				String message = in.readLine();
				writer.println("[Server]Client said:"+message);
				writer.flush();
			} catch (SocketException e) {
				client = null;
				isStopped = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int port = 8080;
		echo(port);
	}

}
