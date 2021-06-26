/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

/**
 *
 * @author gt
 */
public class MainClass {
    public static void main(String[] args){
        ExtendThread s1 = new ExtendThread("Thread object 1");
        ExtendThread s2 = new ExtendThread("Thread object 2");
        ImplementRunnable R = new ImplementRunnable("Test");
        
        Thread th = new Thread(R);
    
        s1.start();
        s2.start();
        th.start();
    
        System.out.println("From main");
    }
    

}
