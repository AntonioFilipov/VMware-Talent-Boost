package TreeImplementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import TreeImplementation.WordsTree.Node;

public class Mapper {

	private static final Map<Character, String> NUM_MAP = new HashMap<Character, String>() {
		{
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}
	};
	
	private ArrayList<String> words;
	
	public Mapper(){
	    this.setWords(new ArrayList<String>());
	}

    public ArrayList<String> getWords() {
        return words;
    }


    public void setWords(ArrayList<String> words) {
        this.words = words;
    }
    

    public void mapNumberToWord(String inputNumber, String currentWord, Node node) {
        
        if(inputNumber.length() == 0) {
            if(node.getMakesWord()) {
                getWords().add(currentWord);
            }           
            return;
        }
        
        if (!inputNumber.matches("[0-9]+")) {
            throw new IllegalArgumentException("Invalid phone number!");
        }
        
        if(node == null) {
            return;
        }
        
        char currentDigitChar = inputNumber.charAt(0);
        Map<Character, Node> childrens = node.getAllChilds();
        
        for(int i = 0; i < NUM_MAP.get(currentDigitChar).length(); i++) {
            char currentLetterChar = NUM_MAP.get(currentDigitChar).charAt(i);
            if(childrens.containsKey(currentLetterChar)) {
                mapNumberToWord(inputNumber.substring(1), currentWord + currentLetterChar, childrens.get(currentLetterChar));
            }           
        }
    }



}
