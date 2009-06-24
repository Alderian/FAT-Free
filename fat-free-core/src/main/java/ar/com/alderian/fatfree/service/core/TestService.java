/**
 * 
 */
package ar.com.alderian.fatfree.service.core;

import ar.com.alderian.fatfree.entity.Test;

/**
 * @author oalvarez
 * 
 */
public interface TestService extends DataBaseService<Test> {

	/**
	 * @return
	 */
	public String getValue();

}
