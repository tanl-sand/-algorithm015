package Week_01;

public class MyCircularDeque {
    private int length;

    private int nowSize;

    private Node firstNode;

    private Node lastNode;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.length = k;
        this.nowSize = 0;
    }

    private boolean initNode(int value){
        Node node = new Node();
        node.setValue(value);
        firstNode = node;
        lastNode = node;
        nowSize ++;
        return true;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(nowSize >= length){
            return false;
        }
        if(isEmpty()){
            return initNode(value);
        }
        Node node = new Node();
        firstNode.setBeforeNode(node);
        node.setValue(value);
        node.setLastNode(firstNode);
        firstNode = node;
        nowSize ++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(nowSize >= length){
            return false;
        }
        if(isEmpty()){
            return initNode(value);
        }
        Node node = new Node();
        lastNode.setLastNode(node);
        node.setValue(value);
        node.setBeforeNode(lastNode);
        lastNode = node;
        nowSize ++;
        return true;
    }

    private boolean removeLastOneNode() {
        firstNode = null;
        lastNode = null;
        nowSize --;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(nowSize == 0){
            return false;
        }
        Node newFirstNode = firstNode.getLastNode();
        if (newFirstNode == null) {
            return removeLastOneNode();
        }
        newFirstNode.setBeforeNode(null);
        firstNode = newFirstNode;
        nowSize --;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(nowSize == 0){
            return false;
        }
        Node newLastNode = lastNode.getBeforeNode();
        if (newLastNode == null) {
            return removeLastOneNode();
        }
        newLastNode.setLastNode(null);
        lastNode = newLastNode;
        nowSize --;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (nowSize == 0){
            return -1;
        }
        return firstNode.getValue();
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (nowSize == 0) {
            return -1;
        }
        return lastNode.getValue();
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.nowSize == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.nowSize >= this.length;
    }

    class Node {
        private Integer value;

        private Node beforeNode;

        private Node lastNode;

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getBeforeNode() {
            return beforeNode;
        }

        public void setBeforeNode(Node beforeNode) {
            this.beforeNode = beforeNode;
        }

        public Node getLastNode() {
            return lastNode;
        }

        public void setLastNode(Node lastNode) {
            this.lastNode = lastNode;
        }
    }
}
