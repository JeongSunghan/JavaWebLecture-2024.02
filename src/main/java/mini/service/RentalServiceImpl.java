package mini.service;

import java.time.LocalDateTime;
import java.util.List;

import mini.dao.RentalsDao;
import mini.entity.Rentals;

public class RentalServiceImpl implements RentalService {
    private RentalsDao rentalsDao;

    public RentalServiceImpl() {
        this.rentalsDao = new RentalsDao();
    }

    @Override
    public void registerRental(String rental_id, String user_id, String equipment_id, LocalDateTime start_date,
            LocalDateTime end_date, int total_price, int payment_status) {
        rentalsDao.registerRental(rental_id, user_id, equipment_id, start_date, end_date, total_price, payment_status);
    }


    @Override
    public void printRentalInfo(String rental_id, String user_id, String equipment_id) {
        rentalsDao.printRentalInfo(rental_id, user_id, equipment_id);
    }

    @Override
    public void printRentalPeriod(LocalDateTime end_date, int total_price) {
        rentalsDao.printRentalPeriod(end_date, total_price);
    }

    @Override
    public void printRentalPrice(String rental_id) {
        rentalsDao.printRentalPrice(rental_id);
    }

    @Override
    public void printRentalStatus(String rental_id) {
        rentalsDao.printRentalStatus(rental_id);
    }

    @Override
    public List<Rentals> getRentalList() {
        return rentalsDao.getRentalsList();
    }

    @Override
    public void printRentalList() {
        rentalsDao.printRentalList();
    }

	@Override
	public void updateRental(String rental_id, String user_id, String equipment_id, LocalDateTime start_date,
			LocalDateTime end_date, int total_price, int payment_status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRental(String rental_id) {
		// TODO Auto-generated method stub
		
	}

	//추가 1
	@Override
	public Rentals getRentalList(String rental_id) {
		// TODO Auto-generated method stub
		return null;
	}
}
