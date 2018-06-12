/*
 Subset
 Given a set of distinct integers, S, return all possible subsets.
 
 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 Also, the subsets should be sorted in ascending ( lexicographic ) order.
 The list is not necessarily sorted.
 Example :
 
 If S = [1,2,3], a solution is:
 
 [
 [],
 [1],
 [1, 2],
 [1, 2, 3],
 [1, 3],
 [2],
 [2, 3],
 [3],
 ]
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) { // 12,13
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);
        getSubsets(A,result,new ArrayList<Integer>(),0);
        return result;
    }
    
    private void getSubsets(ArrayList<Integer> A,
                            ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currList, int begin){
        
        result.add(new ArrayList(currList));
        
        for(int i=begin;i<A.size();i++){
            currList.add(A.get(i));
            begin = begin+1;
            getSubsets(A,result,currList,begin);
            currList.remove(currList.size()-1);
        }
    }
}
