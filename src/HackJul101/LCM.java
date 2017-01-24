package HackJul101;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class LCM {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		int loopTimes = scan.nextInt();
		
		int[] array = new int[length];
		
		for(int i = 0; i < length; i++)
		{
			array[i] = scan.nextInt();
		}
		
		for(int i = 0; i < loopTimes; i++)
		{
			int s = scan.nextInt() - 1;
			int e = scan.nextInt() - 1;
			System.out.println(helper(array, s, e));
		}

	}

	private static int helper(int[] array, int s, int e) {
		HashSet<Integer> set = new HashSet<Integer>();
		int count3 = 0;
		for(int i = s; i <= e; i++)
		{
			if(array[i] % 3 == 0)
			{
				count3++;
			}
			else if(array[i] % 3 == 2)
			{
				if(set.contains(array[i]))
					set.remove(array[i]);
				else
					set.add(array[i]);
			}
			
		}
		if(count3 == 1)
			return 0;
		
		else
		{
			if(set.size() % 2 == 0)
				return 1;
			else
				return 2;
		}
		
		
	}

}
