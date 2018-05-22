/*
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 
 Try solving it using constant additional space.
 
 Example :
 
 Input :
 
 ______
 |     |
 \/    |
 1 -> 2 -> 3 -> 4
 
 Return the node corresponding to node 3.
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode a) {
        if(a==null){
            return null;
        }
        
        ListNode slow = a.next;
        ListNode fast = a.next.next;
        
        while(slow.next!=null && fast.next!=null && fast.next.next!=null){
            if(slow == fast){
                ListNode slower = a;
                while (slower != slow){
                    slow = slow.next;
                    slower = slower.next;
                }
                return slow;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return null;
    }
}
