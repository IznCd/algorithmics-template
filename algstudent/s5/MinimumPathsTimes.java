package algstudent.s5;

public class MinimumPathsTimes{
	
	static int[][] weights; //weight matrix
	static int[][] costs; //Floyd's paths cost matrix
	static int[][] p; //predecessor matrix (steps) in Floyd paths
	
	public static void main(String arg[]) {
		
		for (int n = 200; n < 10000; n*=2) {
			weights = new int[n][n];
			costs = weights.clone();
			p = new int[n][n];

			long t1 = System.currentTimeMillis();
			
			MinimumPaths.fillInWeights(weights); //weights for the example
			MinimumPaths.fillP(p);

			MinimumPaths.floyd(weights, costs, p);
			
			long t2 = System.currentTimeMillis();
			
			System.out.println(n + "\t" + (t2 - t1));

		}		
	}
}