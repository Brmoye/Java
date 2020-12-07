package chap11.carlysevent;

import javax.swing.JOptionPane;

public class Bartender extends Employee {
    
    // Constructor
    public Bartender(int id, String first, String last, double pay) {
        super(id, first, last);
        setPayRate(pay);
        setJobTitle();
    }
    
    @Override
    public void setPayRate(double pay) {
        final double maxPay = 14.00;
        
        if (pay > maxPay) {
            pay = maxPay;
        }
        
        payRate = pay;
    }
    
    @Override
    public void setJobTitle() {
        jobTitle = "bartender";
    }
}
