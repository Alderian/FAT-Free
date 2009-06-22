/**
 * 
 */
package ar.com.alderian.fatfree.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;

import ar.com.alderian.fatfree.entity.Test;

/**
 * @author oalvarez
 * 
 */
public class TestTest extends AbstractBaseDaoTest {

	private static Log log = LogFactory.getLog(TestTest.class);
	private TestDao testDao;

	@Override
	@org.junit.Test
	public void count() {
		log.debug("getting Tests count");
		final int testCount = testDao.count();
		Assert.assertTrue(testCount > 0);
	}

	@Override
	@org.junit.Test
	public void list() {
		log.debug("getting Tests list");
		final List<Test> tests = testDao.list();
		Assert.assertTrue(tests.size() > 0);
	}

	@Override
	@org.junit.Test
	public void find() {
		log.debug("Finding a Test");
		final Test aTestToPersist = new Test("aTestToFind");
		testDao.persist(aTestToPersist);

		final Test aTestToFind = testDao.find(aTestToPersist.getId());
		Assert.assertNotNull(aTestToFind);
	}

	@Override
	@org.junit.Test
	public void persist() {
		log.debug("Persisting a Test");
		final Test aTestToPersist = new Test("aTestToPersist");
		testDao.persist(aTestToPersist);

		final Test aTestTofind = testDao.find(aTestToPersist.getId());
		Assert.assertNotNull(aTestTofind);
	}

	@Override
	@org.junit.Test
	public void update() {
		final String expected = "Updated";

		log.debug("Persisting a Test");
		final Test aTestToPersist = new Test("aTestToPersist");
		testDao.persist(aTestToPersist);

		final Long aTestId = aTestToPersist.getId();

		final Test aTestTofind = testDao.find(aTestId);
		Assert.assertNotNull(aTestTofind);

		aTestTofind.setName(expected);
		testDao.update(aTestTofind);

		final Test anotherTestTofind = testDao.find(aTestId);
		Assert.assertNotNull(anotherTestTofind);

		Assert.assertEquals(expected, anotherTestTofind.getName());
	}

	@Override
	@org.junit.Test
	public void delete() {
		log.debug("getting Tests count");
		final Test aTestToDelete = new Test("aTestToDelete");
		testDao.persist(aTestToDelete);

		Test aTestTofind = testDao.find(aTestToDelete.getId());
		Assert.assertNotNull(aTestTofind);

		final Long idToFind = aTestTofind.getId();
		testDao.delete(aTestToDelete);

		try {
			aTestTofind = testDao.find(idToFind);
		} catch (NoResultException nre) {
			aTestTofind = null;
		}

		Assert.assertNull(aTestTofind);

	}

	@Before
	public void setUp() {
		log.debug("setting up Test");
		if (testDao == null)
			testDao = new TestDaoImpl();

		testDao.setEntityManager(entityManager);
		testDao.populateDatabase();
		entityManager.flush();
	}

}
