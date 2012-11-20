import java.util.Iterator;

/**
* @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
*/

public class OrderedMap<T extends Shorter<T>,E> extends OrderedSet<T> implements Iterable<T>{
	private NodeMap<T, E> head;
	private NodeMap<T, E> tail;
	
	//Use if OrderedSet is not possible 
	
	public void insert(T element, Node<E> secondElement){
		if(!contains(element)) {
			
			head.insert(element, secondElement);
			
		}
	}		
	
	//check if identic
	private boolean contains(T element) {
		
		return head != null && head.contains(element);
		
	}
	public Iterator<T> iterator(){
		return new MyIterator<T, E>(head);
	}
	
	private class MyIterator<T extends Shorter<T>, E> implements Iterator<T>, Iterable<E>{
		private NodeMap<T, E> p;
		private NodeMap<T, E> prev;
		
		public MyIterator(NodeMap<T, E> first){
			this.p = first;
			this.prev = null;
			
		}
		
		public T next(){
			if(p == null){
				return null;
			}
			T element = p.getElement();
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
		/*
		private class TheOtherIterator<E> extends MyIterator implements Iterator<E>{
		private Node<E> p;
		private Node<E> prev = null;
		
		public TheOtherIterator(Node<E> theOtherFirst){
		this.p = theOtherFirst;
		prev = null;
		}
		
		public void add(Node<E> newNode){
		prev.setNextNode(newNode);
		newNode.setNextNode(p);
		}
		
		/*	
		REMOVE IS MISSING!
		
		*/
		
		//}
		
		public Iterator<E> iterator(){
			return new TheOtherIterator<E>(p.getElementHead());
		}
	}
	
}
