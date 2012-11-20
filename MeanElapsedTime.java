import java.util.Iterator;

public class MeanElapsedTime implements ElapsedTime /*or implements depanding on ElapsedTime*/ {
	private Set<Double> times;

	public MeanElapsedTime(Set<Double> times){
		this.times = times;
	}
	
	public int count(){
		int countTimes = 0;
		
		Iterator<Double> iter = times.iterator();
		while(iter.hasNext()) {                          
			countTimes++;
		}
		
		return countTimes;
	}
	
	public void addTimes(double time){
		times.insert(time);
	}
	
	public double longestTime(){
		Iterator<Double> iter = times.iterator();
		double longest = 0.0;
		
		while(iter.hasNext()){
			double tmp = iter.next();
			if(tmp < longest){
				longest = tmp;
			}
		}
		return longest;
	}
	
	

	
	public boolean shorter(ElapsedTime compareTo) {
		double mean = this.toBeCompared();
		
		if(mean < compareTo.toBeCompared()){
				return true;
		} else {
				return false;
		}
	}

	private double mean(){
		
		Iterator<Double> iter = times.iterator();
		
		double sum = 0.0;
		/*	
		while(iter.hasNext()){
			Node<Double> tmp = iter.next();
			sum += tmp.getElement();
		
		}*/
			return sum;
	}

	
	public double toBeCompared() {
		return mean();
	}
}
