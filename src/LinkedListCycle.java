public class LinkedListCycle {
    public static void main(String[] args) {
        System.out.println();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;

        ListNode one = head;
        ListNode two = head.next;

        while (one != null || two != null){
            if(one == two)
                return true;

            int step = 1;
            for (int i = 0; i < step; i++) {
                if(one.next != null)
                    one = one.next;
                else
                    return false;
            }

            step = 2;
            for (int i = 0; i < step; i++) {
                if(two.next != null)
                    two = two.next;
                else
                    return false;
            }

        }

        return false;

    }
}
