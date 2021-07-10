/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spktest;

/**
 *
 * @author gt
 */
public class SPKDAO {

    public SPKDAO() {
    }
    private static final String COMMA_DELIMITER = ",";
    public static String extractTitle(String videoLine) {
        try {
            return videoLine.split (COMMA_DELIMITER)[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
    }

    public static String extractTags(String line) {
        try {
            return line.split (COMMA_DELIMITER)[6];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
        
    }
    
}
