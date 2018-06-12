/*
 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 
 The same repeated number may be chosen from C unlimited number of times.
 
 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The combinations themselves must be sorted in ascending order.
 CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
 The solution set must not contain duplicate combinations.
 Example,
 Given candidate set 2,3,6,7 and target 7,
 A solution set is:
 
 [2, 2, 3]
 [7]
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);
        getCombinations(A,result,new ArrayList<Integer>(),B,0);
        return result;
    }
    
    private void getCombinations(ArrayList<Integer> input,
                                 ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currList,
                                 int target, int begin)
    {
        
        if(target == 0){
            result.add(new ArrayList(currList));
            return;
        }else if(target<0){
            return;
        }
        
        for(int i=begin;i<input.size();i++){
            if(i > begin && input.get(i) == input.get(i-1)) continue;
            currList.add(input.get(i));
            getCombinations(input,result, currList,target-input.get(i),i);
            currList.remove(currList.size()-1);
        }
        return;
    }
}
