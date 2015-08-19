public class BinarySearchTree {
	private Node root;
	private Node parent;
	
	private static class Node{
		private int element;
		private Node left;
		private Node rigth;
		private int heigth;
		private int weigth;
		
		public Node(int element){
			this.element = element;
		}
		
		public Node(int element, Node rigth, Node left){
		    this.element = element;
		    this.rigth = rigth;
		    this.left = left;
		}
	}
	
	public boolean find(int element){
		this.parent = this.root;
		while (true) {
			if (element > this.parent.element) {
				if(this.parent.rigth == null){
					break;
				}
				this.parent = this.parent.rigth; ;
			}else if(element < this.parent.element){
				if(this.parent.left == null){
					break;
				}
				this.parent = this.parent.left;
			}
			
			if (this.parent.element == element) {
				return true;
			}
		}
		return false;
	}
	
	public void insert(int element){
		if (this.root == null) {
			Node node = new Node(element);
			node.heigth = calculateHeigth(node);
			this.root = node;
			this.parent = root;
			return;
		}
		
		Node node = new Node(element);
		while (true) {
			if (node.element > this.parent.element) {
				if (this.parent.rigth == null) {
					this.parent.rigth = node;
			        this.parent.rigth.heigth = calculateHeigth(this.parent.rigth);
					return;
				}else{
					this.parent = this.parent.rigth;
				}
			}else if(node.element < this.parent.element){
				if (this.parent.left == null) {
					this.parent.left = node;
			        this.parent.left.heigth = calculateHeigth(this.parent.left);
					return;
				}else{
					this.parent = this.parent.left;
				}
			}
		}

	}
	
	public void delete(int element){
		this.parent = this.root;
		while (element != this.parent.element) {
			if (element > this.parent.element) {
				if (this.parent.rigth == null) {
					break;
				}else{
					this.parent = this.parent.rigth;
				}
				
			}else if(element < this.parent.element){
				if (this.parent.left == null) {
					break;
				}else{
					this.parent = this.parent.left;
				}
			}
		}
			
		if (this.parent.left == null && this.parent.rigth == null) {
			this.parent = null;
		}else if(this.parent.left != null && this.parent.left.left == null && this.parent.left.rigth == null){
		    this.parent = this.parent.left;
		}else if(this.parent.rigth != null && this.parent.rigth.left == null && this.parent.rigth.rigth == null){
		    this.parent = this.parent.rigth;
		}else{
			Node tempNode = new Node(this.parent.element, this.parent.rigth, this.parent.left);
			tempNode = tempNode.rigth;
			
			while (true) {
				if (tempNode.left == null) {
					break;
				}
				tempNode = tempNode.left;
			}
			
			this.parent.element = tempNode.element;
			if (tempNode.rigth != null) {
			    tempNode = tempNode.rigth;
            }
		}
	}
	
	
	private void calculateWeigth(Node node){
		node.weigth = node.rigth.weigth + node.left.weigth + 1;
	}
	
	private int calculateHeigth(Node node){
	    if (node == null) {
            return -1;
        }
	    return Math.max(calculateHeigth(node.left), calculateHeigth(node.rigth))+1;
	}
	
}
