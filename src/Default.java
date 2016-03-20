
import java.io.File; 
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *@author Strongestislander
 */
public class Default 
{
    /*main class for the program*/
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException { //creates error message if no file found
        // TODO code application logic here
        Scanner input = new Scanner(System.in); //declares input variable to gather input from user
        int choice;
        String id,
               pw,
               pw1;
        
        
        int memberMax = 1,
            adminMax = 2,    
            pos = 1,
            gameNum = 0;
        
        
        Admin [] admin = new Admin[10]; //admin object declaration
        Member [] member = new Member[100]; // member object declaration
        Game [] game = new Game[100]; //game object declaration
      
        admin[0] = new Admin("admin", "123456", -1); //passes in values to admin object
        admin[1] = new Admin("Mark", "654321", -1); // passes in values to admin object
       
        //member[0] = new Member("test", "123", 0, subType.NONE); // passes in values to member object 
        member[0] = new Member("test", "123", 0, subType.GAMER, "christian ", "habihirwe", "h", "ahabihirwe@islander.tamucc.edu", "ach", "654321");   // passes in values to game object
        
        File file = new File("src/bookDb.txt"); // passes in database dummy file into program
        Scanner textfile = new Scanner(file); // creates new variable for dummy file
        if (file.exists())
        {
            
            /*here the program passes in the information of each book from the text file and assignes them to their
            corresponding values*/
            while (textfile.hasNextLine())
            {
              
                String str = textfile.nextLine();
                String [] token = str.split(", ");
                String gameID = token[0];
                String gameName = token[1];
                String gameQuantity = token[2];
                String gameCat = token[3];
                String gameReleaseDate = token[4];
                String gamePublisher = token[5];
                
                game[gameNum] = new Game(Integer.parseInt(gameID), gameName, Integer.parseInt(gameQuantity), gameCat, gameReleaseDate, gamePublisher);    
                gameNum++; 
            }
        }
        
        /*here the program passes in the information about the member from the text file
        and passes it in to the corresponding value*/
        File file2 = new File("src/memberDb.txt"); 
        Scanner memberFile = new Scanner(file2);
        if (file2.exists())
        {
            while (memberFile.hasNextLine())
            {
                //System.out.println(memberMax);
                String str = memberFile.nextLine();
                String [] memberDetail = str.split(", ");
                String buffID = memberDetail[0];
                String buffPW = memberDetail[1];
                String buffType = memberDetail[2];
                String buffFName = memberDetail[3];
                String buffLName = memberDetail[4];
                String buffMI = memberDetail[5];
                String buffEmail = memberDetail[6];
                String buffPID = memberDetail[7];
                String buffPPW = memberDetail[8];
                
                member[memberMax] = new Member(buffID, buffPW, memberMax, subType.valueOf(buffType), buffFName, buffLName, buffMI, buffEmail, buffPID, buffPPW);    
               
                memberMax++;
            }
                    
        }
            /*user menu when program opens
        is in a do while loop so that after each option is selected it 
        returns to this menu instead of closes the program
        */        
        
        do
        {
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        // Login Menu
        System.out.printf("***    Welcome to the BookMart Rentail System     ***\n"
                            + "Please select one of the following option: \n"
                            + "1. Login \n"
                            + "2. Signup \n"
                            + "3. Exit \n"
                            + "Your choice: ");
        choice = input.nextInt();
        /*menu is a switch case menu*/
        
            switch (choice)
            {
                case 1:
                {
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                    Scanner input1 = new Scanner(System.in);
                    boolean found = false;
                    boolean isAdmin = false;

                    System.out.printf("***    BookMart Login   ***\n"
                                + "ID: ");
                    id = input1.next(); //gathers input for user ID
                    System.out.printf("Password: ");
                    pw = input1.next(); // gathers input for user PW
                    /*for loop to traverse the array of all members
                    in the program to ensure that they are valid
                    members of the program*/
                    for (int i = 0; i<memberMax; i++)
                    {
                        
                        if (member[i].isUser(id, pw))
                        {
                            pos = i;
                            found = true; // true means the member exists
                            break;
                        }    
                    }
                    
                    for (int i = 0; i<adminMax; i++)
                    {
                        if (admin[i].isUser(id, pw))
                        {
                            pos = i;
                            
                            found = true;
                            isAdmin = true; // true means admin exists
                            break;
                        }    
                    }
                    

                    if (found == true)
                    {
                        /*if statement: if admin ID is valid they are greated with welcome and the admin menu*/
                        if (isAdmin)
                        {
                            System.out.println("-----------------------------------------------------------------------------------------------------------");
                            System.out.printf("Welcome " + admin[pos].getId() + "!\n");
                            showAdminMenu(admin[pos], game, gameNum, member, memberMax);
                        }
                        /*if member ID is valid they are greated with welcome and the member menu*/
                        else
                        {
                            System.out.println("-----------------------------------------------------------------------------------------------------------");
                            System.out.printf("Welcome " + member[pos].getId() + "!\n");
                            showInnerMenu(member[pos], game, gameNum);
                        }    
                    }
                    else 
                    {
                        System.out.printf("Warning: User not found! \n"); // occurs if the ID does not match any
                    }
                    
                    break;
                }
                case 2:
                {
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                    Scanner input2 = new Scanner(System.in);
                    boolean found = false,
                            match = false;
                           /*here is where the user can sign up to get a login for the program*/
                    System.out.printf("*** 2Mart Signup   ***\n"
                                + "ID: ");
                    id = input2.next(); // gathers user input for ID
                    System.out.printf("Password: ");
                    pw = input2.next(); // gathers user input for PW
                    System.out.printf("Retype Password: ");
                    pw1 = input2.next(); // PW confirmation
                    /*checks if the user is attempting to create another login
                    with a login ID that is already stored in the program*/
                    for (int i = 0; i<memberMax; i++)
                    {
                        if (id.equals(member[i].getId()))
                        {
                            found = true;
                            break;
                        }    
                    }
                    //checks if passwords match
                    if (pw.equals(pw1))
                        match = true;
                   /*error message if user attempts to create Login with a used ID*/ 
                    if (found)
                        System.out.printf("User name exists! Please choose a different ID. \n");
                    else if (!found && !match)
                        /*error message if users passwords do not match*/
                        System.out.printf("The password does not match! Exiting...\n");
                    /*if the login is unique and the passwords match
                    the user account is created*/
                    else if (!found && match)
                    {
                        /*passes in the member variables to the member class
                        to create an account.  also increases memberMax which 
                        is the number of users created in the program*/
                        member[memberMax] = new Member(id, pw, memberMax, subType.NONE);
                        memberMax++;
                        System.out.printf("Creating user sucessfully! \n");
                    
                    }
                        
                    break;
                }
                case 3:
                {
                    /*this option exits the program*/
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                    System.out.println("The program is now exiting ...\n");
                    break;
                }
                default: 
                {
                    /*error message if user chooses an option that is invalid*/
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                    System.out.println("Warning: Invalid option! \n");
                    break;
                }
            }
            
        } while (choice != 3); 
        /*do while loop to keep the menu running after each option is running
        menu will continue to loop until user exits the program*/
    }

