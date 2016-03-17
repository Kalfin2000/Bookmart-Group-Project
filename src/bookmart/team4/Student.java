// This will be the subclass of BookMarkMembership Abstract class
package mookmart.team4;

public class Student extends BookmarkMembership
{
  private final double studentFee = 9.99; // Used to calculate the monthly fee
  private final int studentFreeBooks = 0;  // Used to keep track of the amount of free books allowed
  private int amountDaysBorrowed = 0; // Used to keep track of the amount of free days you get
  private double studentBalance = 0.00 // Used to keep track of the balance for the student


  // Constructor
  public Student(String firstName, String lastName, String middleInitial, String password, String email)
  {
    super(firstName, lastName, middleInitial, password, email);
  }

  @Override
  public int daysBorrowed()
  {
    amountDaysBorrowed++; // Increase the amount of days borrowed by 1
    
    if(amountDaysBorrowed > 7)
    {
      throw new IllegalArgumentException("The amount of free days to borrow this book"
      + " can not exceed 7 day.");
    }
    
    return amountDaysBorrowed;
  }
  
  @Override
  public int freeBooks()
  {
    studentFreeBooks++; //Subtracts from the amount of free books a Student can borrow
    
    if(studentFreeBooks > 1)
    {
      throw new IllegalArgumentException("You can only borrow 1 free book at a time.");
    }
    
    return studentFreeBook;
  }
  
  @Override
  public double fee()
  {
      studentBalance = studentBalance + studentFee; // Adds the monthly fee to the student balance
      
      return studentBalance;
  }

} // End Student subclass
