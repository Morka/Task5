public class Node<T> {
	private T element; // element in node
	private Node<T> next = null; // next node in list
	
	public Node (T elem) {
		this.element = elem;
	}
	
	public Node<T> getNextNode(){
		return next;
	}
	
	public void setNextNode(Node<T> next){
		this.next = next;
	}
	
	public void setElement(T element){
		this.element = element;
	}
	
	public T getElement(){
		return element;
	}
}	


