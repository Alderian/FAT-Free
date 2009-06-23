/**
 * 
 */
package ar.com.alderian.fatfree.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author oalvarez
 * 
 *         Base DAO Test to implement basic functionality
 * 
 *         PersistenceExceptions will be auto-translated due to @Component.
 *         AbstractBaseDaoTest Will automatically be transactional due to @Transactional
 *         Any class that extends this Dao is Transactional and Component.
 *         Context is configured using fatfree-jpa.xml
 * 
 */
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
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