    private static void showInnerMenu(Member member, Game[] game, int gameNum) 
    {
        Scanner input = new Scanner(System.in);
        int choice;
        /*this is the user menu that the user sees once they create an account 
        and log into the program*/
        
        do
        {
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.printf("***   User Menu   ***\n"
                                + "Please select one of the following option: \n"
                                + "1. Browse book library \n"
                                + "2. Enroll to become a studuent or facuilty \n"
                                + "3. Cancel enrollement \n"
                                + "4. Rent a book (Only for enrolled account)\n"
                                + "5. Return a book (Only for enrolled account)\n"
                                + "6. Update account info \n"
                                + "7. Search Book by Name \n"
                                + "8. Sort Book by Category \n"
                                + "9. Sort Book by Release Date \n"
                                + "10. See Rental Book history \n"
                                + "11. Exit \n"
                                + "Your choice: ");
            choice = input.nextInt();
            /*this is a switch case menu within a do while loop so that the user will be returned
            to the menu after every choice they make.  The user will exit the loop when 
            they choose the option for exit*/
            switch (choice)
            {
                case 1:
                {
                   
                    /*this is the book database which is a for loop
                    which outputs the books stored in the database to the user*/
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                    System.out.println("***   Book Database   ***");
                    System.out.printf("%-10s %-30s %-10s %-20s %-15s %-30s\n", "BookID" , "Name", "Quantity", "Category", "Release Date", "Publisher");
                    /*for loop that outputs each game to the screen*/
                    for (int i = 0; i<gameNum; i++)
                    {
                        game[i].gameInfo();
                    }
                    break;
                }
                case 2:
                {
                    /*function call for user to purchase a member subscription*/
                    member.memberSubcriptionPurchase(member);
                    break;
                }
                case 3:
                {
                    /*function call for user to cancel member subscription*/
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                    member.cancelSubcription();
                    break;
                }
                case 4:
                {
                    /*function call for user to rent a book, 
                    passes in bok object as well as bookNum which
                    is the total number of books*/
                    member.rentGame(game, gameNum);
                    
                    break;
                }
                case 5:
                {
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                    member.returnGame(game, gameNum);
                    break;
                }
                case 6:
                {
                   /*function call for member to update their
                    account info*/
                   member.updateInfo();
                   break;
                }
                case 7:
                { 
                  /* having trouble passing in the variables to the search function*/
                    /*Search Book Name*/
                    //game[].searchGameName(game, gameNum);
                    
                    Scanner input1 = new Scanner(System.in);
                    int choice1 = 0; 
                        
                    do
                        {
                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                        int pos = 0;
                        boolean found = false;
                           
                        System.out.printf("***   Book Search by Name   ***\n"
                                + "What is the name of the book are you looking for? ");
                        String gameNameSearch = input1.nextLine();

                        System.out.printf("Now searching for %s \n" , gameNameSearch);

                        for(int i=0; i<gameNum; i++)
                        {
                            if (gameNameSearch.equals(game[i].getGameName()))
                            {
                                found = true;
                                pos = i;
                                break;
                            }
                        }   
                        
                        if(!found)
                            {
                                System.out.println("Sorry that book does not exist!");
                            }
                        else
                        {
                            System.out.println("Here is your book info ..." +
                                    " | BOok Name: " +game[pos].getGameName() +
                                    " | BOok ID: " + game[pos].getGameID() +
                                    " | Book Release Date: " + game[pos].getGameReleaseDate());
                        }
                        System.out.printf("Would you like to search for another BOok? yes = 1 no = 2 \n"
                                + "Your choice: ");
                        choice1 = input.nextInt();
                    } while (choice1 == 1 );
                    
                    break;
                }
                case 8:
                {
                    /*this method will sort the database by Book category*/
                    Scanner input1 = new Scanner(System.in);
                    Scanner input2 = new Scanner(System.in);
                    int choice1 = 0;

                    do
                    {
                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                       //outputs the BOok library that is stored in the program
                        System.out.printf("***   Sort Book by Category  ***\n"
                                     + "Please enter a category (Art, Business, Economics, Computer Science, Design, Education, Law, Mathematics, Music, Philosophy and Psychology.): ");
                        String cat = input1.nextLine();
                        System.out.printf("%-10s %-30s %-10s %-20s %-15s %-30s\n", "BookID" , "Name", "Quantity", "Category", "Release Date", "Publisher");
                        for (int i = 0; i < gameNum; i++)
                        {
                            /*for loop which will process the array of books in 
                            the database*/
                            String buffCat = game[i].getGameCategory();

                            if(cat.equals(buffCat))
                            {
                                /*while in the for loop if the category
                                inputted matches the one in the program
                                the book info will output to the
                                screen*/
                                game[i].gameInfo();
                                
                            }
                        }
                         /*user promts to sort the book again 
                        which is also a do-while loop which will continue 
                        unless the user chooses no*/
                        System.out.printf("Would you like to sort books in another year? yes = 1 no = 2 \n"
                                + "Your choice: ");
                        choice1 = input2.nextInt();
                        
                    } while (choice1 ==1);

                    break;
                }
                case 9:
                {
                    Scanner input1 = new Scanner(System.in);
                    Scanner input2 = new Scanner(System.in);
                    int choice1 = 0;

                    do /*this do while loop allows the user to sort by year*/
                    {
                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                      //outputs list of books sorted by year
                        System.out.printf("***   Sort Books by Year   ***\n"
                                     + "Sort by Year (2003 - 2015): ");
                        int searchDate = input1.nextInt();
                        System.out.printf("%-10s %-30s %-10s %-20s %-15s %-30s\n", "BookID" , "Name", "Quantity", "Category", "Release Date", "Publisher");
                        for (int i = 0; i < gameNum; i++)
                        {
                            /*for loop that traverses through array and uses a 
                            split atribute to single out the year*/
                            String date = game[i].getGameReleaseDate();
                            String [] attr = date.split("/");
                            String year = attr[2];
                            
                            if(searchDate == Integer.parseInt(year))
                            {
                                /*this statement parses out the year
                                in the date which is stored as a string and
                                uses it to display the info*/
                                game[i].gameInfo();
                                
                            }
                        }
                         
                        System.out.printf("Would you like to sort Books in another year? yes = 1 no = 2 \n"
                                + "Your choice: ");
                        choice1 = input2.nextInt();
                        /*do while loop will continue to loop untill user chooses not to 
                        sort by another year*/
                    } while (choice1 ==1);
                    break;
                }
                case 10:
                {
                    /*this is teh function call to see the book rent detail information*/
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                    member.seeGameRentDetail();
                    break;
                }
                case 11:
                {
                    /*this case exits the menu and goes back to the log in menu*/
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                    System.out.println("Exiting to Login Menu ...");
                    break;
                }
                default: // error message if invalid option is selected
                {
                    System.out.println("-----------------------------------------------------------------------------------------------------------");

                    System.out.println("Warning: Invalid option!");
                    break;
                }

            }
        } while (choice != 11); //do while loop if...will loop untill option 11 is selected    
    }
 /*this is the admin menu 
    in this menu the admin, book and member objects are passed 
    along with the total number of books and the total number of members*/
    private static void showAdminMenu(Admin admin, Game[] game, int gameNum, Member[] member, int memberMax) {
        Scanner input = new Scanner(System.in);
        int choice;
        /*do while loop that will continue to take the user back to the menu after 
        a specific option is chosen.  By choosing option 5, the user will 
        exit out of this loop and be taken to the previous menu*/
        do
        {
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.printf("***   Admin Menu   ***\n"
                                + "Please select one of the following option: \n"
                                + "1. See Member List \n"
                                + "2. Search Member Info by Attribute\n"
                                + "3. See Member History\n"
                                + "4. See Book List\n"
                                + "5. Update Book Availability\n"
                                + "6. Exit \n"
                                + "Your choice: ");
            choice = input.nextInt(); // gets user input for choice
            
            /*switch case menu for each option that is available to choose from*/
            switch (choice)
            {
                case 1:
                {
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                    admin.seeMemberList(member, memberMax);
                    break;
                }
                case 2:
                {
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                    Scanner input1 = new Scanner(System.in);
                    int choice1;
                    do
                    {
                        /*this is the member search menu*/
                        System.out.printf("***   Member Search Menu   ***\n"
                                + "Please select one of the following option: \n"
                                + "1. Search by Name \n"
                                + "2. Search by UserID \n"
                                + "3. Search by Subcription Type\n"
                                + "4. Exit \n"
                                + "Your choice: ");
                        choice1 = input1.nextInt();
                        
                        switch (choice1)
                        {
                            case 1: 
                            {
                                /*this will pass in the name, member, and memberMax variables
                                to the admin.seeMemberInfoByName method in which will
                                compare the member name inputted by the user
                                to the one stored in the program*/
                                System.out.println("-----------------------------------------------------------------------------------------------------------");
                                Scanner input2 = new Scanner(System.in);
                                System.out.printf("***   Search by Name Menu   ***\n"
                                                + "Please insert member's name: ");
                                String name = input2.nextLine();
                                admin.seeMemberInfoByName(name, member, memberMax);
                                break;
                            }
                            case 2:
                            {
                                /*this will pass in the ID, member, and memberMax variables
                                to the admin.seeMemberInfoByUID method in which will
                                compare the member ID inputted by the user
                                to the one stored in the program*/
                                
                                System.out.println("-----------------------------------------------------------------------------------------------------------");
                                Scanner input2 = new Scanner(System.in);
                                System.out.printf("***   Search by UserID Menu   ***\n"
                                                + "Please insert member's UserID: ");
                                int uid = input2.nextInt();
                                admin.seeMemberInfoByUID(uid, member, memberMax);
                                break;
                                
                            }
                            case 3:
                            {
                                
                                /*this will pass in the subscription type, member, and memberMax variables
                                to the admin.seeMemberInfoByType method in which will
                                compare the member subscription type inputted by the user
                                to the one stored in the program*/
                                System.out.println("-----------------------------------------------------------------------------------------------------------");
                                Scanner input2 = new Scanner(System.in);
                                System.out.printf("***   Search by Type Menu   ***\n"
                                                + "Please insert member's Subcription Type: ");
                                String type = input2.nextLine();
                                admin.seeMemberInfoByType(subType.valueOf(type), member, memberMax);
                                break;
                                
                            }   
                            case 4:
                            {
                                /*this option exits from this menu and returns
                                the user to the Admin menu*/
                                System.out.println("-----------------------------------------------------------------------------------------------------------");
                                System.out.println("Exiting to Admin Menu ...");
                                break;
                            }
                            
                            default:
                            {
                                /*error message if user chooses an invalid
                                option*/
                                System.out.println("-----------------------------------------------------------------------------------------------------------");
                                System.out.println("Warning: Invalid option!");
                                break;
                            }
                        }
                        System.out.println("-----------------------------------------------------------------------------------------------------------");
                    } while (choice1 != 4); // while loop will continue until user chooses option 4 
                          
                    break;
                }
                case 3:
                {
                    /*this option will call the
                    seeMemberHist method which
                    will show the members history
                    of when they rented a book*/
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                    admin.seeMemberHist(member, memberMax);
                    break;
                }
                case 4:
                {
                    /*this is the book database which is a for loop
                    which outputs the books stored in the database to the user*/
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                    System.out.println("***   Book Database   ***");
                    System.out.printf("%-10s %-30s %-10s %-20s %-15s %-30s\n", "BookID" , "Name", "Quantity", "Category", "Release Date", "Publisher");
                    /*for loop that outputs each book to the screen*/
                    for (int i = 0; i<gameNum; i++)
                    {
                        game[i].gameInfo();
                    }
                    break;
                    
                }
                case 5:
                {
                    admin.updateGameAvailability(game, gameNum);
                    break;
                }
                case 6:
                {
                    /*This option will exit this menu and return the user
                    to the login menu*/
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                    System.out.println("Exiting to Login Menu ...");
                    break;
                }
                default:
                {
                    /*error message if the user 
                    inputs an incorrect choice when navigating the menu*/
                    System.out.println("-----------------------------------------------------------------------------------------------------------");
                    System.out.println("Warning: Invalid option!");
                    break;
                }

            }
            
        } while (choice != 6); //do-while loop will continue to loop until user chooses option 5
    }


    
}