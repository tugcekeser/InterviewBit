/*
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 
 Example :
 [1,1,2] have the following unique permutations:
 
 [1,1,2]
 [1,2,1]
 [2,1,1]
 NOTE : No 2 entries in the permutation sequence should be the same.
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashSet<String> set = new HashSet<String>();
        ArrayList<Integer> subList = new ArrayList<Integer>();
        return getPermutations(result,set,A,subList);
    }
    
    private ArrayList<ArrayList<Integer>> getPermutations( ArrayList<ArrayList<Integer>> result,
                                                          HashSet<String> set,ArrayList<Integer> input, ArrayList<Integer> subList){
        
        if(input.size()==0){
            ArrayList<Integer> newSubList = getCopyOfList(subList);
            String strList = arrayToList(newSubList);
            if(set.contains(strList)){ //Check the value is unique from hashset
                return result;
            }
            else{
                set.add(strList); //If it is unique, add to hashset to check other values' uniqueness
                result.add(newSubList);
                return result;
            }
        }
        
        for(int i=0;i<input.size();i++){
            subList.add(input.get(i));
            ArrayList<Integer> inputNew = getCopyOfList(input);
            inputNew.remove(i);
            getPermutations(result, set,inputNew,subList);
            subList.remove(input.get(i));
        }
        
        return result;
    }
    
    private ArrayList<Integer> getCopyOfList(ArrayList<Integer> list){
        ArrayList<Integer> copyList = new ArrayList<Integer>();
        for(Integer value:list ){
            copyList.add(value);
        }
        return copyList;
    }
    
    private String arrayToList(ArrayList<Integer> list){
        String strList="";
        for(Integer value:list){
            strList = strList+value;
        }
        return strList;
    }
}
