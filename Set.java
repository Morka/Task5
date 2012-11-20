/**
* @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
*/


import java.lang.IllegalStateException; 
import java.lang.Iterable; //Implementing this interface allows an object to be the target of the "foreach" statement.
import java.util.Iterator;

/**
 * Set<T> ist a set of instances of Typeparameter T 
 * implements the Interface Iterable<T>
 **/
public class Set<T> implements Iterable<T> {
	
	private Node<T> head;  // first node of list
	private Node<T> tail;  // last node of list
		
	/**provides Iterator for Set<T>
	 * is not allowed to throw a UnsupportedOperationException
	 */
	private class MyIterator<T> implements Iterator<T>{
		private Node<T> p; // current iterator position
		private Node<T> prev; //previous iterator position
		
		/**
	 	  * Constructor MyIterator
	 	  * @param first first Node of the List
	 	  */
		public MyIterator(Node<T> first){
			p = first;
			prev = null;
			
		}
		
		/**
	 	  * gets next Element of iterator
	 	  * Precondition: iterator must contain further element ( check by hasNext() )
	 	  * @return element (Type T) from current iterator position
	 	  */
		public T next() {      // get next list element
			if (p == null){
				return null;
			}
			T element = p.getElement();	
			prev = p;
			p = p.getNextNode();
				
			return element;
		}
		
		/**
	 	  * checks if iterator contains further elements
	 	  * 
	 	  * @return true if further elements in Iterator, otherwise false
	 	  */
		public boolean hasNext() { 
			return p != null;
		}
		
		/**
	 	  * removes last prompted Iterator Element from Set
	 	  * Precondition: next() must be executed at least once for this Iterator
	 	  */
		public void remove() {
			if(prev != null) 
				prev = p.getNextNode();
			else
				throw new IllegalStateException();
		}
	}
	
	/** 
	  * returns an iterator over a set of elements of type T
	  */
	public Iterator<T> iterator() {
		return new MyIterator<T>(head);
	}
	
	/**
	  * inserts element of Type T in Set
	  * Precondition: element kommt nur ins Set, wenn noch kein IDENTISCHES element im Set vorhanden ist
	  * @param element to insert in Set from Type T
	  */
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
	
	/**
	  * checks if IDENTIC element is in Set
	  * 
	  * @return true if IDENTIC element is in Set, otherwise false
	  */
	private boolean contains(T element) {
		Node<T> p = head;
		
		while(p != null) {
			if(p.getElement() == element)
				return true;
			p = p.getNextNode();;
		}
		
		return false;
	}
}