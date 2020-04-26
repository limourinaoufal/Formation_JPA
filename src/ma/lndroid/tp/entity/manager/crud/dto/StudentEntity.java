package ma.lndroid.tp.entity.manager.crud.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class StudentEntity {
	
	@Id
	private int id;
	
	private String name;
	
	private int age;
	
	

	public StudentEntity(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public StudentEntity() {
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
