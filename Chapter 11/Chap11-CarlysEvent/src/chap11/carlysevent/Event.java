package chap11.carlysevent;

import javax.swing.JOptionPane;

public class Event {
    public final static double PRICE_PER_GUEST_LARGE = 32.00;
    public final static double PRICE_PER_GUEST_SMALL = 35.00;
    public final static int LARGE_EVENT_CUTOFF = 50;
    public final static String[] eventTypeDesc ={"wedding", "baptism", 
                                    "birthday", "corporate", "other"};
    
    private String eventNum;
    private String contactPhoneNumber = "";
    private int numOfGuests;
    private double price, pricePerGuest;
    private boolean eventSize;
    private int eventType;
    
    public Event(String eventNum, int numOfGuests, String phoneNumber, 
            int eventType) {
        setEventNum(eventNum);
        setGuests(numOfGuests);
        setPhoneNumber(phoneNumber);
        setEventType(eventType);
    }
    
    public Event() {
        this("A000", 0, "0000000000", eventTypeDesc.length - 1);
    }
    
    // Mutator methods
    public void setEventNum(String newEventNum) {
        // Check if the event number starts with a letter and has only 
        //  3 numbers after it.
        if (newEventNum.length() == 4 
            && Character.isAlphabetic(newEventNum.charAt(0))
            && Character.isDigit(newEventNum.charAt(1))
            && Character.isDigit(newEventNum.charAt(2))
            && Character.isDigit(newEventNum.charAt(3))) {
                eventNum = newEventNum;
                // Capitalize the letter, just in case.
                eventNum = Character.toUpperCase(newEventNum.charAt(0)) 
                        + newEventNum.substring(1);
        }
        else {
            eventNum = "A000";
        }
    }
    
    public void setGuests(int numOfGuests) {
        this.numOfGuests = numOfGuests;
        
        if (isLargeEvent()) {
            pricePerGuest = PRICE_PER_GUEST_LARGE;
        }
        
        else {
            pricePerGuest = PRICE_PER_GUEST_SMALL;
        }
        
        price = numOfGuests * pricePerGuest;
    }
    
    public void setPhoneNumber(String newContact) {
        contactPhoneNumber = "";
        
        for (int i =0; i < newContact.length(); i++) {
            if (Character.isDigit(newContact.charAt(i))) {
                contactPhoneNumber += newContact.charAt(i);
            }
        }
        
        if (contactPhoneNumber.length() > 10 || contactPhoneNumber.length() 
                < 10) {
            contactPhoneNumber = "0000000000";
        }
    }
    
    public void setEventType(int evt) {
        if (evt >= 0 && evt <= eventTypeDesc.length - 1) {
            eventType = evt;
        }
        else {
            eventType = eventTypeDesc.length - 1;
        }
    }
    
    // Accessor methods
    public String getEventNum() {
        return eventNum;
    }
    
    public int getNumOfGuests() {
        return numOfGuests;
    }
    
    public double getPrice() {
        return price;
    }
    
    public boolean isLargeEvent() {
        eventSize = numOfGuests > LARGE_EVENT_CUTOFF;
        return eventSize;
    }
    
    public double getPricePerGuest() {
        return pricePerGuest;
    }
    
    public String getPhoneNumber() {
        return "(" + contactPhoneNumber.substring(0,3) + ") " 
            + contactPhoneNumber.substring(3,6) + "-" 
            + contactPhoneNumber.substring(6, 10);
    }
    
    public String getEventType() {
        return eventTypeDesc[eventType];
    }
    
    public int getEventTypeInt() {
        return eventType;
    }
    
    public static void displayMotto() {
        JOptionPane.showMessageDialog(null,
        "******************************************************\n"
        + "* Carly's makes the food that makes it a party. *\n"
        + "******************************************************", 
        "Carly's Motto", JOptionPane.INFORMATION_MESSAGE);
    }
}
