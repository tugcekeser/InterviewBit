/*Length of Last Word
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",

return 5 as length("World") = 5.

Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
 
 */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        int begin=0;
        int end = 0;
        boolean isContinue = false;
        
        if(A.trim().equals(""))
            return 0;
        
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)==' '){
                isContinue = false;
                continue;
            }
            if(!isContinue){
                begin = i;
            }
            end = i;
            isContinue = true;
        }
        
        
        return end - begin+1;
    }
}
