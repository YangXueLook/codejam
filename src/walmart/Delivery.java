package walmart;

import java.util.HashMap;
import java.util.Scanner;

public class Delivery {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.next());
		int[] values = new int[n];
		for (int i = 0; i < n; i++)
			values[i] = i + 1;
		TreeNode root = null;
		root = buildTree(root, values, 0);

		int m = Integer.parseInt(in.next());
		int q = Integer.parseInt(in.next());

		HashMap<Integer, int[]> foodResMap = new HashMap<Integer, int[]>();
		Order[] orders = new Order[q];

		for (int i = 0; i < m; i++) {

			int num = Integer.parseInt(in.next());
			int[] array = new int[num];
			for (int j = 0; j < num; j++) {
				array[j] = Integer.parseInt(in.next());
			}
			foodResMap.put(i + 1, array);
		}

		for (int i = 0; i < q; i++) {
			Order order = new Order();
			order.food = Integer.parseInt(in.next());
			order.personLocation = Integer.parseInt(in.next());
			orders[i] = order;
		}

		int sum = 0;
		int startLocation = 1;

		for (int i = 0; i < q; i++) {
			startLocation = i == 0 ? 1 : orders[i - 1].personLocation;

			sum = sum + getTime(root, startLocation, n, orders[i], foodResMap);
		}
		System.out.println(sum);

	}

	private static int getTime(TreeNode root, int startLocation,
			int numOfNodes, Order order, HashMap<Integer, int[]> foodResMap) {
		int[] rests = foodResMap.get(order.food);
		int distance = Integer.MAX_VALUE;
		for (int i = 0; i < rests.length; i++) {
			distance = Math.min(
					distance,
					getMinDistance(root, startLocation, rests[i])
							+ getMinDistance(root, rests[i],
									order.personLocation));
		}

		return distance;
	}

	private static int findLevel(TreeNode root, int node) {
		if (root == null)
			return -1;
		if (root.val == node)
			return 0;

		int level = findLevel(root.left, node);

		if (level == -1) {
			level = findLevel(root.right, node);
		}
		if (level != -1)
			return level + 1;
		return -1;
	}

	private static TreeNode findLCA(TreeNode root, int node1, int node2) {
		if (root == null)
			return null;

		if (root.val == node1 || root.val == node2) {
			return root;
		}

		TreeNode left_lca = findLCA(root.left, node1, node2);
		TreeNode right_lca = findLCA(root.right, node1, node2);

		if (left_lca != null && right_lca != null) {

			return root;
		}
		return left_lca != null ? left_lca : right_lca;
	}

	private static int getMinDistance(TreeNode root, int node1, int node2) {
		TreeNode lca = findLCA(root, node1, node2);
		int dis_lca = findLevel(root, lca.val);
		int dis1 = findLevel(root, node1);
		int dis2 = findLevel(root, node2);
		return dis1 + dis2 - 2 * dis_lca;
	}

	private static TreeNode buildTree(TreeNode root, int[] nums, int index) {
		if (index >= nums.length) {
			return null;
		}
		root = new TreeNode(nums[index]);
		root.left = buildTree(root.left, nums, 2 * index + 1);
		root.right = buildTree(root.right, nums, 2 * index + 2);
		return root;
	}

}

class Order {
	int food;
	int personLocation;
}

class TreeNode {
	TreeNode left, right;
	int val;

	public TreeNode(int i) {
		this.val = i;
	}
}
