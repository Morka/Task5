import java.util.Iterator;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class MeanElapsedTime<T extends ElapsedTime> implements ElapsedTime{
	
	private Set<Double> times;

	public MeanElapsedTime(Set<Double> times){
		this.times = times;
	}
	
	
	public int count(){
		int countTimes = 0;
		
		Iterator iter = times.iterator();
		while(iter.hasNext()){
			iter.next();
			countTimes++;
		}
		
		return countTimes;
	}
	
	public void addTimes(double time){
		times.insert(time);
	}
	
	public boolean shorter(T compareTo){
		double mean = this.toBeCompared();
		
		if(mean < compareTo.toBeCompared()){
			return true;
		}else{
			return false;
		}
	}
	
	public double toBeCompared(){
		return mean();
	}
	
	private double mean(){
		Iterator iter = times.iterator();
		
		double sum = 0.0;
	/*	
		while(iter.hasNext()){
			Node<Double> tmp = iter.next();
			sum += tmp.getElement();
			
		}
		
		return sum / this.count();
	}
	
	public double longestTime(){
		Iterator iter = times.iterator();
		double longest = 0.0;
		
		while(iter.hasNext()){
			Node<Double> tmp = iter.next();
			if(tmp.getElement() < longest){
				longest = tmp.getElement();
			}
			
		}
		return longest;
	*/
	return sum;}

	@Override
	public boolean shorter(Object compareTo) {
		// TODO Auto-generated method stub
		return false;
	}
}
