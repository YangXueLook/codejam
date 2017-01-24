package walmart;

public class Tree {
	public TreeNode buildTree(TreeNode root, int[] nums, int index) {
		if (index >= nums.length) {
			return null;
		}
		root = new TreeNode(nums[index]);
		root.left = buildTree(root.left, nums, 2 * index + 1);
		root.right = buildTree(root.right, nums, 2 * index + 2);
		return root;
	}

	public void preOrderTravelse(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + "   ");
		preOrderTravelse(root.left);
		preOrderTravelse(root.right);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		Tree tree = new Tree();
		TreeNode root = null;
		root = tree.buildTree(root, nums, 0);
		tree.preOrderTravelse(root);
		System.out.println();
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
		System.out.println(root.left.left.val);
		System.out.println(root.left.right.val);

	}
}
