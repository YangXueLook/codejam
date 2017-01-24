package WCS4;

import java.util.Scanner;

public class MinDistance {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int A[] = new int[n];
		for (int A_i = 0; A_i < n; A_i++) {
			A[A_i] = in.nextInt();
		}
		
		System.out.println(helper(A));

	}

	private static int helper(int[] a) {
		// TODO Auto-generated method stub
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < a.length; i++)
		{
			for(int j = i + 1; j < a.length; j++)
			{
				if(a[i] == a[j])
				{
					result = Math.min(result, j - i);
				}
			}
		}
			
		
		
		return result == Integer.MAX_VALUE ? -1 : result;
	}

}
