/*Given a singly linked list, modify the value of first half nodes such that :
 
 1st node’s new value = the last node’s value - first node’s current value
 2nd node’s new value = the second last node’s value - 2nd node’s current value,
 and so on …
 
 NOTE :
 If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes.
 If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes.
 Example :
 
 Given linked list 1 -> 2 -> 3 -> 4 -> 5,
 
 You should return 4 -> 2 -> 3 -> 4 -> 5
 as
 
 for first node, 5 - 1 = 4
 for second node, 4 - 2 = 2
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
    public ListNode subtract(ListNode A) {
        
        ListNode head = A;
        int size = getSizeOfListNode(A);
        if(size<=1){
            return head;
        }
        
        int halfOfSize = size/2;
        ArrayList<Integer> subtractList = createSubtractLinkedList(A, size,halfOfSize);
        
        int count = 0;
        while(A!=null){
            if(count<subtractList.size()){
                A.val =  subtractList.get(count)-A.val;
                A = A.next;
                count++;
            }
            else{
                break;
            }
        }
        return head;
    }
    
    private ArrayList<Integer> createSubtractLinkedList(ListNode A, int size, int halfOfSize){
        
        ArrayList<Integer> subractList = new ArrayList<Integer>();
        ListNode head = A;
        
        for(int i = 0; i<halfOfSize;i++){
            head = head.next;
        }
        
        if(size%2 == 1){
            head = head.next;
        }
        while(head!=null){
            subractList.add(head.val);
            head = head.next;
        }
        
        Collections.reverse(subractList);
        return subractList;
    }
    
    private int getSizeOfListNode(ListNode node){
        ListNode head = node;
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        
        return size;
    }
}
