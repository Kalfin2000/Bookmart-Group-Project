
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
public class Book //Book class
{
   private int BookID;
   private String BookName;
   private int BookQuantity;
   private String BookCategory;
   private String BookReleaseDate;
   private String BookPublisher;
   
   Book(int bid, String bn, int bq, String bc, String brd, String bp)
   { 
       /*constructor for book which passes in variables from main
       and calls set functions within the constructor to assign them
       to their corresponding variables*/
       setBookID(bid);
       setBookName(bn);
       setBookQuantity(bq);
       setBookCategory(bc);
       setBookReleaseDate(brd);
       setBookPublisher(bp);
       
   }
   /*set methods which pass in the variables from main
   and assignes them to the private member variables
   of the class*/
   /*get methods will return the private 
   variables of this class but the 
   method must be called upon in order
   to output the variable onto the screen*/
   public void setBookID(int bid)
   {
       this.BookID = bid;
   }
   public int getBookID()
   {
       return BookID;
   }
   public void setBookName(String bn)
   {
       this.BookName = bn;
   }
   public String getBookName()
   {
       return BookName;
   }
   public void setBookQuantity(int bq)
   {
       this.BookQuantity = bq;
   }
   public int getBookQuantity()
   {
       return BookQuantity;
   }
   public void setBookCategory(String bc)
   {
       this.BookCategory = bc;
   }
   public String getBookCategory()
   {
       return BookCategory;
   }
   public void setBookReleaseDate(String brd)
   {
       this.BookReleaseDate = brd;
   }
   public String getBookReleaseDate()
   {
       return BookReleaseDate;
   }
   public void setBookPublisher(String bp)
   {
       this.BookPublisher = bp;
   }
   public String getBookPublisher()
   {
       return BookPublisher;
   }
   
   public void bookInfo()
   {
       /*this method outputs the book information to the screen*/
       System.out.printf("%-10s %-30s %-10s %-20s %-15s %-30s\n", BookID , BookName, BookQuantity, BookCategory, BookReleaseDate, BookPublisher);
   }
   
   public void searchBookName(Book[] book, int bookTotal)
   {
       /*this method searches the database for a book*/
        Scanner input = new Scanner (System.in);
        boolean found = false;
        int pos = 0;
        int choice;

        System.out.println("What is the name of the book are you looking for");
        String bookNameSearch = input.next();

        System.out.printf("Now searching for %s" , bookNameSearch);
        do
        {
            /*user inputs the title of a book they are looking for
            and a for loop traverses the array of book in the database
            comparing the title that the user inputted with
            the title of the book stored in the program*/
        for(int i=0; i<bookTotal; i++)
        {
           if (bookNameSearch.equals(book[i].getBookName())) //compares the title the user inputted with that in the program
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
                       "Book Name: " +book[pos].getBookName() +
                       "Book ID" + book[pos].getBookID() +
                       "Book Release Date : " + book[pos].getBookReleaseDate());
           }
           System.out.println("Would you like to search for another book? yes = 1 no = 2");
           choice = input.nextInt();
           /*whis is a do while loop which will continue to loop as long as 
           the user continues to search for another book.  the only way
           to break out of the loop is to choose no which will return
           the user to the previous screen*/
       } while(choice ==1 );
       
   }
   
   public void SearchBookCategory(int gid, Book[] book, int bookTotal)
   {
       /*this method will take input of a category from the user and compare it to the array
       of categories that are stored in the program*/
       Scanner input = new Scanner(System.in);
       boolean found = false;
       int pos = 0;
       int choice;
       
       System.out.println("What is the Category you are looking for?");
       String bookSearchCategory = input.next();
       
       do{
       for(int i=0; i<bookTotal; i++)
       {
           /*this for loop traverses the array and searches for the
           category that the user inputted and compares it with
           the one stored in the program*/
           if(bookSearchCategory.equals(book[i].getBookCategory()))
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
                       for(int x=0; x<bookTotal; x++)
                       {
                           /*for loop that outputs all the books in the category along
                           with their information*/
                           System.out.println("Category: " + book[pos].getBookCategory() +
                                              "\nName: " + book[pos].getBookName() + 
                                              "\nPublisher: " + book[pos].getBookPublisher() +
                                              "Release Date: " + book[pos].getBookReleaseDate());
                       }
       }
       System.out.println("would you like to search another category? yes = 1 no = 2");
       choice = input.nextInt();
       }while(choice == 1); 
       /*do while loop which will continue to loop until the
       user decides not to search for another category*/
   }
    
   //*********Under Construction ************
    public void searchReleaseDate(int gid, Book[] book, int bookTotal)
    {
        Scanner input = new Scanner(System.in);
        boolean found = false;
        int pos = 0;
        int choice;

        System.out.println("What year are you searching for ");
        String searchDate = input.next();

        for (int i = 0; i < bookTotal; i++)
        {
           // Integer.parseInt(searchDate)

          // if(Ineger.parseInt(searchDate) == Integer.parseInt(book[i].bookGetBookReleaseDate())
            {
                   found = true;
                   pos = i;
                   break;
            }
        }
         System.out.println("Here are the book available during this date ");
         for(int x = 0; x<bookTotal; x++)
            {
                System.out.println("Name: "+ book[pos].getBookName() +
                                   "Category: " + book[pos].getBookCategory() +
                                   "Quantity: " + book[pos].getBookQuantity() +
                                    "Release Date: " + book[pos].getBookReleaseDate() +
                                    "Publisher: " + book[pos].getBookPublisher());
            }
    }
   

}


