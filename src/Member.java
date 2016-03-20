
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
 * @author Strongestislander
 */
/*This is the member class which is a child of User and 
a parent class of gamer(student) and premium(faculty) */
public class Member extends User {
    /*in this class the private variables for the 
    users information when signing up for an account
    are stored in this class*/
    private String firstName;
    private String lastName;
    private String midInitial;
    private String email;
    private subType subcriptionType;
    private String paypalID;
    private String paypalPassword;
    private int gameRent = 0;
    private int gameHist = 0;
    private int gameReturn = 0;
    private String [] gameRentDetail = new String[100];
    
    //private String [] outbox = new String [100];
    //private int outboxCount = 0;
    
    public Member(String buff, String pw, int uid, subType type) {
        /*this is the constructor for the member class in which the variables
        are passed in from main*/
        super(buff, pw, uid);
        setSubcriptionType(type);
        setFirstName("");
        setLastName("");
        setMidInitial("");
        setEmail("");
        setPaypalID("");
        setPaypalPassword("");
    }
    
    public Member(String buff, String pw, int uid, subType type, String fName, String lName, String mid, String e,  String pid, String ppw) {
        /*in this class the varaibles from main are passed into this class
        and using the set methods they are assigned to their corresponding
        private variables*/
        super(buff, pw, uid);
        setSubcriptionType(type);
        setFirstName(fName);
        setLastName(lName);
        setMidInitial(mid);
        setEmail(e);
        setPaypalID(pid);
        setPaypalPassword(ppw);
    }
    /*these are the set methods which are called that assign
    the variable passed in to the private variable that
    is stored in this class*/
    public void setFirstName(String fName)
    {
        firstName = fName;
    }
    
    public void setLastName(String lName) {
        lastName = lName;
    }

    public void setMidInitial(String mid) {
        midInitial = mid;
    }

    private void setEmail(String e) {
        email = e;
    }

    private void setSubcriptionType(subType type) {
        subcriptionType = type;
    }
    
    
    
    public void setPaypalID(String pid)
    {
        paypalID = pid;
    }
    
    public void setPaypalPassword(String ppw)
    {
        paypalPassword = ppw;
    }
    
