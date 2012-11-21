import java.util.Iterator;

/**
* @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
*/

public class OrderedMap<T extends ElapsedTime,E> extends Set<T>{
	private NodeMap<T, E> head = null;
	private NodeMap<T, E> tail = null;
	
	/**
	* Instantiates a new iterator with the first node in the map
	* 
	* @param first the first node in the map
	* Postcondition: Element T is in the Map
	*/
	public void insert(T element, E secondElement){
		if(!contains(element)) {
			if(head == null){
				head = new NodeMap<T,E>(element, secondElement);
			}else{
			
			head.insert(element, secondElement);
			}
		}
	}		
	/**
	 * Checks wheter the OrderedMap contains an element or not
	 * 
	 * @param element the element to be checked
	 * @return	true of the element is inside the OrderedMap
	 * Precondition: element != null
	 */
	private boolean contains(T element) {
		
		return head != null && head.contains(element);
		
	}
	/**
	* Returns a new MyIterator Object over T in OrderMap
	*/
	public MyIterator<T,E> iterator(){
		return new MyIterator<T, E>(head);
	}
	
	
}
