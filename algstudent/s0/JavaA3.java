import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class JavaA3 {

	private static int n = 10000;
	
	public static void main(String[] args) {
		A3();
	}
	
	public static void A3() {
		for (int i = 0; i < 7; i++) {
			Instant start = Instant.now();
			
			primesArray(n);
			
			Instant end = Instant.now();
			
			Duration timeElapsed = Duration.between(start, end);
			System.out.println("n = "+ n + "***" + "time = " + timeElapsed);
			n = n*2;
		}
	}
	
	public static boolean primeA3(int m) {
		for (int i = 2; i < m/2+1; i++) {
			if (m%i==0)
				return false;
		}
		return true;
	}
	
	public static ArrayList<Integer> primesArray(int n) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for (int i = 2; i < n+1 ; i++) {
			if (primeA3(i))
				primes.add(i);
		}
		
		return primes;
	}
	
}
