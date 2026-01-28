package repository;


import dtos.Booking;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookingRepository {
    private static BookingRepository INSTANCE = new BookingRepository();;
    private Map<Integer, Booking> bookingMap;

    private BookingRepository(){
        bookingMap = new HashMap<>();
    }

    public static BookingRepository getInstance(){
        return INSTANCE;
    }
    public void save(Booking booking){
        bookingMap.put(booking.getBookingID(), booking);
    }
    public void remove(int id){
        bookingMap.remove(id);
    }
    public Booking getByID(int id){
        return bookingMap.get(id);
    }
    public Collection<?> getAllBookings(){
        return bookingMap.values();
    }
}
