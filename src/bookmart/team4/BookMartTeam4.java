/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmart.team4;
import java.util.Scanner;

/**
 *
 * @author Steven Benedict <sbenedict1@islander.tamucc.edu>
 */
public class BookMartTeam4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
        
        int menuChoice;
        
        System.out.println("Welcome to Bookmart, please select an option. \n"
                + "1) Login \n"
                + "2) Create new Account \n");
       menuChoice = scanner.nextInt();
       
       while (menuChoice != 1 && menuChoice != 2)
       {
           System.out.println(menuChoice + " is not a valid menu selection. \n"
                   + "Enter 1 to1 Login to and existing account. \n"
                   + "Enter 2 to create a new account.");
           menuChoice = scanner.nextInt();
       }
    }
    
}
