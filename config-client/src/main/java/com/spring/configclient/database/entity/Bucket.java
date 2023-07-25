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
@Table(name = "bucket")
public class Bucket {

	@Id
    @Column(name = "Bucket_Id")
    private String bucketId;
	
    @Column(name = "Bucket_Name")
    private String bucketName;

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

    @OneToMany(mappedBy = "bucket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Data> dataList;

	public Bucket() {
		
	}

	

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
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

	public List<Data> getDataList() {
		return dataList;
	}

	public void setDataList(List<Data> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "Bucket [bucketName=" + bucketName + ", status=" + status + ", createdBy=" + createdBy
				+ ", createdTimestamp=" + createdTimestamp + ", modifiedBy=" + modifiedBy + ", modifiedTimestamp="
				+ modifiedTimestamp + ", dataList=" + dataList + "]";
	}
}