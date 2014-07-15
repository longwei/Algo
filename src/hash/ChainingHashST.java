package hash;

import java.util.ArrayList;

public class ChainingHashST<Key, Value> {
	private static final int INIT_CAPACITY = 4;
	private int N;//key-value pair
	private int M;//hash table size
	private SequentialSearchST<Key, Value>[] st;
	
	public ChainingHashST(){
		this(INIT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ChainingHashST(int M) {
		this.M = M;
		st = new SequentialSearchST[M];
		for(int i= 0; i < M; i++){
			st[i] = new SequentialSearchST<Key, Value>();
		}
	}
	
	private int hash(Key key){
		return ((key.hashCode() & 0x7fffffff) % M);
	}
	
	public int size(){return  N;}
	public boolean isEmpty(){return (N==0);}
	public Value get(Key key){
		int i = hash(key);
		return st[i].get(key);
	}
	public void put(Key key, Value val){
		if (val == null) {delete(key); return;}
		if ( N > 10 * M) resize( 2*M);
		int i = hash(key);
		if (!st[i].contains(key)) N++;
		st[i].put(key, val);
	}
	public void delete(Key key){
		int i = hash(key);
		if(st[i].contains(key)) N--;
		st[i].delete(key);
	}
	
	public Iterable<Key> keys(){
		ArrayList<Key> index = new ArrayList<Key>();
		for(int i = 0; i < M; i++){
			for(Key key : st[i].keys()){
				index.add(key);
			}
		}
		return index;
	}
	
	
	public void resize(int chains){
		ChainingHashST<Key, Value> temp =  new ChainingHashST<Key, Value>(chains);
		for(int i = 0; i < M; i++){
			for(Key key: st[i].keys()){
				temp.put(key, st[i].get(key));
			}
		}
		this.M = temp.M;
		this.N = temp.N;
		this.st = temp.st;
	}
	
	public static void main(String[] args){
		ChainingHashST<String, Integer> st = new ChainingHashST<String, Integer>();
		String[] inputs = "SEARCH".split("");//empty 1st entry
		for(int i=1; i < inputs.length ; ++i){
			st.put(inputs[i], i);
		}
		for(String s: st.keys())
			System.out.println(s + " " + st.get(s));
		
	}
	

}
