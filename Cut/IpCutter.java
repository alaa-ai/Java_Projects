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
public class IpCutter {
    private String ip;

    public IpCutter(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
 
    String doCutting(){
        String[] parts = ip.split("\\.");
        if (parts.length != 4){
            return "Error in input";
        }
        else{
            return parts[0]+"\n"+parts[1]+"\n"+parts[2]+"\n"+parts[3];
        }
       
    }

    @Override
    public String toString() {
        return "IpCutter{" + "ip=" + ip + '}';
    }

    
}
