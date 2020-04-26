package ma.lndroid.tp.entity.manager.mapping.many.to.many.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_MANY_TO_MANY")
public class StudentManyToMany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "STUDENT_NAME")
	private String name;
	@ManyToMany(targetEntity = LibraryManyToMany.class, 
			cascade = CascadeType.ALL,
			fetch=FetchType.EAGER)
	@JoinTable(name = "LIB_ST_MANY_TO_MANY", joinColumns = @JoinColumn(name = "FK_ST"), inverseJoinColumns = @JoinColumn(name = "FK_LIB"))
	private List<LibraryManyToMany> library = new ArrayList<LibraryManyToMany>();

	public StudentManyToMany(String name) {
		super();
		this.name = name;
	}

	public StudentManyToMany() {
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

	public List<LibraryManyToMany> getLibrary() {
		return library;
	}

	public void setLibrary(List<LibraryManyToMany> library) {
		this.library = library;
	}

	@Override
	public String toString() {
		return "StudentOneToOne [id=" + id + ", name=" + name + ", library="
				+ library + "]";
	}

}
