package googleChallenge;

import java.math.BigInteger;
import java.util.HashMap;

public class NumberOfGraph {

	private static HashMap<Integer, BigInteger> selectMap = new HashMap<Integer, BigInteger>();
	private static HashMap<Integer, BigInteger> possibleGraphMap = new HashMap<Integer, BigInteger>();
	private static HashMap<Integer, BigInteger> answerGraphMap = new HashMap<Integer, BigInteger>();

	public static String answer(int N, int K) {
		int key = N * 1000 + K;

		if (answerGraphMap.containsKey(key))
			return answerGraphMap.get(key).toString();

		if (K == N - 1) {
			BigInteger result = BigInteger.ONE;
			for (int i = 0; i < N - 2; i++)
				result = result.multiply(new BigInteger(N + ""));

			answerGraphMap.put(key, result);
			return result.toString();
		}

		int maxPossibleEdges = N * (N - 1) / 2;

		BigInteger selectKEdgesFromAllPossibleEdge = select(maxPossibleEdges, K);
//		 k < p - n + 2
		if (K >= maxPossibleEdges - N + 2) {
			// must be connected graph
			answerGraphMap.put(key, selectKEdgesFromAllPossibleEdge);
			return selectKEdgesFromAllPossibleEdge.toString();
		}

		else {
			for (int i = 1; i < N; i++) {
				BigInteger x = select(N - 1, i - 1);
				int y = Math.min(i * (i - 1) / 2, K);

				for (int j = i - 1; j < y + 1; j++)
					// remove impossible graphs
					selectKEdgesFromAllPossibleEdge = selectKEdgesFromAllPossibleEdge
							.subtract(new BigInteger(answer(i, j)).multiply(
									new BigInteger(x + "")).multiply(
									possibleGraphs(N - i, K - j)));
			}
			answerGraphMap.put(key, selectKEdgesFromAllPossibleEdge);
			return selectKEdgesFromAllPossibleEdge.toString();
		}

	}
	
	private static BigInteger possibleGraphs(int N, int K) {
		int key = N * 1000 + K;

		if (possibleGraphMap.containsKey(key))
			return possibleGraphMap.get(key);
		
		BigInteger result = select(N * (N - 1) / 2, K);
		possibleGraphMap.put(key, result);
		
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
		// System.out.println(Math.pow(20, 18));
		
		System.out.println(select(4, 0));
		
		
//		for(int i = 2; i <= 20; i++)
//		{
//			for(int j = i - 1; j <= i * (i - 1) /2; j++)
//				System.out.println(i + " " + j+" "+answer(i, j));
//		}
		
		
//		System.out.println(answer(20, 160));

		// System.out.println(select(6, 2));

	}

}
