package Week_03;

import java.util.*;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[0]);
        int InorderRootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[0]){
                InorderRootIndex = i;
                break;
            }
        }
        int[] newLeftInorder = Arrays.copyOfRange(inorder, 0, InorderRootIndex);
        int[] newRightInorder = Arrays.copyOfRange(inorder, InorderRootIndex + 1, inorder.length);
        int[] newLeftPreorder = Arrays.copyOfRange(preorder, 1, 1 + newLeftInorder.length);
        int[] newRightPreorder = Arrays.copyOfRange(preorder, 1 + newLeftInorder.length, inorder.length);
        treeNode.left = buildTree(newLeftPreorder, newLeftInorder);
        treeNode.right = buildTree(newRightPreorder, newRightInorder);
        return treeNode;
    }
}
