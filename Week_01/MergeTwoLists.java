package Week_01;

public class MergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode firstNode = null;
        ListNode nowListNode = null;
        while (true){
            if(nowListNode == null){
                if(l1.val < l2.val){
                    nowListNode = l1;
                    l1 = l1.next;
                }else {
                    nowListNode = l2;
                    l2 = l2.next;
                }
                firstNode =nowListNode;
                continue;
            }
            if(l1 == null){
                nowListNode.next = l2;
                return firstNode;
            }
            if(l2 == null){
                nowListNode.next = l1;
                return firstNode;
            }
            if(l1.val < l2.val){
                nowListNode.next = l1;
                nowListNode = l1;
                l1 = l1.next;
            }else {
                nowListNode.next = l2;
                nowListNode = l2;
                l2 = l2.next;
            }
        }
    }

    /**
     * 题解递归
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

}
