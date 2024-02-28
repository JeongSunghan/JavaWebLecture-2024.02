package mini.entity;

public class SkiEquipment {
	private String equipment_id;
	private String user_id;
	private String equipment_name;
	private String description;
	private String condition;
	private String image_url;

	
	//기본 생성자
	public SkiEquipment() {}
	public SkiEquipment(String equipment_id, String user_id, String equipment_name, String description,
			String condition, String image_url) {
		this.equipment_id = equipment_id;
		this.user_id = user_id;
		this.equipment_name = equipment_name;
		this.description = description;
		this.condition = condition;
		this.image_url = image_url;
	}
	
	//스키 장비 선택 생성자
	public SkiEquipment(String equipment_id, String equipment_name) {
		this.equipment_id = equipment_id;
		this.equipment_name = equipment_name;
	}
	
	
	//스키 장비 생김새/설명 및 내구성 생성자
	public SkiEquipment(String description, String condition, String image_url) {
		this.description = description;
		this.condition = condition;
		this.image_url = image_url;
	}
	

	//대여한걸 수정하고 싶을 때 확인할 생성자 
	public SkiEquipment(String user_id) {
		this.user_id = user_id;
	}
	
	@Override
	public String toString() {
		return "Ski_Equipment [equipment_id=" + equipment_id + ", user_id=" + user_id + ", equipment_name="
				+ equipment_name + ", description=" + description + ", condition=" + condition + ", image_url="
				+ image_url + "]";
	}

	public String getEquipment_id() {
		return equipment_id;
	}

	public void setEquipment_id(String equipment_id) {
		this.equipment_id = equipment_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getEquipment_name() {
		return equipment_name;
	}

	public void setEquipment_name(String equipment_name) {
		this.equipment_name = equipment_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

}
