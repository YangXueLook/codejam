package WCS4;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Floyd {

	public static void main(String[] args) {

		int k, i, j, n, m, t1, t2, t3;
		
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		MyHeap[][] e = new MyHeap[n + 1][n + 1];

		for (i = 1; i <= n; i++) {
			for (j = 1; j <= n; j++) {
				if (i == j) {
					e[i][j] = new MyHeap(m);
					e[i][j].q.add(-1);
				} else {
					e[i][j] = new MyHeap(m);
					e[i][j].q.add(m + 1);
				}
			}
		}

		for (i = 1; i <= m; i++) {
			t1 = in.nextInt();
			t2 = in.nextInt();
			t3 = in.nextInt();

			e[t1][t2].q.remove();
			e[t1][t2].q.add(t3);

			e[t2][t1].q.remove();
			e[t2][t1].q.add(t3);

		}

		for (k = 1; k <= n; k++)
			for (i = 1; i <= n; i++)
				for (j = 1; j <= n; j++)
					if (e[i][j].isGreaterThan(e[i][k], e[k][j]))
					{
						e[i][j].q.clear();
						e[i][j].q.addAll(e[i][k].q);
						e[i][j].q.addAll(e[k][j].q);
					}
						

//		BigInteger sum = BigInteger.ZERO;
//		for (i = 1; i <= n; i++) {
//			for (j = i + 1; j <= n; j++) {
//				sum = sum.add(e[i][j]);
//			}
//
//		}
//		System.out.println(sum.toString(2));
		
		
		
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= n; j++) {
				System.out.print("||");
				for(int num : e[i][j].q)
				{
					System.out.print(num + " ");
				}
				System.out.print("\t");
				
			}
			System.out.println("\n");
		}
		
		
	}
}

class MyHeap {
	PriorityQueue<Integer> q;

	MyHeap(int cap) {
		this.q = new PriorityQueue<Integer>(cap, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
	}

	
	
	public boolean isGreaterThan(MyHeap h1, MyHeap h2) {

		PriorityQueue<Integer> q1 = new PriorityQueue<Integer>(this.q.size(),
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return o2 - o1;
					}
				});

		PriorityQueue<Integer> q2 = new PriorityQueue<Integer>(this.q.size(),
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return o2 - o1;
					}
				});

		PriorityQueue<Integer> q3 = new PriorityQueue<Integer>(this.q.size(),
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return o2 - o1;
					}
				});

		
		q1.addAll(h1.q);
		q2.addAll(h2.q);
		q3.addAll(q);
		
		int a;
		int b;
		int c;
		
		while(!q1.isEmpty() && !q2.isEmpty() && !q3.isEmpty())
		{
			a = q1.remove();
			b = q2.remove();
			c = q3.remove();
			
			if(c > a && c > b)
				return true;
			else if(c < a || c < b)
				return false;
			
		}
		return false;
	}

}
