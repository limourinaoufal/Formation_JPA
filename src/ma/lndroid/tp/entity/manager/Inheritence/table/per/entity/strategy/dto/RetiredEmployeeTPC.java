package ma.lndroid.tp.entity.manager.Inheritence.table.per.entity.strategy.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Table(name="RETIRED_EMP_TPC")
@DiscriminatorValue(value="RET_EMP")
public class RetiredEmployeeTPC extends EmployeeTPC{

	@Column(name = "PENSION")
	private int pension;

	public int getPension() {
		return pension;
	}

	public void setPension(int pension) {
		this.pension = pension;
	}

	public RetiredEmployeeTPC(int pension,String name) {
		super(name);
		this.pension = pension;
	}

	public RetiredEmployeeTPC() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RetiredEmployeeSTS [pension=" + pension + "]";
	}

}
