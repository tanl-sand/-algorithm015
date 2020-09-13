package Week_02;

import java.util.ArrayList;
import java.util.List;

public class Postorder {

    /**
     * 比较简单 递归直接解出
     */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        push(root, list);
        return list;
    }

    public void push(Node root, List<Integer> list){
        if(root == null){
            return;
        }
        if(root.children != null){
            for(Node node : root.children){
                push(node, list);
            }
        }
        list.add(root.val);

    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
