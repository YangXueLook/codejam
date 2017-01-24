package round1C;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class PreRequiredCourse {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int loopTimes = scan.nextInt();
		String[] result = new String[loopTimes];
		
		
		for(int i = 0; i < loopTimes; i++)
		{
			ArrayList<Adjacent> adjList = new ArrayList<Adjacent>();
			int numCourses = scan.nextInt();
			
			for(int j = 0; j < numCourses; j++)
			{
				adjList.add(new Adjacent(j));
			}
			
			int numEdges = scan.nextInt();;
			
			for(int j = 0; j < numEdges; j++)
			{
				int to = scan.nextInt();
				int from = scan.nextInt();;
				
				adjList.get(from).adjList.add(to);
				adjList.get(to).incoming++;
			}
			
			result[i] = String.valueOf(helper(adjList,numCourses));
		}
		
		for (int i = 0; i < loopTimes; i++)
		{
			System.out.println("Case " + (i+1) + ": "+ result[i]);
		}

	}

	private static String helper(ArrayList<Adjacent> adjList, int numCourses) {
		int totalVisited = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		int result = 0;
		
		while(getNextZeroIncomingNode(adjList, visited).size() != 0)
		{
			result++;
			ArrayList<Integer> zeroIncomingNodeList = getNextZeroIncomingNode(adjList, visited);
			for(int currentNode: zeroIncomingNodeList)
			{
				totalVisited++;
				visited.add(currentNode);
				Adjacent a = adjList.get(currentNode);
				for(int i = 0; i < a.adjList.size(); i++)
				{
					adjList.get(a.adjList.get(i)).incoming--;
				}
			}
			
			
		}
		
		if(totalVisited == numCourses)
			return result +" semester(s)";

		else
			return "Never Ends";
		
	}
	
	private static ArrayList<Integer> getNextZeroIncomingNode(ArrayList<Adjacent> adjList, HashSet<Integer> visited) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		
		for(int i = 0; i < adjList.size(); i++)
		{
			if(!visited.contains(i) && adjList.get(i).incoming == 0)
				result.add(i);
		}

		return result;
	}

}

class Adjacent
{
	int val;
	int incoming = 0;
	ArrayList<Integer> adjList = new ArrayList<Integer>();
	Adjacent(int val)
	{
		this.val = val;
	}
}
