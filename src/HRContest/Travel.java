package HRContest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Travel {
	
	static class Attract {
		int id;
		double lat;
		double lon;
	}

	static class Traveller {
		double lat;
		double lon;
		double time;
		double speed;
	}

	static class IDAndTime
	{
		int id;
		double time;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Attract[] attArray = new Attract[n];
		for (int i = 0; i < n; i++) {
			Attract att = new Attract();
			att.id = scan.nextInt();
			att.lat = scan.nextDouble()*3.14159265359/180;
			att.lon = scan.nextDouble()*3.14159265359/180;
			attArray[i] = att;
		}

		int m = scan.nextInt();
		Traveller[] traArray = new Traveller[m];

		for (int i = 0; i < m; i++) {
			Traveller t = new Traveller();
			t.lat = scan.nextDouble()*3.14159265359/180;
			t.lon = scan.nextDouble()*3.14159265359/180;
			String s = scan.next();
			if (s.equals("metro"))
				t.speed = 20;
			else if (s.equals("bike"))
				t.speed = 15;
			else
				t.speed = 5;
			t.time = scan.nextDouble();
			traArray[i] = t;

		}

		for (int i = 0; i < m; i++)
			helper(traArray[i], attArray);

	}

	private static void helper(Traveller traveller, Attract[] attArray) {
		IDAndTime[] resultArray = new IDAndTime[attArray.length];
		for (int i = 0; i < attArray.length; i++) {
			IDAndTime t = new IDAndTime();
			
			double distance = dis(traveller, attArray[i]);
			t.id = attArray[i].id;
			t.time = distance/traveller.speed;
			resultArray[i] = t;
		}
		
		Arrays.sort(resultArray, new Comparator<IDAndTime>(){

			@Override
			public int compare(IDAndTime o1, IDAndTime o2) {
				// TODO Auto-generated method stub
				if(o1.time < o2.time)
					return -1;
				else if(o1.time > o2.time)
					return 1;
				else 
					return (o1.id - o2.id);
				
			}});
		
		int lastIndex = resultArray.length - 1;
		
		for(lastIndex = resultArray.length - 1; lastIndex >=0; lastIndex--)
		{
			if(resultArray[lastIndex].time * (double)60 <= (double)(traveller.time))
				break;
		}
		
		
		for(int i = 0; i <= lastIndex; i++)
		{
//			System.out.print(resultArray[i].id+" "+resultArray[i].time);
			
			if(i < lastIndex)
				System.out.print(resultArray[i].id+" ");
			else
				System.out.print(resultArray[i].id);
		}
			
		
		System.out.println();

	}

	// function distance_between(point1, point2) {
	// var EARTH_RADIUS = 6371;//in km
	// var point1_lat_in_radians = degree2radians( point1.latitude );
	// var point2_lat_in_radians = degree2radians( point2.latitude );
	// var point1_long_in_radians = degree2radians( point1.longitude );
	// var point2_long_in_radians = degree2radians( point2.longitude );
	//
	// return acos( sin( point1_lat_in_radians ) * sin( point2_lat_in_radians )
	// +
	// cos( point1_lat_in_radians ) * cos( point2_lat_in_radians ) *
	// cos( point2_long_in_radians - point1_long_in_radians) ) * EARTH_RADIUS;
	// }

	private static double dis(Traveller traveller, Attract attract) {
		double r = 6371;
		double distance = r
				* Math.acos((Math.sin(traveller.lat) * Math.sin(attract.lat) + Math
						.cos(traveller.lat)
						* Math.cos(attract.lat)
						* Math.cos(attract.lon - traveller.lon)));
		
//		System.out.println("distance"+distance);
		return distance;
	}

}


