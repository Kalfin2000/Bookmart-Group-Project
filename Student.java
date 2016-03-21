/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Strongestislander
 */
/*this is the student class which is a child class of member and
like the premium(faculty) class implements the MemberFunction interface*/
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class Student extends Member implements MemberFunction {
    /*the private variable for student charge is stored here
    the student subscription will be charaged 7.99*/
    private double studentCharge = 7.99;
    /*the max number of books a student subscription 
    can rent is 2*/
    private int studentRentMax = 1;
    
    /*constructor which passes in the variables from main class
    as well as passes in the variables from the parent class so that 
    they can be used in this class*/
    public Student(String buff, String pw, int uid, subType type, String fName, String lName, String mid, String e,  String pid, String ppw) {
        super(buff, pw, uid, type, fName, lName, mid, e, pid, ppw);
        
    }
    /*set methods for the student charge and the student rent number
    these methods bring in the variable and assign it to the 
    private variables that are stored in this class*/
    
    public void setStudentCharge(double charge)
    {
        studentCharge = charge;
    }
    public void setStudentRentNum(int num)
    {
        studentRentMax = num;
    }
    /*these are the get methods which return 
     the private variables by calling on 
    the getmethod they are assigned to */
    public double getStudentCharge()
    {
        return studentCharge;
    }
    
    public double getStudentRentNum()
    {
        return studentRentMax;
    }
    

}
