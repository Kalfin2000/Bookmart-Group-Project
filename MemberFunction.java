/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Strongestislander
 */
//interface functions that are used in the program
public interface MemberFunction {
    public void rentBook( Book[] book, int bookMax);
    public void returnBook(Book[] book, int bookMax);
    public void searchBook(int gid);
}
