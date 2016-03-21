/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Strongestislander
 */
/*this is the user class which stores the ID, pw, and UserID*/
public class User {
    private String id;
    private String password;
    private int UserID;
    
    public User(String buff, String pw, int uid)
    {
        /*constructor which sets the variables for ID, password, and userid
        which were passed in from main*/
        setId(buff);
        setPassword(pw);
        setUserID(uid);
    }
    /*set methods which assign the variables passed in
    to the private variables that are stored in this class*/
    public void setId(String buff)
    {
        id = buff;
    }
    
    public void setPassword(String pw)
    {
        password = pw;
    }
    
    public void setUserID(int uid)
    {
        UserID = uid;
    }
    /*get mehtods which return the private variables in this
    class by using the return methods which will be called
    in other classes*/
    public String getId()
    {
        return id;
    }
    
    public int getUserID()
    {
        return UserID;
    }
    
    public String getPassword()
    {
        return password;
    }
    /*determins if the user info submitted is valid or not*/
    public boolean isUser(String buff, String pw)
    {
        if ((buff.equals(id)) && (pw.equals(password)))
            return true;
        else 
            return false;
    }
    
    public void userInfo()
    {
        /*outputs the users id password and userid to the 
        screen*/
        System.out.println(id +" "+ password +" " + UserID);
    }

    
    
}
