package Week_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个3叉树
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 */
public class LevelOrder {

    /**
     * count： 表示递归深度也表示数组下标
     * ary：存储每个深度节点
     */
    int count = -1;
    List<Integer>[] ary = new List[1000];
    public List<List<Integer>> levelOrder(Node root) {
        add(root);
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> integers : ary) {
            if(integers == null){
                return list;
            }
            list.add(integers);
        }
        return list;
    }

    public void add(Node node){
        count ++;
        if(node == null){
            return;
        }
        List<Integer> list = ary[count] == null? new ArrayList<>():ary[count];
        list.add(node.val);
        ary[count] = list;
        if(node.children != null){
            for (Node child : node.children) {
                add(child);
            }
        }
        count --;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    /**
     * 看了下题解的递归办法、思路是一样但是我的做了很多没必要的操作
     */
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder1(Node root) {
        if (root == null){
            return result;
        }
        add(root, 0);
        return result;
    }

    public void add(Node node, int index){
        if(result.size() <= index){
            result.add(new ArrayList<>());
        }
        result.get(index).add(node.val);
        if(node.children != null){
            for (Node child : node.children) {
                add(child, index + 1);
            }
        }
    }

}
