import java.util.Map;

public class Helpers {
    
    public static void saveFromStringToMap(String input, Map<String,Double> products){
        String[] words = input.split("\\s+");
        Product current = new Product(words[0], Double.parseDouble(words[1]));
        products.put(current.getName(), current.getPrice());
    }
}
