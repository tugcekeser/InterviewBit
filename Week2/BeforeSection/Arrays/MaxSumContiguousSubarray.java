/*
 Max Sum Contiguous Subarray
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 
 For example:
 
 Given the array [-2,1,-3,4,-1,2,1,-5,4],
 
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 
 For this problem, return the maximum sum.
 */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        
        int max=A.get(0);
        int num = A.get(0);
        
        for(int i = 0;i<A.size();i++){
            
            if(i!=0){
                num = A.get(i);
                if(num>max){
                    max = num;
                }
            }
            for(int j=i+1;j<A.size();j++){
                num = num+A.get(j);
                if(num>max){
                    max = num;
                }
            }
        }
        
        return max;
    }
}
