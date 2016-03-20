
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
/*admin class which is a child of the user class*/
public class Admin extends User {

    //private String [] inbox = new String [100];
    //private int inboxCount = 0;
    
    /*constructor which passes in the variables from main*/
    public Admin(String buff, String pw, int uid) {
        super(buff, pw, uid); // passes in the variables from the super class
    }
    
    /*public void inbox(Member member)
    {
        inbox[inboxCount] = member.sentRequest();
        inboxCount++;
    }*/
    /*this method outputs the member list onto the screen by using a for loop */
    public void seeMemberList(Member[] member, int memberMax)
    {
        System.out.println("*** Member Database   ***");
        System.out.printf("%-20s %-15s %-15s %-20s %-20s %-10s %-30s\n", "Member ID", "Member UID", "Member Type", "First Name", "LastName", "MI", "Email");
        for (int i = 0; i<memberMax; i++)
        {
            member[i].memberListing(); // outputs array of members 
        }
    }
    /*this method outputs the member info to the screen by outputting the name*/
    public void seeMemberInfoByName (String name, Member[] member, int memberMax)
    {
        int count =0;
        
        System.out.println("* Start searching for name \"" + name + "\" in the database ...");
        for (int i = 0; i<memberMax; i++) // for loop to traverse the array of members
        {
            if (name.equals(member[i].getFirstName()) || name.equals(member[i].getLastName()))
            {
                /*if membername is equal to the first name or equal to the last name
                program will output set of variables that fit this criteria*/
                member[i].displayInfo();
                count++; // increases count 
                
            }
        }
        System.out.println("* There are " + count + " match(s) in the member database.");
        /*outputs the total number of matches in the database*/
    }
    /*method will output members info to the screen based on 
    the USER ID*/
    public void seeMemberInfoByUID(int uid, Member[] member, int memberMax)
    {
        int count =0;
        System.out.println("* Start searching for UserID #" + uid + " in the database ...");
        for (int i = 0; i<memberMax; i++)
        {
            /*for loop will traverse through an array of members and 
            will compare the user id searched for with the user ids in the program*/
            if (member[i].getUserID() == uid)
            {
                member[i].displayInfo();
                count++; //increases count
            }
        }
        System.out.println("* There are " + count + " match(s) in the member database.");
        /*outputs the number of matches to the screen*/
    }
    /*this method outputs the member into to the screen*/
    public void seeMemberInfoByType (subType type, Member[] member, int memberMax)
    {
        int count =0;
        System.out.println("* Start searching for " + type.toString() + " type in the database ...");
        for (int i = 0; i<memberMax; i++)
        {
            /*for loop which cycles through the array comparing the variable to the one in the database*/
            if (member[i].getSubcriptionType() == type)
            {
                member[i].displayInfo();
                count++; //increases count
            }
        }
        System.out.println("* There are " + count + " match(s) in the member database.");
    //displays the total number of matches in the database
    }
    /*this method outputs a list of members onto the screen*/
    public void seeMemberHist(Member[] member, int memberMax)
    {
        Scanner input = new Scanner(System.in);
        System.out.printf("***   Member Rental History   ***\n"
                        + "Please insert User ID for History checking: ");
        int uid = input.nextInt();
        for (int i = 0; i<memberMax; i++)
        {
            /*this for loop traverses the array and compres
            the userid with the id inputted*/
            if (member[i].getUserID() == uid)
            {
                member[i].seeGameRentDetail(); //displays the book rent detail of that member
            }
        }
    }
    /*this method updats the book availabilitiy by passing in the book object and the 
    total number of Books*/
    public void updateGameAvailability(Game[] game, int gameMax)
    {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        int choice;
        /*this is a do while loop which will continue until
        the user chooses the option to exit the loop*/
        do 
        {
            int pos = 0;
            boolean found = false;
            System.out.println("-----------------------------------------------------------------------------------------------------------"); 
            System.out.printf("***   Update Book Quantity   ***\n"
                    + "Please insert Book ID you want to update: ");
            int gid = input.nextInt();
            /*for loop which searches through the Book id in the database by comparing */
            for (int i = 0; i < gameMax; i++)
            {
                if (gid == game[i].getGameID())
                {
                    pos = i;
                    found = true;   
                }
            }
            
            if (found)
            {
                /*if it is found, the user can update the number of available books  as well as display the
                books in the database*/
                System.out.println("-----------------------------------------------------------------------------------------------------------"); 
                System.out.printf("%-10s %-30s %-10s %-20s %-15s %-30s\n", "BookID" , "Name", "Quantity", "Category", "Release Date", "Publisher");
                game[pos].gameInfo();
                System.out.printf("Please enter the number of available copies for \""+ game[pos].getGameName() + "\": ");
                int num = input2.nextInt();
                game[pos].setGameQuantity(num);
                System.out.println("Update Successfully! ");
                System.out.println("-----------------------------------------------------------------------------------------------------------"); 
                System.out.printf("%-10s %-30s %-10s %-20s %-15s %-30s\n", "BookID" , "Name", "Quantity", "Category", "Release Date", "Publisher");
                game[pos].gameInfo();
                
            }
            else
            {
                System.out.println("Warning: Invalid Book ID!"); //error message for invalid book
            }
            
            System.out.printf("Do you want to update another BOok? Yes = 1 No = 2\n"
                    + "Your choice: ");
            choice = input1.nextInt();
        } while (choice == 1); //do while loop will continue as long as user continues to update books
                               //otherwise the loop will cancel
    }
}
