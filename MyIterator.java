import java.util.Iterator;

public class MyIterator<T extends ElapsedTime, E> implements Iterator<T>{
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
	
	public TheOtherIterator<E> iterator(){
		return new TheOtherIterator<E>(p.getElementHead());
	}
}
