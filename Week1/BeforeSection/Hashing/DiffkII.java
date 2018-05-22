/*
 Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 
 Example :
 
 Input :
 
 A : [1 5 3]
 k : 2
 Output :
 
 1
 as 3 - 1 = 2
 
 Return 0 / 1 for this problem.
 */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> A, int B) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<A.size();i++){
            if(hm.containsKey(A.get(i)-B) || hm.containsKey(A.get(i)+B)){
                return 1;
            }else{
                hm.put(A.get(i),i);
            }
        }
        
        return 0;
    }
}
