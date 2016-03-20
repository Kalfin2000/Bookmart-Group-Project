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
like the premium class implements the MemberFunction interface*/
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class Gamer extends Member implements MemberFunction {
    /*the private variable for gamer charge is stored here
    the gamer subscription will be charaged 7.99*/
    private double gamerCharge = 7.99;
    /*the max number of games a gamer subscription 
    can rent is 2*/
    private int gamerRentMax = 1;
    
    /*constructor which passes in the variables from main class
    as well as passes in the variables from the parent class so that 
    they can be used in this class*/
    public Gamer(String buff, String pw, int uid, subType type, String fName, String lName, String mid, String e,  String pid, String ppw) {
        super(buff, pw, uid, type, fName, lName, mid, e, pid, ppw);
        
    }
    /*set methods for the student charge and the student rent number
    these methods bring in the variable and assign it to the 
    private variables that are stored in this class*/
    
    public void setGamerCharge(double charge)
    {
        gamerCharge = charge;
    }
    public void setGamerRentNum(int num)
    {
        gamerRentMax = num;
    }
    /*these are the get methods which return 
     the private variables by calling on 
    the getmethod they are assigned to */
    public double getGamerCharge()
    {
        return gamerCharge;
    }
    
    public double getGamerRentNum()
    {
        return gamerRentMax;
    }
    

}
