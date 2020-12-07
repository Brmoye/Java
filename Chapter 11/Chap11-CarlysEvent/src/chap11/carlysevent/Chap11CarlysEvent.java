/*
 * Author: Brian Moye
 * Date: 2020/12/06
 * Program: Chap11-CarlysEvent
 * Purpose: Modifies Carlys Event to add a DinnerEvent class and use it.
 */
package chap11.carlysevent;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Chap11CarlysEvent {
    
    static DecimalFormat currency = new DecimalFormat("$###,###,###,##0.00");
    static DecimalFormat people = new DecimalFormat("###,###,##0");
    static int exit = 0;
    
    public static void main(String[] args) {
//        DinnerEvent[] dinnerEvents = new DinnerEvent[4];
        
        DinnerEvent dinnerEvent = new DinnerEvent(getEventNumber(), 
            getNumOfGuests(), getPhoneNumber(), getEventType(), getEntree(), 
            getSide1(), getSide2(), getDessert());


//      Test Events
//        dinnerEvents[0] = new DinnerEvent("B232", 11, "(555)555-5555", 2, 0, 0, 
//                                          1, 1);

        
        Event.displayMotto();
        
//        while(exit != 1) {
//            displayEventInfoArray(dinnerEvents);
//            pickSort(dinnerEvents);
//        }
    }
    
    public static int getNumOfGuests() {
        int inputInt;
        
        String inputStr = JOptionPane.showInputDialog(null,
            "Enter the number of guests:", "Guest Entry", 
            JOptionPane.QUESTION_MESSAGE);
        
        inputInt = Integer.parseInt(inputStr);
        
        if( inputInt < 5 || inputInt > 100 ) {
            JOptionPane.showMessageDialog(null,
                "Number of guests must be between 5 and 100",
                "Guest Entry", 
                JOptionPane.INFORMATION_MESSAGE);
            inputInt = getNumOfGuests();
        }
        
        return inputInt;
    }
    
    public static String getEventNumber() {
        String inputStr = JOptionPane.showInputDialog(null, 
            "Enter the event number:", "Event Number Entry", 
            JOptionPane.QUESTION_MESSAGE);
        
        return inputStr;
    }
    
    public static String getPhoneNumber() {
        String inputStr = JOptionPane.showInputDialog(null, 
            "Enter a contact phone number:", "Phone Number Entry", 
            JOptionPane.QUESTION_MESSAGE);
        
        return inputStr;
    }
    
    public static int getEventType() {
        String inputStr = JOptionPane.showInputDialog(null, 
            "Please enter the number of the corresponding event type:\n" 
            + "0 - Wedding\n" + "1 - Baptism\n" + "2 - Birthday\n" 
            + "3 - Corporate\n" + "4 - Other", 
            "Event Type Entry", JOptionPane.QUESTION_MESSAGE);
        
        return Integer.parseInt(inputStr);
    }
    
    public static int getEntree() {
        String inputStr = JOptionPane.showInputDialog(null, 
            "Please enter the number of the corresponding entree:\n" 
            + "0 - Prime Rib\n" + "1 - Lobster\n" + "2 - Catfish\n" 
            + "3 - Lasagna\n", 
            "Entree Entry", JOptionPane.QUESTION_MESSAGE);
        
        return Integer.parseInt(inputStr);
    }
    
    public static int getSide1() {
        String inputStr = JOptionPane.showInputDialog(null, 
            "Please enter the number for the first side choice:\n" 
            + "0 - Mashed Potatoes\n" + "1 - Green Beans\n" 
            + "2 - Mac-N-Cheese\n" + "3 - Caesar Salad\n", 
            "First Side Entry", JOptionPane.QUESTION_MESSAGE);
        
        return Integer.parseInt(inputStr);
    }
    
    public static int getSide2() {
        String inputStr = JOptionPane.showInputDialog(null, 
            "Please enter the number for the second side choice:\n" 
            + "0 - Mashed Potatoes\n" + "1 - Green Beans\n" 
            + "2 - Mac-N-Cheese\n" + "3 - Caesar Salad\n", 
            "First Side Entry", JOptionPane.QUESTION_MESSAGE);
        
        return Integer.parseInt(inputStr);
    }
    
    public static int getDessert() {
        String inputStr = JOptionPane.showInputDialog(null, 
            "Please enter the number of the corresponding dessert:\n" 
            + "0 - Pumpkin Pie\n" + "1 - Reese's Cake\n" 
            + "2 - Strawberry Cheesecake\n", "First Side Entry", 
            JOptionPane.QUESTION_MESSAGE);
        
        return Integer.parseInt(inputStr);
    }
    
    public static DinnerEvent[] sortEventByEventNum(DinnerEvent[] event) {
        int outerCount = 1;
        int innerCount;
        DinnerEvent tempEvent;
        
        while(outerCount < event.length) {
            tempEvent = event[outerCount];
            innerCount = outerCount - 1;
            while(innerCount >= 0 && event[innerCount].getEventNum()
                    .compareTo(tempEvent.getEventNum()) > 0) {
                event[innerCount + 1] = event[innerCount];
                innerCount--;
            }
            event[innerCount + 1] = tempEvent;
            outerCount++;
        }
        return event;
    }
    
    public static DinnerEvent[] sortEventByGuests(DinnerEvent[] event) {
        int outerCount = 1;
        int innerCount;
        DinnerEvent tempEvent;
        
        while(outerCount < event.length) {
            tempEvent = event[outerCount];
            innerCount = outerCount - 1;
            while(innerCount >= 0 && event[innerCount].getNumOfGuests() 
                    > tempEvent.getNumOfGuests()) {
                event[innerCount + 1] = event[innerCount];
                innerCount--;
            }
            event[innerCount + 1] = tempEvent;
            outerCount++;
        }
        return event;
    }
    
    public static DinnerEvent[] sortEventByEventType(DinnerEvent[] event) {
        int outerCount = 1;
        int innerCount;
        DinnerEvent tempEvent;
        
        while(outerCount < event.length) {
            tempEvent = event[outerCount];
            innerCount = outerCount - 1;
            while(innerCount >= 0 && event[innerCount].getEventTypeInt()
                    > tempEvent.getEventTypeInt()) {
                event[innerCount + 1] = event[innerCount];
                innerCount--;
            }
            event[innerCount + 1] = tempEvent;
            outerCount++;
        }
        return event;
    }
    
    public static void pickSort(DinnerEvent[] events) {
        
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Sort by:\n" + "0 - Event Number\n" + "1 - Number of Guests\n" 
                + "2 - Event Type\n" + "9 - Exit", "Event Sort Options", 
                JOptionPane.INFORMATION_MESSAGE));
        switch (choice) {
            case 0:
                sortEventByEventNum(events);
                break;
            case 2:
                sortEventByEventType(events);
                break;
            case 9:
                exit = 1;
                break;
            default:
                sortEventByGuests(events);
                break;
        }
    }
    
    public static Event getSmaller(DinnerEvent event1, DinnerEvent event2) {
        if (event1.getNumOfGuests() > event2.getNumOfGuests()) {
            return event2;
        }
        else {
            return event1;
        }
    }
    
    public static DinnerEvent getBigger(DinnerEvent event1, DinnerEvent event2) {
        
        if (event1.getNumOfGuests() > event2.getNumOfGuests()) {
            JOptionPane.showMessageDialog(null, "First event number: " 
                + event1.getEventNum() + "\nNumber of guests: " 
                + event1.getNumOfGuests() + "\n\nSecond event number: " 
                + event2.getEventNum() + "\nNumber of guests: " 
                + event2.getNumOfGuests() + "\n\nLarger event: " 
                + event1.getEventNum() + "\nNumber of guests: " 
                + event1.getNumOfGuests(), "Carly's Event Details", 
                JOptionPane.INFORMATION_MESSAGE);
            return event1;
        }
        else {
            JOptionPane.showMessageDialog(null, "First event number: " 
                + event1.getEventNum() + "\nNumber of guests: " 
                + event1.getNumOfGuests() + "\n\nSecond event number: " 
                + event2.getEventNum() + "\nNumber of guests: " 
                + event2.getNumOfGuests() + "\n\nLarger event: " 
                + event2.getEventNum() + "\nNumber of guests: " 
                + event2.getNumOfGuests(), "Carly's Event Details", 
                JOptionPane.INFORMATION_MESSAGE);
            return event2;
        }
    }
    
    public static void displayEventInfoArray(DinnerEvent[] events) {
        String theMessage = "";
        
        // For each event in events[]
        for (DinnerEvent event : events) {
            theMessage += displayEventInfo(event) + event.getMenu() + "\n";
        }
        
        JOptionPane.showMessageDialog(null, theMessage, "Carly's Event Details",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static String displayEventInfo(DinnerEvent event) {
        String message = "";
        
        message += "The contact phone number for event #"+ event.getEventNum() 
            + " is " + event.getPhoneNumber() + ".\nThe cost for a(n) " 
            + event.getEventType() + " event with "
            + people.format(event.getNumOfGuests()) + " guests will be " 
            + currency.format(event.getPrice()) + ".\nThe cost per guest is: "
            + currency.format(event.getPricePerGuest())
            + "\nLarge Event: " + event.isLargeEvent() + "\n";
        
//        JOptionPane.showMessageDialog(null, message, "Carly's Event Details",
//                JOptionPane.INFORMATION_MESSAGE);
        return message;
    }
}
