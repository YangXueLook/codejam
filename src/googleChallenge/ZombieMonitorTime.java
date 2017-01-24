package googleChallenge;

import java.util.Arrays;
import java.util.Comparator;

public class ZombieMonitorTime {
	public static int answer(int[][] intervals) { 
		if(intervals == null || intervals.length == 0)
			return 0;
		
		Arrays.sort(intervals, new Comparator<int[]>(){

			@Override
			
			public int compare(int[] o1, int[] o2) {
				if(o1[0] < o2[0])
					return -1;
				else if(o1[0] > o2[0])
					return 1;
				else if(o1[1] < o2[1])
					return -1;
				else if(o1[1] > o2[1])
					return 1;
				else
					return 0;
			}
			
		});
		
		int sum = 0;
		int currentStart = intervals[0][0];
		int currentEnd = intervals[0][1]; 
		
		for(int i = 1; i < intervals.length; i++)
		{
			if(i != intervals.length - 1)
			{
				if(currentEnd >= intervals[i][0])
				{
					currentEnd = Math.max(intervals[i][1], currentEnd);
				}
				
				else
				{
					sum = sum + currentEnd - currentStart;
					currentStart = intervals[i][0];
					currentEnd = intervals[i][1];
				}
			}
			else
			{
				if(currentEnd >= intervals[i][0])
				{
					sum = sum + Math.max(intervals[i][1], currentEnd) - currentStart;
				}
				
				else
				{
					sum = sum + currentEnd - currentStart;
					sum = sum + intervals[i][1] - intervals[i][0];
				}
			}
			
			
		}


		return sum;

    }

	public static void main(String[] args) {
		System.out.println(answer(new int[][]{{10, 14}, {4, 18}, {19, 20}, {19, 20}, {13, 20}}));
		System.out.println(answer(new int[][]{{1, 3}, {3, 6}}));

	}

}
