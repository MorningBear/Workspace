
public class Numbers {
	static void isPrime(int n) {
		boolean[] prime = new boolean[n];
		for(int i = 2; i < n; i++) {
			prime[i] = true;
		}
		
		for(int i = 2; i < n; i++) {
			if(prime[i] == true) {
				System.out.println(i);
				for(int j = i*i; j < n; ) {
					prime[j] = false;
					j += i;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		isPrime(10);
	}
}
