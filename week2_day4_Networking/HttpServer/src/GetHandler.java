import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


public class GetHandler implements HttpHandler{
  private Map<String, Double> products;
    
    public GetHandler(Map<String, Double> products){
        this.products = products;
    }
    
    @Override
    public void handle(HttpExchange exc) throws IOException {
        String response = "";
        System.out.println(exc.getRequestMethod());
        
        if(exc.getRequestMethod().equals("GET")){
            String productName = exc.getRequestURI().getQuery();
            Double price = products.get(productName);
            response += productName + " " + price + "\n"; 
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
