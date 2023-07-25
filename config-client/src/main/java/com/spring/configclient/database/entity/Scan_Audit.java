package com.spring.configclient.database.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "scan_audit")
public class Scan_Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Scan_Audit_ID")
    private Long scanAuditId;

    @Column(name = "UUID")
    private String uuid;

    @Column(name = "Status")
    private String status;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Created_Timestamp")
    private Timestamp createdTimestamp;

    @Column(name = "Modified_By")
    private String modifiedBy;

    @Column(name = "Modified_Timestamp")
    private Timestamp modifiedTimestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Batch_ID")
    private Batch_Audit batchAudit;

    public Scan_Audit() {
    }

    

    public Long getScanAuditId() {
		return scanAuditId;
	}



	public void setScanAuditId(Long scanAuditId) {
		this.scanAuditId = scanAuditId;
	}



	public String getUuid() {
		return uuid;
	}



	public void setUuid(String uuid) {
		this.uuid = uuid;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}



	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}



	public String getModifiedBy() {
		return modifiedBy;
	}



	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}



	public Timestamp getModifiedTimestamp() {
		return modifiedTimestamp;
	}



	public void setModifiedTimestamp(Timestamp modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}



	public Batch_Audit getBatchAudit() {
		return batchAudit;
	}



	public void setBatchAudit(Batch_Audit batchAudit) {
		this.batchAudit = batchAudit;
	}



	@Override
    public String toString() {
        return "Scan_Audit [scanAuditId=" + scanAuditId + ", uuid=" + uuid + ", status=" + status + ", createdBy="
                + createdBy + ", createdTimestamp=" + createdTimestamp + ", modifiedBy=" + modifiedBy
                + ", modifiedTimestamp=" + modifiedTimestamp + ", batchAudit=" + batchAudit + "]";
    }
}
