package mini.service;

import mini.entity.SkiEquipment;

import java.util.List;

public interface SkiEquipmentService {
    // 스키 장비 등록 메서드
    void registerSkiEquipment(String equipment_id, String user_id, String equipment_name, String description,
                              String condition, String image_url);

    // 스키 장비 정보 확인 메서드
    SkiEquipment getSkiEquipmentInfo(String equipment_id);

    // 스키 장비 상태 확인 메서드
    String getSkiEquipmentCondition(String equipment_id);

    // 특정 이름의 스키 장비 정보 확인 메서드
    SkiEquipment getSelectedSkiEquipment(String equipment_id, String equipment_name);

    // 스키 장비 대여 추가 메서드
    void addSkiEquipmentRental(String equipment_id, String user_id);

    // 스키 장비 대여 삭제 메서드
    void deleteSkiEquipmentRental(String equipment_id, String user_id);

    // 스키 대여 리스트 출력 메서드
    List<SkiEquipment> getSkiRentalList();

    // 특정 사용자가 대여한 스키 장비 목록을 가져오는 메서드
    List<SkiEquipment> getUserRentedSkiEquipment(String user_id);

    // 스키 장비 대여 가능 여부를 확인하는 메서드
    boolean isSkiEquipmentAvailable(String equipment_id);

    // 대여 중인 스키 장비 목록을 가져오는 메서드
    List<SkiEquipment> getRentedSkiEquipmentList();

    // 스키 장비 정보 업데이트 메서드
    void updateSkiEquipment(String equipment_id, String user_id, String equipment_name, String description,
                            String condition, String image_url);

    // 스키 장비 삭제 메서드
    void deleteSkiEquipment(String equipment_id);
}