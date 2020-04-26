package ma.lndroid.tp.entity.manager.Inheritence.single.table.strategy.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@DiscriminatorValue(value="AC_EMP")
public class ActiveEmployeeSTS extends EmployeeSTS{

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

	public ActiveEmployeeSTS() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActiveEmployeeSTS(int salary, int experience,String name) {
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
