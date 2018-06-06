/*
 Balanced Binary Tree
 Given a binary tree, determine if it is height-balanced.
 
 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 
 Example :
 
 Input :
 1
 / \
 2   3
 
 Return : True or 1
 
 Input 2 :
 3
 /
 2
 /
 1
 
 Return : False or 0
 Because for the root node, left subtree has depth 2 and right subtree has depth 0.
 Difference = 2 > 1.
 */

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int isBalanced(TreeNode A) {
        
        if(A==null){
            return 1;
        }
        
        int left = checkIsBalancedWithHeight(A.left);
        int right = checkIsBalancedWithHeight(A.right);
        
        if(left - right<=1 && left - right>=-1){
            //Balanced
            return (isBalanced(A.left)==0 || isBalanced(A.right)==0?0:1);
        }else{
            return 0;
        }
    }
    
    private int checkIsBalancedWithHeight(TreeNode A){
        if(A==null){
            return 0;
        }
        
        int left = checkIsBalancedWithHeight(A.left)+1;
        int right = checkIsBalancedWithHeight(A.right)+1;
        
        return Math.max(left,right);
    }
}
