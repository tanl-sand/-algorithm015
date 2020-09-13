package Week_02;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class InorderTraversal {

    /**
     * 比较简单 递归直接解出
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        push(root, list);
        return list;
    }

    public void push(TreeNode root, List<Integer> list){
        if(root.left != null){
            push(root.left, list);
        }
        list.add(root.val);
        if(root.right != null){
            push(root.right, list);
        }

    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
}
