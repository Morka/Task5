/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

import java.util.Iterator;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> stringset = new Set<String>();
		
		stringset.insert("Hallo");
		stringset.insert("Wolfgang");
		stringset.insert("Wie");
		stringset.insert("geht");
		stringset.insert("es");
		stringset.insert("dir?");
		
		String str = "Danke, sehr gut";
		stringset.insert(str);

		
		Iterator<String> it = stringset.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		

	}

}
