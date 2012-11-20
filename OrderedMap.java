/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class OrderedMap<T extends Shorter<T>,E> extends OrderedSet<T> implements Iterable<T>{
	private ComparableNode<T> head;
	private ComparableNode<T> tail;
	
	private Node<E> theOtherHead;
	private Node<E> theOtherTail;
	
	//Use if OrderedSet is not possible 
	/*
	public void insert(T element){
		if(!contains(element)) {

			head.insert(element);

		}
	}		
	
	//check if identic
	private boolean contains(T element) {

		return head != null && head.contains(element);

	}*/
	
	private class MyIterator<T>{
		private Node<T> p;
		private Node<T> prev;
		
		public MyIterator(Node<T> first){
			p = first;
			prev = null;
			
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
	}
	
}
