package walmart;

import java.util.Scanner;
import java.math.BigInteger;

public class Test {
	public static final BigInteger MOD = new BigInteger(String.valueOf(1000000007));
	
	public static void main(String[] args) {
		System.out.print("{");
		for(int i = 4; i <= 4000; i = i + 2)
			System.out.print(helper(i, i/2) + ",");
		System.out.print("}");
		System.out.println("DONE---------");
	}
	private static int helper(int n, int m)
	{
		BigInteger c = BigInteger.valueOf(1);
		for (int i = 1; i <= m; i++) {
			c = c.multiply(BigInteger.valueOf(n - i + 1)).divide(
					BigInteger.valueOf(i));

		}
		c = c.divide(BigInteger.valueOf(n/2 + 1));
		c = c.mod(MOD);
		return Integer.valueOf(c.toString());
	}
}
