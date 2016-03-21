/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author strongestislander
 */
import java.util.Scanner;
public class AdminMenuTemplate {
    
     private static void showAdminMenu(Admin user) 
    {
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.printf("***Admin Menu***\n" 
                         + "Please Select one of the following options: \n"
                         + "1. See Member Info\n"
                         + "2. See Member History\n"
                         + "3. Inbox\n"
                         + "4.Exit\n"
                         + "Your choice: ");
        choice = input.nextInt();
       do{  
        switch(choice)
        {
            case 1:
            {
               break; 
            }
            case 2:
            {
              break;  
            }
            case 3:
            {
               break;
            }
            case 4:
            {
               break;
            }
            default:
            {
                System.out.println("Invalid option \n");
                break;
            }
        }
       }while(choice != 4);
        
    }
    
}
