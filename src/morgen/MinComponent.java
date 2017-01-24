package morgen;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinComponent {
	
	static class Node
	{
		int weight = 0;
		HashSet<Node> connected = new HashSet<Node>();
		Node(int weight)
		{
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
//		PriorityQueue<Integer> prq = new PriorityQueue<Integer>();
//
//		// insert values in the queue
//		for (int i = 3; i < 10; i++) {
//			prq.add(new Integer(i));
//		}
//		prq.add(3);
//		System.out.println("Initial priority queue values are: " + prq);
//
//		// remove 7 from the queue
//		boolean isremoved = prq.remove(3);
////		System.out.println(prq.peek());
////		prq.remove(3);
////		System.out.println(prq.peek());
//		
//		Integer min = -1;
//		prq.add(min);
//		System.out.println(prq.peek());
//		min = 100;
//		System.out.println(prq.peek());
//		
//		System.out.println("Return value after remove: " + isremoved);
//
//		System.out.println("Priority queue values after remove: " + prq);

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Node[] array = new Node[n + 1];
		PriorityQueue<Node> prq = new PriorityQueue<Node>();
		
		int q = scan.nextInt();
		for(int i = 1; i <= n; i++)
		{
			int num = scan.nextInt();
			array[i] = new Node(num);
			
			
//			prq.add(num);
		}
			
		
		for(int i = 0; i < q; i++)
		{
			int from = scan.nextInt();
			int to = scan.nextInt();
			
			System.out.println(helper(array, from, to));
 		}
		
		
	}

	private static int helper(Node[] array, int from, int to) {
		// TODO Auto-generated method stub
		if(!array[to].connected.contains(array[from]))
		{
			Iterator it1 = array[from].connected.iterator();
			while(it1.hasNext())
				array[to].connected.add((Node) it1.next());
			
			array[from].connected.addAll(array[to].connected);
			
			array[from].weight = array[from].weight + array[to].weight;
			array[to].weight = array[from].weight;
			
			it1 = array[from].connected.iterator();
			while(it1.hasNext())
			{
				Node n =  (Node) it1.next();
				n.weight = array[from].weight;
				n.connected.addAll(array[to].connected);
				n.connected.add(array[to]);
			}
			
			it1 = array[to].connected.iterator();
			while(it1.hasNext())
			{
				Node n =  (Node) it1.next();
				n.weight = array[from].weight;
				n.connected.addAll(array[to].connected);
				n.connected.add(array[from]);
			}
			
			
			array[from].connected.add(array[to]);
			array[to].connected.add(array[from]);
			
			
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 1; i < array.length; i++)
		{
			min = Math.min(min, array[i].weight);
		}
			
			
		
		return min;
	}

	

}
