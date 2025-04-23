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