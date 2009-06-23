/**
 * 
 */
package ar.com.alderian.fatfree.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * @author oalvarez
 * 
 *         Base Service Test to implement basic functionality
 * 
 *         Context is configured using fatfree-model.xml
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/fatfree-model.xml" })
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
public abstract class AbstractBaseServiceTest extends
		AbstractJUnit4SpringContextTests {

	/* Forceing to test this */
	public abstract void list();

	public abstract void create();

	public abstract void update();

	public abstract void delete();

	public abstract void find();

	public abstract void count();

}
