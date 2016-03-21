/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Strongestislander
 */
/*this is the faculty member class */
import java.util.Date;
import java.util.Scanner;
public class Faculty extends Member implements MemberFunction //child class of member and implements memberFunction interface
{
    /*the faculty charge variable is the amount that a faculty user
    pays when subscribing for this type of subscription*/
    private double facultyCharge = 9.99;
    private int facultyRentMax = 4;
    /*rentMax is the total number of books that the faculty user
    can rent from the program*/
    
    /*constructor which passes in the variables from main and assignes them, as well as
    passes in variables from the parent class and assigns them*/
    public Faculty(String buff, String pw, int uid, subType type, String fName, String lName, String mid, String e, String pid, String ppw) {
        super(buff, pw, uid, type, fName, lName, mid, e,  pid, ppw);
    }
    /*these are the set methods for faculty charges and faculty rent number
    in these methods the variables are set to the private variables in this class*/
    public void setFacultyCharge(double charge)
    {
        facultyCharge = charge;
    }
    
    public void setFacultyRentNum(int num)
    {
        facultyRentMax = num;
    }
    /*in these get methods the faculty charge and faculty rent number private
    variables are returned by calling on the get methods*/
    public double getFacultyCharge()
    {
        return facultyCharge;
    }
    
    public double getFacultyRentNum()
    {
        return facultyRentMax;
    }

    
    @Override
    public void searchBook(int gid) 
    {
        
    }
    
}
