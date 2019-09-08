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
		//size==0일때
		if(this.root()==null) {
			this.addRoot(k);
			return this.root();
		}
		
		//size>0 일때
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

        if(found == null) // 지울 노드를 못찾은 경우
            return null;

        MyBinNode parent = (MyBinNode)found.parent();
        MyBinNode toSwap;
        if(!this.hasLeft(found) && !this.hasRight(found)) // 자식이 없는 경우
            toSwap = null;
        else if(this.hasLeft(found) && this.hasRight(found)){ // 자식이 둘인 경우
        	toSwap = this.nextNode(found);
            // inOrder 순서상 다음 노드 찾기
            
        	if(((MyBinNode)toSwap.parent()).left()==toSwap)
        		((MyBinNode)toSwap.parent()).setLeft(null);
        	else
        		((MyBinNode)toSwap.parent()).setRight(null);
        	
            //옮길 노드가 지울노드의 바로 밑 노드인 경우 (자기자신을 무한 참조하는것을 방지)
            toSwap.setLeft(found.left());
            if(found.right() != toSwap)
                toSwap.setRight(found.right());
        }else if(found.left() != null) // 왼쪽 자식만 있는 경우
            toSwap = found.left();
        else { // 우측 자식만 있는 경우
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

        // 지운노드의 부모 갱신
        if(toSwap!=null)
            toSwap.setParent(parent);
        
        // 지울 노드의 초기화 작업
        found.setParent(null);
        found.setLeft(null);
        found.setRight(null);
        totalSize--;
        
        return found;
		
	}
}
