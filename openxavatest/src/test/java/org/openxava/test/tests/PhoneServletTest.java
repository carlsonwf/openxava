package org.openxava.test.tests;

import org.openxava.tests.*;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;

/**
 * 
 * @author Javier Paniza
 */

public class PhoneServletTest extends ModuleTestBase {
	
	private final static String MODULE = "AcademicYear"; // Any module is valid
	
	public PhoneServletTest(String testName) {
		super(testName, MODULE);
	}
	
	protected void setUp() throws Exception {
	}
		
	protected void tearDown() throws Exception {
	}
	
	public void testPhoneServlet() throws Exception {
		WebClient client = new WebClient();
		assertNoMobileUI(client, "http://" + getHost() + ":" + getPort() + getContextPath() + "p/" + MODULE); 
		assertNoMobileUI(client, "http://" + getHost() + ":" + getPort() + getContextPath() +"phone");		
	}

	private void assertNoMobileUI(WebClient client, String url) throws Exception {
		HtmlPage page = (HtmlPage) client.getPage(url);
		String html = page.asXml();		
		assertTrue(html.indexOf("Mobile User Interface only available in")>=0);
	}
		
}
