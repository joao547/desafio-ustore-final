package com.example.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teste.models.ObjectStorage;

public interface ObjectStorageRepository extends JpaRepository<ObjectStorage, Integer>{
	ObjectStorage findById(int id);
	List<ObjectStorage> findByDescription(String description);
	List<ObjectStorage> findByLength(int length);
}
