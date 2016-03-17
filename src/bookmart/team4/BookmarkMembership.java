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
public class BookmarkMembership {
    private String christian;
            
    private String anus;
}

public Abstract class BookmarkMembership
{

  String firstName;  // Holds first name of user
  String lastName;  // Holds last name of user
  String middleInitial;  // Holds middle initial
  String password;  // Holds password string
  String email;  // Holds email string
  
  abstract void setFirstName(String fName)
  {
      // Will later be used by children classes to set first name.
  }
  
  abstract void setLastName(String lName)
  {
      // Will laster be used by children classes to set last name.
  }
  
  abstract void setMiddleInitial(String mName)
  {
      // Will later be used by children classes to set middle initial.
  }
  
  abstract void setPass(String pass)
  {
      // Will later be used by children classes to set password.
  }
  
  abstract void setEmail(String mail)
  {
      // Will later be used by children classes to set email.
  }
  
  
}
