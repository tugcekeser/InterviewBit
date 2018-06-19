/*
 Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).
 
 Example :
 Given binary tree
 
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 
 [
 [3],
 [9,20],
 [15,7]
 ]
 Also think about a version of the question where you are asked to do a level order traversal of the tree when depth of the tree is much greater than number of nodes on a level.
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        traverse(A,output,0);
        return output;
    }
    
    void traverse(TreeNode treeNode,ArrayList<ArrayList<Integer>> output,int height){
        if(treeNode==null){
            return;
        }
        
        ArrayList<Integer> result;
        if(height<output.size()){
            result =  output.get(height);
            result.add(treeNode.val);
            output.remove(height);
            output.add(height,result);
        }else{
            result = new ArrayList<Integer>();
            result.add(treeNode.val);
            output.add(result);
        }
        
        
        traverse(treeNode.left, output, height+1 );
        traverse(treeNode.right, output, height+1 );
    }
}
