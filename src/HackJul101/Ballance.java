package HackJul101;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Ballance {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] matrix = new int[5][2];
		
		for(int i = 0; i < 5; i++)
		{
			matrix[i][0] = scan.nextInt();
			matrix[i][1] = scan.nextInt();
		}
		
		 Arrays.sort(matrix, new Comparator<Object>()
				 {

					@Override
					public int compare(Object o1, Object o2) {
						int[] a1 = (int[]) o1;
						int[] a2 = (int[]) o2;
						return a1[0] - a2[0];
					}});
		
		
		for(int i = 0; i < 4; i++)
		{
			if(!(matrix[i][0] < matrix[i + 1][0] && matrix[i][1] < matrix[i + 1][1]))
			{
				System.out.println("0");
				return;
			}
				
		}
		System.out.println("1");
		

	}

}
