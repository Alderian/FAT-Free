/**
 * 
 */
package ar.com.alderian.fatfree.service;

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
 *         Base Service Test to implement basic functionality
 * 
 *         Context is configured using fatfree-model.xml
 * 
 */
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = { "classpath:/fatfree-core.xml" })
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
public abstract class AbstractBaseServiceTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	protected EntityManager entityManager;

	@PersistenceContext(unitName = "entityManager")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/* Forceing to test this */
	public abstract void list();

	public abstract void create();

	public abstract void update();

	public abstract void delete();

	public abstract void find();

	public abstract void count();

	@Before
	public void setUpDatabase() {
		Assert.assertTrue(entityManager.isOpen());
	}

}
