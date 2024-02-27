package mini.service;

public interface UserService {
	
    // 사용자 등록 메서드
    void registerUser(int user_id, String username, String password, String email, String phone_number);

    // 사용자 정보 확인 메서드
    void printUserInfo(int user_id);

    // 렌탈, 스키와 유저 아이디가 동일한지 확인하는 메서드
    void checkUserId(int user_id);
}
