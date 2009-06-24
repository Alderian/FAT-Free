/**
 * 
 */
package ar.com.alderian.fatfree.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ar.com.alderian.fatfree.entity.Test;

/**
 * @author oalvarez
 * 
 */
public class TestServiceImpl extends AbstractBaseServiceImpl<Test> implements
		TestService {

	private static final Log log = LogFactory.getLog(TestServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.alderian.fatfree.service.TestService#getValue()
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
		return "select count(test) from Test test";
	}

	@Override
	protected String getQueryFindAll() {
		return "select test from Test test";
	}

	@Override
	protected String getQueryFindById() {
		return "select test from Test test where test.id = :id";
	}

}
