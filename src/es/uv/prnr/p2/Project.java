package es.uv.prnr.p2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;


//TODO JPQL de Ejercicio3 employeeInProject 
@NamedQuery(
			name="Project.findEmployee",
			query = ""
			)

//TODO JPQL de Ejercicio3 getTopHoursMonth
@NamedQuery(
			name="Project.getTopMonths",
			query=""
)

//TODO Consulta SQL para getMonthly Budget. Se recomienda encarecidamente testearla con Workbench
//antes de incluirla aquí
@NamedNativeQuery(
		name="Project.getMonthlyBudget",
		query = "",
		resultSetMapping = "MonthBudgetMapping"
)

//TODO Mapeo del ResultSet para la consulta anterior
/*@SqlResultSetMapping(
		name="MonthBudgetMapping",
		classes = {
			@ConstructorResult(
				targetClass=,
				columns= {
				}
			)	
	}
)*/

//TODO Anotaciones JPA necesarias
@Entity
public class Project  {

	@Id
	private int id;
	
	private String name;
	
	//TODO Relación * a 1 con Department
	@ManyToOne
	@JoinColumn(name="fk_department")
	private Department department;
	
	private BigDecimal budget;
	
	private LocalDate startDate;
	
	private LocalDate endDate;

	private String area;
	
	//TODO Relacion * a 1 con Project
	@ManyToOne
	@JoinColumn(name="fk_manager")
	private Manager manager;
	
	@ManyToMany
	@JoinTable(
		name="dept_emp",
			joinColumns=@JoinColumn(name="fk_emp_no",
			referencedColumnName="emp_no"),
			inverseJoinColumns=@JoinColumn(name="fk_dept_no",
			referencedColumnName="dept_no")
		)
	
	//TODO relacion * a * utilizando una tabla intermedia
	private Set<Employee> team = new HashSet<Employee>(0);
	
	//TODO Relacion 1 a * con la clase ProjectHours
	private List<ProjectHours> hours = new ArrayList<ProjectHours>();
	
	
	public Project() {
	}

	public Project(String name, Department department, Manager manager, BigDecimal budget, LocalDate startDate, LocalDate endDate, String area) {
		this.name = name;
		this.department = department;
		this.manager = manager;
		this.budget = budget;
		this.startDate = startDate;
		this.endDate = endDate;
		this.area = area;
	}
	
	/**
	 * Relaciona el proyecto con el empleado e
	 * @param e
	 */
	public void addEmployee(Employee e) {
		//TODO Codigo para relacionar el empleado con el proyecto
	}
	
	/**
	 * Añade un numero de horas al empleado e para un mes-año concreto
	 * @param e
	 * @param month
	 * @param year
	 * @param hours
	 */
	public void addHours(Employee e, int month, int year, int hours) {
		//TODO Codigo añadir las horas del empleado
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department Department) {
		this.department = Department;
	}

	public BigDecimal getBudget() {
		return this.budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Manager getManager() {
		return manager;
	}

	public Set<Employee> getEmployees() {
		return this.team;
	}

	
	public List<ProjectHours> getHours(){
		return this.hours;
	}
	
	public void print () {
		System.out.println("Project " + this.name + " from department " + this.department.getDeptName() );
		System.out.print("Managed by ");
		this.manager.print();
		System.out.println("Project Team");
	}

}
