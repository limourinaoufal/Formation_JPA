package ma.lndroid.tp.entity.manager.mapping.one.to.many.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="LIBRARY_ONE_TO_MANY")
public class LibraryOneToMany {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="LIBRARY_NAME")
	private String libraryName;
	

	
	public LibraryOneToMany(String libraryName) {
		super();
		this.libraryName = libraryName;
	}

	public LibraryOneToMany() {
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
