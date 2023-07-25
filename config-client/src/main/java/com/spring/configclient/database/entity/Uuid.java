package com.spring.configclient.database.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "uuid")
public class Uuid {

    @Id
    @Column(name = "UUID_Data")
    private String uuidData;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Created_Timestamp")
    private Timestamp createdTimestamp;

    @Column(name = "Modified_By")
    private String modifiedBy;

    @Column(name = "Modified_Timestamp")
    private Timestamp modifiedTimestamp;

	public Uuid() {
		
	}
	
	  

	public String getUuidData() {
		return uuidData;
	}

	public void setUuidData(String uuidData) {
		this.uuidData = uuidData;
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
		return "UUID [uuidData=" + uuidData + ", createdBy=" + createdBy + ", createdTimestamp=" + createdTimestamp
				+ ", modifiedBy=" + modifiedBy + ", modifiedTimestamp=" + modifiedTimestamp + "]";
	}
}