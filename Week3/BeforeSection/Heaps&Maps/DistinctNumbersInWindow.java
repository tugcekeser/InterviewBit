/*
 Distinct Numbers in Window
 You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.
 
 Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.
 
 Note:
 
 If K > N, return empty array.
 For example,
 
 A=[1, 2, 1, 3, 4, 3] and K = 3
 
 All windows of size K are
 
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 
 So, we return an array [2, 3, 3, 2].
 */

public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        
        ArrayList<Integer> result  = new ArrayList<Integer>();
        for(int i=0;i<=A.size()-B;i++){
            HashSet<Integer> hs = new HashSet<Integer>();
            
            for(int j=i;j<i+B;j++){
                if(!hs.contains(A.get(j))){
                    hs.add(A.get(j));
                }
            }
            result.add(hs.size());
        }
        
        return result;
    }
}
