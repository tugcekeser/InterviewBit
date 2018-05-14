/*Given an array, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array.
 More formally,
 
 G[i] for an element A[i] = an element A[j] such that
 j is minimum possible AND
 j > i AND
 A[j] > A[i]
 Elements for which no greater element exist, consider next greater element as -1.
 
 Example:
 
 Input : A : [4, 5, 2, 10]
 Output : [5, 10, 10, -1]
 
 Example 2:
 
 Input : A : [3, 2, 1]
 Output : [-1, -1, -1]
 */

public class Solution {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i=0;i<A.size();i++){
            for(int j=i+1;j<=A.size();j++){
                if(j==A.size()){
                    result.add(-1);
                    break;
                }
                else if(A.get(j)>A.get(i)){
                    result.add(A.get(j));
                    break;
                }
            }
        }
        
        return result;
    }
}
