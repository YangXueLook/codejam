package yogeshtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1 {

	//O(n*lg(n))
	static List<Integer> funnySort(List<Integer> unsorted) {
		if(unsorted == null || unsorted.size() <= 1)
			return unsorted;
		
		Collections.sort(unsorted);
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		int headIndex = 0;
		int tailIndex = unsorted.size() - 1;
		
		while(headIndex < tailIndex)
		{
			resultList.add(unsorted.get(tailIndex));
			resultList.add(unsorted.get(headIndex));
			headIndex++;
			tailIndex--;
		}
		
		if(headIndex == tailIndex)
		{
			resultList.add(unsorted.get(tailIndex));
		}
		
		return resultList;
	}
	//test
	public static void main(String[] args) {
		System.out.println(Math.log(364848)/Math.log(2));
		System.out.println(Math.log(37338)/Math.log(2));
		
		
//		List<Integer> unsorted = new ArrayList<Integer>();
//		unsorted.add(1);
//		unsorted.add(7);
//		unsorted.add(2);
//		unsorted.add(3);
//		unsorted.add(19);
//		unsorted.add(Integer.MAX_VALUE);
//		unsorted.add(Integer.MAX_VALUE);
//		
//		List<Integer> result = funnySort(unsorted);
//		for(int i: result)
//			System.out.println(i);
		
		
		
		
		for(int i = 0; i < 10000; i++)
		{
			int n = (int) (Math.random() * 20 + 1);
			List<Integer> unsorted = new ArrayList<Integer>();
			
			for(int j = 0; j < n; j++)
			{
				unsorted.add((int) (Math.random() * 100));
			}
			
			
			
			List<Integer> result = funnySort(unsorted);
			Collections.sort(unsorted);
			
			List<Integer> secondHalf = new ArrayList<Integer>();
			for(int j = 0; j < result.size(); j = j + 2)
			{
				secondHalf.add(result.get(j));
			}
			Collections.reverse(secondHalf);
			
			List<Integer> firstHalf = new ArrayList<Integer>();
			for(int j = 1; j < result.size(); j = j + 2)
			{
				firstHalf.add(result.get(j));
			}
			firstHalf.addAll(secondHalf);
			
			for(int j = 0; j < firstHalf.size(); j++)
			{
				assert(firstHalf.get(j) == unsorted.get(j));
				
			}
			
		}

	}

}
