package com.example.virus.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class States {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

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

	@OneToMany(mappedBy = "state")
	private List<Cities> city;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	
	public States( String scode, int active, int total, int decease, int recover, String date,
			List<Cities> city) {

		this.scode = scode;
		this.active = active;
		this.total = total;
		this.decease = decease;
		this.recover = recover;
		this.date = date;
		this.city = city;
	}

	public States() {
		System.out.println("states......................");
	}

}

