import java.util.Iterator;

public class TheOtherIterator<E> implements Iterator{
	private Node<E> p;
	private Node<E> prev = null;
	
	public TheOtherIterator(Node<E> theOtherFirst){
		this.p = theOtherFirst;
		prev = null;
	}
	
	public void add(E newNode){
		Node<E> theNewNode = new Node<E>(newNode);
		if(p.getNextNode() == null){
			p.setNextNode(theNewNode);
		}else{
			theNewNode.setNextNode(p.getNextNode());
			p.setNextNode(theNewNode);
		}
		
	}
	
	public E next(){
		if(p == null){
			return null;
		}
		E element = p.getElement();
		prev = p;
		p = p.getNextNode();
		
		return element;
	}
	
	public boolean hasNext(){
		if(p != null){
			return true;
		}
		else{
			return false;
		}
	}
	public void remove(){
		if(prev != null){
			prev = p.getNextNode();
		}
		else{
			throw new IllegalStateException();
		}
	}
}
