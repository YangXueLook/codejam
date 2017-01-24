package googleChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Minglish {
	
	static class Node
	{
		char val;
		int incoming = 0;
		ArrayList<Node> childrenList = new ArrayList<Node>();
		Node(char c)
		{
			this.val = c;
		}
		
	}
	
	public static String answer(String[] words) { 
		HashSet<Character> set = new HashSet<Character>();
		for(String s: words)
		{
			for(int i = 0; i < s.length(); i++)
				set.add(s.charAt(i));
		}
		HashMap<Character, Node> map = new HashMap<Character, Node>();
		
		Iterator it = set.iterator();
		
		while(it.hasNext())
		{
			char c = (char) it.next();
			map.put(c, new Node(c));
		}
		
		for(int i = 0; i < words.length - 1; i++)
		{
			int commonPrefixLength = getCommonPrefixLength(words[i], words[i + 1]);
			
			if(commonPrefixLength != Math.min(words[i].length(), words[i + 1].length()))
			{
				char smallerChar = words[i].charAt(commonPrefixLength);
				char biggerChar = words[i + 1].charAt(commonPrefixLength);
				
				map.get(smallerChar).incoming++;
				map.get(biggerChar).childrenList.add(map.get(smallerChar));
			}
		}
		
		StringBuffer result = new StringBuffer("");
		while(map.size() != 0)
		{
			char c = getNextZeroIncomingChar(map);
			
			result.append(c);
			
			for(Node n: map.get(c).childrenList)
				n.incoming--;
			
			map.remove(c);
			
		}
		
		
		

        return result.reverse().toString();

    } 

	private static char getNextZeroIncomingChar(HashMap<Character, Node> map) {

		Iterator it =map.keySet().iterator();
		while(it.hasNext())
		{
			char c = (char) it.next();
			if(map.get(c).incoming == 0)
				return c;
		}
		
		
		return 0;
	}

	private static int getCommonPrefixLength(String s1, String s2) {
		int index = 0;
		while(index < Math.min(s1.length(), s2.length()))
		{
			if(s1.charAt(index) == s2.charAt(index))
				index++;
			else
				break;
		}
		
		
		return index;
	}

	public static void main(String[] args) {
		System.out.println(getCommonPrefixLength("aaa", "aaa"));
		
		System.out.println(answer(new String[]{"y", "z", "xy"}));

	}

}
