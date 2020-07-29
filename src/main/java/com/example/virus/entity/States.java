package com.example.virus.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table
public class States {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@Value(value = " ")
	private String id;

	@Column
	private String scode;

	@Column
	private int active;

	@Column
	private int total;
	@Column
	private int decease;
	@Column
	private int recover;
	@Column
	private String date;

	@Column
	private String pass;

	@Column
	private String time;
	
	@Column
	private long population;
	
	

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	@OneToMany(mappedBy = "states", cascade = CascadeType.ALL)
	private List<Cities> city;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Cities> getCity() {
		return city;
	}

	public void setCity(List<Cities> city) {
		this.city = city;
	}

	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public States(String scode, int active, int total, int decease, int recover, String date, List<Cities> city) {

		this.scode = scode;
		this.active = active;
		this.total = total;
		this.decease = decease;
		this.recover = recover;
		this.date = date;
		this.city = city;
	}

	public States() {
	}

}
