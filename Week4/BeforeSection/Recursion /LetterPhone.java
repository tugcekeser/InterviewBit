/*Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.
 */
public class Solution {
    
    private ArrayList<String> digit0 = new ArrayList<>(Arrays.asList("0"));
    private ArrayList<String> digit1= new ArrayList<>(Arrays.asList("1"));
    private ArrayList<String> digit2= new ArrayList<>(Arrays.asList("a","b","c"));
    private ArrayList<String> digit3= new ArrayList<>(Arrays.asList("d","e","f"));
    private ArrayList<String> digit4= new ArrayList<>(Arrays.asList("g","h","i"));
    private ArrayList<String> digit5= new ArrayList<>(Arrays.asList("j","k","l"));
    private ArrayList<String> digit6 = new ArrayList<>(Arrays.asList("m","n","o"));
    private ArrayList<String> digit7= new ArrayList<>(Arrays.asList("p","q","r","s"));
    private ArrayList<String> digit8= new ArrayList<>(Arrays.asList("t","u","v"));
    private ArrayList<String> digit9= new ArrayList<>(Arrays.asList("w","x","y","z"));
    
    private ArrayList<ArrayList<String>> digitList = new ArrayList<ArrayList<String>> ();
    
    public ArrayList<String> letterCombinations(String A) {
        
        digitList.add(digit0);
        digitList.add(digit1);
        digitList.add(digit2);
        digitList.add(digit3);
        digitList.add(digit4);
        digitList.add(digit5);
        digitList.add(digit6);
        digitList.add(digit7);
        digitList.add(digit8);
        digitList.add(digit9);
        
        ArrayList<String> input = convertStringToArray(A);
        ArrayList<String> output = new ArrayList<String>();
        getPossibleCombinations(input,output, new ArrayList<String>(), 0);
        return output;
    }
    
    private ArrayList<String> convertStringToArray(String A){
        ArrayList<String> input = new ArrayList<String>();
        
        for(int i=0;i<A.length();i++){
            input.add(Character.toString(A.charAt(i)));
        }
        
        return input;
    }
    
    private void getPossibleCombinations(ArrayList<String> input, ArrayList<String> output,
                                         ArrayList<String> curr, int begin){
        
        if(curr.size() == input.size()){
            output.add(arrayToString(curr));
            return;
        }
        
        ArrayList<String> letterList = digitList.get(Integer.parseInt(input.get(begin)));
        for(int j=0;j<letterList.size();j++){
            curr.add(letterList.get(j));
            int newBegin = begin+1;
            getPossibleCombinations(input,output,curr,newBegin);
            curr.remove(curr.size()-1);
        }
    }
    
    private String arrayToString(ArrayList<String> input){
        String result = "";
        
        for(int i=0;i<input.size();i++){
            result = result+input.get(i);
        }
        return result;
    }
}
