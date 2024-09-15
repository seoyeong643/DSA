package algorithms.numbertheory;

public class GCD {
    public int calculateGCD(int a, int b) {
        if (b==0) return a;
        return calculateGCD(b,a%b);
    }

    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for(int n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        return calculateGCD(min, max);
    }


//     Definition for singly-linked list.
     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode point = head;
        while(point.next != null){
            int gcdValue = calculateGCD(point.val, point.next.val);
            ListNode gcdNode = new ListNode(gcdValue);
            ListNode temp = point.next;
            point.next = gcdNode;
            gcdNode.next = temp;
            point = temp;
        }
        return head;
    }
}
