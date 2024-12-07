package com.abc.app.mortgage.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACTION_SUMMARY")
public class TransactionSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "SRC_ACCOUNT_ID", nullable = false)
    private Long srcAccountId;

    @Column(name = "DEST_ACCOUNT_ID", nullable = false)
    private Long destAccountId;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;

    @Column(name = "TRANSFER_REF_NO", length = 30, nullable = false)
    private String transferRefNo;

    @Column(name = "TRANSFER_AMOUNT", precision = 10, scale = 5, nullable = false)
    private BigDecimal transferAmount;
    
    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "IS_COMPLETE", nullable = false)
    private Boolean isComplete;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSrcAccountId() {
		return srcAccountId;
	}

	public void setSrcAccountId(Long srcAccountId) {
		this.srcAccountId = srcAccountId;
	}

	public Long getDestAccountId() {
		return destAccountId;
	}

	public void setDestAccountId(Long destAccountId) {
		this.destAccountId = destAccountId;
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

    public String getTransferRefNo() {
        return transferRefNo;
    }

    public void setTransferRefNo(String transferRefNo) {
        this.transferRefNo = transferRefNo;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    
    
}
