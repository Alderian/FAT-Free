/**
 * 
 */
package ar.com.alderian.fatfree.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import ar.com.alderian.fatfree.entity.Test;

/**
 * @author oalvarez
 * 
 */
@Transactional
public class TestDaoImpl extends AbstractBaseDaoImpl<Test> implements TestDao {

	private static final Log log = LogFactory.getLog(TestDaoImpl.class);

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
