package yogeshtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Q4 {
	//O(lst.size()^2)
	//first intuition is DP.
	//Why use List<List<Integer>>? I think int[][] is better.
	static List<Integer> highestSumList(List<List<Integer>> lst) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(lst == null || lst.size() == 0)
			return result;
		
		int[][] matrix = new int[lst.size()][lst.size()];
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
				matrix[i][j] = Integer.MIN_VALUE;
		}
		
		matrix[0][0] = lst.get(0).get(0);
		
		for(int i = 0; i < lst.size() - 1; i++)
		{
			for(int j = 0; j <= i; j++)
			{
				matrix[i + 1][j] = Math.max(matrix[i + 1][j], matrix[i][j] + lst.get(i + 1).get(j));
				matrix[i + 1][j + 1] = Math.max(matrix[i + 1][j + 1], matrix[i][j] + lst.get(i + 1).get(j + 1));
			}
		}

//		for(int i = 0; i < lst.size(); i++)
//		{
//			for(int j = 0; j <= i; j++)
//			{
//				System.out.print(matrix[i][j] + "\t");
//			}
//			System.out.println();
//		}
		
		//back trace
		int currentMax = matrix[lst.size() - 1][0];
		int currentM = lst.size() - 1;
		int currentN = 0;
		for(int j = 0; j < lst.size(); j++)
		{
			if(matrix[lst.size() - 1][j] > currentMax)
			{
				currentMax = matrix[lst.size() - 1][j];
				currentN = j;
			}
		}
		
		result.add(lst.get(currentM).get(currentN));
		
		
		while(currentM > 0)
		{
			
			if(matrix[currentM][currentN] != matrix[currentM - 1][currentN] + lst.get(currentM).get(currentN))
			{
				currentN = currentN - 1;
			}
			currentM--;
			
			
			result.add(lst.get(currentM).get(currentN));
		}
		
		Collections.reverse(result);
		return result;
	}
	
	static List<List<Integer>> deepCopy(List<List<Integer>> list)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i = 0; i < list.size(); i++)
		{
			ArrayList<Integer> l = new ArrayList<Integer>();
			for(int j = 0; j < list.get(i).size(); j++)
			{
				l.add(list.get(i).get(j));
			}
			result.add(l);
		}
		
		return result;
	}
	
	
	//enumerate all possible path sums, for testing purpose
	static HashSet<Integer> getAllPossibleSums(List<List<Integer>> lst)
	{
		
		HashSet<Integer> result = new HashSet<Integer>();
		if(lst.size() == 1 && lst.get(0).size() == 1)
		{
			result.add(lst.get(0).get(0));
			
			return result;
		}
		else
		{
			int currentValue = lst.get(0).get(0);
			
			//go down
			List<List<Integer>> l1 = deepCopy(lst);
			l1.remove(0);
			for(List<Integer> l : l1)
			{
				//for each layer below, tail element is unreachable
				l.remove(l.size() - 1);
			}
			
			HashSet<Integer> result1 = getAllPossibleSums(l1);
			for(int i: result1)
			{
				result.add(i + currentValue);
			}
			
			
			//go right down
			List<List<Integer>> l2 = deepCopy(lst);
			l2.remove(0);
			for(List<Integer> l : l2)
			{
				//for each layer below, head element is unreachable
				l.remove(0);
			}

			HashSet<Integer> result2 = getAllPossibleSums(l2);
			for(int i: result2)
			{
				result.add(i + currentValue);
			}
			
		}
		
		return result;
	}
	
	
	//test
	public static void main(String[] args) {
		
		for(int i = 0; i < 1000; i++)
		{
			//initialize lst
			int size = (int) (Math.random()* 10 + 1);

			List<List<Integer>> lst = new ArrayList<List<Integer>>();
			for(int j = 0; j < size; j++)
			{
				ArrayList<Integer> l = new ArrayList<Integer>();
				for(int k = 0; k < j + 1; k++)
				{
					l.add((int) (Math.random()* 20 + 1));
				}
				lst.add(l);
			}
			
			
			List<Integer> result = highestSumList(lst);
			int maxSum = 0;
			for(int num: result)
			{
				maxSum = maxSum + num;
			}
			
			HashSet<Integer> allPossibleSumSet = getAllPossibleSums(lst);
			for(int sum: allPossibleSumSet)
			{
				assert maxSum >= sum;
				
			}	
			
		}
	}

}
