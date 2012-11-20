
/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class CompositeTime implements ElapsedTime {
	private double[] array;
	
	public CompositeTime(double[] times) {
		array = times;
	}
	
	public int count() {
		return array.length;
	}
	
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
	
	
	public boolean shorter(ElapsedTime compareTo) {
		double sum = sum();
	
		if(sum < compareTo.toBeCompared())	
			return true;
		else
			return false;
	}
	
	public double toBeCompared() {
		return sum();
	}
	
	private double sum() {
		double sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		return sum;
	}
}
