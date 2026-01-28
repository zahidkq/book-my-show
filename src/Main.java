import enums.Genre;
import service.BookingService;
import service.ShowService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ShowService showService = new ShowService();
        BookingService bookingService = new BookingService();
        showService.registerShow("TMKOC", Genre.COMEDY);
        showService.onboardShowSlots("TMKOC",
                Arrays.asList(new Object[]{"9:00", "10:00", 3},
                              new Object[]{"12:00","13:00",2},
                              new Object[]{"15:00","16:00",5}
                )
        );
        bookingService.book("UserA", "TMKOC", "12:00", 2);
        bookingService.cancel(1001);
    }
}