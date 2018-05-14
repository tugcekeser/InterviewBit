/*
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 
 Example:
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 
 Your algorithm should run in O(n) complexity.
 */

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestConsecutive(final List<Integer> A) {
        int longestCon = 0;
        HashMap<Integer, Integer> hm =new HashMap<Integer,Integer>();
        for(Integer value : A){
            int subLongestCon=1;
            int temp=value-1;
            while(hm.containsKey(temp)){
                subLongestCon++;;
                temp--;
            }
            
            temp = value+1;
            while(hm.containsKey(temp)){
                subLongestCon++;
                temp++;
            }
            
            if(subLongestCon>longestCon){
                longestCon = subLongestCon;
            }
            
            hm.put(value,1);
        }
        return longestCon;
    }
}