    public void setGameRent(int r)
    {
        gameRent = r;
    }
    /*these are the get methods which return
    the private variables that are stored in this class
    by calling on the get method which will output
    the private variable*/
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getMidInitial()
    {
        return midInitial;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public subType getSubcriptionType()
    {
        return subcriptionType;
    }

    public String getPaypalID()
    {
        return paypalID;
    }
    
    public String getPaypalPassword()
    {
        return paypalPassword;
    }
    
    public int getGameRent()
    {
        return gameRent;
    }
    /*this is the method which allows the user to update
    the info that they have entered into the program
    when signing up for an account*/
    public void updateInfo()
    {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        int choice;
        String buff;
        /*this is a menu asking the user what it is that they want to update
        it is stored in a do while loop which will continue to loop
        until the user exits the menu by choosing option 6*/
        do
        {
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            displayInfo();
            System.out.printf("***   Update Info   ***\n"
                                + "Please select the field you want to update: \n"
                                + "1. First Name \n"
                                + "2. Last Name \n"
                                + "3. Mid Initial \n"
                                + "4. Email \n"
                                + "5. Paypal account\n"
                                + "6. Exit to User Menu\n"
                                + "Your choice: ");
            choice = input.nextInt();
            /*swich case menu which assigns a different method to each 
            option that is available for the user to use*/
            switch (choice)
            {
                case 1: 
                {
                    /*here the user is asked to enter their first name
                    which is then passed into the setFirstName method
                    which will update their name*/
                    System.out.printf("Please enter your first name: ");
                    buff = input1.nextLine();
                    setFirstName(buff);
                    break;
                }
                case 2: 
                {
                    /*here the user is asked to enter their last name
                    which is then passed into the setLastName method
                    which will update their last name*/
                    System.out.printf("Please enter your last name: ");
                    buff = input1.nextLine();
                    setLastName(buff);
                    break;
                }
                case 3: 
                {
                    /*here the user is asked to enter their middle inital
                    which is then passed into the setMidInital method
                    which will update their middle initial*/
                    System.out.printf("Please enter your Mid Initial: ");
                    buff = input1.nextLine();
                    setMidInitial(buff);
                    break;
                }
                case 4: 
                {
                    /*here the user is asked to enter their email
                    which is then passed into the setEmail method
                    which will update their email*/
                    System.out.printf("Please enter your Email: ");
                    buff = input1.next();
                    setEmail(buff);
                    break;
                }
                case 5:
                {
                    /*here the user is asked to enter their paypall ID
                    and password which will then pass the new ID and PW
                    to the appropriate set methods which will then
                    update their paypal information*/
                    System.out.printf("Paypal ID: ");
                    buff = input1.next();
                    setPaypalID(buff);
                    System.out.printf("Paypal Password: ");
                    buff = input1.next();
                    setPaypalPassword(buff);
                    break;
                }
                case 6: 
                {
                    /*this option exits the update member info menu*/
                    System.out.printf("Exiting to User Menu ...\n");
                    break;
                }
                default:
                {
                    /*this is an error message in case the user chooses the wrong option*/
                    System.out.printf("Warning: Invalid option! \n");
                    break;
                }        
            }
        } while (choice != 6);    
    }
    
    public void displayInfo()
    {
        /*this function calls on all the get methods
        which will return all the private variables of this class*/
        System.out.printf("[!] " + getId() +"'s Info [!]\n"
                + "- First name: " + getFirstName() + "\n"
                + "- Last name: " + getLastName() + "\n"
                + "- MI: " + getMidInitial() + "\n"
                + "- Email: " + getEmail() + "\n"
                + "- Subcription type: " + getSubcriptionType().toString() + "\n"
                + "- Paypal ID: " + getPaypalID() + "\n"
                + "- Paypal Password: " + getPaypalPassword() + "\n");
    }
    
    
    public void cancelSubcription()
    {
     /*this method calles on the enum class which will
        set the private variable storing the subscription 
        to none which in turn will cancel the subscription of the user*/   
        subcriptionType = subType.NONE;
        System.out.printf("Subcription cancels sucessfully! \n");
    }
    
    /*public void contactCustomerService()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("***   Outbox   ***\n"
                + "Please enter your request to admin: ");
        String mess = input.nextLine();
        outbox[outboxCount]= mess;
        outboxCount++;
        System.out.println("Message sent successfully!");
    }
    
    public String sentRequest()
    {
        return outbox[outboxCount-1];
    }*/
    
    public void memberListing()
    {
        /*this method will return the members information and output it to the screen*/
        System.out.printf("%-20s %-15s %-15s %-20s %-20s %-10s %-30s\n", super.getId(), super.getUserID(), getSubcriptionType(), firstName, lastName, midInitial, email);
    }
    
    public void memberSubcriptionPurchase(Member member)
    {
        /*in this method the user will be able to purchase a member 
        subscription*/
        
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        String buff;
        int choice;
        /*this method consists of a switch case menu which encloses
        a do while loop which will continue to loop until the 
        user chooses to exit the menu, which will exit the loop*/
        do
        {    
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.printf("***   Account Subcription   ***\n"
                        + "Please select the subcription type that you would like to purchase: \n"
                        + "1. Student ($7.99/month)\n"
                        + "2. Facuilty ($9.99/month)\n"
                        + "3. Exit\n"
                        + "Your choice: ");
            choice = input.nextInt(); // gathers input from the user on their selection
              /*calls this function which enables the user to input thier first name 
            which is then passed in to the private variable*/
            if (firstName.isEmpty())
            {
                System.out.printf("Please enter your first name (Required for Subcription Account): ");
                buff = input1.nextLine();
                setFirstName(buff);
            } 
            /*calls the set last name method which allows the user to 
            input their last name which will set it to the private variable
            stored in this class*/
            if (lastName.isEmpty())
            {
                System.out.printf("Please enter your last name (Required for Subcription Account): ");
                buff = input1.nextLine();
                setLastName(buff);
            } 
             /*calls the set middile initial method which allows the user to 
            input their middle initial which will set it to the private variable
            stored in this class*/
            if (midInitial.isEmpty())
            {
                System.out.printf("Please enter your Mid Initial (Required for Subcription Account): ");
                buff = input1.nextLine();
                setMidInitial(buff);
            } 
             /*calls the set email method which allows the user to 
            input their email which will set it to the private variable
            stored in this class*/
            if (email.isEmpty())
            {
                System.out.printf("Please enter your Email (Required for Subcription Account): ");
                buff = input1.next();
                 setEmail(buff);
            } 
             /*calls the set pay pal Id and set pay pal password which allows the user to 
            input their pay pal user id and password and set them to the private variable
            stored in this class*/
            if (paypalID.isEmpty() || paypalPassword.isEmpty())
            {
                System.out.printf("Paypal ID (Required for Subcription Account): ");
                buff = input1.next();
                setPaypalID(buff);
                System.out.printf("Paypal Password (Required for Subcription Account): ");
                buff = input1.next();
                setPaypalPassword(buff);
            }      
            
            switch (choice)
            {
                case 1:
                {
                    /*this option is if the user chooses to 
                    subscribe to the gamer(student) subscritption 
                    it will set their subscription type to gamer(student) using the
                     enum value*/
                    setSubcriptionType(subType.GAMER);
                    System.out.printf("Subcribe Successfully to " + getSubcriptionType() + " Account! \n");
                    break;
                }
                case 2:
                {
                    /*this option is if the user chooses to 
                    subscribe to the premium(faculty) subscritption 
                    it will set their subscription type to premium(faculty) using the
                     enum value*/
                    setSubcriptionType(subType.PREMIUM);
                    System.out.printf("Subcribe Successfully to " + getSubcriptionType() + " Account! \n");
                    break;
                }
                case 3:
                {
                    /*this is the option which the user will
                    exit out of the do while loop and return to the menu*/
                    System.out.printf("Exiting to User Menu ...\n");
                    break;
                }
                default:
                {
                    /*this is the error message that is outputted to the screen
                    if the user inputs the incorrect option*/
                    System.out.printf("Warning: Invalid option! \n");
                    break;
                }
            }
        
        } while (choice != 3); //do while loop will continue until user choose 3 which is exit
        
    }
    
    public void rentGame(Game[] game, int gameMax) 
    {
        /*this is the rent book method which passes in the book object and the
        bookMax variable */
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        int choice = 0;
        boolean found = false;
        int gameRentMax = 2;
        /*checks if the user has a subscripiton*/
        if (getSubcriptionType() == subType.NONE)
        {
            System.out.println("Warning: This option only available for paid accont! Your account type is " + getSubcriptionType());
        }
        else
        {    /*if user has a subscription will proceed to this menu */
            do
            {
   
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                System.out.printf("***   Rent Book Menu   ***\n"
                                + "Please insert the Book ID you want to rent: ");
                /*user enters Book ID of the book of their choice*/
                int gid = input1.nextInt();
                int pos = 0;
                for(int i=0; i<gameMax; i++)
                {
                    /*id is passed through for loop which browses the book database
                    and checks which id is the same*/
                    if (gid == game[i].getGameID())
                    {
                        /*when there is a match that ID along with the rest of information is saved
                        by assigning the i value of the array to pos which is the position value*/
                        found = true;
                        pos = i;
                        break;
                    }
                }
                 /*checks if the user is renting the appropriate amount of books for their 
                subscription*/
                if ((getGameRent() >= 2) && (getSubcriptionType() == subType.GAMER))
                {
                    /*error message*/
                    System.out.println("Warning: Maximum Books for student account is 1 monthly. Please upgrade your subcription type or return your book to rent Another!\"");
                }
                /*checks if the user is renting the appropriate amount of games for the 
                premium(faculty) subscription*/
                else if ((getGameRent() >= 4) && (getSubcriptionType() == subType.PREMIUM))
                {
                    /*error message*/
                    System.out.println("Warning: Maximum Books for Faculty account is 4 monthly. Please return a book to rent another!");
                }
                else if(!found) 
                {
                    System.out.println("Sorry that Book does not exist! ");
                }
                else
                {
                    /*if appropriate number of books are being rented then the date 
                    is recorded*/
                    if (getSubcriptionType() == subType.GAMER)
                        gameRentMax = 2;
                    else 
                        gameRentMax = 4;
                    
                    DateFormat dateFormat = new SimpleDateFormat( "MM/dd/yyyy HH:mm:ss" );
                    Calendar calendar = new GregorianCalendar(); // The date you want to format
                    Date dateToFormat2 = calendar.getTime();
                    String formattedDate2 = dateFormat.format( dateToFormat2 );
                    calendar.add(Calendar.DAY_OF_MONTH, 2);
                    Date dateToFormat1 = calendar.getTime();
                    String formattedDate1 = dateFormat.format( dateToFormat1 );
                    
                    
                    
                    /*this subtracts the number of books from the database*/
                    if ((game[pos].getGameQuantity() - 1) <= 0)
                        System.out.println("Sorry this book has no copy left! Please check later for availability");
                    else
                    {    /*when a book is rented the number of books that are being rented are being kept count of 
                        using the bookRent variable: the book information as well as the return date is 
                        outputted to the user as well as how the quantity of that book is subtracted*/
                        gameRent++;
                        gameHist++;
                        System.out.printf("\"" + game[pos].getGameName() + "\" (Release Date: " + game[pos].getGameReleaseDate() + ") is now available for pickup in your account ...\n"
                                + "Rent Date: " + formattedDate2 + " | Return date: " + formattedDate1 + "\n");
                        System.out.println("You now have " + (gameRentMax+gameReturn-gameHist) + " free books(s) left for this month");
                        gameRentDetail[gameHist-1] = "[NOTRETURNED] / " + game[pos].getGameID() + " / " +  game[pos].getGameName() + " / Rent Date: " + formattedDate2;    
                        game[pos].setGameQuantity(game[pos].getGameQuantity() - 1);
                    }   
                }
                System.out.printf("Would you like to order another book?\n"
                        + "1. Yes\n"
                        + "2. No\n"
                        + "Your choice: ");
                choice = input.nextInt();
            }while(choice == 1);
    
        }
    }
    
    public void seeGameRentDetail()
    {
        
        System.out.println("***   " + getLastName() + "'s Book Rental History   ***");
        for (int i = 0; i < gameHist; i++)
        {
            System.out.println(gameRentDetail[i]);
        }
    }
        
    public void returnGame(Game[] game, int gameMax)
    {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        int choice;
        do 
        {
            int pos = 0;
            boolean found = false;
            seeGameRentDetail();
            if (gameRent == 0)
            {
                System.out.println("You have no book to return. Exiting to User Menu ...");
                
            }
            else
            {
                
                System.out.printf("Please insert Book ID of the book you want to return: ");
                int gid = input1.nextInt();
                
                for (int i =0; i<gameHist; i++)
                {
                    String str = gameRentDetail[i];
                    //System.out.println( gameRentDetail[i]);
                    String [] detail = str.split(" / ");
                    String buffState = detail[0];
                    String buffGid = detail[1];
                    String dt = detail[3];
                    
                    DateFormat dateFormat = new SimpleDateFormat( "MM/dd/yyyy HH:mm:ss" );
                    Calendar calendar = new GregorianCalendar(); // The date you want to format
                    Date dateToFormat2 = calendar.getTime();
                    String formattedDate2 = dateFormat.format( dateToFormat2 );
                    
                    //System.out.println(gid + " " + detail[2]);
                    if (gid == Integer.parseInt(buffGid))
                    {
                        //System.out.println("Inner Loop");
                        for (int m = 0; m<gameMax; m++)
                        {
                            if (gid == game[m].getGameID())
                            {
                                found = true;
                                //System.out.println("Found ");
                                pos = m;
                                break;
                            }    
                        }
                        
                        if (found)
                        {
                            if (buffState.equals("[NOTRETURNED]"))
                            {
                                /*if the book id is found in the database
                                the book quantity will be updated and added back to the original list
                                and the book will be set to returned
                                */
                                game[pos].setGameQuantity(game[pos].getGameQuantity() + 1);
                                gameRentDetail[i] = "[RETURNED] / " + game[pos].getGameID() + " / " +  game[pos].getGameName() + " / Rent Date: " + dt + " / Return Date: " + formattedDate2;
                                gameRent--;
                                gameReturn++;
                                System.out.printf("\"" + game[pos].getGameName() + "\" (#" + game[pos].getGameID() + ") is successfully returned to GamesTop! \n");
                        
                            }
                            else 
                            {
                                System.out.printf("Return Error: This book has already been returned! \n"); 
                                /*warning incase user tries to return a book that is already returned*/
                            }
                        }    
                        else 
                        {
                            
                            System.out.println("Return Error: Invalid BookID ... ");
                            //invalid book id error message
                        }
                    }
                    
                }

            }
            System.out.printf("Do you want to return another book? Yes = 1 No = 2\n"
                    + "Your choice: ");
            choice = input.nextInt();
        } while (choice == 1); /*do while loop will continue as long as user continues to return books*/
            
    }
    public void searchGame(int gid){}
}
 