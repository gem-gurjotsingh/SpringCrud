package com.xadmin.SpringBootCrud.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	private String id;
	private String name;
	private String location;
	private String team;


	public Employee() {

	}
	public Employee(String id, String name, String location, String team) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.team = team;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
}