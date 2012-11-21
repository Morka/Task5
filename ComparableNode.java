public class ComparableNode<T extends Shorter<T>>{
	private T element; // element in node
	private ComparableNode<T> next = null; // next node in list
	
	/**
	 * Instantiates a new ComparableNode object with a given element
	 * 
	 * @param elem	the element inside the new node
	 */
	public ComparableNode (T elem) {
		//Precondition: elem != null
		//Postcondition: element of the node is set
		this.element = elem;
	}
	
	/**
	 * Retrieves the next node in the OrderedSet
	 * 
	 * @return	following node of the OrderedSet
	 */
	public ComparableNode<T> getNextNode(){
		//Postondition: returns the following node
		return next;
	}
	
	/**
	 * Sets the next node in the OrderedSet
	 * 
	 * @param next	the next node in the OrderedSet
	 */
	public void setNextNode(ComparableNode<T> next){
		//Precondition: next != null
		//Postcondition: next gets set to a new node
		this.next = next;
	}
	
	/**
	 * Sets the element in the node
	 * 
	 * @param element	the new element in the node
	 */
	public void setElement(T element){
		//Precondition: element != null
		//Postcondition: element gets set to the new element
		this.element = element;
	}
	
	/**
	 * Returns the element from the node
	 * 
	 * @return	the element inside the node
	 */
	public T getElement(){
		//Postcondition: returns the element in this node
		return element;
	}
	
	/**
	 * Checks if the element in the node is equal a given element, if not and there is a next node it will ask this node to check
	 * 
	 * @param elem	the element which will be compared to the node
	 * @return	true if the element is equal to the element in the node
	 */
	public boolean contains(T elem){
		//Precondition: elem != null
		//Postcondition: returns true if the elem is in this or a following node
		return elem.equals(element) || (next != null && next.contains(elem));
		
	}
	
	/**
	 * Inserts a new element at the appropriate position in the node chain
	 * 
	 * @param element	the new element to insert
	 */
	public void insert(T element){
		//Precondition: element != null
		//Postcondition: inserts element at the suitable position

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


