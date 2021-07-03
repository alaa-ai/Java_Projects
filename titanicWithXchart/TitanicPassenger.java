/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package titanicWithXchart;

/**
 *
 * @author gt
 */
public class TitanicPassenger {
    private String pclass;
    private String survived;
    private String name;
    private String sex;
    private float age;
    private String sibsp;
    private String parch ;
    private String ticket;
    private float fare;
    private String cabin;
    private String embarked;
    private String boat;
    private String body;
    private String home_dest;

    public String getPclass() {
        return pclass;
    }

    public String getSurvived() {
        return survived;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public float getAge() {
        return age;
    }

    public String getSibsp() {
        return sibsp;
    }

    public String getParch() {
        return parch;
    }

    public String getTicket() {
        return ticket;
    }

    public float getFare() {
        return fare;
    }

    public String getCabin() {
        return cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public String getBoat() {
        return boat;
    }

    public String getBody() {
        return body;
    }

    public String getHome_dest() {
        return home_dest;
    }

    public void setPclass(String pclass) {
        this.pclass = pclass;
    }

    public void setSurvived(String survived) {
        this.survived = survived;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public void setSibsp(String sibsp) {
        this.sibsp = sibsp;
    }

    public void setParch(String parch) {
        this.parch = parch;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public void setEmbarked(String embarked) {
        this.embarked = embarked;
    }

    public void setBoat(String boat) {
        this.boat = boat;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setHome_dest(String home_dest) {
        this.home_dest = home_dest;
    }

    @Override
    public String toString() {
        return "TitanicPassenger{" + "pclass=" + pclass + ", survived=" + survived + ", name=" + name + ", sex=" + sex + ", age=" + age + ", sibsp=" + sibsp + ", parch=" + parch + ", ticket=" + ticket + ", fare=" + fare + ", cabin=" + cabin + ", embarked=" + embarked + ", boat=" + boat + ", body=" + body + ", home_dest=" + home_dest + '}';
    }
    


   
    
    
    
}
