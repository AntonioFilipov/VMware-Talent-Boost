import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class PostHandler implements HttpHandler  {
    
    private Map<String, Double> products;
    
    public PostHandler(Map<String, Double> products){
        this.products = products;
    }
    
	@Override
	public void handle(HttpExchange exc) throws IOException {
	    
	    System.out.println(exc.getRequestMethod());
	    
        if(exc.getRequestMethod().equals("POST")){
    		InputStreamReader bodyReader = new InputStreamReader(exc.getRequestBody(), StandardCharsets.UTF_8);
    		BufferedReader br = new BufferedReader(bodyReader);
    		
    		try {
    			String line = null;
    			while ((line = br.readLine()) != null) {
    			    Helpers.saveFromStringToMap(line, this.products);
    			}
    		} finally {
    			br.close();
    			// exc.close();
    		}
    		
    		String response = "OK";
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
