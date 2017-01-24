package rocketfuel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	
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
		
		for(Interval i1: array)
		{
			for(Interval i2: array)
			{
				if(i1.start < i2.start && i1.end > i2.end)
					i1.score++;
			}
		}
		
		Arrays.sort(array, new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.score != o2.score)
					return o1.score - o2.score;
				else
					return o1.ID - o2.ID;
			}});
		
		
		for(Interval i: array)
		{
			System.out.println(i.ID + " " + i.score);
		}
    }
}
