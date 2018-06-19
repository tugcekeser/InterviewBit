/*
 How many minimum numbers from fibonacci series are required such that sum of numbers should be equal to a given Number N?
 Note : repetition of number is allowed.
 
 Example:
 
 N = 4
 Fibonacci numbers : 1 1 2 3 5 .... so on
 here 2 + 2 = 4
 so minimum numbers will be 2
 */

public class Solution {
    
    public int fibsum(int A) {
        return getMax(A);
    }
    
    private int getMax(int A){
        if(A==0) return 0;
        int max = findAllFibonaciNumbers(A);
        int curr = A-max;
        return getMax(curr)+1;
        
    }
    
    private int findAllFibonaciNumbers(int A){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(1);
        int curr=0;
        int index = 1;
        
        while(curr<A){
            curr = numbers.get(index)+numbers.get(index-1);
            if(curr>A) break;
            index++;
            numbers.add(curr);
        }
        
        return numbers.get(numbers.size()-1);
    }
    
}
