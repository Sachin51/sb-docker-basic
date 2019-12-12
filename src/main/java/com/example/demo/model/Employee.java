package com.example.demo.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"createdAt","updatedAt"}, allowGetters = true)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long slNo;
	
	private String empId;
	
	@NotBlank
	private String empName;//text(UI)
	
	@NotBlank
	private String homeTown;//text(UI)
	
	private boolean sex;//radio(UI)
	
	private Date dateOfJoining;//Datepicker with validation(UI)
	
	private String martialStatus;//dropdown(UI)
	
	private Date dob;//Datepicker with validation(UI)
	
	//pic needs to be added.
	//progress bar needs to be added for photo
	
	private int ratingOfCompany;//use start rating in UI
	
	@Column(nullable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@Column(nullable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public long getSlNo() {
		return slNo;
	}

	public void setSlNo(long slNo) {
		this.slNo = slNo;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getRatingOfCompany() {
		return ratingOfCompany;
	}

	public void setRatingOfCompany(int ratingOfCompany) {
		this.ratingOfCompany = ratingOfCompany;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Employee [slNo=" + slNo + ", empId=" + empId + ", empName=" + empName + ", homeTown=" + homeTown
				+ ", sex=" + sex + ", dateOfJoining=" + dateOfJoining + ", martialStatus=" + martialStatus + ", dob="
				+ dob + ", ratingOfCompany=" + ratingOfCompany + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}
}
