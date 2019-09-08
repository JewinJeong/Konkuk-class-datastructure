package practice1;
import java.util.ArrayList;

public class MyHashTable {
	private ArrayList bucketArray;
	private int bucketCapacity;
	private int size;
	
	MyHashTable(int initialCapacity){
		this.bucketArray = new ArrayList(initialCapacity);
		for(int i = 0 ; i<initialCapacity; i++) {
			this.bucketArray.add(new ArrayList());
		}
		this.bucketCapacity = initialCapacity;
		this.size = 0;
	}
	private int hashFunc(String k) {
		int key = Integer.parseInt(k);
		return key % bucketCapacity;
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
			return (String)list.get(list.size()-1);
		}
	}
	public String put(String k, String v) {
		int key = hashFunc(k);
		ArrayList list = (ArrayList)bucketArray.get(key);
		list.add(v);
		this.size++;
		return v;
	}
	public String remove(String k) {
		int key = hashFunc(k);
		ArrayList list = (ArrayList)bucketArray.get(key);
		this.size--;
		return (String)list.remove(list.size()-1);
	}
	public void printAll() {
		for(int i = 0; i< bucketCapacity; i++) {
			System.out.println(bucketArray.get(i));
		}
	}
}
