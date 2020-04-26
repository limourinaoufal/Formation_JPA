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
@Table(name="LIBRARY_MANY_TO_MANY")
public class LibraryManyToMany {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="LIBRARY_NAME")
	private String libraryName;
	
	
	public LibraryManyToMany(String libraryName) {
		super();
		this.libraryName = libraryName;
	}
	

	public LibraryManyToMany() {
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

	@Override
	public String toString() {
		return "LibraryOneToMany [id=" + id + ", libraryName=" + libraryName
				+ "]";
	}

	

}
