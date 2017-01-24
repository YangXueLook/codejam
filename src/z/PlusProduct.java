package z;

import java.util.Scanner;

public class PlusProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		scan.nextLine();
		boolean[][] matrix = new boolean[n][m];
		
		for(int i = 0; i < n; i++)
		{
			String s = scan.nextLine();
			
			for(int j = 0; j < m; j++)
			{
				matrix[i][j] = s.charAt(j) == 'G';
			}
		}
		
		System.out.println(helper(matrix));
		
	}

	private static int helper(boolean[][] matrix) {
		// TODO Auto-generated method stub
		int result = 0;
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				if(matrix[i][j])
				{
					boolean[][] copy = deepCopy(matrix);
					int firstSize = findMax(copy, i, j);
					
//					System.out.println(firstSize + "\t" + i + "\t" + j);
					int secondSize = 0;
					for(int m = 0; m < copy.length; m++)
					{
						for(int n = 0; n < copy.length; n++)
						{
							if(copy[m][n])
							{
								boolean[][] copycopy = deepCopy(copy);
								secondSize = Math.max(secondSize, findMax(copycopy, m, n));
							}
								
						}
					}
					
					result = Math.max(result, firstSize * secondSize);	
				}
				
				
			}
		}
		
		return result;
	}

	private static int findMax(boolean[][] copy, int x, int y) {
		copy[x][y] = false;
		int result = 1;
		
		int length = 1;
		while(x - length >= 0 && x + length < copy.length && y - length >= 0 && y + length < copy[0].length && copy[x - length][y] && copy[x + length][y] && copy[x][y - length] && copy[x][y + length])
		{
			copy[x - length][y] = copy[x + length][y] = copy[x][y - length] = copy[x][y + length] = false;
			length++;
			result = result + 4;
		}
		
		
		
		return result;
	}

	private static boolean[][] deepCopy(boolean[][] matrix) {
		boolean[][] copy = new boolean[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				copy[i][j] = matrix[i][j];
			}
		}
		
		return copy;
	}

}
