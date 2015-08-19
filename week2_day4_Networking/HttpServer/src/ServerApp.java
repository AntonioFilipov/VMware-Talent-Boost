import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpServer;

public class ServerApp {
  
    public static void main(String[] args) throws Exception {
        Map<String, Double> products = new HashMap<String, Double>();
        HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);
        server.createContext("/info", new InfoHandler());
        server.createContext("/post", new PostHandler(products));
        server.createContext("/get", new GetHandler(products));
        server.createContext("/delete", new GetHandler(products));

        server.setExecutor(null); // creates a default executor
        server.start();
     }
}
