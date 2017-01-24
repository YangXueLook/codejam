package yogeshtest;

import java.util.ArrayList;
import java.util.List;

public class Q2 {
	//O(n)
//	"For example:
//		[5, 3, 5, 2, 3, 8]
//		We can re-order the elements:
//		[2, 3, 5, 5, 3, 8]""
//	According to this example, I assume I do not have to maintain original odd/even number order. e.g.
//	in [5, 3, 5, 2, 3, 8], odd number sequence is 5353; in [2, 3, 5, 5, 3, 8], it is 3553.
	
	
	
	static List<Integer> distantEvenNumbers(List<Integer> list)
	{
		if(list == null || list.size() <= 2)
			return list;
		
		int evenNumCount = countEven(list);

		
		//partition: oooooo...|eeeeeee...
		int low = 0;
		int high = list.size() - 1;
		while(low < high)
		{
			while(low < list.size() && list.get(low)%2 != 0)
			{
				low++;
			}
			while(high >= 0 && list.get(high)%2 == 0)
			{
				high--;
				
			}
			
			if(low >= high)
				break;
			
			int temp = list.get(low);
			list.set(low, list.get(high));
			list.set(high, temp);
			
			
			low++;
			high--;
		}
		
		if(evenNumCount <= 1)
			return list;
		
		int maxIntervalLength = (list.size() - 1)/(evenNumCount - 1);
		
		int currentIndex = 0;
		int nextEvenIndex = list.size() - evenNumCount;
		
		//swap
		while(evenNumCount > 0 && currentIndex < list.size())
		{
			int temp = list.get(currentIndex);
			list.set(currentIndex, list.get(nextEvenIndex));
			list.set(nextEvenIndex, temp);
			
			
			evenNumCount--;
			currentIndex = currentIndex + maxIntervalLength;
			nextEvenIndex++;
		}
		
		
		return list;
	}
	
	private static int countEven(List<Integer> list) {
		int count = 0;
		for(int i: list)
		{
			if(i%2 == 0)
			{
				count++;
			}
		}
	
		return count;
	}
	//test
	public static void main(String[] args) {
		
		
		for(int i = 0; i < 100; i++)
		{
			
			List<Integer> list = new ArrayList<Integer>();
			int length = (int) (Math.random()*10);
			for(int j = 0; j < length; j++)
			{
				list.add((int) (Math.random()*100));
			}
			
			
			List<Integer> result = distantEvenNumbers(list);
			
			int evenCounter = countEven(result);
			
			if(evenCounter > 1)
			{
				int expectedInterval = (result.size() - 1)/(evenCounter - 1);
				
				int currentEvenIndex = 0;
				while(currentEvenIndex < result.size() && result.get(currentEvenIndex)%2 != 0)
					currentEvenIndex++;
				
				for(int j = currentEvenIndex + 1; j < result.size(); j++)
				{
					if(result.get(j)%2 == 0)
					{
						assert((j - currentEvenIndex) >= expectedInterval);
						
						currentEvenIndex = j;
					}
				}
				System.out.println();
			}
			
			
			
		}
		
		
	}



	



	

}
