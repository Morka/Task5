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
		//Precondition: string != null
		//Postcondition: String gets its value assigned
		this.value = string;
		
	}

	/**
	 * Returns true if this objects saved string is shorter than the string in the object compareTo
	 * 
	 * @param compareTo	the string which will be compared to this Descriptions string
	 */
	public boolean shorter(Description compareTo) {
		//Precondition: compareTo != null
		//Postcondition: returns true if the string in this Description is shorter than the one in compareTo
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
		//Postcondition: returns the String value
		return value;
		
	}
	
	/**
	 * Calculates the number of lines of the string inside this Object
	 * 
	 * @return	number of lines of value
	 */
	public int lineCount() {
		//Postcondition: returns the line count of this class' string; retrun value > 0
		return value.split("\n").length;
		
	}
	

}
