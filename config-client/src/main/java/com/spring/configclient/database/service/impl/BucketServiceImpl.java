package com.spring.configclient.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.configclient.database.entity.Bucket;
import com.spring.configclient.database.repository.BucketRepository;
import com.spring.configclient.database.service.BucketService;

@Service
public class BucketServiceImpl implements BucketService {

    private final BucketRepository bucketRepository;

    @Autowired
    public BucketServiceImpl(BucketRepository bucketRepository) {
        this.bucketRepository = bucketRepository;
    }

    @Override
    public Bucket getByBucketId(String bucketId) {
        return bucketRepository.findById(bucketId).get();
    }

    @Override
    public Bucket getByBucketName(String bucketName) {
        return bucketRepository.getByBucketName(bucketName);
    }

    @Override
    public Bucket saveBucket(Bucket bucket) {
        return bucketRepository.save(bucket);
    }

    @Override
    public void deleteBucket(String bucketId) {
        bucketRepository.deleteById(bucketId);
    }
}