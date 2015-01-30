import java.util.Scanner;
public class TicTacToe
{
  private static char[][] board = new char [3][3];
  
  private static char turn;// X always goes first.
  private static String imput;
  private static int turnRow;
  private static int turnCol;
  private static int entryCount;// can't be higher than 9
  private static boolean winner;
  private static boolean reEnter;
  public static void main (String [] args)
  {
    Scanner keyboard = new Scanner(System.in);
    do
    {
      winner = false;
      entryCount = 0;
      System.out.println("Let's play a game of tic-tac-toe!\n\n");
      System.out.println("To place an entry on the board," +
      " enter the row and column number on the line " +
      "separated by a space.");
      for (int i = 0; i < 3; i++) //initialize the board as blanks
        {
          for(int j = 0; j < 3; j++)
          {
            TicTacToe.board[i][j] = ' ';
          }
        }
      TicTacToe.writeBoard();
      do
      {
        TicTacToe.setTurn();
        System.out.println(turn + "'s turn. Where would you like to place " + "an " + turn + "?");
        reEnter = true;
        while(reEnter)// see userImput()
        {
          String i = keyboard.nextLine().trim();
          String t = i.substring(0 , 1);// first int entered
          String s = i.substring(i.indexOf(" ") + 1).trim();//second int entered
          int x = Character.getNumericValue(t.charAt(0)) - 1;// need to substract one to
          int y = Character.getNumericValue(s.charAt(0)) - 1;//account for the 0 index
          TicTacToe.userImput(x ,y);
        }
        TicTacToe.writeBoard();
        TicTacToe.winner();
      }while((!winner) && (entryCount != 9));
      if (!winner)
      {
        System.out.println("Cat's game!");
      }
      System.out.println("Would you like to play again? Yes/No?");
      imput = keyboard.nextLine();
      
    }while (imput.equalsIgnoreCase("yes"));
  }
  public static void writeBoard()
  {
    System.out.println("-----------------");

    System.out.println("|R\\C| 1 | 2 | 3 |");

    System.out.println("-----------------");


    for(int i =0; i < 3; i++)
    {
      System.out.print("   " + (i + 1) + "| ");
      for(int j = 0; j < 3; j++)
      {

        System.out.print(board[i][j] + " | ");
      }
      System.out.println();
      System.out.println("-----------------");
    }
  }
  public static void userImput(int row , int col)
  {
      if (((row < 3 & col < 3) && ((row >= 0) && (col >= 0)) && (board[row][col] == ' ')))// makes sure the entry is valid
      {
       board[row][col] = turn;
       reEnter = false;
      }
      else if (row < 3 && col < 3)
      {
        System.out.println("The space you entered is already taken! Try again!");
      }
      else
      {
        System.out.println("Whoops. One or both of the numbers entered are outside the grid. Try again!");
      }
  }
  public static void setTurn()
  {
    if (entryCount % 2 == 0)
    {
      turn = 'X';
    }
    else
    {
      turn = 'O';
    }
    entryCount++;
  }
 
  public static void vMessage()
  {
    System.out.println("Yay! " + turn + " won!");
  }
 
  public static boolean winner()
  {
    int sum = 0;
    for (int i = 0; i < board.length; i++)//checks for a horizontal win
    {
      
      sum = 0;
      for( int j = 0; j < board[i].length; j++)
      {
        if (board[i][j] == turn)
        {
          sum++;
        }
      }
      if(sum == 3)
        {
          vMessage();
          winner = true;
          break;
        }
    }
    sum = 0;
    for (int i = 0; i < board.length; i++)//checks for a left-to-right diagonal win
    {
      
      if(board[i][i] == turn)
      {
        sum++;
      }
    }
    if(sum == 3)
      {
        vMessage();
        winner = true;
    
      }
    sum = 0;
    for (int i = 0; i < board.length; i++)//checks for a vertical win
    {
      sum = 0;
      for (int j = 0; j< board[i].length; j++)
      {
        if (board[j][i] == turn)
        {
          sum++;
        }
      }
      if(sum == 3)
        {
          vMessage();
          winner = true;
          break;
        }
    }
    sum = 0;
    int i , j;
    for(i = 2 , j = 0; i > -1; i--, j++)//checks for a right-to-left diagonal win
    {
      if(board[i][j] == turn)
      {
        sum++;
      }
    }
    if(sum == 3)
      {
        vMessage();
        winner = true;
      }
    
    return winner;
  }
  
}

