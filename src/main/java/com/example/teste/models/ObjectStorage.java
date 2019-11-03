package com.example.teste.models;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.teste.ProcessObject;

@Entity
public class ObjectStorage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private byte[] data;
	private String description;
	private int length;
	
	public ObjectStorage(Object object) throws IOException {
		ProcessObject po = new ProcessObject();
		setDescription(object.toString());
		setLength(po.objectToByte(object).length);
		setData(po.objectToByte(object));
	}
	
	public ObjectStorage() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
}
