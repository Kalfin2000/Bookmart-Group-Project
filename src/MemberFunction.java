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
    public void rentGame( Game[] game, int gameMax);
    public void returnGame(Game[] game, int gameMax);
    public void searchGame(int gid);
}
