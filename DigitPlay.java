//October Easy 2019 : Problem Digital Play
import java.util.HashSet;
import java.util.Scanner;

public class DigitPlay {
	static HashSet<Long> primeNumber = new HashSet<Long>();
	
	static boolean isPrime(long n){
		int i;

		if (n==2)
			return true;

		if (n%2==0)
			return false;

		for (i=3;i<=Math.sqrt(n);i+=2)
			if (n%i==0)
				return false;

		return true;
	}

	static void precompute() {		
		for(long i=0; i<=90; i++) {
			if(isPrime(i)==true)
				primeNumber.add(i);
		}
			
	}
	
    public static void main(String[] args) {
		long a, b, k;
		Scanner sc = new Scanner(System.in);
		a = sc.nextLong();
		b = sc.nextLong();
		k = sc.nextLong();
		
		int res = 0;
		

		precompute();
		
		for(long i=a; i<=b; i++) {
			long sum = 0;
			
			long temp = i;
			while (temp > 0)
		    {
		        long digit = temp % 10;
		        sum  = sum + digit;
		        temp /= 10;
		    }
			
			//if( (isPrime(sum)==true) && (i%k==0) )
			if( (primeNumber.contains(sum)) && (i%k==0) )
				res++;
		}
		System.out.println(res);
	}
    
    
}
