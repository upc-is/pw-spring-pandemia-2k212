package pe.edu.upc.pandemia.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

// Composite Primary Key Class 
public class JobHistoryId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer employee;
	private Date startDate;
	
	public JobHistoryId() {
		super();
	}

	// Constructor
	public JobHistoryId(Integer employee, Date startDate) {
		super();
		this.employee = employee;
		this.startDate = startDate;
	}

	// Getter y Setter
	public Integer getEmployee() {
		return employee;
	}

	public void setEmployee(Integer employee) {
		this.employee = employee;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(employee, startDate);
	}

	/** JobHistoryId jobHistoryId1 = new JobHistoryId(1, new Date("2021", "01", "10"));
	 * JobHistoryId jobHistoryId2 = new JobHistoryId(2, new Date("2021", "03", "10"));
	 * if (jobHistoryId1 == employee)
	 * if(this == obj) -> representativo
	 */	
	// if (a == b) -> Comparar Objetos
	@Override
	public boolean equals(Object obj) {
		// Si es el mismo
		if(this == obj)
			return true;
		// Si el obj es null o las clases de los objetos son diferentes
		if(obj == null || this.getClass() != obj.getClass())
			return false;
		// Verificar que los atributos sean iguales.
		// Cast
		JobHistoryId jobHistoryId = (JobHistoryId)obj;
		
		if(this.employee != jobHistoryId.employee)
			return false;
		if(this.startDate != jobHistoryId.startDate)
			return false;
		return true;
	}
	
	
}







