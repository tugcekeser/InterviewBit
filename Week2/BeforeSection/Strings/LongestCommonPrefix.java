/*Longest Common Prefix
 Write a function to find the longest common prefix string amongst an array of strings.
 
 Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
 
 As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 
 Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.
 
 Example:
 
 Given the array as:
 
 [
 
 "abcdefgh",
 
 "aefghijk",
 
 "abcefgh"
 ]
 The answer would be “a”.
 */

public class Solution {
    public String longestCommonPrefix(ArrayList<String> A) {
        
        String prefix  = A.get(0);
        
        for(int i = 1;i<A.size();i++){
            
            for(int j =0;j<prefix.length();j++){
                if(prefix.charAt(j)!=A.get(i).charAt(j)){
                    prefix = prefix.substring(0,j);
                }
            }
        }
        
        return prefix;
    }
}
