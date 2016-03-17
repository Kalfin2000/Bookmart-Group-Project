// This will be a subclass of BookMarkMembership Abstract class


public class Faculty extends BookmarkMembership
{
  private final float facultyFee = 7.99; // Used to calculate the monthly fee
  private final int facultyFreeBooks = 0;  // Used to keep track of the amount of free books allowed
  private int amountDaysBorrowed = 0; // Used to keep track of the amount of free days you get
  private float facultyBalance = 0.00 // Used to keep track of the balance for the facutly member


  // Constructor
  public Facutly(String firstName, String lastName, String middleInitial, String password, String email)
  {
    super(firstName, lastName, middleInitial, password, email);
  }

  @Override
  public int daysBorrowed()
  {
    amountDaysBorrowed++; // Increase the amount of days borrowed by 1
    
    if(amountDaysBorrowed > 14)
    {
      throw new IllegalArgumentException("The amount of free days to borrow this book
      can not exceed 14 day.");
    }
  }
  
  @Override
  public int freeBooks()
  {
    facultyFreeBooks++; //Subtracts from the amount of free books a Faculty member can borrow
    
    if(facultyFreeBooks > 4)
    {
      throw new IllegalArgumentException("You can only borrow 4 free book at a time.");
    }
  }
  
  @Override
  public float fee()
  {
      facultyBalance = facutlyBalance + facutlyFee; // Adds the monthly fee to the Faculty member balance
  }

} // End Facutly subclass
