package com.vmware.talentboost.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vmware.talentboost.spring.data.UnauthorizedException;
import com.vmware.talentboost.spring.data.UserAccount;
import com.vmware.talentboost.spring.impl.AccountManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-config.xml")
public class AuthTests {
	
	@Autowired
	private AccountManager accountManager;
//	
//	@Before
//	public void setUp(){
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"test-config.xml");
//		accountManager = (AccountManager) context.getBean("accountManagerTestBean");
//	}
	
	@Test
	public void testAuthenticatePositive() {
		try {
			String username = "tanya";
			UserAccount user = accountManager.authenticate(username);
			assertNotNull(user);
			assertNotNull(user.username);
			assertEquals("tanya", user.username);
			assertNotNull(user.role);
			assertEquals("player", user.role);
			
		} catch (UnauthorizedException e) {
			fail("Exception should have been thrown!");
		}
	}
	
	@Test
	public void testAuthenticateNegative() {
		Exception testException = null;
		try {
			String username = "teddy";
			accountManager.authenticate(username);
			fail("Exception should have been thrown!");
			
		} catch (Exception e) {
			testException = e;
		}
		assertNotNull(testException);
		assertTrue(testException instanceof UnauthorizedException);
	}
}
