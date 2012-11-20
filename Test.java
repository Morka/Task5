/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

import java.util.Iterator;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<CompositeTime> set = new Set<CompositeTime>();
		double[] darray = {3.14, 7.18, 4.23};
		CompositeTime ctime = new CompositeTime(darray);
		//ElapsedTime etime = new ElapsedTime(10.3);
		
		//set.insert(ctime);
		
		//Iterator<CompositeTime> it = set.iterator();
		//while(it.hasNext()) {
		//	System.out.println(ctime.shorter(etime));
		//}
		
		//OrderedSet + Description Test
		Description desc1 = new Description("I? I am a monument to all your sins.");
		Description desc2 = new Description("This one is machine and nerve,\nand has its mind concluded.\nThis one is but flesh and faith,\nand is the more deluded.");
		Description desc3 = new Description("There is much talk, and I have listened,\nthrough rock and metal and time.\nNow I shall talk, and you shall listen.");
		Description desc4 = new Description("Silence fills the empty grave,\nnow that I have gone.\nBut my mind is not at rest,\nfor questions linger on.\nI will ask, and you will answer.");
		Description desc5 = new Description("We exist together now,\ntwo corpses in one grave...");
		OrderedSet<Description> ordSet = new OrderedSet<Description>();//WIE BITTE WAS? Das problem is glaub ich weil Description ja Shorter<String> implementiert aber in OrderedSet Shortert<T> 
		//die schranke ist. Kann des wer loesen? I hab da grad an knopf im denken...I vermut es geht irgendwie mit wildcards aber leider wenn i a Shorter<?> mach in OrderedSet dann bugged da rest
		//System.out.println(string4);
		
		OrderedMap<String, Double> test = new OrderedMap<String, Double>();	

	}
}
