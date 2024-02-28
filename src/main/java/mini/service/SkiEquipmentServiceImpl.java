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
    public SkiEquipment getSkiEquipmentInfo(String equipment_id) {
        return skiEquipmentDao.getSkiEquipmentInfo(equipment_id);
    }

    @Override
    public String getSkiEquipmentCondition(String equipment_id) {
        return skiEquipmentDao.getSkiEquipmentCondition(equipment_id);
    }

    @Override
    public SkiEquipment getSelectedSkiEquipment(String equipment_id, String equipment_name) {
        return skiEquipmentDao.getSelectedSkiEquipment(equipment_id, equipment_name);
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
    public List<SkiEquipment> getSkiRentalList() {
        return skiEquipmentDao.getSkiRentalList();
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
    public List<SkiEquipment> getRentedSkiEquipmentList() {
        return skiEquipmentDao.getRentedSkiEquipmentList();
    }

    @Override
    public void updateSkiEquipment(String equipment_id, String user_id, String equipment_name, String description,
                                    String condition, String image_url) {
        skiEquipmentDao.updateSkiEquipment(equipment_id, user_id, equipment_name, description, condition, image_url);
    }

    @Override
    public void deleteSkiEquipment(String equipment_id) {
        skiEquipmentDao.deleteSkiEquipment(equipment_id);
    }
}