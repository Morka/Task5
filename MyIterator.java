import java.util.Iterator;

public class MyIterator<T extends ElapsedTime, E> implements Iterator<T>{
	private NodeMap<T, E> p;
	private NodeMap<T, E> prev;
	
	/**
		 * Instantiates a new iterator with the first node in the set
		 * 
		 * @param first	the first node in the set
		 */
	public MyIterator(NodeMap<T, E> first){
		this.p = first;
		this.prev = null;
		
	}
	/**
	 * Returns the next element from the Map
	 * 
	 */
	public T next(){
		if(p == null){
			return null;
		}
		T element = p.getElement();
		prev = p;
		p = p.getNextNode();
		
		return element;
	}
	/**
	 * returns true if there is a next element in the set
	 * 
	 */
	public boolean hasNext(){
		if(p != null){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * removes the current node from the set
	 * 
	 */
	public void remove(){
		if(prev != null){
			prev = p.getNextNode();
		}
		else{
			throw new IllegalStateException();
		}
	}
	/**
	 * Gives back iterator which iterates through elements E
	 * @return new TheOtherIterator
	 * 
	 */
	
	public TheOtherIterator<E> iterator(){
		return new TheOtherIterator<E>(p.getElementHead());
	}
}
