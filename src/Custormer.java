/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author hiuhihi78
 */
public class Custormer {
    
    private String ID;
    private String Name;
    private String Number;

    public Custormer() {
    }

    public Custormer(String ID, String Name, String Number) {
        this.ID = ID;
        this.Name = Name;
        this.Number = Number;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    
    
    @Override
    public String toString() {
        String s = String.format("%-10s | %-10s | %-10s", ID,Name,Number);
        return s;
    }
    
    
}
