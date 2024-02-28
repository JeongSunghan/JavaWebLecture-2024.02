package mini.service;

import mini.entity.SkiEquipment;

import java.util.List;

public interface SkiEquipmentService {
    static final int COUNT_PER_PAGE = 10;

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

    // 스키 대여 리스트 출력 메서드
    void printSkiRentalList();

    // 특정 사용자가 대여한 스키 장비 목록을 가져오는 메서드
    List<SkiEquipment> getUserRentedSkiEquipment(String user_id);

    // 스키 장비 대여 가능 여부를 확인하는 메서드
    boolean isSkiEquipmentAvailable(String equipment_id);

    // 대여 기간이 만료된 스키 장비를 자동으로 반납하는 메서드
    void autoReturnExpiredSkiEquipment();

    // 대여 중인 스키 장비 목록을 가져오는 메서드
    List<SkiEquipment> getRentedSkiEquipmentList();

    
    //에러로 인한 추가
	SkiEquipment getSkiEquipmentInfo(String equipment_id);

	void updateSkiEquipment(String equipment_id, String user_id, String equipment_name, String description,
			String condition, String image_url);

	void deleteSkiEquipment(String equipment_id);
}
