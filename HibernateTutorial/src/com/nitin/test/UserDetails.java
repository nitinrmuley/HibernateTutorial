package com.nitin.test;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
    @Id @GeneratedValue
    @Column(name="USER_ID")
	private int userId;
    @Column(name="USER_NAME")
	private String userName;
    
    @Embedded   //it is value object associated with userdetails class
    Address homeAddress;
    
    /***how override default attributes of address for office address for street and city**/
    
     @AttributeOverrides({
     @AttributeOverride(name="street",column=@Column(name="OFFICE_STREET_NAME")),
     @AttributeOverride(name="city",column=@Column(name="OFFICE_CITY_NAME"))})
    private Address officeAddress;
    
    
   
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	@Temporal (TemporalType.DATE) //takes only date and avoid timestamp
    private Date joinedDate;
    
    //avoid by hibernate
   // @Transient
    
    @Lob   //large object like CLOB BLOB
    private String description;
    
	public int getUserId() {
		return userId;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
		
}
