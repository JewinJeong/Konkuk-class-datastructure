import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
public class MyMergeSort {
	private ArrayList L1;
	private ArrayList L2;	
	private Comparator comp;
//	MyMergeSort(){
//		L1 = new ArrayList();
//		L2 = new ArrayList();
//	}
	MyMergeSort(Comparator c){
		L1 = new ArrayList();
		L2 = new ArrayList();
		this.comp = setComparator(c);
	}
	public void sort(ArrayList l) {
		int length = l.size();
		while(l.size()/2 != 2) {
			for(int i = 0; i<length; i=i+2) {
				int result = comp.compare(l.get(i), l.get(i+1));
				if(result >= 0) {
					L1.add(l.get(i+1));
					L1.add(l.get(i));
				}
				else {
					L1.add(l.get(i));
					L1.add(l.get(i+1));
				}
			}
		}
		
	}
	public Comparator setComparator(Comparator c) {
		this.comp = c;
		return this.comp;
	}
	
	
	public static void main(String[] args) {
        Random random = new Random();
        ArrayList a1 = new ArrayList();

        for(int i = 0; i<20; i++){

            a1.add(0,Integer.toString(random.nextInt(100)+1));
            System.out.print(a1.get(0)+" ");
        }
        IntComparator c = new IntComparator();
        MyMergeSort m = new MyMergeSort(c);

        while(a1.size()!=1){
            m.sort(a1);
        }
        for(int i = 0; i<m.L1.size(); i++) {
        	System.out.println(m.L1.get(i));
        }
//        ArrayList a2 = (ArrayList)a1.get(0);
//        for(int i = 0; i<a2.size();i++){
//            System.out.print(a1.get(i)+ " ");
//        }
		

    }
}
