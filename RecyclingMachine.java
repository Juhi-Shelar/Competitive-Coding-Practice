//October Easy 2019 : Problem DigitPlay
import java.util.Scanner;

public class RecyclingMachine {
	
	static long foo(long n, long k) {
		long res = 0;
		
		while(n>=k) {
			long quo = n/k;
			long rem = n%k;
			
			res = res + quo;
			n =  rem + quo;
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		long[] n = new long[t];
		long[] k = new long[t];
		
		for(int i=0; i<t; i++) {
			n[i] = sc.nextLong();
			k[i] = sc.nextLong();
		}
		
		for(int i=0; i<t; i++) {
			System.out.println(foo(n[i],k[i]));
		}
		
		
	}
}







/*
String s = sc.next();

String temp[] = s.split(" ");
n[i] = Long.parseLong(temp[0]);
k[i] = Long.parseLong(temp[1]);
*/