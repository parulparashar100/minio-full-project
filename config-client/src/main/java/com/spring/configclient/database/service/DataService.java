package com.spring.configclient.database.service;

import com.spring.configclient.database.entity.Data;

public interface DataService {

    void saveData(Data data);
    Data getDataByUuid(String uuid);
    Data getDataByApiFileName(String apiFileName);

}