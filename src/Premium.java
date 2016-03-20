/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Strongestislander
 */
/*this is the premium member class */
import java.util.Date;
import java.util.Scanner;
public class Premium extends Member implements MemberFunction //child class of member and implements memberFunction interface
{
    /*the premium charge variable is the amount that a premium user
    pays when subscribing for this type of subscription*/
    private double premiumCharge = 9.99;
    private int premiumRentMax = 4;
    /*rentMax is the total number of books that the premium user
    can rent from the program*/
    
    /*constructor which passes in the variables from main and assignes them, as well as
    passes in variables from the parent class and assigns them*/
    public Premium(String buff, String pw, int uid, subType type, String fName, String lName, String mid, String e, String pid, String ppw) {
        super(buff, pw, uid, type, fName, lName, mid, e,  pid, ppw);
    }
    /*these are the set methods for premium chargea and premium rent number
    in these methods the variables are set to the private variables in this class*/
    public void setPremiumCharge(double charge)
    {
        premiumCharge = charge;
    }
    
    public void setPremiumRentNum(int num)
    {
        premiumRentMax = num;
    }
    /*in these get methods the premium charge and premium rent number private
    variables are returned by calling on the get methods*/
    public double getPremiumCharge()
    {
        return premiumCharge;
    }
    
    public double getPremiumRentNum()
    {
        return premiumRentMax;
    }

    
    @Override
    public void searchGame(int gid) 
    {
        
    }
    
}
