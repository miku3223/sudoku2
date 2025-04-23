import java.io.*;
import java.util.*;

public class SudokuBoard {
   private char[][] board;
   
   public SudokuBoard(String fileName) throws FileNotFoundException {
      board = new char[9][9];
      String input = "";
      Scanner file = new Scanner(new File(fileName));
      for(int r = 0; r < board.length; r++) {
         input = file.nextLine();
         for(int c = 0; c < board[r].length; c++) {
            board[r][c] = input.charAt(c);
         }
      }
   }

   public boolean isValid(){
      return checkNums() && checkRows() && checkColums() && checkMiniSquare();

   }

   private boolean checkNums(){
      for (int r = 0; r < board.length; r++) {
         for (int c = 0; c < board[0].length; c++) {
            if(!((board[r][c] >= '1' && board[r][c] <= '9') || board[r][c] == ' ' || board[r][c] == '.')){
               return false;
            }
         }
      }
      return true;
   }

   private boolean checkRows(){
      for (int r = 0; r <board.length ; r++) {
         Set<Character> boardSet = new HashSet<>();

         for (int c = 0; c < board[0].length; c++) {
            if(board[r][c]!=' ' && board[r][c]!='.' && board[r][c]!='0'){
               char ch = board[r][c];
               if(!boardSet.add(ch)){
                  return false;
               }
            }

         }
      }
      return true;
   }

   private boolean checkColums(){
      for (int col = 0; col <board.length ; col++) {
         Set<Character> boardSet = new HashSet<>();
         for (int row = 0; row < board[0].length; row++) {
            if(board[row][col]!=' ' && board[row][col]!='.' && board[row][col]!='0'){
               char ch = board[row][col];
               if(!boardSet.add(ch)){
                  return false;
               }
            }

         }
      }
      return true;
   }

   private boolean checkMiniSquare(){
      for (int i = 1; i <= 9; i++) {
         char[][] mini = miniSquare(i);
         Set<Character> miniSet = new HashSet<>();
         for (int col = 0; col <mini.length ; col++) {
            for (int row = 0; row < mini[0].length; row++) {
               if(mini[row][col]!=' ' && mini[row][col]!='.' && mini[row][col]!='0'){
                  char ch = mini[row][col];
                  if(!miniSet.add(ch)){
                     return false;
                  }
               }
            }
         }

      }
      return true;
   }
   private char[][] miniSquare(int spot) {
      char[][] mini = new char[3][3];
      for(int r = 0; r < 3; r++) {
         for(int c = 0; c < 3; c++) {
            // whoa - wild! This took me a solid hour to figure out (at least)
            // This translates between the "spot" in the 9x9 Sudoku board
            // and a new mini square of 3x3
            mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
         }
      }
      return mini;
   }

   public String toString() {
      StringBuilder output = new StringBuilder("┏━━━┯━━━┯━━━┳━━━┯━━━┯━━━┳━━━┯━━━┯━━━┓\n");
      for(int r = 0; r < board.length; r++) {
         for (int c = 0; c < board[r].length; c++) {
            if(board[r][c] == '.') {
               if(c == 0 || c == 3 || c == 6) {    // Thickens lines on edges and between blocks of 9
                  output.append("┃   ");
               } else {
                  output.append("│   ");
               }
            } else {
               if(c == 0 || c == 3 || c == 6) {    // Thickens lines on edges and between blocks of 9
                  output.append("┃ " + board[r][c] + " ");
               } else {
                  output.append("│ " + board[r][c] + " ");
               }
            }
         }
         if(r == 2 || r == 5) {                    // Thickens lines between blocks of 9
            output.append("┃\n┣━━━┿━━━┿━━━╋━━━┿━━━┿━━━╋━━━┿━━━┿━━━┫\n");
         } else if (r == 8) {                      // Thickens bottom edge line
            output.append("┃\n┗━━━┷━━━┷━━━┻━━━┷━━━┷━━━┻━━━┷━━━┷━━━┛\n");
         } else {
            output.append("┃\n┠───┼───┼───╂───┼───┼───╂───┼───┼───┨\n");
         }
      }
   return output.toString();
   }

}