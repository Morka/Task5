
/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class CompositeTime implements ElapsedTime{
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
	
	//noch nicht fertig
	/*public boolean shorter(T compareTo) {
		double sum = sum();
	
		if(sum < compareTo.getTime())
			
		return true;
	}*/
	
	private double sum() {
		double sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		return sum;
	}

	@Override
	public boolean shorter(Object compareTo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
