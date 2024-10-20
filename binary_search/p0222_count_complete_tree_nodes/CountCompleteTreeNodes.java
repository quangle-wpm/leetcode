package leetcode.binary_search.p0222_count_complete_tree_nodes;

import java.util.*;

public class CountCompleteTreeNodes {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode leftNode = root;
        TreeNode rightNode = root;

        int left = 1, right = 1;

        while (leftNode.left != null) {
            leftNode = leftNode.left;
            left++;
        }

        while (rightNode.right != null) {
            rightNode = rightNode.right;
            right++;
        }

        if (left == right) {
            return (int) Math.pow(2, left) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static TreeNode buildTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int i = 1;
        while (i < nums.length) {
            TreeNode curr = q.remove();
            if (i < nums.length) {
                curr.left = new TreeNode(nums[i++]);
                q.add(curr.left);
            }
            if (i < nums.length) {
                curr.right = new TreeNode(nums[i++]);
                q.add(curr.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();

        System.out.println(countCompleteTreeNodes.countNodes(null)); // 0
        System.out.println(countCompleteTreeNodes.countNodes(buildTree(null))); // 0
        System.out.println(countCompleteTreeNodes.countNodes(buildTree(new int[]{1}))); // 1
        System.out.println(countCompleteTreeNodes.countNodes(buildTree(new int[]{1, 2, 3, 4, 5, 6}))); // 6
    }
}
