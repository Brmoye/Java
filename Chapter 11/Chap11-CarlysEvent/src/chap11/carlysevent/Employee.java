package chap11.carlysevent;

public abstract class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    protected double payRate;
    protected String jobTitle;
    
    // Constructor
    public Employee(int id, String first, String last) {
        setEmployeeID(id);
        setFirstName(first);
        setLastName(last);
    }
    
    // Mutator methods
    public void setEmployeeID(int id) {
        this.employeeID = id;
    }
    
    public void setFirstName(String name) {
        this.firstName = name;
    }
    
    public void setLastName(String name) {
        this.lastName = name;
    }
    
    public abstract void setPayRate(double pay);
    
    public abstract void setJobTitle();
    
    // Accessor methods
    public int getEmployeeID() {
        return employeeID;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public double getPayRate() {
        return payRate;
    }
    
    public String getJobTitle() {
        return jobTitle;
    }
}
