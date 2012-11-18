import java.util.Iterator;

public class MyIterator<T> implements Iterator<T>{
	private Node<T> p; // iterator position
	private Node<T> prev; //previous Node Element of current iterator position
	
	public MyIterator(Node<T> head){
		p = head;
		prev = null;
	
	}
	
	public T next() {      // get next list element
		if (p == null)
			return null;
		T element = p.getElement();
		prev = p;
		p = p.getNextNode();
		
		return element;
	}
	
	public boolean hasNext() {  // more elements?
		return p != null;
	}
	
	public void remove() {
		if(prev != null) 
			prev = p.getNextNode();
		else
			throw new IllegalStateException();
	}
}
