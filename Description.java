/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Description<T extends Shorter>{
	
	private String value;
	
	public Description(String string){
		
		this.value = string;
		
	}

	public boolean shorter(T compareTo) {
		
		if(this.toBeCompared() < compareTo.toBeCompared()){
			
			return true;
			
		} else {
			
			return false;
			
		}
	}
	
	public double toBeCompared(){
		return value.length();
	}
	
	public String toString() {
		
		return value;
		
	}
	
	public int lineCount() {
		
		return value.split("\n").length;
		
	}
	

}
