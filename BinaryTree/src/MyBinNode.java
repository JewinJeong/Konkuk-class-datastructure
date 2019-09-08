import java.util.ArrayList;

public class MyBinNode extends MyNode {
	private Object element;
	private MyBinNode left;
	private MyBinNode right;
	
	public MyBinNode() {
		super();
	}
	public MyBinNode(Object e) {
		super(e);
		super.setChildren(new ArrayList<MyNode>(2));
		super.children().add(0,null);
		super.children().add(1,null);
	}
	public MyBinNode left() {
		return (MyBinNode) this.children().get(0);
	}
	public MyBinNode right() {
		return (MyBinNode) this.children().get(1);
	}
	public void setLeft(MyBinNode v) {
		this.children().add(0,v);
		v.setParent(this);
	}
	public void setRight(MyBinNode v) {
		this.children().add(1,v);
		v.setParent(this);
	}
}
