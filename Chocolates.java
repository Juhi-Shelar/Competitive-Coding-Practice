//October Easy 2019 : Problem Chocolates
import java.util.Scanner;

public class Chocolates {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a,b,d1,d2;
		
		a = sc.nextInt();
		b = sc.nextInt();
		d1 = sc.nextInt();
		d2 = sc.nextInt();
		
		int t = a/d1;
		int t2 = t*d2+b;
		
		System.out.println(t2);
	}
}
