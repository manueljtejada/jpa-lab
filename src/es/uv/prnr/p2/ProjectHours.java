package es.uv.prnr.p2;

import javax.persistence.*;

//TODO Anotaciones JPA necesarias
public class ProjectHours {
	int id;
	int month;
	int year;
	int hours;

	//TODO Relacion * a 1 con Employee
	Employee employee;

	//TODO Relacion * a 1 con Project
	Project project;
	
	public ProjectHours() {
		
	}
	
	public ProjectHours(int month, int year, int hours, Employee employee, Project project) {
		this.month = month;
		this.year = year;
		this.hours = hours;
		this.employee = employee;
		this.project = project;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Project getProject() {
		return project;
	}
	
	
	
}
