package ma.lndroid.tp.entity.manager.mapping.one.to.one.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_ONE_TO_ONE")
public class StudentOneToOne {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="STUDENT_NAME")
	private String name;
	
	@OneToOne(mappedBy="student")
	private LibraryOneToOne library;

	public StudentOneToOne(String name) {
		super();
		this.name = name;
	}

	public StudentOneToOne() {
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

	public LibraryOneToOne getLibrary() {
		return library;
	}

	public void setLibrary(LibraryOneToOne library) {
		this.library = library;
	}

	@Override
	public String toString() {
		return "StudentOneToOne [id=" + id + ", name=" + name + ", library="
				+ library + "]";
	}

}
