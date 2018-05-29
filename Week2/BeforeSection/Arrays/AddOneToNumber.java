/*
 Add One To Number
 Given a non-negative number represented as an array of digits,
 
 add 1 to the number ( increment the number represented by the digits ).
 
 The digits are stored such that the most significant digit is at the head of the list.
 
 Example:
 
 If the vector has [1, 2, 3]
 
 the returned vector should be [1, 2, 4]
 
 as 123 + 1 = 124.
 
 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
 For example, for this problem, following are some good questions to ask :
 Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 A : For the purpose of this question, YES
 Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */

public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        
        Collections.reverse(A);
        int carry = 0;
        
        for(int i=0;i<A.size() ;i++){
            int digit = A.get(i);
            digit = digit+carry;
            
            if(i==0){
                digit++;
            }
            
            if(digit/10>=1){
                carry = digit/10;
                digit = digit%10;
            }else{
                carry=0;
            }
            
            A.set(i,digit);
        }
        
        if(carry>0){
            A.add(carry);
        }
        
        Collections.reverse(A);
        
        int endOfZeros = -1;
        
        for(Integer item:A){
            if(item==0){
                endOfZeros++;
            }else{
                break;
            }
        }
        
        for(int i=endOfZeros;i>=0;i--){
            A.remove(i);
        }
        
        return A;
        
    }
}
