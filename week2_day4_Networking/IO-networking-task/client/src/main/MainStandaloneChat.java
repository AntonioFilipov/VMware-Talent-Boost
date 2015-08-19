package main;

import java.io.IOException;

public class MainStandaloneChat {

	private static final int PORT = 8080;
	private static final String HOST = "127.0.0.1";
	
	public static void main(String[] args) throws IOException {
		new Client(HOST, PORT, System.in, System.out).start();
	}
}