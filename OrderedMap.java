import java.util.Iterator;

/**
* @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
*/

public class OrderedMap<T extends Shorter<T>,E> /*extends OrderedSet<T>*/{
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
	public MyIterator<T, E> iterator(){
		return new MyIterator<T, E>(head);
	}
	
	
}
