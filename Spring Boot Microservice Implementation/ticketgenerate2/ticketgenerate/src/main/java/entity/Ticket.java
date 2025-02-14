package entity;

import java.sql.Date;

import org.hibernate.generator.Generator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "")
public class Ticket {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	@Column(name = "phone-number")
	String phoneNo;

	@Column(name = "category")
	@Enumerated(EnumType.STRING)
	Category category;
	
	@Column(name = "issuedetail")
	String issueDetail;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	Status status;

	@Column(name = "resolution_detail")
	String resolution;

	@Column(name = "createtime")
	Date createdate;

	@Column(name = "resolvedate")
	Date resolvedate;

	public Ticket() {
		super();
	}

	public Ticket(Integer id, String phoneNo, Category category, String issueDetail, Status status, String resolution,
			Date createdate, Date resolvedate) {
		super();
		this.id = id;
		this.phoneNo = phoneNo;
		this.category = category;
		this.issueDetail = issueDetail;
		this.status = status;
		this.resolution = resolution;
		this.createdate = createdate;
		this.resolvedate = resolvedate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getResolvedate() {
		return resolvedate;
	}

	public void setResolvedate(Date resolvedate) {
		this.resolvedate = resolvedate;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", phoneNo=" + phoneNo + ", category=" + category + ", issueDetail=" + issueDetail
				+ ", status=" + status + ", resolution=" + resolution + ", Createdate=" + createdate + ", resolvedate="
				+ resolvedate + "]";
	}

}
