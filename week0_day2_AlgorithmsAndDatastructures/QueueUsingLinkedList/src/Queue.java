public class Queue<T> {
    private int count = 0;
    private Node head;
    private Node tail;
    
    public class Node<T>{
        private T element;
        private Node rigth;
        private Node left;
        
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
    
    
    public void enqueueBack(T element){
        if (this.tail == null) {
            Node node = new Node(element);
            this.tail = node;
            this.head = node;
            this.count+=1;
            return;
        }
        
        Node node = new Node(element);
        this.tail.rigth = node;
        node.left = this.tail;
        this.tail = node;
        this.count+=1;
    }
    
    public void enqueueFront(T element){
        if (this.tail == null) {
            Node node = new Node(element);
            this.head = node;
            this.tail = node;
            this.count+=1;
        }
        
        Node node = new Node(element);
        
        this.head.left = node;
        node.rigth = this.head;
        this.head = node;
        this.count+=1;
    }
    
    public T dequeBack(){
        T result = (T)this.tail.element;
        this.tail = this.tail.left;
        this.tail.rigth = null;
        this.count-=1;
        return result;
    }
    
    public T dequeFront(){
        T result = (T)this.head.element;
        this.head = this.head.rigth;
        this.head.left = null;
        this.count-=1;
        return result;
    }
    
    public T peekBack(){
        return (T)this.tail.element;
    }
    
    public T peekFront(){
        return (T)this.head.element;
    }
    
    
}
