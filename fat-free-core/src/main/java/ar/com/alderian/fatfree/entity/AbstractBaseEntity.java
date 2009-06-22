/**
 * 
 */
package ar.com.alderian.fatfree.entity;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author oalvarez
 * 
 *         Base Entity Bean. Implements toString in a fancy way using
 *         ToStringBuilder.
 * 
 *         Extends Entity Beans from this class so that they implement toString
 *         in a clearer way
 * 
 */
public abstract class AbstractBaseEntity implements Serializable {

	/**
	 * Default generated SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * Implements toString in a fancy way using ToStringBuilder
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
