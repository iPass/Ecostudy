package com.ecostudy.models;

import java.io.Serializable;

public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String email;
	private String name;
	private int allPosition;
	private int position;
	private int[] schools;
	private int block;
	private String brand;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAllPosition() {
		return allPosition;
	}

	public void setAllPosition(int allPosition) {
		this.allPosition = allPosition;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int[] getSchools() {
		return schools;
	}

	public void setSchools(int[] schools) {
		this.schools = schools;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}