package HRContest;

import java.util.Arrays;
import java.util.Scanner;

public class DancingPairs {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long k = scan.nextLong();
		
		long[] boys = new long[n];
		long[] girls = new long[n];
		
		for(int i = 0; i < n; i++)
			boys[i] = scan.nextLong();
		
		for(int i = 0; i < n; i++)
			girls[i] = scan.nextLong();
		
		Arrays.sort(boys);
		Arrays.sort(girls);
		
		int result = 0;
		
		for(int i = 0, j = 0; i < n && j < n;)
		{
			if(Math.abs(boys[i] - girls[j]) <= k)
			{
				result++;
				i++;
				j++;
			}
			else if(boys[i] < girls[j])
				i++;
			else
				j++;
		}
		
		
		System.out.println(result);
	}

}
