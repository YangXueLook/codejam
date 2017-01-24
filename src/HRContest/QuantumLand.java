package HRContest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class QuantumLand {
	
	
	
	static ArrayList<Integer> trace = new ArrayList<Integer>();
	static boolean hasCycle = false;
	static HashSet<String> pathSet = new HashSet<String>(); 
	static double result = 0;
	
	
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] matrix = new int[n + 1][n + 1];
		double[][] proMatrix = new double[n + 1][n + 1];
		for(int i = 1; i <= n; i++)
		{
			int to = scan.nextInt();
			matrix[i][to] = 1;
			double pro = scan.nextDouble();
			proMatrix[i][to] = pro/(double)100;
			
		}
		
		
		helper(matrix, proMatrix);
		
//		System.out.println(result);
		System.out.println(String.format("%.2f", result));

	}

	private static void helper(int[][] matrix, double[][] proMatrix) {
		int num = matrix.length;
		for(int i = 1; i < num; i++)
		{
//			if(!visited.contains(i))
			findCycle(i, matrix, num, proMatrix);
		}
		
	}
	
	static void findCycle(int v, int[][] matrix, int num, double[][] proMatrix) {
		int j = trace.indexOf(v);
		if ((j) != -1) {
			hasCycle = true;
			ArrayList<Integer> list = new ArrayList<Integer>();
			double expect = 1;
			int startIndex = trace.get(j);
			int traceSum = 0;
			
			while (j < trace.size()) {
//				System.out.print(trace.get(j) + " ");
				
				
				traceSum = traceSum + trace.get(j);
				list.add(trace.get(j));
				
				if(j != trace.size() - 1)
					expect = expect * proMatrix[trace.get(j)][trace.get(j + 1)];
				else
					expect = expect * proMatrix[trace.get(j)][startIndex];
				j++;
				
			}
			
			shift(list);
			String s = list.toString();
			
			if(!pathSet.contains(s))
			{
				pathSet.add(s);
				result = result + expect; 
			}
			
			
			
			
//			System.out.print("\n");
			return;
		}
		trace.add(v);

		for (int i = 0; i < num; i++) {
			if (matrix[v][i] == 1)
				findCycle(i, matrix, num, proMatrix);
		}
		trace.remove(trace.size() - 1);
	}
	
	
	private static void shift(ArrayList<Integer> list)
	{
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i = 0; i < list.size(); i++)
		{
			if(min > list.get(i))
			{
				minIndex = i;
				min = list.get(i);
			}
		}
		
		for(int i = 0; i < minIndex; i++)
			list.add(list.get(i));
		
		for(int i = minIndex - 1; i >= 0; i--)
			list.remove(i);
		
//		System.out.println(list.toString());
	}

}
