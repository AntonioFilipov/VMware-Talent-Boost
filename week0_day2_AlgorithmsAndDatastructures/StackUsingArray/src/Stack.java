public class Stack<T> {
    private final int INITIAL_CAPACITY=4;
    private final int EXTENDABLE_SIZE=2;
    
    private T[] container;
    private int capacity = this.INITIAL_CAPACITY;
    private int count = 0;
    
    public Stack(){
        this.container = (T[])new Object[INITIAL_CAPACITY];
    }
    
    public Stack(int size){
        this.capacity = size;
        this.container = (T[])new Object[this.capacity];
    }
    
    public int capacity(){
        return this.capacity;
    }
    
    public int size(){
        return this.count;
    }
    
    public boolean isEmpty(){
        return this.count == 0;
    }
    
    public void delete(){
        this.container = null;
        this.count=0;
        this.capacity=0;
    }
    
    public void clear(){
        this.container = (T[])new Object[this.capacity];
        this.count=0;
    }
    
    public void push(T value){
        extend();
        this.container[this.count] = value;
        this.count+=1;
    }
    
    public T pop(){
        shrink();
        T result = this.container[count-1];
        this.container[count-1] = null;
        this.count-=1;
        return result;
    }
    
    public T peek(){
        return this.container[count-1];
    }
    
    private void extend(){
        if (this.count == this.capacity) {
            this.capacity *= this.EXTENDABLE_SIZE;
            
            manageArray(this.capacity);
        }
    }
    
    private void shrink(){
        if (this.count == this.capacity/this.EXTENDABLE_SIZE) {
            this.capacity/=this.EXTENDABLE_SIZE;
            
            manageArray(this.capacity);
        }
    }
    
    private void manageArray(int capacity){
        T[] extendedArray = (T[])new Object[this.capacity];
        for (int i = 0; i < this.count; i++) {
            extendedArray[i] = this.container[i];
        }
        this.container = extendedArray;
        extendedArray = null;
    }
}
