package ma.lndroid.tp.entity.manager.mapping.many.to.one.dto;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_MANY_TO_ONE")
public class StudentManyToOne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "STUDENT_NAME")
	private String name;

	@ManyToOne(targetEntity = LibraryManyToOne.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_LIB")
	private LibraryManyToOne library;

	public StudentManyToOne(String name) {
		super();
		this.name = name;
	}

	public StudentManyToOne() {
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

	public LibraryManyToOne getLibrary() {
		return library;
	}

	public void setLibrary(LibraryManyToOne library) {
		this.library = library;
	}

	@Override
	public String toString() {
		return "StudentOneToOne [id=" + id + ", name=" + name + ", library="
				+ library + "]";
	}

}
