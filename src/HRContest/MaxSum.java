package HRContest;

import java.util.Scanner;

public class MaxSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt();
//		long[] array = new long[n];
//		for(int i = 0; i < n; i++)
//			array[i] = scan.nextLong();
		
//		System.out.println(Long.MAX_VALUE);
//		long[][][] cubic = new long[n][n][n];
		
		int n = 300;
		long[] array = new long[n];
		for(int i = 0; i < n; i++)
			array[i] = 100000;
					
		
		long result = Long.MIN_VALUE;

		
		long[][] bottomLayer = new long[n][n];
		for(int i = 0; i < n; i++)
		{
			for(int j = i + 1; j < n; j++)
			{
				bottomLayer[i][j] = array[i] * array[j];
				result = Math.max(result, bottomLayer[i][j]);
			}
		}
		
		long[][] previousLayer = bottomLayer;
		long[][] currentLayer = new long[n][n];
		long[][] temp;
		
		
		for(int length = 1; length < n; length++)
		{
			for(int i = 0; i < n; i++)
			{
				for(int j = n - 1; i + length < j - length; j--)
				{
					currentLayer[i][j] = previousLayer[i][j] + bottomLayer[i + length][j - length];
					result = Math.max(result, currentLayer[i][j]);
//					System.out.println(i+"\t"+j+"\t"+length+"\t"+ currentLayer[i][j]);
				}
			}
			temp = previousLayer;
			previousLayer = currentLayer;
			currentLayer = temp;
		}
		
		
//		for(int i = 0; i < n; i++)
//		{
//			for(int j = i + 1; j < n; j++)
//			{
//				cubic[i][j][0] = array[i] * array[j];
//				result = Math.max(result, cubic[i][j][0]);
//			}
//		}
//		
//		for(int i = 0; i < n; i++)
//		{
//			for(int j = i + 1; j < n; j++)
//			{
//				for(int length = 1; i + length < j - length; length++)
//				{
//					
//					cubic[i][j][length] = cubic[i][j][length - 1] + cubic[i + length][j - length][0];
//					
//					result = Math.max(result, cubic[i][j][length]);
//					
////					System.out.println(i+"\t"+j+"\t"+length+"\t"+cubic[i][j][length]);
//				}
//				
//				
//			}
//		}
		

		System.out.println(result);

	}

	

}
