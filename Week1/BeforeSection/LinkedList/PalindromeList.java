/*
 Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.
 
 Notes:
 
 Expected solution is linear in time and constant in space.
 For example,
 
 List 1-->2-->1 is a palindrome.
 List 1-->2-->3 is not a palindrome.
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
    public int lPalin(ListNode A) {
        ListNode head = A;
        int length = getLengthOfList(A);
        int half = length %2 == 1 ? length/2 : length/2+1;
        ArrayList<Integer> reversedList= getReversedList(A,half);
        Collections.reverse(reversedList);
        for(Integer val:reversedList){
            if(head.val!=val){
                return 0;
            }
            head = head.next;
        }
        
        return 1;
    }
    
    private int getLengthOfList(ListNode A){
        ListNode node = A;
        int counter = 0;
        while(node!=null){
            counter++;
            node = node.next;
        }
        return counter;
    }
    
    private ArrayList<Integer> getReversedList (ListNode A, int half){
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode node = A;
        int counter = 0;
        while(node!=null){
            counter++;
            if(counter>=half){
                list.add(node.val);
            }
            node = node.next;
        }
        
        return list;
    }
}
