/*
 Given a 2D board and a word, find if the word exists in the grid.
 
 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The cell itself does not count as an adjacent cell.
 The same letter cell may be used more than once.
 
 Example :
 
 Given board =
 
 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns 1,
 word = "SEE", -> returns 1,
 word = "ABCB", -> returns 1,
 word = "ABFSAB" -> returns 1
 word = "ABCD" -> returns 0
 Note that 1 corresponds to true, and 0 corresponds to false.
 */

public class Solution {
    
    public int exist(ArrayList<String> A, String B) {
        ArrayList<ArrayList<Character>> board = new ArrayList<ArrayList<Character>>();
        
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Character> arr = stringToArray(A.get(i));
            board.add(arr);
        }
        
        boolean isValid = false;
        int[][] visited = new int[board.size()][board.get(0).size()];
        
        for (int i = 0; i < board.size(); i++) {
            
            for (int j = 0; j < board.get(0).size(); j++) {
                if(search(board, i, j, B, 0, visited)) return 1;
            }
        }
        
        return 0;
    }
    
    private boolean search(ArrayList<ArrayList<Character>> board, int currRow, int currCol,
                           String B, int currIndex, int[][] visited) {
        
        if (currIndex == B.length()) {
            return true;
        }
        
        if (currRow == board.size() || currCol == board.get(0).size() || currRow < 0 ||
            currCol < 0 || visited[currRow][currCol] == 1 || board.get(currRow).get(currCol) != B.charAt(currIndex)) {
            return false;
        }
        
        currIndex++;
        visited[currRow][currCol] = 1;
        
        boolean result= search(board, currRow + 1, currCol, B, currIndex, visited) ||
        search(board, currRow, currCol + 1, B, currIndex, visited) ||
        search(board, currRow - 1, currCol, B, currIndex, visited) ||
        search(board, currRow, currCol - 1, B, currIndex, visited);
        visited[currRow][currCol] = 0;
        return result;
    }
    
    private ArrayList<Character> stringToArray(String str) {
        ArrayList<Character> chars = new ArrayList<Character>();
        for (char c : str.toCharArray()) {
            chars.add(c);
        }
        
        return chars;
    }
}
