package round1C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BellOrWave {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int loopTimes = scan.nextInt();
		ArrayList<Point> list = new ArrayList<Point>();

		for (int i = 0; i < loopTimes; i++) {
			float x = scan.nextFloat();
			float y = scan.nextFloat();
			list.add(new Point(x, y));
		}

		Collections.sort(list, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {

				if (o1.x - o2.x < 0)
					return -1;
				else if (o1.x - o2.x > 0)
					return 1;
				else
					return 0;

			}

		});
		
		float firstValue = Math.abs(list.get(0).y);
		
		boolean isSquare = true;
		
		for(Point p: list)
		{
			if(!(Math.abs(p.y) == firstValue))
			{
				isSquare = false;
				break;
			}
		}
		
		if(isSquare)
		{
			System.out.println("square-wave");
			
		}
		else
		{
			System.out.println("sine-wave");
//			int f = 5;
//			for(int i = 1; i <= 10; i++)
//			{
//				if(passFreCheck(list, f * i, firstValue))
//				{
//					System.out.println(f * i);
//					break;
//				}
//					
//			}
		}
		
//		passFreCheck(list, 10);
		
		int f = 5;
		for(int i = 1; i <= 10; i++)
		{
			if(passFreCheck(list, f * i))
			{
				System.out.println(f * i);
				break;
			}
				
		}

	}

//	private static boolean passSineFreCheck(ArrayList<Point> list, int f,
//			float firstValue) {
//		float halfCycleLength = (float)1/(float)(f * 2);
//		return true;
//	}

	private static boolean passFreCheck(ArrayList<Point> list, int f) {
		float halfCycleLength = (float)1/(float)(f * 2);
//		System.out.println(halfCycleLength);
		
		for(Point p: list)
		{
//			System.out.println(((p.x * 1000/halfCycleLength)));
			
			if((int)(p.x * 1000) % (int)(1000*halfCycleLength) == 0)
			{
//				System.out.println("edge");
				continue;
			}
				
			
			if((int)(Math.floor(p.x * 1000/(int)(1000*halfCycleLength))) %2 == 0)
			{
				if(p.y < 0)
				{
//					System.out.println(p.x+" "+p.y);
					return false;
				}
					
			}
			else
			{
				if(p.y > 0)
				{
//					System.out.println(p.x+" "+p.y);
					return false;
				}
					
			}
		}
		
		return true;
	}

}

class Point {
	float x;
	float y;

	Point(float x, float y) {
		this.x = x;
		this.y = y;
	}
}