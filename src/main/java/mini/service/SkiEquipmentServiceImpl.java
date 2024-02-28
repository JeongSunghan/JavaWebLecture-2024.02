package mini.service;

import mini.dao.SkiEquipmentDao;
import mini.entity.SkiEquipment;

import java.util.List;

public class SkiEquipmentServiceImpl implements SkiEquipmentService {
	private SkiEquipmentDao skiEquipmentDao;

	public SkiEquipmentServiceImpl() {
		this.skiEquipmentDao = new SkiEquipmentDao();
	}

	@Override
	public void registerSkiEquipment(String equipment_id, String user_id, String equipment_name, String description,
			String condition, String image_url) {
		skiEquipmentDao.registerSkiEquipment(equipment_id, user_id, equipment_name, description, condition, image_url);
	}

	@Override
	public void printSkiEquipmentInfo(String equipment_id) {
		SkiEquipment skiEquipment = skiEquipmentDao.getSkiEquipmentInfo(equipment_id);
		if (skiEquipment != null) {
			// TODO: skiEquipment 객체의 정보 출력
		} else {
			// TODO: 해당 장비가 존재하지 않는 경우 처리
		}
	}

	@Override
	public void printSkiEquipmentCondition(String equipment_id) {
		String condition = skiEquipmentDao.getSkiEquipmentCondition(equipment_id);
		if (condition != null) {
			// TODO: condition 출력
		} else {
			// TODO: 해당 장비가 존재하지 않는 경우 처리
		}
	}

	@Override
	public void printSelectedSkiEquipment(String equipment_id, String equipment_name) {
		SkiEquipment skiEquipment = skiEquipmentDao.getSelectedSkiEquipment(equipment_id, equipment_name);
		if (skiEquipment != null) {
			// TODO: 선택된 스키 장비 출력
		} else {
			// TODO: 선택된 장비가 존재하지 않는 경우 처리
		}
	}

	@Override
	public void addSkiEquipmentRental(String equipment_id, String user_id) {
		skiEquipmentDao.addSkiEquipmentRental(equipment_id, user_id);
	}

	@Override
	public void deleteSkiEquipmentRental(String equipment_id, String user_id) {
		skiEquipmentDao.deleteSkiEquipmentRental(equipment_id, user_id);
	}

	@Override
	public void printSkiRentalList() {
		List<SkiEquipment> rentalList = skiEquipmentDao.getSkiRentalList();
		// TODO: 대여 리스트 출력
	}

	@Override
	public List<SkiEquipment> getUserRentedSkiEquipment(String user_id) {
		return skiEquipmentDao.getUserRentedSkiEquipment(user_id);
	}

	@Override
	public boolean isSkiEquipmentAvailable(String equipment_id) {
		return skiEquipmentDao.isSkiEquipmentAvailable(equipment_id);
	}

	@Override
	public void autoReturnExpiredSkiEquipment() {
		skiEquipmentDao.autoReturnExpiredSkiEquipment();
	}

	@Override
	public List<SkiEquipment> getRentedSkiEquipmentList() {
		return skiEquipmentDao.getRentedSkiEquipmentList();
	}

	@Override
	public SkiEquipment getSkiEquipmentInfo(String equipment_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSkiEquipment(String equipment_id, String user_id, String equipment_name, String description,
			String condition, String image_url) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSkiEquipment(String equipment_id) {
		// TODO Auto-generated method stub

	}
}
