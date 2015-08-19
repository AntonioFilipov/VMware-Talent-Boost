public class HashTable {

    private int capacity=0;
    private int size=0;
    private String[] array;
    private double loadFactor = 0.75;
    private int collisionCount = 0;
    
    public HashTable(int initialCapacity){
        this.capacity = nextPrimeNumber(initialCapacity);
        this.array = new String[this.capacity]; 
    }
    
    public HashTable(int initialCapacity, double loadFactor){
        this.capacity = nextPrimeNumber(initialCapacity);
        this.array = new String[this.capacity]; 
        this.loadFactor = loadFactor;
    }
    
    public void insert(String s){
        this.collisionCount = 0;
        int cell = h1(s);
        if (this.array[cell] == null) {
            this.array[cell] = s;
        }else{
            while (this.array[cell] != null) {
                cell += h2(s);
                this.collisionCount++;
                if (cell > this.capacity-1) {
                    cell -= this.capacity-1;
                }
            }
            this.array[cell] = s;
        }
        this.size++;
        extend();
    }
    
    
    public boolean find(String s){
        int cell = h1(s);
        boolean[] checkRepeated = new boolean[this.capacity];
        
        if (this.array[cell] == s) {
            return true;
        }else{
        	while (true) {
                cell+=h2(s);
                if (cell > this.capacity-1) {
                    cell -= this.capacity-1;
                }
                
        		if (checkRepeated[cell] == true) {
					break;
				}
        		
				if (this.array[cell] == s) {
					return true;
				}
				else{
					checkRepeated[cell] = true;
				}
			}
        }
        return false;
    }
    
    public int size(){
        return this.size;
    }
    
    public int capacity(){
        return this.capacity;
    }
    
    public int collisionCount(){
        return this.collisionCount;
    }
    
    private int h1(String x){
        int hashCode = 0;
        for (int i=0; i < x.length(); i++) {
            hashCode = (hashCode << 1) | (hashCode >> (32 - 1));
            hashCode ^= x.charAt(i);
        }
        return hashCode%this.capacity;
    }
    
    private int h2(String x){
        int hash=7;
        for (int i=0; i < x.length(); i++) {
            hash = (hash*31+x.charAt(i))%this.capacity;
        }  
        return hash%this.capacity;
    }
    
    private int nextPrimeNumber(int number){
        int increasingNumber = number;
        boolean isPrime;
        if (number == 1) {
            return 1;
        }else if (number == 2) {
            return 2;
        }else if (number == 3){
            return 3;
        }
        
        while (true) {
            isPrime = true;
            for (int i = 2; i <= Math.sqrt(increasingNumber); i++) {
                if (increasingNumber % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                return increasingNumber;
            }
            increasingNumber++;
        }
    }
    
    private void extend(){
        if (this.size/(double)this.capacity > this.loadFactor) {
            this.capacity = nextPrimeNumber(this.capacity*2);
            this.size=0;
            String[] extendedArray = new String[this.capacity];
            String[] oldArray = new String[this.array.length];
            for (int i = 0; i < this.array.length; i++) {
                oldArray[i] = this.array[i];
            }
            this.array = extendedArray;
            
            for (int i = 0; i < oldArray.length; i++) {
                insert(oldArray[i]);
            }
        }
    }
}
