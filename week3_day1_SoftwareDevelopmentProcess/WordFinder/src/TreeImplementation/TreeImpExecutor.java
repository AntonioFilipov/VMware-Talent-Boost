package TreeImplementation;

import java.util.HashSet;

public class TreeImpExecutor {

	public static void main(String[] args) {

		WordProcessor reader = new WordProcessor();
		reader.readFromFile("filteredWords");

		WordsTree tree = new WordsTree();

		HashSet<String> set = new HashSet<String>();
		
		tree.addWords(reader.getWords());
		
		Mapper map = new Mapper();
		map.mapNumberToWord("25", "", tree.getRoot());
		System.out.println(map.getWords().toString());

	}

}
