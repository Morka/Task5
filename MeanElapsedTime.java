public class MeanElapsedTime implements ElapsedTime /*or implements depanding on ElapsedTime*/{
	
	private Set<Double> times;

	public MeanElapsedTime(Set<Double> times){
		this.times = times;
	}
	
	public int count(){
		int countTimes = 0;
		while(times.iterator().hasNext()){
			countTimes++;
		}
		
		return countTimes;
	}

	@Override
	public boolean shorter(Object compareTo) {
		// TODO Auto-generated method stub
		return false;
	}
}
