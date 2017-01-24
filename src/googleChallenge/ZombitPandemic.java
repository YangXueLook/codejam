package googleChallenge;

import java.math.BigInteger;
import java.util.HashMap;

public class ZombitPandemic {
	private static HashMap<Integer, BigInteger> selectMap = new HashMap<Integer, BigInteger>();
	
//	def S(n):
//	    """
//	    Returns the number of pseudoforests with exactly one connected component
//	    involving all the nodes, ie. all nodes connected by a single tree.
//	    'A000435' requires float division, so I'm using 'A001864 / n' instead.
//	    """
//	    if n not in mem_single:
//	        values = choose(n, k) * (n - k) ** (n - k) * k ** k for k in range(1, n)
//	        mem_single[n] = sum(values) / n
//
//	    return mem_single[n]
	
	static BigInteger S(int n)
	{
		BigInteger[] values = new BigInteger[n];
		for(int i = 1; i < n; i++)
		{
			values[i] = select(n, i).multiply(power(n - i)).multiply(power(i));
		}
		
		BigInteger sum = BigInteger.ZERO;
		for(int i = 1; i < n; i++)
		{
			sum = sum.add(values[i]);
		}
		
		return sum.divide(new BigInteger(n + ""));
	}
	
	static BigInteger power(int n)
	{
		BigInteger result = new BigInteger("1");
		for(int i = 0; i < n; i++)
		{
			result = result.multiply(new BigInteger(n + ""));
		}
		return result;
	}
	
	

	private static BigInteger select(int N, int K) {

		int key = N * 1000 + K;

		if (selectMap.containsKey(key))
			return selectMap.get(key);

		BigInteger result = factorial(N).divide(factorial(K)).divide(
				factorial(N - K));
		selectMap.put(key, result);
		return result;
	}
	
	private static BigInteger factorial(int n) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(new BigInteger(i + ""));
		}
		return fact;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
