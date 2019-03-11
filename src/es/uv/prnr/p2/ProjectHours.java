package es.uv.prnr.p2;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//TODO Anotaciones JPA necesarias
@Entity
@Table(name="monthly_hours")
public class ProjectHours {
	@Id
	int id;
	int month;
	int year;
	int hours;

	//TODO Relacion * a 1 con Employee
	@ManyToOne
	@JoinColumn(name="fk_emp_no")
	Employee employee;

	//TODO Relacion * a 1 con Project
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "fk_project",
				nullable = false)
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
