public class ComparableNode<T extends Shorter<T>>{
	private T element; // element in node
	private ComparableNode<T> next = null; // next node in list
	
	public ComparableNode (T elem) {
		this.element = elem;
	}
	
	public ComparableNode<T> getNextNode(){
		return next;
	}
	
	public void setNextNode(ComparableNode<T> next){
		this.next = next;
	}
	
	public void setElement(T element){
		this.element = element;
	}
	
	public T getElement(){
		return element;
	}
	
	public boolean contains(T elem){
		
		return elem.equals(element) || (next != null && next.contains(elem));
		
	}
	
	public void insert(T element){
		
		if(this.element.shorter(element)){
			
			if(next != null){
				
				next.insert(element);
				
			} else {
				
				next = new ComparableNode<T>(element);
				
			}
			
		} else {
			
			ComparableNode<T> newNextNode = new ComparableNode<T>(this.element);
			newNextNode.setNextNode(this.next);
			this.element = element;
			this.next = newNextNode;
			
		}
		
	}
}	


