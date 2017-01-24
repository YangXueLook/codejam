package WCS4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class EqualStacks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		
		HashSet<Integer> s2 = new HashSet<Integer>();
		HashSet<Integer> s3 = new HashSet<Integer>();
		
		s2.add(0);
		s3.add(0);
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;

		for (int a0 = 0; a0 < n1; a0++) {
			int height = in.nextInt();
			l1.add(height);
		}
		for (int a0 = 0; a0 < n2; a0++) {
			int height = in.nextInt();
			l2.add(height);
		}
		for (int a0 = 0; a0 < n3; a0++) {
			int height = in.nextInt();
			l3.add(height);
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		c1 = getSum(l1);
		list.add(c1);
		for (int i = 0; i < l1.size(); i++)
		{
			 c1 = c1 - l1.get(i);
			 list.add(c1);
			 
		}
		
		c2 = getSum(l2);
		s2.add(c2);
		for (int i = 0; i < l2.size(); i++)
		{
			 c2 = c2 - l2.get(i);
			 s2.add(c2);
		}
		
		c3 = getSum(l3);
		s3.add(c3);
		for (int i = 0; i < l3.size(); i++)
		{
			 c3 = c3 - l3.get(i);
			 s3.add(c3);
		}
		
		
		
		
		
		for (int i = 0; i < list.size(); i++) {
			int c = list.get(i);
			if (s2.contains(c) && s3.contains(c)) {
				System.out.println(c);
				break;
			}
		}

	}

	private static int getSum(ArrayList<Integer> l) {
		int sum = 0;
		for(int i : l)
		{
			sum = sum + i;
		}

		
		return sum;
	}

}
