/**
 * 
 */
package ar.com.alderian.fatfree.service;

import org.springframework.transaction.annotation.Transactional;

import ar.com.alderian.fatfree.dao.TestDao;
import ar.com.alderian.fatfree.entity.Test;

/**
 * @author oalvarez
 *
 */
@Transactional
public class TestServiceImpl extends AbstractBaseServiceImpl<Test> implements TestService {
	
	/* (non-Javadoc)
	 * @see ar.com.alderian.fatfree.service.TestService#getValue()
	 */
	public String getValue() {
		return "Este es un mensaje de prueba";
	}

	public TestDao getTestDao() {
		return (TestDao) this.getBaseDao();
	}

	public void setTestDao(TestDao testDao) {
		this.setBaseDao(testDao);
	}
	
}
