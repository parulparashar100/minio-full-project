package com.spring.configclient.database.entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "batch_audit")
public class Batch_Audit {
	
    @Id
    @Column(name = "Batch_ID")
    private String batchId;

    @Column(name = "Configuration_ID")
    private String configurationId;

    @Column(name = "Start_Datetime")
    private Timestamp startDatetime;

    @Column(name = "End_Datetime")
    private Timestamp endDatetime;

    @Column(name = "No_of_files_to_be_scanned")
    private Long noOfFilesToBeScanned;

    @Column(name = "No_of_files_scanned")
    private Long noOfFilesScanned;

    @Column(name = "No_of_problem_files")
    private Long noOfProblemFiles;

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

    @OneToMany(mappedBy = "batchAudit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Scan_Audit> scanAudits;

	public Batch_Audit() {
		
	}


	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getConfigurationId() {
		return configurationId;
	}

	public void setConfigurationId(String configurationId) {
		this.configurationId = configurationId;
	}

	public Timestamp getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(Timestamp startDatetime) {
		this.startDatetime = startDatetime;
	}

	public Timestamp getEndDatetime() {
		return endDatetime;
	}

	public void setEndDatetime(Timestamp endDatetime) {
		this.endDatetime = endDatetime;
	}

	public Long getNoOfFilesToBeScanned() {
		return noOfFilesToBeScanned;
	}

	public void setNoOfFilesToBeScanned(Long noOfFilesToBeScanned) {
		this.noOfFilesToBeScanned = noOfFilesToBeScanned;
	}

	public Long getNoOfFilesScanned() {
		return noOfFilesScanned;
	}

	public void setNoOfFilesScanned(Long noOfFilesScanned) {
		this.noOfFilesScanned = noOfFilesScanned;
	}

	public Long getNoOfProblemFiles() {
		return noOfProblemFiles;
	}

	public void setNoOfProblemFiles(Long noOfProblemFiles) {
		this.noOfProblemFiles = noOfProblemFiles;
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

	public List<Scan_Audit> getScanAudits() {
		return scanAudits;
	}

	public void setScanAudits(List<Scan_Audit> scanAudits) {
		this.scanAudits = scanAudits;
	}

	@Override
	public String toString() {
		return "BatchAudit [batchId=" + batchId + ", configurationId=" + configurationId + ", startDatetime="
				+ startDatetime + ", endDatetime=" + endDatetime + ", noOfFilesToBeScanned=" + noOfFilesToBeScanned
				+ ", noOfFilesScanned=" + noOfFilesScanned + ", noOfProblemFiles=" + noOfProblemFiles + ", status="
				+ status + ", createdBy=" + createdBy + ", createdTimestamp=" + createdTimestamp + ", modifiedBy="
				+ modifiedBy + ", modifiedTimestamp=" + modifiedTimestamp + "]";
	}
}