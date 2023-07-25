package com.spring.configclient.database.service.impl;

import java.util.Optional;

import com.spring.configclient.database.entity.Data;
import com.spring.configclient.database.repository.DataRepository;
import com.spring.configclient.database.service.DataService;

public class DataServiceImpl implements DataService {

    private DataRepository dataRepository;

    public DataServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void saveData(Data data) {
        dataRepository.save(data);
    }

    @Override
    public Data getDataByUuid(String uuid) {
        Optional<Data> optionalData = dataRepository.findById(uuid);
        return optionalData.orElse(null); // Or handle the absence with a proper default value or throw an exception.
    }

    @Override
    public Data getDataByApiFileName(String apiFileName) {
        return dataRepository.findByApiFileName(apiFileName);
    }
}