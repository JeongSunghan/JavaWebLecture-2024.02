package mini.service;

import java.time.LocalDateTime;

public interface RentalService {
	
	    // 대여 등록 메서드
	    void registerRental(String rental_id, String user_id, String equipment_id, LocalDateTime start_date,
	                        LocalDateTime end_date, int total_price, int payment_status);

	    // 대여 정보 확인 메서드
	    void printRentalInfo(String rental_id, String user_id, String equipment_id);

	    // 대여 기간 확인 메서드
	    void printRentalPeriod(LocalDateTime end_date, int total_price);
	}



