package other;

public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);

        a.next = b;
        b.next = c;

        c.next = d;

        deleteDuplicates(a);
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode node = new ListNode(head.val);
        ListNode idx = node;

        while(head.next != null){
           if(head.val != head.next.val){
               node.next = new ListNode(head.next.val);
               node = node.next;
           }
           head = head.next;
        }

        return idx;
    }
}
