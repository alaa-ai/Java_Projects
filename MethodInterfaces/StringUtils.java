/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MethodInterfaces;

import java.util.function.BiPredicate;

/**
 *
 * @author gt
 */
public class StringUtils {
    public static String betterString(String s1, String s2 , BiPredicate<String, String> p){
        {
            if (p.test(s1, s2))
            {
                return s1;  
            } else {
                return s2;
            }
    }
   }
          
    public static void main(String[] args){
        String string1 = new String("Hi");
        String string2 = new String("Hello");
        

        
    
        String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
        System.out.println(longer);
        
        String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);
        System.out.println(first);
        
       
        
    }
}

