/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public interface Shorter<T> {

	public boolean shorter(T compareTo);
	
	public double toBeCompared();	
}
