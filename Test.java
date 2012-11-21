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
		Set<Double> set2 = new Set<Double>();
		set2.insert(11.1);
		set2.insert(99.2);

		MeanElapsedTime etime = new MeanElapsedTime(set); //mean = 4.2
		MeanElapsedTime etime2 = new MeanElapsedTime(set2);
		
		double[] darray1 = {3.14, 7.26, 4.2}; 
		CompositeTime ctime1 = new CompositeTime(darray1); //compositeTime = 14.6
		
		double[] darray2 = {1.1, 2.2}; 
		CompositeTime ctime2 = new CompositeTime(darray2); //compositeTime = 3.3
		
		System.out.println(ctime1.shorter(etime)); //14.6 < 4.2 --> false
		System.out.println(etime.shorter(ctime2)); //4.2 < 3.3 --> false
		System.out.println(ctime2.shorter(ctime1)); //3.3 < 14.2 --> true
		
		System.out.println("-----BEGIN OrderedSet-Test-----");
		//OrderedSet + Description Test
		//Expected Output - every node(5) of the OrderedSet with line count
		//3rd node gets deleted - all(4) remaining nodes with line count
		Description desc1 = new Description("I? I am a monument to all your sins.");
		Description desc2 = new Description("This one is machine and nerve,\nand has its mind concluded.\nThis one is but flesh and faith,\nand is the more deluded.");
		Description desc3 = new Description("There is much talk, and I have listened,\nthrough rock and metal and time.\nNow I shall talk, and you shall listen.");
		Description desc4 = new Description("Silence fills the empty grave,\nnow that I have gone.\nBut my mind is not at rest,\nfor questions linger on.\nI will ask, and you will answer.");
		Description desc5 = new Description("We exist together now,\ntwo corpses in one grave...");
		OrderedSet<Description> ordSet = new OrderedSet<Description>(); 
		
		ordSet.insert(desc1);
		ordSet.insert(desc2);
		ordSet.insert(desc3);
		ordSet.insert(desc4);
		ordSet.insert(desc5);
		
		Iterator<Description> ordIt = ordSet.iterator();
		
		System.out.println("---First OrderedSet-Test---");
		while(ordIt.hasNext()){
			
			Description tmpDesc = ordIt.next();
			System.out.println("Text: \n" + tmpDesc.toString());
			System.out.println("Zeilen: " + tmpDesc.lineCount() + "\n");
			
		}
		
		ordIt = ordSet.iterator();
		
		ordIt.next();
		ordIt.next();
		
		ordIt.remove();

		ordIt = ordSet.iterator();
		
		System.out.println("---Removed OrderedSet-Test---");
		while(ordIt.hasNext()){
			
			Description tmpDesc = ordIt.next();
			System.out.println("Text: \n" + tmpDesc.toString());
			System.out.println("Zeilen: " + tmpDesc.lineCount() + "\n");
			
		}
		System.out.println("-----END OrderedSet-Test-----");
		

		OrderedMap<ElapsedTime, Double> orderedMap = new OrderedMap<ElapsedTime, Double>();
		
		orderedMap.insert(etime, 2131.1);
		orderedMap.insert(ctime1, 231.5);
		
		MyIterator<ElapsedTime, Double> iter = orderedMap.iterator();
		
		//NodeMap<ElapsedTime, Double> test = iter.nextList();
		
		iter.next();
		
		TheOtherIterator<Double> iter2 = iter.iterator();
		iter2.add(1223112341.6);
		iter2.add(1671.91);
		iter2.add(55.1);
		/*
		Output: 231.5
				55.1
				1671.91
				1223112341.6
		*/
		while(iter2.hasNext()){
			System.out.println(iter2.next());
		}
		System.out.println("\nTestcase 2");
		OrderedMap<MeanElapsedTime, CompositeTime> orderedMap2 = new OrderedMap<MeanElapsedTime, CompositeTime>();
		
		orderedMap2.insert(etime, ctime1);
		orderedMap2.insert(etime2, ctime1);
		
		MyIterator<MeanElapsedTime, CompositeTime> m2Iter1 = orderedMap2.iterator();
		
		TheOtherIterator<CompositeTime> m2Iter2 = m2Iter1.iterator();
		
		m2Iter2.add(ctime2);
		/*
		Output: 5.2
				3.14
				1.1
				99.2
		*/
		OrderedSet<ElapsedTime> ordSet2 = new OrderedSet<ElapsedTime>();
		while(m2Iter1.hasNext()){
				MeanElapsedTime mEtime = m2Iter1.next();
				System.out.println(mEtime.longestTime()); //5.2; 99.2
				ordSet2.insert(mEtime);
				while(m2Iter2.hasNext()){
					CompositeTime coTime = m2Iter2.next();
					System.out.println(coTime.shortestTime()); //3.14, 1.1
					ordSet2.insert(coTime);
				}
		}
		System.out.println("-----END OrderedMap-Test-----");
		
		System.out.println("\nTestcase3");
		Iterator<ElapsedTime> ordIter = ordSet2.iterator();
		while(ordIter.hasNext()){
			ElapsedTime tmp = ordIter.next();
			if(ordIter.hasNext()){
				
			}else{
				System.out.println(tmp.toBeCompared());
			}
		}


	}
}
