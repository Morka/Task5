/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Description implements Shorter<Description> {
	
	private String value;
	
	public Description(String string){
		
		this.value = string;
		
	}

	@Override
	public boolean shorter(Description compareTo) {
		
		if(this.value.length() < compareTo.toString().length()){
			
			return true;
			
		} else {
			
			return false;
			
		}
	}
	
	public String toString() {
		
		return value;
		
	}
	
	public int lineCount() {
		
		return value.split("\n").length;
		
	}
	

}
