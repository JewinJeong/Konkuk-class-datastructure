package practice2;

public class Main {
	public static void main(String[] args) {
		MyHashTable mht = new MyHashTable(13);
		mht.put("32145", "������");
		mht.put("54678", "���ؿ�");
		mht.put("47591", "�躴��");
		mht.put("12348", "��ȫ��");
		mht.put("12349", "�߹ο�");
		mht.put("12310", "������");
		mht.put("12311", "������");
		mht.put("12312", "���ȯ");
		mht.put("12313", "������");
		mht.put("12314", "����");
		mht.put("12315", "ȫ�浿");
		mht.put("12311", "���̸�");
		mht.put("12317", "��������");
		mht.put("12318", "����");
		mht.put("12319", "�׸�");
		mht.printAll();
		System.out.println(mht.size());
		
	}
}
