package TreeImplementation;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Responsible for storing words in a tree
 * 
 * @author Antonio
 *
 */
public class WordsTree {
	private Node root = new Node();
	private Node parent = root;
	
    /**
     * Responsible for creating a single element of the tree
     * 
     * @author Antonio
     *
     */
	public class Node{
		private char letter;
		private Map<Character, Node> childs = new HashMap<Character, Node>();
		private boolean makesWord = false;
		
		public Node(){
			
		}
		
		public Node(char letter){
			this.letter = letter;
		}
		
		public char getLetter(){
			return this.letter;
		}
		
		public boolean hasChilds(){
		    return this.childs.size() == 0;
		}
		public Node getChild(char inputChar){
			Node child = this.childs.get(inputChar);
			return child;
		}
		
		public Map<Character, Node> getAllChilds(){
			return this.childs;
		}
		
		public void addChild(Node inputNode){
			this.childs.put(inputNode.getLetter(), inputNode);
		}
		
		public boolean getMakesWord(){
			return this.makesWord;
		}
		
		public void setMakesWord(boolean value){
			this.makesWord = value;
		}
	}
	
	public Node getRoot(){
		return this.root;
	}
	
	/**
	 * add words from collection type to tree
	 * @param map
	 */
	public void addWords(Collection<String> map){
		for (String string : map) {
			for (int i = 0; i < string.length(); i++) {
				if (!this.parent.getAllChilds().containsKey(string.charAt(i))) {
					Node node = new Node(string.charAt(i));
					if (i == string.length()-1) {
						node.setMakesWord(true);
					}
					this.parent.addChild(node);
				}else{
					if (i == string.length()-1) {
						this.parent.getChild(string.charAt(i)).setMakesWord(true);
					}
				}
				this.parent = this.parent.getChild(string.charAt(i));
			}
			this.parent = root;
		}
	}
	/**
	 * Check whether the word is in tree
     * @param word
     *            input word
     * @return true/false
	 */
	public boolean isWord(String word){
		this.parent = this.root;
		for (int i = 0; i < word.length(); i++) {
			if (!this.parent.getAllChilds().containsKey(word.charAt(i))) {
			    return false;
			}
			this.parent = this.parent.getChild(word.charAt(i));
		}
        if (this.parent.getMakesWord()) {
            return true;
        }
        return false;
	}
	
}
