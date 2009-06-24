/**
 * 
 */
package ar.com.alderian.fatfree.web.controller;

import org.springframework.stereotype.Controller;

import ar.com.alderian.fatfree.service.TestService;

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
