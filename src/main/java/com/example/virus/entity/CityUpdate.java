package com.example.virus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class CityUpdate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String sid;
	@Column
	private String name;
	@Column
	private String date;
	@Column
	private int active;
	@Column
	private int total;
	@Column
	private int decease;
	@Column
	private int recover;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getDecease() {
		return decease;
	}

	public void setDecease(int decease) {
		this.decease = decease;
	}

	public int getRecover() {
		return recover;
	}

	public void setRecover(int recover) {
		this.recover = recover;
	}

	public CityUpdate() {

	}

	public CityUpdate(String sid, String name, String date, int active, int total, int decease, int recover) {
		this.sid = sid;
		this.name = name;
		this.date = date;
		this.active = active;
		this.total = total;
		this.decease = decease;
		this.recover = recover;
	}

}
