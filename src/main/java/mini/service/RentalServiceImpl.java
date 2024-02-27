package mini.service;

import java.time.LocalDateTime;
import java.util.List;

import mini.entity.Rentals;

public class RentalServiceImpl implements RentalService {

	@Override
	public void registerRental(String rental_id, String user_id, String equipment_id, LocalDateTime start_date,
			LocalDateTime end_date, int total_price, int payment_status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printRentalInfo(String rental_id, String user_id, String equipment_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printRentalPeriod(LocalDateTime end_date, int total_price) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printRentalPrice(String rental_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printRentalStatus(String rental_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Rentals> getRentalList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printRentalList() {
		// TODO Auto-generated method stub
		
	}

}
