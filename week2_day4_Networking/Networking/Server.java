// Don't forget about the package

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import sun.net.www.protocol.http.HttpURLConnection;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * Sample http server. Handles GET requests on http://localhost:8080/test
 */
public class Server {

    public static void main(String[] args) throws Exception {
       HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
       server.createContext("/test", new MyHandler());
       server.setExecutor(null); // Creates a default executor. Not part of the lesson
       server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
           System.out.println(t.getRequestURI().getQuery());
           String response = "This is the response";
           t.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length());
           OutputStream os = t.getResponseBody();
           os.write(response.getBytes());
           os.close();
        }
    }

}