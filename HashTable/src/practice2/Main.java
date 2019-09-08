package practice2;

public class Main {
	public static void main(String[] args) {
		MyHashTable mht = new MyHashTable(13);
		mht.put("32145", "정제윈");
		mht.put("54678", "이준우");
		mht.put("47591", "김병만");
		mht.put("12348", "최홍만");
		mht.put("12349", "추민우");
		mht.put("12310", "배준협");
		mht.put("12311", "나동현");
		mht.put("12312", "허경환");
		mht.put("12313", "장재인");
		mht.put("12314", "정말");
		mht.put("12315", "홍길동");
		mht.put("12311", "내이름");
		mht.put("12317", "뭔짓이지");
		mht.put("12318", "이제");
		mht.put("12319", "그만");
		mht.printAll();
		System.out.println(mht.size());
		
	}
}
