/**
 * 
 */
package ar.com.alderian.fatfree.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author oalvarez
 * 
 */
@Entity
public class Test extends AbstractBaseEntity {

	/**
	 * Default Serial version Id
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String Name;

	/**
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		Id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * Complete constructor.
	 * 
	 * @param name
	 *            the name to set
	 */
	public Test(String name) {
		super();
		Name = name;
	}

	/**
	 * Default constructor
	 */
	public Test() {
		super();
	}

}
