package ma.lndroid.tp.entity.manager.Inheritence.joined.strategy.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Table(name="RETIRED_EMP_JS")
@DiscriminatorValue(value="RET_EMP")
public class RetiredEmployeeJS extends EmployeeJS{

	@Column(name = "PENSION")
	private int pension;

	public int getPension() {
		return pension;
	}

	public void setPension(int pension) {
		this.pension = pension;
	}

	public RetiredEmployeeJS(int pension,String name) {
		super(name);
		this.pension = pension;
	}

	public RetiredEmployeeJS() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RetiredEmployeeSTS [pension=" + pension + "]";
	}

}
