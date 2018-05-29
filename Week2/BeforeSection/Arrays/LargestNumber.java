/*
 Largest Number
 Given a list of non negative integers, arrange them such that they form the largest number.
 
 For example:
 
 Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 
 Note: The result may be very large, so you need to return a string instead of an integer.
 */

public class Solution {
    
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {  //[3, 30, 34, 5, 9]
        // 9
        // 5
        // 3, 30, 34
        
        String result = "";
        
        for(int i = 9;i>=0;i--){
            ArrayList<String> subList = new ArrayList<String>();
            //Grouping the numbers -  can be improved - This is my brute force solution
            for(int j = 0;j<A.size();j++){
                
                String valueStr = Integer.toString(A.get(j));
                if(valueStr.substring(0,1).equals(""+i)){
                    subList.add(valueStr);
                }
                
            }
            Collections.sort(subList, new LargerNumberComparator());
            if(subList.size()>0 && subList.get(0).equals("0") && result.isEmpty()){
                return result = "0";
            }
            
            for(int j = 0;j<subList.size();j++){
                result = result+subList.get(j);
            }
            
        }
        
        return result;
    }
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }
}
