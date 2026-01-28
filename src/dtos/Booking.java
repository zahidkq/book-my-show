package dtos;

public class Booking {
    private String userName;
    private String showName;
    private int bookingID;
    private String slotTime;
    private int persons;

    public Booking(int bookingID, String userName, String showName, String slotTime, int persons){
        this.bookingID = bookingID;
        this.userName = userName;
        this.showName = showName;
        this.slotTime = slotTime;
        this.persons = persons;
    }
    public int getBookingID() {
        return bookingID;
    }

    public String getUserName() {
        return userName;
    }

    public String getShowName() {
        return showName;
    }

    public String getSlotTime() {
        return slotTime;
    }

    public int getPersons() {
        return persons;
    }
}
