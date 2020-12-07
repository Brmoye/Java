package chap11.carlysevent;

import javax.swing.JOptionPane;

public class Waitstaff extends Employee {
    
    // Constructor
    public Waitstaff(int id, String first, String last, double pay) {
        super(id, first, last);
        setPayRate(pay);
        setJobTitle();
    }
    
    @Override
    public void setPayRate(double pay) {
        final double maxPay = 10.00;
        
        if (pay > maxPay) {
            pay = maxPay;
        }
        
        payRate = pay;
    }
    
    @Override
    public void setJobTitle() {
        jobTitle = "waitstaff";
    }
}
