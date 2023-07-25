package com.spring.configclient.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.configclient.database.entity.Bucket;

@Repository
public interface BucketRepository extends JpaRepository<Bucket, String> {

//    Bucket getByBucketId(String bucketId);
    Bucket getByBucketName(String bucketName);

}