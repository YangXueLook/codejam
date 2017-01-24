package googleChallenge;

import java.math.BigInteger;
import java.util.HashMap;

public class CaptiveLine {
	
	public static HashMap<Integer, BigInteger> quickFindMap = new HashMap<Integer, BigInteger>();

	public static String answer(int x, int y, int n) {
		BigInteger result = helper(n - 1, x + y - 2).multiply(combinations(x + y - 2, x - 1));

		return result.toString();

	}

	private static BigInteger combinations(int n, int x) {
		BigInteger result = factorial(n).divide(factorial(x)).divide(factorial(n - x));

		return result;
	}

	private static BigInteger helper(int n, int x) {
		if (x > n || x < 1)
			return new BigInteger("0");
		else if (x == n)
			return new BigInteger("1");
		else if (x == 1)
			return factorial(n - 1);
		else if (x == n - 1)
			return combinations(n, 2);
		else
		{
			int key = n * 100 + x;
			if(quickFindMap.containsKey(key))
				return quickFindMap.get(key);
			
			else
			{
				BigInteger result = helper(n - 1, x - 1).add(helper(n - 1, x - 1).multiply(new BigInteger((n - 1) + "")));
				quickFindMap.put(key, result);
				return result;
			}
			
		}
			

	}

	public static BigInteger factorial(int n) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= n; i++) 
		{
			fact = fact.multiply(new BigInteger(i + ""));
		}
		return fact;
	}

	public static void main(String[] args) {
		System.out.println(answer(1,1,40));

	}

}
