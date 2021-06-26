/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cut;

/**
 *
 * @author gt
 */
public class MainClass {
    public static void main(String args[]){
        IpCutter ip1 = new IpCutter("163.121.12.30");
        ip1.setIp( "163.121.12.30");
        System.out.println(ip1.getIp());
        System.out.println(ip1.doCutting());
}
}
