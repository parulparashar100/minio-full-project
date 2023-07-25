package com.spring.configclient.database.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "client_code")
public class Client_Code {

    @Id
    @Column(name = "Client_Code")
    private String clientCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Bucket_Name")
    private Bucket bucket;

    @Column(name = "Access_Type")
    private String accessType;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Created_Timestamp")
    private Timestamp createdTimestamp;

    @Column(name = "Modified_By")
    private String modifiedBy;

    @Column(name = "Modified_Timestamp")
    private Timestamp modifiedTimestamp;

	public Client_Code() {
	
	}

	

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public Bucket getBucket() {
		return bucket;
	}

	public void setBucket(Bucket bucket) {
		this.bucket = bucket;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
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

	@Override
	public String toString() {
		return "ClientCode [clientCode=" + clientCode + ", bucket=" + bucket + ", accessType=" + accessType
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + "]";
	}
}