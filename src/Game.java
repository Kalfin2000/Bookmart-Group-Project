
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Strongestislander
 */
import java.util.Scanner; // allows class to use scanner method
public class Game //Book class
{
   private int GameID;
   private String GameName;
   private int GameQuantity;
   private String GameCategory;
   private String GameReleaseDate;
   private String GamePublisher;
   
   Game(int gid, String gn, int gq, String gc, String grd, String gp)
   { 
       /*constructor for book which passes in variables from main
       and calls set functions within the constructor to assign them
       to their corresponding variables*/
       setGameID(gid);
       setGameName(gn);
       setGameQuantity(gq);
       setGameCategory(gc);
       setGameReleaseDate(grd);
       setGamePublisher(gp);
       
   }
   /*set methods which pass in the variables from main
   and assignes them to the private member variables
   of the class*/
   /*get methods will return the private 
   variables of this class but the 
   method must be called upon in order
   to output the variable onto the screen*/
   public void setGameID(int gid)
   {
       this.GameID = gid;
   }
   public int getGameID()
   {
       return GameID;
   }
   public void setGameName(String gn)
   {
       this.GameName = gn;
   }
   public String getGameName()
   {
       return GameName;
   }
   public void setGameQuantity(int gq)
   {
       this.GameQuantity = gq;
   }
   public int getGameQuantity()
   {
       return GameQuantity;
   }
   public void setGameCategory(String gc)
   {
       this.GameCategory = gc;
   }
   public String getGameCategory()
   {
       return GameCategory;
   }
   public void setGameReleaseDate(String grd)
   {
       this.GameReleaseDate = grd;
   }
   public String getGameReleaseDate()
   {
       return GameReleaseDate;
   }
   public void setGamePublisher(String gp)
   {
       this.GamePublisher = gp;
   }
   public String getGamePublisher()
   {
       return GamePublisher;
   }
   
   public void gameInfo()
   {
       /*this method outputs the book information to the screen*/
       System.out.printf("%-10s %-30s %-10s %-20s %-15s %-30s\n", GameID , GameName, GameQuantity, GameCategory, GameReleaseDate, GamePublisher);
   }
   
   public void searchGameName(Game[] game, int gameTotal)
   {
       /*this method searches the database for a game*/
        Scanner input = new Scanner (System.in);
        boolean found = false;
        int pos = 0;
        int choice;

        System.out.println("What is the name of the game are you looking for");
        String gameNameSearch = input.next();

        System.out.printf("Now searching for %s" , gameNameSearch);
        do
        {
            /*user inputs the title of a book they are looking for
            and a for loop traverses the array of book in the database
            comparing the title that the user inputted with
            the title of the book stored in the program*/
        for(int i=0; i<gameTotal; i++)
        {
           if (gameNameSearch.equals(game[i].getGameName())) //compares the title the user inputted with that in the program
           {
               found = true;
               pos = i;
               break;
           }
         }   
           if(found == false)
           {
               /*error message if user attempts to input a book that doesnt exist*/
               System.out.println("Sorry that book does not exist");
           }
           if(found == true)
           {
               /*if book that is being searched for is found in the 
               database of the program
               the book information is outputted to the screen*/
               System.out.println("Here is your book info!!" +
                       "Book Name: " +game[pos].getGameName() +
                       "Book ID" + game[pos].getGameID() +
                       "Book Release Date : " + game[pos].getGameReleaseDate());
           }
           System.out.println("Would you like to search for another book? yes = 1 no = 2");
           choice = input.nextInt();
           /*whis is a do while loop which will continue to loop as long as 
           the user continues to search for another game.  the only way
           to break out of the loop is to choose no which will return
           the user to the previous screen*/
       } while(choice ==1 );
       
   }
   
   public void SearchGameCategory(int gid, Game[] game, int gameTotal)
   {
       /*this method will take input of a category from the user and compare it to the array
       of categories that are stored in the program*/
       Scanner input = new Scanner(System.in);
       boolean found = false;
       int pos = 0;
       int choice;
       
       System.out.println("What is the Category you are looking for?");
       String gameSearchCategory = input.next();
       
       do{
       for(int i=0; i<gameTotal; i++)
       {
           /*this for loop traverses the array and searches for the
           category that the user inputted and compares it with
           the one stored in the program*/
           if(gameSearchCategory.equals(game[i].getGameCategory()))
           {
               found = true;
               pos = i;
               break;
           }
       }
       if(found == false)
       {
           /*error message that outputs to the screen if the
           user attempts to search for an unexistant category*/
           System.out.println("That category does not exist");
       }
       if(found == true)
       {
           /*if the category does match a category in the database
           the info is displayed to the screen*/
                       System.out.println("Here is your book info!!");
                       for(int x=0; x<gameTotal; x++)
                       {
                           /*for loop that outputs all the games in the category along
                           with their information*/
                           System.out.println("Category: " + game[pos].getGameCategory() +
                                              "\nName: " + game[pos].getGameName() + 
                                              "\nPublisher: " + game[pos].getGamePublisher() +
                                              "Release Date: " + game[pos].getGameReleaseDate());
                       }
       }
       System.out.println("would you like to search another category? yes = 1 no = 2");
       choice = input.nextInt();
       }while(choice == 1); 
       /*do while loop which will continue to loop until the
       user decides not to search for another category*/
   }
    
   //*********Under Construction ************
    public void searchReleaseDate(int gid, Game[] game, int gameTotal)
    {
        Scanner input = new Scanner(System.in);
        boolean found = false;
        int pos = 0;
        int choice;

        System.out.println("What year are you searching for ");
        String searchDate = input.next();

        for (int i = 0; i < gameTotal; i++)
        {
           // Integer.parseInt(searchDate)

          // if(Ineger.parseInt(searchDate) == Integer.parseInt(game[i].gameGetGameReleaseDate())
            {
                   found = true;
                   pos = i;
                   break;
            }
        }
         System.out.println("Here are the book available during this date ");
         for(int x = 0; x<gameTotal; x++)
            {
                System.out.println("Name: "+ game[pos].getGameName() +
                                   "Category: " + game[pos].getGameCategory() +
                                   "Quantity: " + game[pos].getGameQuantity() +
                                    "Release Date: " + game[pos].getGameReleaseDate() +
                                    "Publisher: " + game[pos].getGamePublisher());
            }
    }
   

}


