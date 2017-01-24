package round1C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Escape {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int e = scan.nextInt();
		int k = scan.nextInt();
		
		Node[] nodeArray = new Node[n + 1];
		for(int i = 1; i <= n; i++)
			nodeArray[i] = new Node(i);
		
		for(int i = 0; i < n - 1; i++)
		{
			int firstNodeIndex = scan.nextInt();
			int secondNodeIndex = scan.nextInt();
			int weight = scan.nextInt();
			
			nodeArray[firstNodeIndex].adjNodesSet.add(nodeArray[secondNodeIndex]);
			nodeArray[firstNodeIndex].pathWeightMap.put(nodeArray[secondNodeIndex], weight);
			
			nodeArray[secondNodeIndex].adjNodesSet.add(nodeArray[firstNodeIndex]);
			nodeArray[secondNodeIndex].pathWeightMap.put(nodeArray[firstNodeIndex], weight);
		}
		
		for(int i = 0; i < e; i++)
		{
			int firstNodeIndex = scan.nextInt();
			int secondNodeIndex = scan.nextInt();
			int weight = scan.nextInt();
			
//			nodeArray[firstNodeIndex].adjNodesSet.add(nodeArray[secondNodeIndex]);
			nodeArray[firstNodeIndex].shortcutWeightMap.put(nodeArray[secondNodeIndex], weight);
			
//			nodeArray[secondNodeIndex].adjNodesSet.add(nodeArray[firstNodeIndex]);
			nodeArray[secondNodeIndex].shortcutWeightMap.put(nodeArray[firstNodeIndex], weight);
		}
		
		for(int i = 1; i <= n; i++)
		{
			System.out.println(shortestPath(nodeArray, i, k));
		}

	}

	private static int shortestPath(Node[] nodeArray, int i, int k) {
		if(nodeArray[i].adjNodesSet.size() == 1 || nodeArray[i].adjNodesSet.size() == 0)
			return 0;

		HashSet<Integer> visisted = new HashSet<Integer>();
//		visisted.add(i);
		
//		System.out.println(shortestPathWithoutShortcut(nodeArray, i, visisted));
		
		int result = Integer.MAX_VALUE;
		
//		System.out.println("**********");
		ArrayList<ArrayList<Integer>> allPaths = allPossiblePaths(nodeArray, i, visisted);
		for(ArrayList<Integer> list : allPaths)
		{
			
//			for(int index: list)
//			{
//				System.out.print(index+"\t");
//			}
//			System.out.println();
//			System.out.print("length: ");
//			System.out.println(getShortestLength(nodeArray, list, k));
			
			result = Math.min(result, getShortestLength(nodeArray, list, k));
		}
//		System.out.println("**********");
		return result;
	}

	private static int getShortestLength(Node[] nodeArray,
			ArrayList<Integer> list, int k) {
		ArrayList<Integer> shortcutBenefitList = new ArrayList<Integer>();
		
		int result = 0;
		
		for(int i = list.size() - 1; i > 0; i--)
		{
			int pathLength = nodeArray[list.get(i)].pathWeightMap.get(nodeArray[list.get(i - 1)]);
			
			result = result + pathLength;
			
			if(nodeArray[list.get(i)].shortcutWeightMap.containsKey(nodeArray[list.get(i - 1)]))
			{
				int shortcutLength = nodeArray[list.get(i)].shortcutWeightMap.get(nodeArray[list.get(i - 1)]);
				int benefit = Math.max(0, pathLength - shortcutLength);
				shortcutBenefitList.add(benefit);
			}
			
		}
		
		Collections.sort(shortcutBenefitList);
		int index = shortcutBenefitList.size() - 1;
		
		for(int i = 0; i < k && index >= 0; i++)
		{
			result = result - shortcutBenefitList.get(index);
			index--;
		}
		
		return result;
	}

	private static ArrayList<ArrayList<Integer>> allPossiblePaths(Node[] nodeArray, int i, HashSet<Integer> visisted) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if(nodeArray[i].adjNodesSet.size() == 1)
		{
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(i);
			result.add(list);
			return result;
		}
			

		visisted.add(i);
		
//		int result = Integer.MAX_VALUE;
		
		Iterator it = nodeArray[i].adjNodesSet.iterator();
		
		while(it.hasNext())
		{
			Node node = (Node) it.next();
//			System.out.println(i+"-----"+node.nodeIndex);
			if(!visisted.contains(node.nodeIndex))
			{
//				int weight = nodeArray[i].pathWeightMap.get(node);
				
				ArrayList<ArrayList<Integer>> tempResult = allPossiblePaths(nodeArray, node.nodeIndex, visisted);
				
				for(ArrayList<Integer> list: tempResult)
				{
					list.add(i);
					result.add(list);
				}
				
				
				
//				result = Math.min(result, weight + allPossiblePaths(nodeArray, node.nodeIndex, visisted));
			}
			
		}
		
		
		return result;
	}

}

class Node
{
	int nodeIndex = 0;
	HashSet<Node> adjNodesSet = new HashSet<Node>();
	HashMap<Node, Integer> pathWeightMap = new HashMap<Node, Integer>();
	HashMap<Node, Integer> shortcutWeightMap = new HashMap<Node, Integer>();
	
	Node(int n)
	{
		this.nodeIndex = n;
	}
	
}