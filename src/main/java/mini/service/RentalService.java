package mini.service;

import java.time.LocalDateTime;
import java.util.List;

import mini.entity.Rentals;

public interface RentalService {
    // 대여 등록 메서드
    void registerRental(String rental_id, String user_id, String equipment_id, LocalDateTime start_date,
                        LocalDateTime end_date, int total_price, int payment_status);

    // 대여 정보 확인 메서드
    void printRentalInfo(String rental_id, String user_id, String equipment_id);

    // 대여 기간 확인 메서드
    void printRentalPeriod(LocalDateTime end_date, int total_price);

    // 가격 확인 메서드
    void printRentalPrice(String rental_id);

    // 대여 상태 확인 메서드
    void printRentalStatus(String rental_id);

    // 대여 목록 가져오는 메서드
    List<Rentals> getRentalList();

    // 대여 목록 출력하는 메서드
    void printRentalList();
}
