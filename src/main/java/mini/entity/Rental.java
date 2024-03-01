package mini.entity;

import java.time.LocalDateTime;

public class Rental {
	private String rentalId;
	private String userId;
	private String equipmentId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private int totalPrice;
	private int paymentStatus;

	public Rental(String rentalId, String userId, String equipmentId, LocalDateTime startDate, LocalDateTime endDate,
			int totalPrice, int paymentStatus) {
		super();
		this.rentalId = rentalId;
		this.userId = userId;
		this.equipmentId = equipmentId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.paymentStatus = paymentStatus;
	}

	public Rental(String rentalId, String userId, String equipmentId, LocalDateTime startDate, LocalDateTime endDate) {
		super();
		this.rentalId = rentalId;
		this.userId = userId;
		this.equipmentId = equipmentId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Rental(int totalPrice, int paymentStatus) {
		super();
		this.totalPrice = totalPrice;
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Rental [rentalId=" + rentalId + ", userId=" + userId + ", equipmentId=" + equipmentId + ", startDate="
				+ startDate + ", endDate=" + endDate + ", totalPrice=" + totalPrice + ", paymentStatus=" + paymentStatus
				+ "]";
	}

	public String getRentalId() {
		return rentalId;
	}

	public void setRentalId(String rentalId) {
		this.rentalId = rentalId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}
