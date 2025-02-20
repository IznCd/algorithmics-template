package algstudent.s11;

/**
 * This program serves to measure times automatically increasing 
 * the size of the problem. In addition, we use a repetition value 
 * determined by nTimes, an argument of the program
 */
public class Vector5 {
	static int[]a;
	static int[]m;
	
	public static void main(String arg []) {
		int repetitions = Integer.parseInt(arg[0]);
		long t1,t2;
		
		for (int n=5120000; n<=Integer.MAX_VALUE; n*=2){ //n is increased *5   
			  a = new int[n];
			  Vector1.fillIn(a);
			  m = new int[2];
			  
			  t1 = System.currentTimeMillis();
			  //We have to repeat the whole process to be measured
			  for (int repetition=1; repetition<=repetitions; repetition++){    	
			     Vector1.maximum(a, m);
			  }
			  t2 = System.currentTimeMillis();
			  System.out.printf("SIZE=%d TIME=%d milliseconds MAX=%d MAX.POS=%d NTIMES=%d\n", n, t2-t1, m[1], m[0], repetitions);	
		}//for 
		
	}//main

}
