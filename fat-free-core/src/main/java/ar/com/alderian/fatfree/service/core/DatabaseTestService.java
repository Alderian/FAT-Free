/**
 * 
 */
package ar.com.alderian.fatfree.service.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ar.com.alderian.fatfree.entity.Test;

/**
 * @author oalvarez
 * 
 */
public class DatabaseTestService extends AbstractDatabaseService<Test> implements
		TestService {

	private static final Log log = LogFactory.getLog(DatabaseTestService.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.alderian.fatfree.service.core.core.TestService#getValue()
	 */
	public String getValue() {
		return "Este es un mensaje de prueba";
	}

	@Override
	public void populateDatabase() {
		if (count() == 0) {
			log.debug("populating Test");
			persist(new Test("Standard"));
			persist(new Test("Overtime"));
		}
	}

	@Override
	protected String getQueryCountAll() {
		return "Test.count";
	}

	@Override
	protected String getQueryFindAll() {
		return "Test.findAll";
	}

	@Override
	protected String getQueryFindById() {
		return "Test.findById";
	}

}
