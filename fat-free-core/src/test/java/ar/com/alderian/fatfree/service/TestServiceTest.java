/**
 * 
 */
package ar.com.alderian.fatfree.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.NoResultException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;

import ar.com.alderian.fatfree.entity.Test;
import ar.com.alderian.fatfree.service.TestService;
import ar.com.alderian.fatfree.service.TestServiceImpl;

/**
 * @author oalvarez
 * 
 */
public class TestServiceTest extends AbstractBaseServiceTest {

	private static Log log = LogFactory.getLog(TestServiceTest.class);
	private TestService databaseTestService;

	@Override
	@org.junit.Test
	public void count() {
		log.debug("getting Tests count");
		final int testCount = databaseTestService.count();
		Assert.assertTrue(testCount > 0);
	}

	@Override
	@org.junit.Test
	public void list() {
		log.debug("getting Tests list");
		final List<Test> tests = databaseTestService.list();
		Assert.assertTrue(tests.size() > 0);
	}

	@Override
	@org.junit.Test
	public void find() {
		log.debug("Finding a Test");
		final Test aTestToPersist = new Test("aTestToFind");
		databaseTestService.persist(aTestToPersist);

		final Test aTestToFind = databaseTestService.find(aTestToPersist.getId());
		Assert.assertNotNull(aTestToFind);
	}

	@Override
	@org.junit.Test
	public void create() {
		log.debug("Persisting a Test");
		final Test aTestToPersist = new Test("aTestToPersist");
		databaseTestService.persist(aTestToPersist);

		final Test aTestTofind = databaseTestService.find(aTestToPersist.getId());
		Assert.assertNotNull(aTestTofind);
	}

	@Override
	@org.junit.Test
	public void update() {
		final String expected = "Updated";

		log.debug("Persisting a Test");
		final Test aTestToPersist = new Test("aTestToPersist");
		databaseTestService.persist(aTestToPersist);

		final Long aTestId = aTestToPersist.getId();

		final Test aTestTofind = databaseTestService.find(aTestId);
		Assert.assertNotNull(aTestTofind);

		aTestTofind.setName(expected);
		databaseTestService.update(aTestTofind);

		final Test anotherTestTofind = databaseTestService.find(aTestId);
		Assert.assertNotNull(anotherTestTofind);

		Assert.assertEquals(expected, anotherTestTofind.getName());
	}

	@Override
	@org.junit.Test
	public void delete() {
		log.debug("getting Tests count");
		final Test aTestToDelete = new Test("aTestToDelete");
		databaseTestService.persist(aTestToDelete);

		Test aTestTofind = databaseTestService.find(aTestToDelete.getId());
		Assert.assertNotNull(aTestTofind);

		final Long idToFind = aTestTofind.getId();
		databaseTestService.delete(aTestToDelete);

		try {
			aTestTofind = databaseTestService.find(idToFind);
		} catch (NoResultException nre) {
			aTestTofind = null;
		}

		Assert.assertNull(aTestTofind);

	}

	@org.junit.Test
	public void getValue() {
		Assert.assertNotNull(databaseTestService.getValue());
	}

	@PostConstruct
	public void setUp() {
		log.debug("setting up Test");
		TestServiceImpl service = new TestServiceImpl();

		service.setEntityManager(entityManager);
		databaseTestService = service;
	}

	@Before
	@Override
	public void setUpDatabase() {
		super.setUpDatabase();

		log.debug("setting up Test Database");
		((TestServiceImpl)databaseTestService).populateDatabase();
		entityManager.flush();
	}

}
