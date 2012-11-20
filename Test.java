/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

import java.util.Iterator;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Set<Double> set = new Set<Double>();
		set.insert(3.2);
		set.insert(4.2);
		set.insert(5.2);
		MeanElapsedTime etime = new MeanElapsedTime(set); //mean = 4.2
		
		double[] darray1 = {3.14, 7.26, 4.2}; 
		CompositeTime ctime1 = new CompositeTime(darray1); //compositeTime = 14.6
		
		double[] darray2 = {1.1, 2.2}; 
		CompositeTime ctime2 = new CompositeTime(darray2); //compositeTime = 3.3
		
		System.out.println(ctime1.shorter(etime)); //14.6 < 4.2 --> false
		System.out.println(etime.shorter(ctime2)); //4.2 < 3.3 --> false
		System.out.println(ctime2.shorter(ctime1)); //3.3 < 14.2 --> true
		
		
		//OrderedSet + Description Test
		Description desc1 = new Description("I? I am a monument to all your sins.");
		Description desc2 = new Description("This one is machine and nerve,\nand has its mind concluded.\nThis one is but flesh and faith,\nand is the more deluded.");
		Description desc3 = new Description("There is much talk, and I have listened,\nthrough rock and metal and time.\nNow I shall talk, and you shall listen.");
		Description desc4 = new Description("Silence fills the empty grave,\nnow that I have gone.\nBut my mind is not at rest,\nfor questions linger on.\nI will ask, and you will answer.");
		Description desc5 = new Description("We exist together now,\ntwo corpses in one grave...");
		Set<Description> ordSet = new Set<Description>(); 
		//die schranke ist. Kann des wer loesen? I hab da grad an knopf im denken...I vermut es geht irgendwie mit wildcards aber leider wenn i a Shorter<?> mach in OrderedSet dann bugged da rest
		//System.out.println(string4);
		

		//OrderedMap<String, Double> test = new OrderedMap<String, Double>();	
	}
}
