public class Stack<T> {
    private Node head;
    private Node tail;
    private int count = 0;
    
    public class Node<T>{
        public T element;
        public Node left;
        public Node right;
        
        public Node(){
            
        }
        
        public Node(T element){
            this.element = element;
        }
    }
    
    public int size(){
        return this.count;
    }
    
    public boolean isEmpty(){
        return this.count == 0;
    }
    
    public void clear(){
        Node node = new Node();
        this.tail = node;
        this.head = node;
    }
    
    public void delete(){
        this.head = null;
    }
    
    public void push(T element){
        if (this.tail==null) {
            Node node = new Node(element);
            this.head = node;
            this.tail = node;
            return;
        }
        
        Node node = new Node(element);
        node.left = this.tail;
        this.tail.right = node;
        this.tail = node;    
        count+=1;
    }
    
    public T pop(){
        T result = (T) this.tail.element;
        this.tail = this.tail.left;
        this.tail.right = null;
        count-=1;
        return result;
    }
    
    public T peek(){
        return (T)this.tail.element;
    }
    
}
