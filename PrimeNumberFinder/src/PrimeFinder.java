import java.util.ArrayList;

public class PrimeFinder {
	public static final int UPPER_LIMIT = 10000000;
	public static final int PRIMES_TO_PRINT = 35;
	private boolean limitIsPrime;
	private int candidates[];
	ArrayList<Integer> primes;
	public PrimeFinder() {
		primes = new ArrayList<>();
		candidates = new int[UPPER_LIMIT];
		limitIsPrime = true;
	}
	private void initUnsieved() {
		for (int i = 3; i < UPPER_LIMIT; i++){
			//Only fill candidates with odd numbers
			if (i%2 != 0)
				candidates[i] = i;
		}
	};
	private void sieve() {
		for (int i = 3; i < Math.sqrt(UPPER_LIMIT); i++) {
			if (((int)((i/Math.sqrt(UPPER_LIMIT))*100))%5 == 0)
				System.out.println((int)((i/Math.sqrt(UPPER_LIMIT))*100) + "% done sieving.");
			for (int j = i; j < UPPER_LIMIT; j++) {
				if ((long)i*j == UPPER_LIMIT)
					limitIsPrime = false;
				else if ((long)i*j <= UPPER_LIMIT - 1)
					candidates[i*j] = 0;
			}
		}
	}
	private void collectResults(){
		primes.add(2);
		for (int i = 0; i < UPPER_LIMIT - 1; i++) {
			if (candidates[i] != 0) {
				primes.add(candidates[i]);
			}
		}
		if (limitIsPrime) {
			primes.add(UPPER_LIMIT);
		}
	}
	private void printPrimes() {
		for (int i = 0; i <= PRIMES_TO_PRINT; i++) {
			System.out.print(primes.get(i) + " ");
			{
		}
			
		}
		System.out.println();
	}
	public int primesFound() {
		return primes.size();
	}
	public static void main(String args[]) {
		System.out.println("Finding all primes between 0 and " + UPPER_LIMIT);
		System.out.println("");
		System.out.println("Filling candidates array");
		PrimeFinder finder = new PrimeFinder();
		finder.initUnsieved();
		System.out.println("Sieving.");
		finder.sieve();
		System.out.println("Collecting results.");
		finder.collectResults();
		System.out.println(finder.primesFound() + " primes found.");
		finder.printPrimes();
		
		
	}

}
