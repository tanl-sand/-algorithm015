package Week_03;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return recurrence(root, null, null);
    }

    private boolean recurrence(TreeNode node, Integer max, Integer min){
        if(node == null){
            return true;
        }
        if(max != null && max <= node.val)return false;
        if(min !=null && min >= node.val)return false;
        if(!recurrence(node.left, node.val, min))return false;
        if(!recurrence(node.right, max, node.val))return false;
        return true;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


