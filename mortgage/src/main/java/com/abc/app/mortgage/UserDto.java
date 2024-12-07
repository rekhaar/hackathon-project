/**
 * 
 */
package com.abc.app.mortgage.vo;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Rambabu Keshetti
 *
 */

public class UserDto {

Long userid;

String userName;

String firstName;

String lastName;

boolean isActive;

Date birthDate;

String addressLine;
String postalcode;
String country;
String gender;
String emailId;
String primaryMobileNo;
String secondaryMobileNo;
LocalDateTime createDate;
LocalDateTime updateDate;
Long createdBy;
Long updatedBy;
public Long getUserid() {
	return userid;
}
public void setUserid(Long userid) {
	this.userid = userid;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}
public Date getBirthDate() {
	return birthDate;
}
public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
}
public String getAddressLine() {
	return addressLine;
}
public void setAddressLine(String addressLine) {
	this.addressLine = addressLine;
}
public String getPostalcode() {
	return postalcode;
}
public void setPostalcode(String postalcode) {
	this.postalcode = postalcode;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getPrimaryMobileNo() {
	return primaryMobileNo;
}
public void setPrimaryMobileNo(String primaryMobileNo) {
	this.primaryMobileNo = primaryMobileNo;
}
public String getSecondaryMobileNo() {
	return secondaryMobileNo;
}
public void setSecondaryMobileNo(String secondaryMobileNo) {
	this.secondaryMobileNo = secondaryMobileNo;
}
public LocalDateTime getCreateDate() {
	return createDate;
}
public void setCreateDate(LocalDateTime createDate) {
	this.createDate = createDate;
}
public LocalDateTime getUpdateDate() {
	return updateDate;
}
public void setUpdateDate(LocalDateTime updateDate) {
	this.updateDate = updateDate;
}
public Long getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(Long createdBy) {
	this.createdBy = createdBy;
}
public Long getUpdatedBy() {
	return updatedBy;
}
public void setUpdatedBy(Long updatedBy) {
	this.updatedBy = updatedBy;
}
@Override
public String toString() {
	return "User [userid=" + userid + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", isActive=" + isActive + ", birthDate=" + birthDate + ", addressLine=" + addressLine + ", postalcode="
			+ postalcode + ", country=" + country + ", gender=" + gender + ", emailId=" + emailId + ", primaryMobileNo="
			+ primaryMobileNo + ", secondaryMobileNo=" + secondaryMobileNo + ", createDate=" + createDate
			+ ", updateDate=" + updateDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
}

}
