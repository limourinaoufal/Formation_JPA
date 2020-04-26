package ma.lndroid.tp.entity.manager.Inheritence.single.table.strategy.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@DiscriminatorValue(value="RET_EMP")
public class RetiredEmployeeSTS extends EmployeeSTS{

	@Column(name = "PENSION")
	private int pension;

	public int getPension() {
		return pension;
	}

	public void setPension(int pension) {
		this.pension = pension;
	}

	public RetiredEmployeeSTS(int pension,String name) {
		super(name);
		this.pension = pension;
	}

	public RetiredEmployeeSTS() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RetiredEmployeeSTS [pension=" + pension + "]";
	}

}
