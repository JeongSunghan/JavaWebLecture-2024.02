package mini.entity;

import java.time.LocalDateTime;

public class Rentals {
	private String rental_id;
	private String user_id;
	private String equipment_id;
	private LocalDateTime start_date;
	private LocalDateTime end_date;
	private int total_price;
	private int payment_status;

	// 기본 생성자
	public Rentals() {};
	public Rentals(String rental_id, String user_id, String equipment_id, LocalDateTime start_date,
			LocalDateTime end_date, int total_price, int payment_status) {
		this.rental_id = rental_id;
		this.user_id = user_id;
		this.equipment_id = equipment_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.total_price = total_price;
		this.payment_status = payment_status;

	}

	//대여상태 확인 생성자
	public Rentals(String rental_id, String user_id, String equipment_id) {
		this.rental_id = rental_id;
		this.user_id = user_id;
		this.equipment_id = equipment_id;
	}
	
	
	//대여 날짜 확인 생성자
	public Rentals(LocalDateTime start_date, LocalDateTime end_date, int total_price) {
		this.start_date = start_date;
		this.end_date = end_date;
		this.total_price = total_price;
	}
	
	

	//대여 가격 확인 및 지불 가격 입력 생성자
	public Rentals(int total_price, int payment_status) {
		super();
		this.total_price = total_price;
		this.payment_status = payment_status;
	}
	

	@Override
	public String toString() {
		return "Rentals [rental_id=" + rental_id + ", user_id=" + user_id + ", equipment_id=" + equipment_id
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", total_price=" + total_price
				+ ", payment_status=" + payment_status + "]";
	}

	public String getRental_id() {
		return rental_id;
	}

	public void setRental_id(String rental_id) {
		this.rental_id = rental_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getEquipment_id() {
		return equipment_id;
	}

	public void setEquipment_id(String equipment_id) {
		this.equipment_id = equipment_id;
	}

	public LocalDateTime getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDateTime start_date) {
		this.start_date = start_date;
	}

	public LocalDateTime getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDateTime end_date) {
		this.end_date = end_date;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public int getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}

}
