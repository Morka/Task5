import java.util.Iterator;

public class MeanElapsedTime implements ElapsedTime /*or implements depanding on ElapsedTime*/{
	
	private Set<Double> times;

	public MeanElapsedTime(Set<Double> times){
		this.times = times;
	}
	
	public int count(){
		int countTimes = 0;
		
		Iterator iter = times.iterator();
		while(iter.hasNext()){                          
			countTimes++;
		}
		
		return countTimes;
	}
	
	public void addTimes(double time){
		times.insert(time);
	}
	
	public double longestTime(){
		Iterator iter = times.iterator();
		double longest = 0.0;
		
		while(iter.hasNext()){
			Node<Double> tmp = iter.next().getElement();
			if(tmp.getElement() < longest){
				longest = tmp.getElement();
			}
		}
		return longest;
	}

	@Override
	public boolean shorter(Object compareTo) {
		// TODO Auto-generated method stub
		return false;
	}
}
