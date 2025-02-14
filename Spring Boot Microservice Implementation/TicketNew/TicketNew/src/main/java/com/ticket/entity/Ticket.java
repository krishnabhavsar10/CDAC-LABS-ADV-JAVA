package com.ticket.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	@Column(name="phonenumber")
	String phoneNumber;
	
	@Column(name = "category")
	@Enumerated(EnumType.STRING)
	Category category;
	
	@Column(name="issuedetail")
	String issueDetail;
	
	@Column(name="resolvedetails")
	String ResolveDetails;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	Status status;
	
	@Column(name = "complaindate")
	LocalDateTime complainDate;
	
	@Column(name = "resolvedate")
	LocalDateTime resolveDate;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getIssueDetail() {
		return issueDetail;
	}

	public void setIssueDetail(String issueDetail) {
		this.issueDetail = issueDetail;
	}

	public String getResolveDetails() {
		return ResolveDetails;
	}

	public void setResolveDetails(String resolveDetails) {
		ResolveDetails = resolveDetails;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getComplainDate() {
		return complainDate;
	}

	public void setComplainDate(LocalDateTime complainDate) {
		this.complainDate = complainDate;
	}

	public LocalDateTime getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(LocalDateTime resolveDate) {
		this.resolveDate = resolveDate;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", phoneNumber=" + phoneNumber + ", category=" + category + ", issueDetail="
				+ issueDetail + ", ResolveDetails=" + ResolveDetails + ", status=" + status + ", complainDate="
				+ complainDate + ", resolveDate=" + resolveDate + "]";
	}	
	
}
