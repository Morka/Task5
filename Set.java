/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

import java.lang.IllegalStateException; 
import java.lang.Iterable; //Implementing this interface allows an object to be the target of the "foreach" statement.
import java.util.Iterator;

public class Set<T> implements Iterable<T> {
	
	private Node<T> head;  // first node of list
	private Node<T> tail;  // last list node

	//Returns an iterator over a set of elements of type T.
	public Iterator<T> iterator() {
		return new MyIterator<T>(head);
	}
	
	public void insert(T element) {
		if(!contains(element)) {
			
			if (head == null)
				tail = head = new Node<T>(element);
			else {
				tail.setNextNode(new Node<T>(element));
				tail = tail.getNextNode();
			}
		}
	}		
	
	//check if identic
	private boolean contains(T element) {//SOLL DES NET PRIVATE SEIN?? steht ja net das gefordert is also sollts private sein weil se schaun ja drauf??
		Node<T> p = head;
		
		while(p != null) {
			if(p.getElement() == element)
				return true;
			p = p.getNextNode();;
		}
		
		return false;
	}
}