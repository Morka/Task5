public class NodeMap<T extends ElapsedTime, E>{
	private NodeMap<T, E> next = null;
	private T element;
	private Node<E> elementHead;
	
	/**
	 * Instantiates a new NodeMap object with a given element
	 * 
	 * @param elem	the element inside the new node
	 */
	public NodeMap(T elem, E elementHead){
		this.elementHead = new Node<E>(elementHead);
		this.element = elem;
	}
	/**
	 * Retrieves the next node 
	 * 
	 * @return	following node
	 */
	
	public NodeMap<T, E> getNextNode(){
		return next;
	}
	/**
	 * Sets the next node
	 * 
	 * @param next the next node
	 */
	public void setNextNode(NodeMap<T, E> next){
		this.next = next;
	}
	/**
	 * Sets the element in the node
	 * 
	 * @param element the new element in the node
	 */
	
	public void setElement(T element){
		this.element = element;
	}
		
	/**
	 * Returns the element from the node
	 * 
	 * @return	the element inside the node
	 */
	
	public T getElement(){
		return element;
	}
	/**
	 * Returns the element of second Type from the node
	 * 
	 * @return	the element of second Type inside the node
	 */
	public Node<E> getElementHead(){
		return elementHead;
	}
	/**
	 * Checks if the element in the node is equal a given element, if not and there is a next node it will ask this node to check
	 * 
	 * @param elem the element which will be compared to the node
	 * @return	true if the element is equal to the element in the node
	 */
	
	public boolean contains(T elem){
		return elem.equals(element) || (next != null && next.contains(elem));
	}
	/**
	 * Inserts a new element at the appropriate position in the node chain
	 * 
	 * @param element the new element to insert
	 */
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
