package walmart;

import java.math.BigInteger;
import java.util.Scanner;

public class Mountain {
	
	public static final BigInteger MOD = new BigInteger(String.valueOf(1000000007));

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		for(int i = 0; i < t; i++)
		{
			int num = Integer.parseInt(in.nextLine());
			System.out.println(findShapes(num));
		}
		
	}

	
	private static int findShapes(int num) {
		
		if(num == 0)
			return 0;
		if(num == 2)
			return 1;
		
		int result = 1;
		for(int i = 4; i <= num; i = i + 2)
		{
			result = (result + helper(i, i/2))%1000000007;
		}
		
		return result;
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
