public class OrderedMap<T,E> extends Set<T> implements Iterable<T>{
	private Node<T> head;
	private Node<T> tail;
	
	private Node<E> theOtherHead;
	private Node<E> theOtherTail;
	
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
