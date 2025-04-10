package algstudent.s5;

public class NullPathTimes {
    public static void main(String[] args) {
    	int n = Integer.parseInt(args[0]);
        for (int i = 20; i < n; i+=5) {
            long totalTime = 0;
            int trials = 100;

            for (int trial = 0; trial < trials; trial++) {
                int[][] weights = NullPath.generateWeights(i);
                long start = System.currentTimeMillis();
                NullPath.findNullPath(i, weights);
                totalTime += System.currentTimeMillis() - start;
            }

            System.out.printf("n=%d \t Average time: %.2f ms%n", 
                              i, totalTime / 100.0);
        }
    }
}