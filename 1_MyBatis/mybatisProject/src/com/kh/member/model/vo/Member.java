package com.kh.member.model.vo;

import java.sql.Date;

public class Member {
	private int mid;
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String birthDay;
	private String gender;
	private String phone;
	private String address;
	private Date enrollDate;
	private Date updateDate;
	private String mStatus;
	
	public Member() {}

	
	public Member(int mid, String userId, String userPwd, String userName, String email, String birthDay, String gender,
			String phone, String address, Date enrollDate, Date updateDate, String mStatus) {
		super();
		this.mid = mid;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.birthDay = birthDay;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.enrollDate = enrollDate;
		this.updateDate = updateDate;
		this.mStatus = mStatus;
	}

	
	public Member(int mid, String userId, String userPwd, String userName, String email,
			String phone, String address) {
		super();
		this.mid = mid;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}


	public Member(String userId, String userPwd, String userName, String email, String birthDay, String gender,
			String phone, String address) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.birthDay = birthDay;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getmStatus() {
		return mStatus;
	}

	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", email=" + email + ", birthDay=" + birthDay + ", gender=" + gender + ", phone=" + phone
				+ ", address=" + address + ", enrollDate=" + enrollDate + ", updateDate=" + updateDate + ", mStatus="
				+ mStatus + "]";
	}
	
	

}
