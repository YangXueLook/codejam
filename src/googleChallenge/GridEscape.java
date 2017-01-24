package googleChallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class GridEscape {
	
	static class ArrayListWrapper
	{
		ArrayList<Integer> list= new ArrayList<Integer>();
//		ArrayListWrapper()
//		{
//			list = new ArrayList<Integer>();
//		}
	}
	
	public static int answer(int food, int[][] grid) { 
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return food;
		
		
		ArrayListWrapper[][] possibleValueMatrix = new ArrayListWrapper[grid.length][grid[0].length];
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				possibleValueMatrix[i][j] = new ArrayListWrapper();
			}
		}
		
		
		
		possibleValueMatrix[0][0].list.add(0);
		
		for(int i = 1; i < grid.length; i++)
		{
			possibleValueMatrix[i][0].list.add(grid[i][0] + possibleValueMatrix[i - 1][0].list.get(0));
		}
		
		for(int j = 1; j < grid[0].length; j++)
		{
			possibleValueMatrix[0][j].list.add(grid[0][j] + possibleValueMatrix[0][j - 1].list.get(0));
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 1; i < grid.length; i++)
		{
			for(int j = 1; j < grid[0].length; j++)
			{
				set.clear();
				
				for(int m : possibleValueMatrix[i - 1][j].list)
				{
					set.add(m + grid[i][j]);
				}
				
				for(int n : possibleValueMatrix[i][j - 1].list)
				{
					set.add(n + grid[i][j]);
				}
				
				possibleValueMatrix[i][j].list.addAll(set);
			}
		}
		
		ArrayList<Integer> list = possibleValueMatrix[grid.length - 1][grid[0].length - 1].list;
		Collections.sort(list);
		
	
		
		if(food < list.get(0))
			return -1;
		
		
		int result = food - list.get(0);
		for(int i = 1; i < list.size(); i++)
		{
			if(food < list.get(i))
				break;
			else
				result = food - list.get(i);
		}
		

		return result;
    }

	public static void main(String[] args) {

		int[][] grid = new int[][] {{0, 2, 5}, {1, 1, 3}, {2, 1, 1}};
		
		System.out.println(answer(12, grid));

	}

}

