/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public interface ElapsedTime extends Shorter<ElapsedTime>{//if not as interface then like MeanElapsedTime
	
	//public boolean shorter(T compareTo);
	public int count();
	
	public double toBeCompared();


}
