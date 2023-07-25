package com.spring.configclient.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "data")
public class Data {

    @Id
    @Column(name = "UUID")
    private String uuid;

    @Column(name = "Api_File_Name")
    private String apiFileName;

    @Column(name = "Api_File_Path")
    private String apiFilePath;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Bucket_Name")
    @Column(name = "Bucket_Name")
    private String bucket;

    @Column(name = "Desination_File_Name")
    private String destinationFileName;

    @Column(name = "Destination_File_Path")
    private String destinationFilePath;

    @Column(name = "Hash_File")
    private String hashFile;

    @Column(name = "Hash_Enc_File")
    private String hashEncFile;

    @Column(name = "Meta_Data", columnDefinition = "json")
    private String metaData;

    @Column(name = "Verification_Date")
    private Timestamp verificationDate;

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
    
    

	public Data() {
		
	}

	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getApiFileName() {
		return apiFileName;
	}

	public void setApiFileName(String apiFileName) {
		this.apiFileName = apiFileName;
	}

	public String getApiFilePath() {
		return apiFilePath;
	}

	public void setApiFilePath(String apiFilePath) {
		this.apiFilePath = apiFilePath;
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getDestinationFileName() {
		return destinationFileName;
	}

	public void setDestinationFileName(String destinationFileName) {
		this.destinationFileName = destinationFileName;
	}

	public String getDestinationFilePath() {
		return destinationFilePath;
	}

	public void setDestinationFilePath(String destinationFilePath) {
		this.destinationFilePath = destinationFilePath;
	}

	public String getHashFile() {
		return hashFile;
	}

	public void setHashFile(String hashFile) {
		this.hashFile = hashFile;
	}

	public String getHashEncFile() {
		return hashEncFile;
	}

	public void setHashEncFile(String hashEncFile) {
		this.hashEncFile = hashEncFile;
	}

	public String getMetaData() {
		return metaData;
	}

	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}

	public Timestamp getVerificationDate() {
		return verificationDate;
	}

	public void setVerificationDate(Timestamp verificationDate) {
		this.verificationDate = verificationDate;
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

	@Override
	public String toString() {
		return "Data [uuid=" + uuid + ", apiFileName=" + apiFileName + ", apiFilePath=" + apiFilePath + ", bucket="
				+ bucket + ", destinationFileName=" + destinationFileName + ", destinationFilePath="
				+ destinationFilePath + ", hashFile=" + hashFile + ", hashEncFile=" + hashEncFile + ", metaData="
				+ metaData + ", verificationDate=" + verificationDate + ", status=" + status + ", createdBy="
				+ createdBy + ", createdTimestamp=" + createdTimestamp + ", modifiedBy=" + modifiedBy
				+ ", modifiedTimestamp=" + modifiedTimestamp + "]";
	}
}