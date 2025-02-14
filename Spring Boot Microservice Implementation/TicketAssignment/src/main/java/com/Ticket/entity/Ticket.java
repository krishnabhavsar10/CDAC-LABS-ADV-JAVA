package com.Ticket.entity;

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
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "requesterphonenumber", nullable = false, unique = true, length = 15)
    private String requesterPhoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(name = "issuedetails", nullable = false, columnDefinition = "TEXT")
    private String issueDetails;

    @Column(name = "resolutiondetails", columnDefinition = "TEXT")
    private String resolutionDetails;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.OPEN;

    @Column(name = "createdatetime", nullable = false)
    private LocalDateTime createDateTime = LocalDateTime.now();

    @Column(name = "resolutiondatetime")
    private LocalDateTime resolutionDateTime;

    // Enums for Category and Status

    public enum Category {
        SIM, 
        CALLING, 
        BROADBAND;
    }

    public enum Status {
        OPEN, 
        IN_PROGRESS, 
        RESOLVED;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequesterPhoneNumber() {
        return requesterPhoneNumber;
    }

    public void setRequesterPhoneNumber(String requesterPhoneNumber) {
        this.requesterPhoneNumber = requesterPhoneNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getIssueDetails() {
        return issueDetails;
    }

    public void setIssueDetails(String issueDetails) {
        this.issueDetails = issueDetails;
    }

    public String getResolutionDetails() {
        return resolutionDetails;
    }

    public void setResolutionDetails(String resolutionDetails) {
        this.resolutionDetails = resolutionDetails;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getResolutionDateTime() {
        return resolutionDateTime;
    }

    public void setResolutionDateTime(LocalDateTime resolutionDateTime) {
        this.resolutionDateTime = resolutionDateTime;
    }
}
