package com.spring.configclient.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.configclient.database.entity.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, String> 

{
//	public Data findByUuid(String uuid);
	public Data findByApiFileName(String apiFileName);
}