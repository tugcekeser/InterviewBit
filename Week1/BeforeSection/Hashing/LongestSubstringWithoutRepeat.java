/*
 Given a string,
 find the length of the longest substring without repeating characters.
 
 Example:
 
 The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 
 For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class Solution {
    public int lengthOfLongestSubstring(String A) {
        
        if(A.length()<2){
            return A.length();
        }
        
        HashSet<Character> hs = new HashSet<Character>();
        char [] array = A.toCharArray();
        int maxLenght = 0;
        int count = 0;
        
        for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){
                
                if(hs.contains(array[j])){
                    if(count>maxLenght){
                        maxLenght = count;
                    }
                    hs = new HashSet<Character>();
                    count = 0;
                    break;
                }else{
                    hs.add(array[j]);
                    count++;
                }
            }
        }
        return maxLenght;
    }
}
