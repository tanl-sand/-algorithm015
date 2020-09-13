package Week_02;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    /**
     * 比较简单 大同小异
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        push(root, list);
        return list;
    }

    public void push(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left != null){
            push(root.left, list);
        }
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
