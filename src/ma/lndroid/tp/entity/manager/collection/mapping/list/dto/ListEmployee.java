package ma.lndroid.tp.entity.manager.collection.mapping.list.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class ListEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;



	@ElementCollection
	@CollectionTable(name="EMPL_ADDR_LIST",joinColumns=@JoinColumn(name="FK_EMP"))
	@OrderColumn(name="LIST_INDICE")
	@AttributeOverrides({
		@AttributeOverride(name="city",column=@Column(name="VILLE") ),
		@AttributeOverride(name="street",column=@Column(name="RUE") )
	})
	private List<Address> adresses = new ArrayList<Address>();

	public ListEmployee(String name) {
		super();
		this.name = name;

	}

	public ListEmployee() {
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

	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", adresses="
				+ adresses + "]";
	}




}
