/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Description implements Shorter<Description> {
	
	private String value;
	
	/**
	 * Instantiates a new Description object with the given string value
	 * 
	 * @param string	the string to be set inside the Object
	 */
	public Description(String string){
		
		this.value = string;
		
	}

	/**
	 * Returns true if this objects saved string is shorter than the string in the object compareTo
	 * 
	 * @param compareTo	the string which will be compared to this Descriptions string
	 */
	public boolean shorter(Description compareTo) {
		
		if(this.value.length() < compareTo.toString().length()){
			
			return true;
			
		} else {
			
			return false;
			
		}
	}
	
	/**
	 * Returns a the string saved in this Description object
	 * 
	 */
	public String toString() {
		
		return value;
		
	}
	
	/**
	 * Calculates the number of lines of the string inside this Object
	 * 
	 * @return	number of lines of value
	 */
	public int lineCount() {
		
		return value.split("\n").length;
		
	}
	

}
