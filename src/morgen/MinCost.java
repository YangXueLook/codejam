package morgen;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MinCost {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i = 0; i < t; i++)
		{
			String s1 = scan.next();
			String s2 = scan.next(); 
			
			int dCost = scan.nextInt();
			int iCost = scan.nextInt(); 
			int rCost = scan.nextInt();
			System.out.println(helper(s1, s2, dCost, iCost, rCost));
		}

	}

	private static int helper(String s1, String s2, int dCost, int iCost,
			int rCost) {
		
		
		
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		
		for(int i = 0; i < s1.length(); i++)
		{
			if(!map1.containsKey(s1.charAt(i)))
				map1.put(s1.charAt(i), 1);
			else
				map1.put(s1.charAt(i), map1.get(s1.charAt(i)) + 1);
		}
		
//		int left1 = 0;
//		Iterator it1 = map1.keySet().iterator();
//		while(it1.hasNext())
//		{
//			System.out.println(map1.get(it1.next()));
//		}
		
		for(int i = 0; i < s2.length(); i++)
		{
			if(!map1.containsKey(s2.charAt(i)))
			{
				if(!map2.containsKey(s2.charAt(i)))
					map2.put(s2.charAt(i), 1);
				else
					map2.put(s2.charAt(i), map2.get(s2.charAt(i)) + 1);
			}
			else
			{
				if(map1.get(s2.charAt(i)) > 1)
					map1.put(s2.charAt(i), map1.get(s2.charAt(i)) - 1);
				else
					map1.remove(s2.charAt(i));
			}
		}
		
		int left1 = 0;
		Iterator it1 = map1.keySet().iterator();
		while(it1.hasNext())
		{
			left1 = left1 + map1.get(it1.next());
		}
			
		
		int left2 = 0;
		Iterator it2 = map2.keySet().iterator();
		while(it2.hasNext())
			left2 = left2 + map2.get(it2.next());
		
		int result = 0;
		
		if(left1 > left2)
		{
			result = result + (left1 - left2) * dCost;
			result = result + left2 * Math.min(rCost, dCost + iCost);
		}
		else
		{
			result = result + (left2 - left1) * iCost;
			result = result + left1 * Math.min(rCost, dCost + iCost);
		}
		
		return result;
	}

}
