package mini.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import mini.entity.Rental;

public interface RentalService {
    public static final int RENTAL_SUCCESSFUL = 0;
    public static final int ITEM_NOT_AVAILABLE = 1;
    public static final int USER_NOT_EXIST = 2;
    public static final int RETURN_SUCCESSFUL = 3;
    public static final int COUNT_PER_PAGE = 10;

    Rental getRentalById(String rentalId);

    List<Rental> getRentalList(int page);

    int getRentalCount();

    void rentItem(String userId, String equipmentId, LocalDateTime startDate, LocalDateTime endDate, BigDecimal totalPrice);

    void returnItem(String rentalId);
    
    void rentAndPay(String userId, String equipmentId, LocalDateTime startDate, LocalDateTime endDate, BigDecimal totalPrice);

    void addRental(Rental rental);

    void updateRental(Rental rental);

    void deleteRental(String rentalId);

    void close();
}
