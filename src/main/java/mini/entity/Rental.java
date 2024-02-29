package mini.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Rental {
	private String rentalId;
	private String userId;
	private String equipmentId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BigDecimal totalPrice;
	private boolean paymentStatus;

	public Rental() {};
	public Rental(String rentalId, String userId, String equipmentId, LocalDateTime startDate, LocalDateTime endDate,
			BigDecimal totalPrice, boolean paymentStatus) {
		this.rentalId = rentalId;
		this.userId = userId;
		this.equipmentId = equipmentId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.paymentStatus = paymentStatus;
	}
	
	//가격 제외한 생성자(?)
	public Rental(String rentalId, String userId, String equipmentId, LocalDateTime startDate, LocalDateTime endDate) {
		this.rentalId = rentalId;
		this.userId = userId;
		this.equipmentId = equipmentId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	//계산을 위해 만든 생성자
	public Rental(BigDecimal totalPrice, boolean paymentStatus) {
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

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}
