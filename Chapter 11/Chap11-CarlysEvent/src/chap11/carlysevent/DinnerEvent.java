package chap11.carlysevent;

public class DinnerEvent extends Event {
    
    public final static String[] entrees = {"Prime Rib", "Lobster", "Catfish", 
                                            "Lasagna"};
    public final static String[] sides = {"Mashed Potatoes", "Green Beans", 
                                           "Mac-N-Cheese", "Caesar Salad"};
    public final static String[] desserts = {"Pumpkin Pie", "Reese's Cake", 
                                             "Strawberry Cheesecake"};
    
    private int entree;
    private int side1;
    private int side2;
    private int dessert;
    private final Employee[] employees = new Employee[15];
    
    // Constructors
    public DinnerEvent(String eventNum, int numOfGuests, String phoneNumber, 
            int eventType, int entree, int side1, int side2, int dessert) {
        
        super(eventNum, numOfGuests, phoneNumber, eventType);
        setEntree(entree);
        setSide1(side1);
        setSide2(side2);
        setDessert(dessert);
    }
    
    public DinnerEvent() {
        this("A000", 0, "0000000000", eventTypeDesc.length - 1, 0, 0, 1, 0);
    }
    
    // Mutator methods
    public void setEntree(int entree) {
        this.entree = entree;
    }
    
    public void setSide1(int side1) {
        this.side1 = side1;
    }
    
    public void setSide2(int side2) {
        this.side2 = side2;
    }
    
    public void setDessert(int dessert) {
        this.dessert = dessert;
    }
    
    public void setEmployee(int employeeType, int employeeNum, int employeeID, 
                            String first, String last, double pay) {
        
        switch (employeeType) {
            case 2:
                employees[employeeNum - 1] = new Coordinator(employeeID, first, last, 
                        pay);
                break;
            case 1:
                employees[employeeNum - 1] = new Bartender(employeeID, first, last, 
                        pay);
                break;
            default:
                employees[employeeNum - 1] = new Waitstaff(employeeID, first, last, 
                        pay);
                break;
        }
    }
    
    // Accessor methods
    public String getEntree() {
        return entrees[entree];
    }
    
    public String getSide1() {
        return sides[side1];
    }
    
    public String getSide2() {
        return sides[side2];
    }
    
    public String getDessert() {
        return desserts[dessert];
    }
    
    public String getMenu() {
        return "Dinner selection:\n" + "Entree:\n" + getEntree() + "\nSides:\n"
                + getSide1() + "\n" + getSide2() + "\n" + "Dessert:\n" 
                + getDessert() + "\n";
    }
    
    public Employee[] getEmployees() {
        return employees;
    }
    
    public String getEmployeesInfo() {
        String employeeInfo = "Employees:\n";
        
        for (int i = 0; i < employees.length; i++) {
            try {
                employeeInfo += "ID#" + employees[i].getEmployeeID()
                    + ": " + employees[i].getFirstName() + " " 
                    + employees[i].getLastName() 
                    + " paid " + employees[i].getPayRate() + " per hour as "
                    + employees[i].getJobTitle() + "\n";
            }
            catch (NullPointerException err) {
                return employeeInfo;
            }
        }
        return employeeInfo;
    }
    
}
