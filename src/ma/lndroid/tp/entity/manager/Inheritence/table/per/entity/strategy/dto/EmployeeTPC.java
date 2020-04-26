package ma.lndroid.tp.entity.manager.Inheritence.table.per.entity.strategy.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_TPC")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="DIC_TYPE_OBJ",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="EMP")
public class EmployeeTPC{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NAME")
	private String name;

	public EmployeeTPC(String name) {
		super();
		this.name = name;
	}

	public EmployeeTPC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + "]";
	}

}
