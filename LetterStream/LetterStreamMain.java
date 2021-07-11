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
public class LetterStreamMain {
    public static void main(String[] args) {
        String str1 = "GitHub";
        boolean s1 = LetterDao.isitLetter(str1);
        System.out.println("Input: " + str1);
        System.out.println("Output: " + s1);
        
        String str2 = "Git13Hub";
        boolean s2 = LetterDao.isitLetter(str2);
        System.out.println("Input: " + str2);
        System.out.println("Output: " + s2);
}
}
