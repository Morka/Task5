
/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

/**
 * CompositeTime is subtype from ElapsedTime
 * class describes the overall time of all individual time
 **/
public class CompositeTime implements ElapsedTime {
	private double[] array; //stores all individual time
	
	/**
	  * Constructor
	  * @param times initializes the double-array array;
	  */
	public CompositeTime(double[] times) {
		array = times;
	}
	
	/**
	  * counts the number of individual time
	  * 
	  * @return number of individual time
	  */
	public int count() {
		return array.length;
	}
	
	/**
	  * identifies the shortest individual time
	  * 
	  * @return shortest individual time
	  */
	public double shortestTime() {
		double shortest=0;
		
		if(array.length > 0)
			shortest = array[0];
		
		for(int i = 1; i < array.length; i++) {
			if(array[i] < shortest)
				shortest = array[i];
		}
		
		return shortest;
	}
	
	/** Method from interface Shorter
	  * takes the own comparative value and compares it with the comparative value of compareTo
	  * 
	  * @return if sum < comparative value -> true, otherwise false
	  */
	public boolean shorter(ElapsedTime compareTo) {
		double sum = sum();
	
		if(sum < compareTo.toBeCompared())	
			return true;
		else
			return false;
	}
	
	/** Method from interface ElapsedTime
	  * provides comparative value for ElapsedTime instances 
	  * 
	  * @return comparative value of CompositeTime
	  */
	public double toBeCompared() {
		return sum();
	}
	
	/** algorithm to find the comparative value
	  * takes the sum of all individual time
	  * 
	  * @return sum of all individual time
	  */
	private double sum() {
		double sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		return sum;
	}
}
