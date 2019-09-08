package practice2;
import java.util.ArrayList;

public class MyHashTable {
	private ArrayList bucketArray;
	private int bucketCapacity;
	private int size;
	private float loadFactor;
	
	MyHashTable(int initialCapacity){
		this.bucketArray = new ArrayList();
		for(int i = 0; i<initialCapacity; i++) {
			this.bucketArray.add(new ArrayList());
		}
		this.bucketCapacity = initialCapacity;
		this.size = 0;
	}
	MyHashTable(int initialCapacity, float loadFactor){
		this.loadFactor = 0;
		this.bucketArray = new ArrayList();
		for(int i = 0; i<initialCapacity; i++) {
			bucketArray.add(new ArrayList());
		}
		this.bucketCapacity = initialCapacity;
	}
	
	private int hashFunc(String k) {
		int key = Integer.parseInt(k);
		return key % this.bucketCapacity;
	}
	private void rehash(int capacity) {
		ArrayList a = bucketArray;
		bucketArray = new ArrayList(capacity*2);
		for(int i = a.size(); i<capacity*2; i++) {
			bucketArray.add(new ArrayList());
		}
		bucketCapacity = capacity*2;
	}
	
	public float getLoadFactor() {
		return loadFactor;
	}
	
	public int size() {
		return this.size;
	}
	public String get(String k) {
		int key = hashFunc(k);
		ArrayList list = (ArrayList)bucketArray.get(key);
		if(list.size() == 0) {
			return "null";
		}
		else {
			return (String) list.get(list.size()-1);
		}
	}
	public String put(String k, String v) {
		int key = hashFunc(k);
		if(loadFactor >=0.9) {
			rehash(bucketCapacity);
		}
		ArrayList list = (ArrayList)bucketArray.get(key);
		list.add(v);
		loadFactor = (loadFactor*bucketCapacity - 1)/bucketCapacity;
		this.size++;
		return v;
	}
	public String remove(String k) {
		int key = hashFunc(k);
		ArrayList list = (ArrayList)bucketArray.get(key);
		loadFactor = (loadFactor * bucketCapacity - 1)/bucketCapacity;
		this.size--;
		return (String)list.remove(list.size()-1);
	}
	public void printAll() {
		for(int i = 0; i< bucketCapacity; i++) {
			System.out.println(bucketArray.get(i));
		}
	}
}
