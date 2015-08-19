
public class Executable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(5);
		tree.insert(4);
		tree.insert(6);
		tree.insert(-1);
		tree.delete(4);
//		System.out.println(tree.find(10));
		System.out.println(tree.find(-2));
		
	}

}
