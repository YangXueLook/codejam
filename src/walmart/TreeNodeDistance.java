package walmart;



public class TreeNodeDistance {

	// ����node�ڵ���root�еĵڼ��㣬-1��ʾû����root�������ҵ�
	public static int findLevel(TreeNode root, int node) {
		if (root == null)
			return -1;
		if (root.val == node)
			return 0;
		// ��������������
		int level = findLevel(root.left, node);
		// ������û���ҵ�������������
		if (level == -1) {
			level = findLevel(root.right, node);
		}
		if (level != -1)
			return level + 1;
		return -1;
	}

	public static TreeNode findLCA(TreeNode root, int node1, int node2) {
		if (root == null)
			return null;

		// �ҵ������ڵ��е�һ���ͷ���
		if (root.val == node1 || root.val == node2) {
			return root;
		}

		// �ֱ��������������������ڵ�
		TreeNode left_lca = findLCA(root.left, node1, node2);
		TreeNode right_lca = findLCA(root.right, node1, node2);

		if (left_lca != null && right_lca != null) {
			// ��ʱ˵���������ڵ�϶��Ƿֱ������������У���ǰ�ڵ��ΪLCA
			return root;
		}
		return left_lca != null ? left_lca : right_lca;
	}

	public static int distanceNodes(TreeNode root, int node1, int node2) {
		TreeNode lca = findLCA(root, node1, node2);
		int dis_lca = findLevel(root, lca.val);
		int dis1 = findLevel(root, node1);
		int dis2 = findLevel(root, node2);
		return dis1 + dis2 - 2 * dis_lca;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);

		
		System.out.println(distanceNodes(root, 1, 3));
		System.out.println(distanceNodes(root, 3, 2));
		System.out.println(distanceNodes(root, 2, 5));
		System.out.println(distanceNodes(root, 5, 2));
		System.out.println(distanceNodes(root, 2, 3));
		System.out.println(distanceNodes(root, 3, 5));
		System.out.println(distanceNodes(root, 5, 3));
		System.out.println(distanceNodes(root, 3, 1));
		System.out.println(distanceNodes(root, 1, 3));
		
	}
}
