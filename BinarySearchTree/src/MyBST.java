import java.util.ArrayList;

public class MyBST extends MyBinTree {
	MyBST(){super();}
	MyBST(Object e){super(e);}
	
	private MyBinNode nextNode(MyBinNode v) {
		MyBinNode temp = v.right();
		while(true) {
			if(this.hasLeft(temp))
				temp = temp.left();
			else
				break;
		}
		return temp;
	}
	public Object find(Object k) {
		MyBinNode temp = this.root();
		while(temp!=null) {
			if((int)temp.element() == (int)k)
				break;
			else
				temp = (int)k<=(int)temp.element() ? temp.left() : temp.right();
		}
		return temp;
	}
	public ArrayList findAll(Object k) {
		ArrayList foundList = new ArrayList();
		MyBinNode temp = this.root();
		while(temp!=null) {
			if((int)temp.element() == (int)k)
				foundList.add(temp);
			temp = (int)k<=(int)temp.element() ? temp.left() : temp.right();
		}
		return foundList;
	}
	public Object insert(Object k) {
		totalSize++;
		//size==0�϶�
		if(this.root()==null) {
			this.addRoot(k);
			return this.root();
		}
		
		//size>0 �϶�
		MyBinNode toAdd = new MyBinNode(k);
		MyBinNode parent=null;
		MyBinNode temp = this.root();
		while(temp!=null) {
			parent = temp;
			temp = (int)k<=(int)temp.element() ? temp.left() : temp.right(); 
		}
		if((int)k <= (int)parent.element())
			parent.setLeft(toAdd);
		else
			parent.setRight(toAdd);
		toAdd.setParent(parent);
		return toAdd;
	}
	public Object remove(Object k) {
		MyBinNode found = (MyBinNode)this.find(k);

        if(found == null) // ���� ��带 ��ã�� ���
            return null;

        MyBinNode parent = (MyBinNode)found.parent();
        MyBinNode toSwap;
        if(!this.hasLeft(found) && !this.hasRight(found)) // �ڽ��� ���� ���
            toSwap = null;
        else if(this.hasLeft(found) && this.hasRight(found)){ // �ڽ��� ���� ���
        	toSwap = this.nextNode(found);
            // inOrder ������ ���� ��� ã��
            
        	if(((MyBinNode)toSwap.parent()).left()==toSwap)
        		((MyBinNode)toSwap.parent()).setLeft(null);
        	else
        		((MyBinNode)toSwap.parent()).setRight(null);
        	
            //�ű� ��尡 �������� �ٷ� �� ����� ��� (�ڱ��ڽ��� ���� �����ϴ°��� ����)
            toSwap.setLeft(found.left());
            if(found.right() != toSwap)
                toSwap.setRight(found.right());
        }else if(found.left() != null) // ���� �ڽĸ� �ִ� ���
            toSwap = found.left();
        else { // ���� �ڽĸ� �ִ� ���
            toSwap = found.right();
        }
        
    	if(toSwap!=null && ((MyBinNode)toSwap.parent()).left()==toSwap) {
    		((MyBinNode)toSwap.parent()).setLeft(null);
    	}
    	else if(toSwap!=null && ((MyBinNode)toSwap.parent()).right()==toSwap) {
    		((MyBinNode)toSwap.parent()).setRight(null);
    	}
    		

       
        if(parent == null)
            root = toSwap;
        else if(parent.left() == found)
            parent.setLeft(toSwap);
        else
            parent.setRight(toSwap);

        // �������� �θ� ����
        if(toSwap!=null)
            toSwap.setParent(parent);
        
        // ���� ����� �ʱ�ȭ �۾�
        found.setParent(null);
        found.setLeft(null);
        found.setRight(null);
        totalSize--;
        
        return found;
		
	}
}
