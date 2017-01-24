package rocketfuel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSortTest {
	static class Interval 
	{
		int ID;
		long start;
		long end;
		int score = 0;

		Interval(int ID, long start, long end) 
		{
			this.ID = ID;
			this.start = start;
			this.end = end;
		}
	}

	

	static void mergeArray(Interval array[], int startIndex, int midIndex, int endIndex, Interval temp[]) {
		int i = startIndex;
		int j = midIndex + 1;
		int m = midIndex;
		int n = endIndex;
		int k = 0;

		while (i <= m && j <= n) 
		{
			if (array[i].end > array[j].end)
			{
				temp[k] = array[i];
				i++;
				k++;
			}
				
			else 
			{
				//array[j] contains all intervals between i and m
				array[j].score += m - i + 1;
				temp[k] = array[j];
				j++;
				k++;
			}
		}

		while (i <= m)
		{
			temp[i] = array[i];
			i++;
			k++;
		}
		while (j <= n)
		{
			temp[k] = array[j];
			j++;
			k++;
		}
			
		//copy back to array
		for (i = 0; i < k; i++)
			array[startIndex + i] = temp[i];
	}

	static void mergeSort(Interval array[], int startIndex, int endIndex, Interval temp[]) {
		if (startIndex < endIndex) {
			int mid = (startIndex + endIndex) / 2;
			mergeSort(array, startIndex, mid, temp);
			mergeSort(array, mid + 1, endIndex, temp);
			mergeArray(array, startIndex, mid, endIndex, temp);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int n = Integer.parseInt(line);

		Interval[] array = new Interval[n];
		int index = 0;
		while ((line = br.readLine()) != null) {

			String[] split = line.split(" ");
			array[index] = new Interval(Integer.parseInt(split[0]),
					Long.parseLong(split[1]), Long.parseLong(split[2]));
			index++;

		}
		
		System.out.println(array.length);
//		for(Interval interval: array)
//			 System.out.println(interval.ID + "\t" + interval.start + "\t" +interval.end);
//		
		Arrays.sort(array, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
//				if(o1.start > o2.start)
//					return -1;
//				else if(o1.start == o2.start)
//					return 0;
//				else
//					return 1;

				return 1;
			}
		});
		mergeSort(array, 0, array.length - 1, new Interval[n]);
		// for(Interval interval: array)
		// System.out.println(interval.ID + "\t" + interval.start + "\t" +
		// interval.end);
		//
		// System.out.println(endInversionCount);
		Arrays.sort(array, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.score != o2.score)
					return o1.score - o2.score;
				else
					return o1.ID - o2.ID;
			}
		});
		for (Interval interval : array)
			System.out.println(interval.ID + " " + interval.score);

	}

}
