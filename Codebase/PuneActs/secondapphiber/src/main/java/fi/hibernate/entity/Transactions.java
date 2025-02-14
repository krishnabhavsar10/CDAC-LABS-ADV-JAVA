package fi.hibernate.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="transactions")
public class Transactions 
{
	@Id
	@Column(name="txId")
	int transactionId;
	
	@Column(name="amount")
	float amount;
	
	@Column(name="cardNo")
	int cardNo;
	
	@Column(name="txDate")
	Date txDate;
	
	@Column(name="status")
	int status;
	
	@ManyToOne
	@JoinColumn(name="cardNo",insertable = false,updatable = false,nullable=false)
	Cards objCard;
	
	public Cards getObjCard() {
		return objCard;
	}

	public void setObjCard(Cards objCard) {
		this.objCard = objCard;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public Date getTxDate() {
		return txDate;
	}

	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
