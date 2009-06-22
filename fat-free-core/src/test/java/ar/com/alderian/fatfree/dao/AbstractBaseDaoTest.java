/**
 * 
 */
package ar.com.alderian.fatfree.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * @author oalvarez
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/fatfree-jpa.xml" })
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
public abstract class AbstractBaseDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	protected EntityManager entityManager;

	@PersistenceContext(unitName = "entityManager")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/* Forceing to test this */
	public abstract void list();
	public abstract void persist();
	public abstract void update();
	public abstract void delete();
	public abstract void find();
	public abstract void count();


	@Before
	public void setUp() {
		Assert.assertTrue(entityManager.isOpen());
	}

}