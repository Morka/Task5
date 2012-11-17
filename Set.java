/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

import java.lang.IllegalStateException; 
import java.lang.Iterable; //Implementing this interface allows an object to be the target of the "foreach" statement.
import java.util.Iterator;

public class Set<T> implements Iterable<T> {
	
	public class Node<T> {
		private T element; // element in node
		private Node<T> next = null; // next node in list
	
		public Node (T elem) {
			this.element = elem;
		}
	}	
	
	private Node<T> head = null;  // first node of list
	private Node<T> tail = null;  // last list node
	
	private class MyIterator<T> implements Iterator<T> {
		private Node<T> p = (Node<T>) head; // iterator position
		private Node<T> prev = null; //previous Node Element of current iterator position
		
		public T next() {      // get next list element
			if (p == null)
				return null;
			T element = p.element;
			prev = p;
			p = p.next;
		
			return element;
		}
		
		public boolean hasNext() {  // more elements?
			return p != null;
		}
		
		public void remove() {
			if(prev != null) 
				prev.next = p.next;
			else
				throw new IllegalStateException();
			}
	}	
	
	//Returns an iterator over a set of elements of type T.
	public Iterator<T> iterator() {
		return new MyIterator<T>();
	}
	
	public void insert(T element) {
		if(!contains(element)) {
			
			if (head == null)
				tail = head = new Node<T>(element);
			else
				tail = tail.next = new Node<T>(element);
		}
	}		
	
	//check if identic
	public boolean contains(T element) {
		Node<T> p = head;
		
		while(p != null) {
			if(p.element == element)
				return true;
			p = p.next;
		}
		
		return false;
	}
}