/*
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 
 A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 Example :
 
 
 Given A : 1 -> 2 -> 3
 A height balanced BST  :
 
 2
 /   \
 1     3
 */


/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
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
    public TreeNode sortedListToBST(ListNode a) {
        
        if(a==null){
            return null;
        }else if(a.next==null){
            return new TreeNode(a.val);
        }
        
        List<Integer> list = new ArrayList<Integer>();
        while(a!=null){
            list.add(a.val);
            a=a.next;
        }
        
        return createBST(list,0,list.size()-1);
        
    }
    
    TreeNode createBST(List<Integer> input, int begin, int end){
        if(begin==end){
            return new TreeNode(input.get(begin));
        }
        int mid = (end+begin)/2;
        
        TreeNode node = new TreeNode(input.get(mid));
        if(begin<mid){
            node.left = createBST(input,begin,mid-1);
        }
        if(mid<end){
            node.right = createBST(input,mid+1,end);
        }
        
        return node;
    }
    
}
    
    
