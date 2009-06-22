/**
 * 
 */
package ar.com.alderian.fatfree.service;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import ar.com.alderian.fatfree.dao.TestDao;
import ar.com.alderian.fatfree.entity.Test;

/**
 * @author oalvarez
 * 
 */
public class TestServiceTest extends AbstractBaseServiceTest {

	private TestService service;
	private TestDao mockTestDao;

	@Before
	public void setUp() throws Exception {
		final TestServiceImpl impl = new TestServiceImpl();
		mockTestDao = createMock(TestDao.class);
		impl.setTestDao(mockTestDao);
		this.service = impl;
	}

	@Override
	@org.junit.Test
	public void count() {
		// Prepare test data
		final String name = "test";
		final Test test = new Test(name);
		final List<Test> tests = new ArrayList<Test>();
		tests.add(test);
		final int expected = tests.size();

		// Script the test
		expect(mockTestDao.count()).andReturn(expected);
		replay(mockTestDao);

		// Run the test
		final int actual = service.count();
		verify(mockTestDao);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);
	}

	@Override
	@org.junit.Test
	public void create() {
		// Prepare test data
		final String name = "test";
		final Test test = new Test(name);

		// Script the test
		mockTestDao.persist(test);
		replay(mockTestDao);

		// Run the test
		service.create(test);
		verify(mockTestDao);
	}

	@Override
	@org.junit.Test
	public void delete() {
		// Prepare test data
		final String name = "test";
		final Test test = new Test(name);

		// Script the test
		mockTestDao.delete(test);
		replay(mockTestDao);

		// Run the test
		service.delete(test);
		verify(mockTestDao);
	}

	@Override
	@org.junit.Test
	public void find() {
		// Prepare test data
		final String name = "test";
		final Long id = Long.valueOf(1);
		final Test test = new Test(name);
		test.setId(id);

		// Script the mock object's expectations
		expect(mockTestDao.find(id)).andReturn(test);
		replay(mockTestDao);

		// Run the test. The mock object will fail the test if its
		// script is not followed.
		final Test actualAccount = service.find(id);
		verify(mockTestDao);
		Assert.assertTrue(actualAccount == test);
	}

	@Override
	@org.junit.Test
	public void list() {
		// Prepare test data
		final String name = "test";
		final Test account = new Test(name);
		final List<Test> tests = new ArrayList<Test>();
		tests.add(account);

		// Script the test
		expect(mockTestDao.list()).andReturn(tests);
		replay(mockTestDao);

		// Run the test
		final List<Test> actual = service.list();
		verify(mockTestDao);
		Assert.assertNotNull(actual);
		Assert.assertEquals(1, actual.size());
		Assert.assertEquals(account, actual.get(0));
	}

	@Override
	@org.junit.Test
	public void update() {
		// Prepare test data
		final String name = "test";
		final Test test = new Test(name);
		;
		// Script the test
		mockTestDao.update(test);
		replay(mockTestDao);

		// Run the test
		service.update(test);
		verify(mockTestDao);
	}

	@org.junit.Test
	public void getValue() {
		Assert.assertNotNull(service.getValue());
	}

}
