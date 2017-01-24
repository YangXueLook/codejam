package HRContest;

import java.util.Scanner;

public class BeginEnd {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[26];
		
		String s = scan.next();
		
		
		
		for(int i = 0; i < n; i++)
		{
			char c = s.charAt(i);
			int index = c - 'a';
			array[index]++; 
		}
		
//		System.out.println(array[0]+"---------");
		
		
		
		long sum = 0;
		for(int count : array)
		{
			if(count == 0)
				continue;
			else if(count == 1)
				sum++;
			else
			{
				sum = sum + (long)count + ((long)count - 1)*(long)count/2;
			}
			 
		}
		System.out.println(sum);
	}

}
