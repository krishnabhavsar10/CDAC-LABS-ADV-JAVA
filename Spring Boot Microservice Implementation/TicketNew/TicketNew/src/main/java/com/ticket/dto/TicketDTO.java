package com.ticket.dto;

import java.time.LocalDateTime;

import com.ticket.entity.Category;
import com.ticket.entity.Status;

public class TicketDTO {
	
	Integer id;
	String phoneNumber;
	Category category;
	String issueDetail;
	String ResolveDetails;
	Status status;
	LocalDateTime complainDate;
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
		return "TicketDTO [id=" + id + ", phoneNumber=" + phoneNumber + ", category=" + category + ", issueDetail="
				+ issueDetail + ", ResolveDetails=" + ResolveDetails + ", status=" + status + ", complainDate="
				+ complainDate + ", resolveDate=" + resolveDate + "]";
	}
}
