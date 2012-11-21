import java.util.Iterator;

public class MeanElapsedTime implements ElapsedTime /*or implements depanding on ElapsedTime*/ {
	private Set<Double> times;
	
	/**
	  * Constructor
	  * @param times initializes the Set<Double>;
	  */
	public MeanElapsedTime(Set<Double> times){
		this.times = times;
	}
	
	/**
	  * Counts number of times in "times"
	  * @return count of times in "times" 
	  */
	
	public int count(){
		int countTimes = 0;
		
		Iterator<Double> iter = times.iterator();
		while(iter.hasNext()) { 
			iter.next();
			countTimes++;
		}
		return countTimes;
	}
	
	/**
	  * Ads new Times to the set
	  * @param time time to be added;
	  * Postcondition: time is added to times
	  */
	public void addTimes(double time){
		times.insert(time);
	}
	
	/**
	  * computets longest time
	  * @return longest time in the set
	  * Postcondition: returned double value that contains the longest time in set
	  */
	
	public double longestTime(){
		Iterator<Double> iter = times.iterator();
		double longest = 0.0;
		
		if(iter.hasNext()){
			longest = iter.next();
		}else{
			return longest;
		}
		
		while(iter.hasNext()){
			double tmp = iter.next();
			if(tmp > longest){
				longest = tmp;
			}
		}
		return longest;
	}
	
	/** Method from interface Shorter
	  * takes the own comparative value and compares it with the comparative value of compareTo
	  * 
	  * @return if mean < comparative value -> true, otherwise false
	  * Precondtion: compareTo != null
	  */
	
	public boolean shorter(ElapsedTime compareTo) {
		double mean = this.mean();
		
		if(mean < compareTo.toBeCompared()){
			return true;
		} else {
			return false;
		}
	}
	/** 
	  * algorithm to find the comparative value
	  * takes the mean of all individual time
	  * 
	  * @return mean of all individual time
	  * Postcondition: return value is mean of times
	  */
	
	private double mean(){
		
		Iterator<Double> iter = times.iterator();
		
		double sum = 0.0;
		
		while(iter.hasNext()){
			double tmp = iter.next();
			sum += tmp;
			
		}
		return sum / this.count();
	}
	
	/** Method from interface ElapsedTime
	  * provides comparative value for ElapsedTime instances 
	  * 
	  * @return comparative value of MeanElapsedTime
	  */
	public double toBeCompared() {
		return mean();
	}
}
