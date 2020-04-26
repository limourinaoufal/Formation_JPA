package ma.lndroid.tp.entity.manager.mapping.one.to.many.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_ONE_TO_MANY")
public class StudentOneToMany {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="STUDENT_NAME")
	private String name;
	
	@OneToMany(targetEntity=LibraryOneToMany.class,cascade=CascadeType.ALL)
	@JoinTable(name="LIB_STU" , inverseJoinColumns=@JoinColumn(name="FK_LIB"),joinColumns=@JoinColumn(name="FK_ST"))
	private List<LibraryOneToMany> library=new ArrayList<LibraryOneToMany>();

	public StudentOneToMany(String name) {
		super();
		this.name = name;
	}

	public StudentOneToMany() {
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

	public List<LibraryOneToMany> getLibrary() {
		return library;
	}

	public void setLibrary(List<LibraryOneToMany> library) {
		this.library = library;
	}

	@Override
	public String toString() {
		return "StudentOneToOne [id=" + id + ", name=" + name + ", library="
				+ library + "]";
	}

}
