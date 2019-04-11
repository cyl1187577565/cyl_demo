package leetCode;

/**
 * leetcode 226翻转二叉树
 */
public class L0226_Invert_Tree {
    public TreeNode invertTree(TreeNode root) {

        if (root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return  root;
    }
}
