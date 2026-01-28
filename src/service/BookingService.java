package service;

import dtos.Booking;
import model.LiveShow;
import model.ShowSlot;
import model.WaitList;
import repository.BookingRepository;
import repository.ShowRepository;

import java.util.concurrent.atomic.AtomicInteger;

public class BookingService {
    private AtomicInteger idGen = new AtomicInteger(1000);
    private BookingRepository bookingRepository = BookingRepository.getInstance();
    private ShowRepository showRepository = ShowRepository.getINSTANCE();

    public void book(String user, String showName, String slotTime, int persons){
        LiveShow show = showRepository.getShowByName(showName);
        ShowSlot slot = show.getSlots().get(slotTime);

        if(slot.canBook(persons)){
            slot.book(persons);
            int id = idGen.incrementAndGet();
            bookingRepository.save(new Booking(id, user, showName, slotTime, persons));
            System.out.println("Booked. Booking id: " + id);
        } else {
            slot.getWaitLists().add(new WaitList(user, persons));
            System.out.println("Added to WaitList");
        }
    }
    public void cancel(int bookingID){
        Booking booking = bookingRepository.getByID(bookingID);
        LiveShow show = showRepository.getShowByName(booking.getShowName());
        ShowSlot slot = show.getSlots().get(booking.getSlotTime());

        slot.cancel(booking.getPersons());
        bookingRepository.remove(bookingID);
        System.out.println("Booking Cancelled");

        if(!slot.getWaitLists().isEmpty()){
            WaitList waitList = slot.getWaitLists().poll();
            book(waitList.getUserName(), show.getShowName(), slot.getStartTime(), waitList.getPersons());
        }
    }
}
