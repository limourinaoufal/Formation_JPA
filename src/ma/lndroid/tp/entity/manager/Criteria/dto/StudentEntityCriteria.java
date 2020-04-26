package ma.lndroid.tp.entity.manager.Criteria.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_CRITERIA")
@NamedQueries({
	@NamedQuery(name="getAllCriteria",query="Select s from StudentEntityCriteria s"),
	@NamedQuery(name="getByNameSTCriteria",query="select s from StudentEntityCriteria s where s.name=:jpqlName"),
})
public class StudentEntityCriteria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AGE")
	private int age;

	public StudentEntityCriteria(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public StudentEntityCriteria() {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", age=" + age
				+ "]";
	}

}
