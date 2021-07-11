/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LetterStream;

/**
 *
 * @author gt
 */
public class LetterDao {

    public LetterDao() {
    }
    
    public static boolean isitLetter(String str){
        return ((str!=null)
                &&(!(str.equals("")))
                &&(str.chars().allMatch(Character::isLetter)));
}
}
