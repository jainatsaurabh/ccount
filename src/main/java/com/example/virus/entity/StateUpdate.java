package com.example.virus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.web.ResourceProperties.Strategy;
import org.springframework.boot.context.properties.bind.DefaultValue;

import com.sun.istack.NotNull;

@Entity
@Table
public class StateUpdate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String sid;
	@Column
	private int active;
	@Column
	private int recover;
	@Column
	private int decease;
	@Column
	private int total;
	@Column
	private String date;

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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getRecover() {
		return recover;
	}

	public void setRecover(int recover) {
		this.recover = recover;
	}

	public int getDecease() {
		return decease;
	}

	public void setDecease(int decease) {
		this.decease = decease;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public StateUpdate() {

	}

	public StateUpdate(String sid, int active, int recover, int decease, int total, String date) {
		this.sid = sid;
		this.active = active;
		this.recover = recover;
		this.decease = decease;
		this.total = total;
		this.date = date;
	}

}
