package mini.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import mini.dao.RentalDao;
import mini.entity.Rental;

public class RentalServiceImpl implements RentalService {
    private RentalDao rDao = new RentalDao();

    @Override
    public Rental getRentalById(String rentalId) {
        return rDao.getRentalById(rentalId);
    }

    @Override
    public List<Rental> getRentalList(int page) {
        return rDao.getRentalList(page);
    }

    @Override
    public int getRentalCount() {
        return rDao.getRentalCount();
    }

    @Override
    public void rentItem(String userId, String equipmentId, LocalDateTime startDate, LocalDateTime endDate, BigDecimal totalPrice) {
        rDao.rentItem(userId, equipmentId, startDate, endDate, totalPrice);
    }

    @Override
    public void returnItem(String rentalId) {
        rDao.returnItem(rentalId);
    }

    @Override
    public void addRental(Rental rental) {
        rDao.addRental(rental);
    }

    @Override
    public void updateRental(Rental rental) {
        rDao.updateRental(rental);
    }

    @Override
    public void deleteRental(String rentalId) {
        rDao.deleteRental(rentalId);
    }

    @Override
    public void close() {
        rDao.close();
    }

    //결제 추가하기
	@Override
	public void rentAndPay(String userId, String equipmentId, LocalDateTime startDate, LocalDateTime endDate,
			BigDecimal totalPrice) {
		// TODO Auto-generated method stub
		
	}
}
