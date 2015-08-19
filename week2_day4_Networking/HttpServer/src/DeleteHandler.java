import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class DeleteHandler implements HttpHandler{
    private Map<String, String> products;

    public DeleteHandler(Map<String, String> products) {
        this.products = products;
    }

    @Override
    public void handle(HttpExchange exc) throws IOException {

        System.out.println(exc.getRequestMethod());

        if (exc.getRequestMethod().equals("DELETE")) {
            InputStreamReader bodyReader = new InputStreamReader(exc.getRequestBody(), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(bodyReader);
            
            try {
                String line = null;
                while ((line = br.readLine()) != null) {
                    String product = line.trim();
                    this.products.remove(product);
                }
            } finally {
                br.close();
                // exc.close();
            }
            
            String response = "DELETED";
            exc.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length());
            OutputStream os = exc.getResponseBody();
            try {
                os.write(response.getBytes());
            } finally {
                os.close();
            }
            
        }
    }
}
