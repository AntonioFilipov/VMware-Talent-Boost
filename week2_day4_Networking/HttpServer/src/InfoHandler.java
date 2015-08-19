import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import sun.net.www.protocol.http.HttpURLConnection;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class InfoHandler implements HttpHandler {
    
	@Override
	public void handle(HttpExchange exc) throws IOException {
		String response = "Hello!";
		exc.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length());
		OutputStream os = exc.getResponseBody();
		try {
			os.write(response.getBytes());
		} finally {
			os.close();
		}
	}
}
