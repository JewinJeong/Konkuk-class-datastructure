import java.util.ArrayList;

public class MyBinaryTree extends MyTree {
	MyBinNode root;
	int size;
	public MyBinaryTree(){
		super();
	}
	public MyBinaryTree(Object e) {
		super(e);
	}
	public Boolean isEmpty() {
		return size ==0;
	}
	public Boolean isRoot(MyBinNode v) {
		return v.parent() == null;
	}
	public Boolean isInternal(MyBinNode v) {
		return (v.children().isEmpty() != true);
	}
	public Boolean isExternal(MyBinNode v) {
		return v.children().isEmpty();
	}
	
	public MyBinNode root() {
		return root;
	}
	public MyBinNode parent(MyBinNode v) {
		return (MyBinNode) v.parent();
	}
	public MyBinNode Left(MyBinNode v) {
		return (MyBinNode) v.left();
	}
	public MyBinNode Right(MyBinNode v) {
		return (MyBinNode) v.right();
	}
	public static boolean hasLeft(MyBinNode v) {
		return (MyBinNode) v.left() != null;
	}
	public static boolean hasRight(MyBinNode v) {
		return (MyBinNode) v.right() != null;
	}
	public MyBinNode addRoot(Object e) {
		MyBinNode temp = this.root;
		this.root = new MyBinNode(e);
		this.size = 1;
		return temp;
	}
	public MyBinNode addNode(Object e) {
		MyBinNode an = new MyBinNode(e);
		an.setParent(this.root);
		this.root.children().add(an);
		this.size++;
		return an;
	}
	public MyBinNode insertLeft(MyBinNode v, Object e) {
		MyBinNode ln = new MyBinNode(e);
		ln.setParent(v);
		v.setLeft(v);;
		this.size++;
		return ln;
	}
	public MyBinNode insertRight(MyBinNode v, Object e) {
		MyBinNode ln = new MyBinNode(e);
		ln.setParent(v);
		v.setRight(v);
		this.size++;
		return ln;
	}
	public Object replace(MyBinNode v, Object e) {
		v.setElement(e);
		return e;
	}
	public MyBinNode remove(MyBinNode v) throws TwoChildrenException {
		if(hasRight(v) && hasLeft(v)) {
			throw new TwoChildrenException("two children error");
		}
		else if(hasLeft(v)){
			MyBinNode temp = new MyBinNode(v.children());
			v.parent().children().set(0, temp);
			return temp;
		}
		else if (hasRight(v)) {
			MyBinNode temp = new MyBinNode(v.children());
			v.parent().children().set(1, temp);
			return temp;
		}
		else {
			v.parent().children().remove(0);
			return v;
		}
	}
	public static void printExpr(MyBinNode v) {
		if(hasLeft(v)) {
			System.out.println("(");
			printExpr(v.left());
		}
		System.out.println(v.element());
		if(hasRight(v)) {
			printExpr(v.right());
			System.out.println(")");
		}
	}
	
	public class TwoChildrenException extends Exception{
		public TwoChildrenException(String msg) {
			super(msg);
		}
	}
}
