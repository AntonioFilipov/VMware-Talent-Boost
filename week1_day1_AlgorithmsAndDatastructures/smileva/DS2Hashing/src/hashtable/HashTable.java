package hashtable;

import java.math.BigInteger;

public class HashTable {
	private int initialCapacity;
	private int _capacity;
//	private int[] table;
	private String[] table; //table have to hold data in string format and integer indexes
	private double _loadFactor = 0.75;
	private int _size;
	private int collisionCount=0;
	
	public HashTable(int initialCapacity) {
		this.initialCapacity = initialCapacity;
		String numAsString = initialCapacity + "";
		BigInteger a = new BigInteger(numAsString);
		BigInteger b = a.nextProbablePrime();
		_capacity = b.intValue();
//		table = new int[_capacity];
		table = new String[_capacity];
		_loadFactor = 0.75;
		_size = 0;
	}
	
	public HashTable(int initialCapacity, double loadFactor) {
		this.initialCapacity = initialCapacity;
		BigInteger a = new BigInteger(""+initialCapacity);
		BigInteger b = a.nextProbablePrime();
		_capacity = b.intValue();
//		table = new int[_capacity];
		table = new String[_capacity];
		_loadFactor = loadFactor;
		_size = 0;
	}
	
	public void insert(String s) {
//		_size++;
//		
//		if(_size / _capacity > _loadFactor) {
//			//resize
//		}
		
		//Antonio
        int cell = h1(s);
        if (this.table[cell] == null) {
            this.table[cell] = s;
        }else{
            while (this.table[cell] != null) {
            	this.collisionCount++;
                cell += h2(s);
                if (cell > this._capacity-1) {
                    cell -= this._capacity-1;
                }
            }
            this.table[cell] = s;
        }
        this._size++;
        extend();
	}
	
	public boolean find(String s) {
	//Antonio
	 int cell = h1(s);
	    boolean[] checkRepeated = new boolean[this._capacity];
	    if (this.table[cell] == s) {
	        return true;
	    }else{
	    	while (true) {
	    		if (checkRepeated[cell] == true) {
					break;
				}
				cell+=h2(s);
				if (this.table[cell] == s) {
					return true;
				}
				else{
					checkRepeated[cell] = true;
				}
			}
	    }
	    return false;	
	}
	
	public int colisionCount(){
		return this.collisionCount;
	}
	
	public int size() {
		return _size;
	}
	
	public int capacity() {
		return _capacity;
	}
	
	private int h(String s, int base) {
		final int c = 100001;
		final int B = base;
		final int M = _capacity;
		int[] pows = new int[c];
		int res = 0;
		pows[0] = 1;
		for(int i = 1; i < c; i++) {
			pows[i] = pows[i-1]*B % M;
		}
		for(int i = 0; i < s.length(); i++) {
			res += (res*B + (s.charAt(i) - 'a'))%M;
		}
		return res;
	}
	
	private int h1(String s) {
		int res = h(s, 31);
		return res%this._capacity;
	}
	
	private int h2(String s) {
		int res = h(s, 37);
		return res%this._capacity;
	}
	
	 private void extend(){
		//Antonio
        if (this._size/(double)this._capacity > this._loadFactor) {
    		BigInteger a = new BigInteger(""+this._capacity*2);
    		BigInteger b = a.nextProbablePrime();
    		this._capacity = b.intValue();
            this._size=0;
            String[] extendedArray = new String[this._capacity];
            String[] oldArray = new String[this.table.length];
            for (int i = 0; i < this.table.length; i++) {
                oldArray[i] = this.table[i];
            }
            this.table = extendedArray;
            
            for (int i = 0; i < oldArray.length; i++) {
                insert(oldArray[i]);
            }
        }
    }
	

	public static void main(String[] args) {
		HashTable table = new HashTable(4);
		table.insert("abab");
		table.insert("adasd");
		table.insert("adasd");
		table.insert("adafaaf");
		System.out.println("Collision count:"+table.collisionCount);
		//System.out.println('d' - 'a');
	}

}
