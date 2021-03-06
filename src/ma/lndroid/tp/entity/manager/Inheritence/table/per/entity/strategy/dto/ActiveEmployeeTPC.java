package ma.lndroid.tp.entity.manager.Inheritence.table.per.entity.strategy.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Table(name="ACTIVE_EMP_TPC")
@DiscriminatorValue(value="AC_EMP")
public class ActiveEmployeeTPC extends EmployeeTPC{

	@Column(name = "SALARY")
	private int salary;

	@Column(name = "EXPERIENCE")
	private int experience;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public ActiveEmployeeTPC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActiveEmployeeTPC(int salary, int experience,String name) {
		super(name);
		this.salary = salary;
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "ActiveEmployeeSTS [salary=" + salary + ", experience="
				+ experience + "]";
	}

}
