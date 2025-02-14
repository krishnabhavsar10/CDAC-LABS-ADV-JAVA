package com.Ticket.dto;

import java.time.LocalDateTime;

import com.Ticket.entity.Ticket;
import com.Ticket.entity.Ticket.Category;
import com.Ticket.entity.Ticket.Status;

public class TicketDTO {

    private int id;
    private String requesterPhoneNumber;
    private String category; // Enum name as String
    private String issueDetails;
    private String resolutionDetails;
    private String status; // Enum name as String
    private LocalDateTime createDateTime;
    private LocalDateTime resolutionDateTime;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    // Static Factory Methods for Mapping
    public static TicketDTO fromEntity(Ticket ticket) {
        TicketDTO dto = new TicketDTO();
        dto.setId(ticket.getId());
        dto.setRequesterPhoneNumber(ticket.getRequesterPhoneNumber());
        dto.setCategory(ticket.getCategory().name());
        dto.setIssueDetails(ticket.getIssueDetails());
        dto.setResolutionDetails(ticket.getResolutionDetails());
        dto.setStatus(ticket.getStatus().name());
        dto.setCreateDateTime(ticket.getCreateDateTime());
        dto.setResolutionDateTime(ticket.getResolutionDateTime());
        return dto;
    }

    public Ticket toEntity() {
        Ticket ticket = new Ticket();
        ticket.setId(this.id);
        ticket.setRequesterPhoneNumber(this.requesterPhoneNumber);
        ticket.setCategory(Category.valueOf(this.category));
        ticket.setIssueDetails(this.issueDetails);
        ticket.setResolutionDetails(this.resolutionDetails);
        ticket.setStatus(Status.valueOf(this.status));
        ticket.setCreateDateTime(this.createDateTime);
        ticket.setResolutionDateTime(this.resolutionDateTime);
        return ticket;
    }
}
