package mini.service;

public interface SkiEquipmentService {
	
    // 스키 장비 등록 메서드
    void registerSkiEquipment(String equipment_id, String user_id, String equipment_name, String description,
                              String condition, String image_url);

    // 스키 장비 정보 확인 메서드
    void printSkiEquipmentInfo(String equipment_id);

    // 스키 장비 상태 및 설명 확인 메서드
    void printSkiEquipmentCondition(String equipment_id);

    // 스키 장비 선택 확인 메서드
    void printSelectedSkiEquipment(String equipment_id, String equipment_name);

    // 스키 장비 대여 추가 메서드
    void addSkiEquipmentRental(String equipment_id, String user_id);

    // 스키 장비 대여 삭제 메서드
    void deleteSkiEquipmentRental(String equipment_id, String user_id);
}
