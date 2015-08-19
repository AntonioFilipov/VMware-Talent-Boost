package TreeImplementation;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class WordProcessor {
	private HashSet<String> words = null;
	
	public HashSet<String> getWords(){
		return this.words;
	}
	
	public WordProcessor(){
		this.words = new HashSet<String>();
	}
	
	@SuppressWarnings("resource")
	public void readFromFile(String fileName){
		try {
            Scanner input = new Scanner(System.in);
            File file = new File(fileName);

            input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                words.add(line);
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
}
