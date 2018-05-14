/*
 Given an array of non negative integers A, and a range (B, C),
 find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C
 
 Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
 where 0 <= i <= j < size(A)
 
 Example :
 
 A : [10, 5, 1, 0, 2]
 (B, C) : (6, 8)
 ans = 3
 as [5, 1], [5, 1, 0], [5, 1, 0, 2] are the only 3 continuous subsequence with their sum in the range [6, 8]
 
 NOTE : The answer is guranteed to fit in a 32 bit signed integer.
 NOTE: You only need to implement the given function. Do not read input, instead use the arguments to the function. Do not print the output, instead return values as specified. Still have a doubt? Checkout Sample Codes for more details. 
 */


public class Solution {
    public int numRange(ArrayList<Integer> A, int B, int C) {
        
        int sum=0,result=0;
        
        for(int i=0;i<A.size();i++){
            sum=0;
            
            for(int j=i;j<A.size();j++){
                
                if(A.get(j)<=C){
                    sum = sum+A.get(j);
                    
                    if(sum<=C && sum>=B){
                        result++;
                    }
                    else if(sum>C){
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
        
        return result;
    }
}
