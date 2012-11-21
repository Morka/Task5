public class NodeMap<T extends ElapsedTime, E>{
	private NodeMap<T, E> next = null;
	private T element;
	private Node<E> elementHead;
	
	public NodeMap(T elem, E elementHead){
		this.elementHead = new Node<E>(elementHead);
		this.element = elem;
	}
	
	public NodeMap<T, E> getNextNode(){
		return next;
	}
	
	public void setNextNode(NodeMap<T, E> next){
		this.next = next;
	}
	
	public void setElement(T element){
		this.element = element;
	}
	
	public T getElement(){
		return element;
	}
	
	public Node<E> getElementHead(){
		return elementHead;
	}
	
	public boolean contains(T elem){
		return elem.equals(element) || (next != null && next.contains(elem));
	}
	
	public void insert(T element, E secondElement){
		if(this.element.shorter(element)){
			if(next != null){
				next.insert(element, secondElement);
			}
			else{
				next = new NodeMap<T,E>(element, secondElement);
			}
		}else{
			NodeMap<T, E> newNextNode = new NodeMap<T, E>(this.element, this.elementHead.getElement());
			newNextNode.setNextNode(this.next);
			this.element = element;
			this.elementHead.setElement(secondElement);
			this.next = newNextNode;
		}
	}
}
