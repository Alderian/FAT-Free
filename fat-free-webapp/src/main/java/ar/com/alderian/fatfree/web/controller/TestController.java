/**
 * 
 */
package ar.com.alderian.fatfree.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import ar.com.alderian.fatfree.entity.Test;
import ar.com.alderian.fatfree.service.core.TestService;

/**
 * @author oalvarez
 * 
 */
@Controller
public class TestController {

	private TestService testService;

	/**
	 * @return
	 */
	public String getLabel() {

		return "Esta es una etiqueta.";

	}

	/**
	 * @return
	 */
	public String getValue() {

		return "Esta es el valor: " + testService.getValue();

	}

	/**
	 * @return
	 */
	public List<Test> getlist() {
		List<Test> list = testService.list();
		if (list == null) list = new ArrayList<Test>();
		return list;
	}

	/**
	 * @return the testService
	 */
	public TestService getTestService() {
		return testService;
	}

	/**
	 * @param testService
	 *            the testService to set
	 */
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

}
