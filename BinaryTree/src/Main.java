
public class Main {
	public static void main(String[] args) {
		MyBinaryTree mbt = new MyBinaryTree();
		MyBinNode d = mbt.addRoot('+');
		MyBinNode a = mbt.insertLeft(d, 'x');
		MyBinNode b = mbt.insertRight(d, 'x');
		mbt.insertLeft(a, 2);
		MyBinNode c = mbt.insertRight(a, '-');
		mbt.insertLeft(c, 3);
		mbt.insertRight(c,4);
		mbt.insertLeft(b, 3);
		mbt.insertRight(b, 2);
		
		mbt.printExpr(d);
		
	}
	
}
