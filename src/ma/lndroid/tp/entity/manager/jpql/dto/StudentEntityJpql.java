package ma.lndroid.tp.entity.manager.jpql.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_JPQL")
@NamedQueries({
	@NamedQuery(name="getAllSTJpql",query="Select s from StudentEntityJpql s"),
	@NamedQuery(name="getByNameSTJpql",query="select s from StudentEntityJpql s where s.name=:jpqlName"),
})
public class StudentEntityJpql {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AGE")
	private int age;

	public StudentEntityJpql(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public StudentEntityJpql() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
