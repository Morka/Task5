/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

import java.lang.IllegalStateException; 
import java.lang.Iterable;
import java.util.Iterator;

public class OrderedSet<T extends Shorter<T>> implements Iterable<T> {
	
	private ComparableNode<T> head = null;
	
	private class MyOrderedIterator<T extends Shorter<T>> implements Iterator<T> {
		private ComparableNode<T> p; // current iterator position
		private ComparableNode<T> prev; //previous Node of current iterator position
		
		/**
		 * Instantiates a new iterator with the first node in the set
		 * 
		 * @param first	the first node in the set
		 */
		public MyOrderedIterator(ComparableNode<T> first){
			//Precondition: first != null
			//Postcondition: retusn an Iterator with a soutable root-node
			p = first;
			prev = null;
		}
		
		/**
		 * Returns the next element from the set
		 * 
		 */
		public T next() {
			//Postcondition: returns the next node; sets p to the node after the next node
			if (p == null)
				return null;
			T element = p.getElement();
			prev = p;
			p = p.getNextNode();
		
			return element;
		}
		
		/**
		 * returns true if there is a next element in the set
		 * 
		 */
		public boolean hasNext() {
			return p != null;
		}
		
		/**
		 * removes the current node from the set
		 * 
		 */
		public void remove() {
			//Postcondition: removes the node from the set; Must not be the first node
			if(prev != null) 
				prev.setNextNode(p.getNextNode());
			else
				throw new IllegalStateException();
			}
	}	
	
	/**
	 * Inserts a new element inside the OrderedSet
	 * 
	 * @param element	The element to insert into the set
	 */
	public void insert(T element) {
		//Precondition: element != null
		//Postcondition: element gets inserted in OrderedSet
		if(!contains(element)) {

			if(head == null){
				
				head = new ComparableNode<T>(element);
				
			} else {
				
				head.insert(element);
				
			}
			
		}
	}		
	
	/**
	 * Checks wheter the OrderedSet contains an element or not
	 * 
	 * @param element	the element to be checked
	 * @return	true of the element is inside the OrderedSet
	 */
	private boolean contains(T element) {
		//Precondition: element != null
		//Postcondition: returns whether element is in this Set or not
		return head != null && head.contains(element);

	}
	
	/**
	 * Returns a new iterator over the OrderedSet
	 * 
	 */
	public Iterator<T> iterator() {
		
		return new MyOrderedIterator<T>(head);
		
	}
	
}