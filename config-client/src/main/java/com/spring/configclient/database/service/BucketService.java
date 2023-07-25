package com.spring.configclient.database.service;

import com.spring.configclient.database.entity.Bucket;

public interface BucketService {

    Bucket getByBucketId(String bucketId);

    Bucket getByBucketName(String bucketName);

    Bucket saveBucket(Bucket bucket);

    void deleteBucket(String bucketId);

}