package HRContest;

import java.util.Scanner;

public class PerfectHiring {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long p = scan.nextLong();
		long x = scan.nextLong();
		
		long currentMax = 0;
		int currentCandidate = 0;
		
		for(int i = 1; i <= n; i++)
		{
			long currentRate = scan.nextLong();;
			if(p * currentRate > currentMax)
			{
				currentMax = p * currentRate;
				currentCandidate = i;
			}
			
			p = p - x;
		}
		
		System.out.println(currentCandidate);

	}

}
