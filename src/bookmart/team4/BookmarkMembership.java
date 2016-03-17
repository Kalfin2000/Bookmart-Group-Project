/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmart.team4;

/** 
 *
 * @author Steven Benedict <sbenedict1@islander.tamucc.edu>
 */
//public class BookmarkMembership {
//    private string christian;
//}

public abstract class BookmarkMembership
{

  private String firstName;  // Holds first name of user
  private String lastName;  // Holds last name of user
  private String middleInitial;  // Holds middle initial
  private String password;  // Holds password string
  private String email;  // Holds email string
  
  
  //Constructor
  public BookmarkMembership(String firstName, String lastName, String middleInitial, String password, String email)
  {
      this.firstName = firstName; // Initializes firstName
      this.lastName = lastName; // Initializes lastName
      this.middleInitial = middleInitial; // Initializes middleInitial
      this.password = password; // Initilizes password
      this.email = email; // Initilizes email
  }
  // Sets First Name
  public void setFirstName(String firstName)
  {
      this.firstName = firstName;
  }
  // Return First Name
  public String getFirtsName()
  {
      return firstName;
  }
  // Sets Last Name
  public void setLastName(String lastName)
  {
      this.lastName = lastName;
  }
  // Returns Last Name
  public String getLastName()
  {
      return lastName;
  }
  
  // Sets Middle Initial
  public void setMiddleInitial(String middleInitial)
  {
      this.middleInitial = middleInitial;
  }
  
  // Return Middle Initial
  public String getMiddleInitial()
  {
      return middleInitial;
  }
  
  // Gets Password
  public void setPass(String password)
  {
      this.password = password;
  }
  
  // Returns Password
  public String getPassword()
  {
      return password;
  }
  
  //Sets Email
  public void setEmail(String email)
  {
      this.email = email;
  }
  
  // Return Email
  public String getEmail()
  {
      return email;
  }
  
  public abstract int daysBorrowed();
  //Abstract method that will later be used to count the days a user can borrow a book
  // When used by Student, there will only be 7 days to borrow book
  // When used by Faculty, there will be 14 days to borrow a book
  
  public abstract double fee();
  // Abstract method that will calculate the monthly fee for the user
  // When used by Student, the fee will be $7.99/month
  // When used by Faculty, the fee will be $9.99/month
  
  public abstract int freeBooks();
  // Abstract method that will display the amount of free books to borrow demepending on a user
  // When used by Student, the amount of free books = 1
  // When used by Faculty, the amount of free books = 4

}
