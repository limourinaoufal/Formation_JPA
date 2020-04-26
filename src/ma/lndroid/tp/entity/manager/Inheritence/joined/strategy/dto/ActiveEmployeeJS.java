package ma.lndroid.tp.entity.manager.Inheritence.joined.strategy.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Table(name="ACTIVE_EMP_JS")
@DiscriminatorValue(value="AC_EMP")
public class ActiveEmployeeJS extends EmployeeJS{

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

	public ActiveEmployeeJS() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActiveEmployeeJS(int salary, int experience,String name) {
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
