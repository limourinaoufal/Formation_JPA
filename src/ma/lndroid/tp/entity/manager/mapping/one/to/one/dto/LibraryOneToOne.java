package ma.lndroid.tp.entity.manager.mapping.one.to.one.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="LIBRARY_ONE_TO_ONE")
public class LibraryOneToOne {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="LIBRARY_NAME")
	private String libraryName;
	
	@OneToOne(targetEntity=StudentOneToOne.class,fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="FK_STUDENT")
	private StudentOneToOne student;
	
	public LibraryOneToOne(String libraryName) {
		super();
		this.libraryName = libraryName;
		this.student = student;
	}

	public LibraryOneToOne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public StudentOneToOne getStudent() {
		return student;
	}

	public void setStudent(StudentOneToOne student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "LibraryOneToOne [id=" + id + ", libraryName=" + libraryName
				+ ", student=" + student + "]";
	}
	
	

}
