import java.util.Iterator;

/**
* @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
*/

public class OrderedMap<T extends Shorter<T>,E> extends OrderedSet<T> implements Iterable<T>{
	private NodeMap<T, E> head = null;
	private NodeMap<T, E> tail = null;
	
	//Use if OrderedSet is not possible 
	
	public void insert(T element, E secondElement){
		if(!contains(element)) {
			if(head == null){
				head = new NodeMap<T,E>(element, secondElement);
			}else{
			
			head.insert(element, secondElement);
			}
			
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
			NodeMap<T,E> element = p;
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
		
		
		public Iterator<E> iterator(){
			return new TheOtherIterator<E>(p.getElementHead());
		}
	}
	
}
