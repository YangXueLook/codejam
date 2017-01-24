package walmart;

import java.util.HashMap;
import java.util.Scanner;

public class Fab {
	public static long a, b, c, d;
	public static final int MOD = 1000000007;
	public static HashMap<Long, Long> MAP = new HashMap<Long, Long>();

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int q = Integer.parseInt(in.next());
		for(int i = 0; i < q; i++)
		{
			long result = 0;
			
			int n = Integer.parseInt(in.next());
			
			long[] array = new long[n];
			long[] sumArray = new long[n];
			
			for(int j = 0; j < n; j++)
			{
				array[j] = Long.parseLong(in.next());
			}
			
			sumArray[0] = array[0];
			for(int j = 1; j < n; j++)
			{
				sumArray[j] = sumArray[j - 1] + array[j];
			}
			
			for(int j = -1; j < sumArray.length - 1; j++)
			{
				for(int k = j + 1; k < sumArray.length; k++)
				{
					long intervalSum = j == -1?sumArray[k]:sumArray[k] - sumArray[j];
					
					if(MAP.containsKey(intervalSum))
					{
						result = (result + MAP.get(intervalSum))%MOD;
					}
					
					
					else if(intervalSum <= 2)
					{
						result = (result + 1)%MOD; 
						MAP.put(intervalSum, (long) 1);
					}
					else
					{
						findNthFab(intervalSum - 2);
						
						result = (result + (b + d)%MOD)%MOD; 
						MAP.put(intervalSum, (long)(b + d)%MOD);
						
					}
					
					
				}
					
			}
			System.out.println(result);
			
		}
	}

	private static void findNthFab(long n) {
		long tempA, tempB, tempC, tempD;

		if (n == 1) {
			a = 0;
			b = c = d = 1;
			return;
		}
		if (n % 2 == 0) {
			findNthFab(n / 2);
			tempA = a * a + b * c;
			tempB = b * (a + d);
			tempC = c * (a + d);
			tempD = c * b + d * d;
			a = tempA % MOD;
			b = tempB % MOD;
			c = tempC % MOD;
			d = tempD % MOD;
			return;
		} else {
			findNthFab(n / 2);
			tempA = b * (a + d);
			tempB = a * a + b * (a + c + d);
			tempC = c * b + d * d;
			tempD = c * (a + b + d) + d * d;
			a = tempA % MOD;
			b = tempB % MOD;
			c = tempC % MOD;
			d = tempD % MOD;
			return;
		}

	}

}
