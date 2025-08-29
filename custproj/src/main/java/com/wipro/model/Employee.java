package com.wipro.model;

import java.io.Serializable;
import java.sql.Date;

public class Employee implements Serializable {
	private String empName;
	private Integer empId;
	private String job;
	private String managerId;
	private Date hiredDate;

	@Override
	public String toString() {
		return "(" + this.empName + ", " + this.empId + ", " + this.job + ")";
	}

	public void setEmpName(String name) {
		this.empName = name;
	}

	public void setEmpId(Integer id) {
		this.empId = id;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getEmpName() {
		return this.empName;
	}

	public Integer getEmpId() {
		return this.empId;
	}

	public String getJob() {
		return this.job;
	}

}
