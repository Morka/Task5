/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public interface ElapsedTime<T> extends Shorter<T>{//if not as interface then like MeanElapsedTime
	
	//public boolean shorter(T compareTo);
	public int count();


}
