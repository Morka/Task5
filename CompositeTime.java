
/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class CompositeTime<T> implements ElapsedTime<T>{
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
	
	
	public boolean shorter(T compareTo) {
		double sum = sum();
	
		if(sum < 1/*compareTo.getTime()*/)	
			return true;
		else
			return false;
	}
	
	public double getTime() {
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
