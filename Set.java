/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

import java.lang.IllegalStateException; 
import java.lang.Iterable; //Implementing this interface allows an object to be the target of the "foreach" statement.
import java.util.Iterator;

public class Set<T> implements Iterable<T> {
	
	private Node<T> head = null;  // first node of list
	private Node<T> tail = null;  // last list node

	//Returns an iterator over a set of elements of type T.
	public Iterator<T> iterator() {
		return new MyIterator<T>(head);
	}
	
	public void insert(T element) {
		if(!contains(element)) {
			
			if (head == null)
				tail = head = new Node<T>(element);
			else{
				tail = new Node<T>(element);
				tail.setNextNode(new Node<T>(element));
			}
		}
	}		
	
	//check if identic
	public boolean contains(T element) {
		Node<T> p = head;
		
		while(p != null) {
			if(p.getElement() == element)
				return true;
			p = p.getNextNode();;
		}
		
		return false;
	}
}