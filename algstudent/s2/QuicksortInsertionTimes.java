package algstudent.s2;

/* This class measures times for the Bubble method
for the 3 assumptions: (already ordered, reverse ordered and random ordered) */
public class QuicksortInsertionTimes {
	static int[] v;

	public static void main(String arg[]) {
		long t1, t2;
		String opcion = arg[0];
		int n = 16000000;
		
		v = new int[n];

		if (opcion.compareTo("ordered") == 0)
			Vector.sorted(v);
		else if (opcion.compareTo("reverse") == 0)
			Vector.reverseSorted(v);
		else
			Vector.randomSorted(v);

		int[] kValues = {1050, 10, 20, 30, 50, 100, 200, 500, 1000};
		
		// Test different values of k
	    for (int k : kValues) {
	        // Measure the time for Quicksort + Insertion Sort
	        t1 = System.currentTimeMillis();
	        QuicksortInsertion.quicksort(v, k); // Use the hybrid algorithm
	        t2 = System.currentTimeMillis();

	        // Print the results
	        System.out.println("k: " + k + " - " + (t2 - t1) + " ms");
	        System.out.println();
	    }
	
	}
}
