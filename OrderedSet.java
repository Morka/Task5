/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

import java.lang.IllegalStateException; 
import java.lang.Iterable; //Implementing this interface allows an object to be the target of the "foreach" statement.
import java.util.Iterator;

public class OrderedSet<T extends Comparable<T>> implements Shorter<T>, Iterable<T> {
	
	private ComparableNode<T> head = null;
	private ComparableNode<T> tail = null;
	
	private class MyOrderedIterator<T extends Comparable<T>> implements Iterator<T> {
		private ComparableNode<T> p; // iterator position
		private ComparableNode<T> prev; //previous Node Element of current iterator position
		
		public MyOrderedIterator(ComparableNode<T> first){
			p = first;
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
				prev.setNextNode(p.getNextNode());
			else
				throw new IllegalStateException();
			}
	}	
	
	public void insert(T element) {
		if(!contains(element)) {

			head.insert(element);

		}
	}		
	
	//check if identic
	private boolean contains(T element) {
		ComparableNode<T> p = head;
		
		while(p != null) {
			if(p.getElement() == element)
				return true;
			p = p.getNextNode();;
		}
		
		return false;
	}
	
	public boolean shorter(T toCompare){
		
		/*if(toCompare.compareTo(this.head)){
			
			
			
		}*/
		
		return false;
		
	}
	
	public Iterator<T> iterator() {
		
		return new MyOrderedIterator<T>(head);
		
	}
	
}