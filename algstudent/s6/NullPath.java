package algstudent.s5;

import java.util.Random;

public class NullPath {
    public final static int MIN_WEIGHT = 10;
    public final static int MAX_WEIGHT = 99;
    public final static double P1 = 0.5;
    public final static int TOLERANCE = MAX_WEIGHT;
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[][] weights = generateWeights(n);
        printMatrix(weights);
        int[] path = findNullPath(n, weights);

        if (path != null) {
            System.out.println("NullPath found:");
            for (int i = 0; i < n; i++) {
                System.out.print(path[i] + (i < n - 1 ? " -> " : "\n"));
            }
            System.out.println("Total cost: " + calculatePathSum(path, weights));
        } else {
            System.out.println("No NullPath found within tolerance.");
        }
    }

    public static int[][] generateWeights(int n) {
        int[][] weights = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (rand.nextDouble() < P1) {
                        weights[i][j] = rand.nextInt(MAX_WEIGHT - MIN_WEIGHT + 1) + MIN_WEIGHT;
                    } else {
                        weights[i][j] = -(rand.nextInt(MAX_WEIGHT - MIN_WEIGHT + 1) + MIN_WEIGHT);
                    }
                }
            }
        }
        return weights;
    }

    public static int calculatePathSum(int[] path, int[][] weights) {
        int sum = 0;
        for (int i = 0; i < path.length - 1; i++) {
            sum += weights[path[i]][path[i + 1]];
        }
        return sum;
    }
    
    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.print(String.format("%5d", matrix[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static int[] findNullPath(int n, int[][] weights) {
        boolean[] visited = new boolean[n];
        int[] path = new int[n];
        visited[0] = true;
        path[0] = 0;
        boolean found = backtrack(0, 1, 0, visited, path, n, weights);
        return found ? path : null;
    }

    private static boolean backtrack(int current, int count, int sum, boolean[] visited, int[] path, int n, int[][] weights) {
        if (count == n) {
            return (current == n - 1) && (Math.abs(sum) <= TOLERANCE);
        }

        for (int next = 0; next < n; next++) {
            if (count + 1 == n && next != n - 1) continue; // Last step must be target node
            if (count + 1 != n && next == n - 1) continue; // Intermediate steps can't be target node

            if (!visited[next]) {
                int edgeWeight = weights[current][next];
                int newSum = sum + edgeWeight;

                // Prune paths that can't meet the tolerance
                int remainingSteps = n - count - 1;
                int maxPossible = remainingSteps * MAX_WEIGHT;
                int minPossible = -remainingSteps * MAX_WEIGHT;
                if (newSum + minPossible > TOLERANCE || newSum + maxPossible < -TOLERANCE) {
                    continue;
                }

                // Try with next node
                visited[next] = true;
                path[count] = next;

                // Try to go further from that node
                if (backtrack(next, count + 1, newSum, visited, path, n, weights)) {
                    return true;
                }

                visited[next] = false; // Undo the decision if couldn't go further
            }
        }

        return false;
    }
}