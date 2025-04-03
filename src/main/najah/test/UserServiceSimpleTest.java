package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.najah.code.UserService;

@Execution(ExecutionMode.CONCURRENT)
class UserServiceSimpleTest {
	UserService us;

	@BeforeEach
	void setUp() throws Exception {
		us = new UserService();
		System.out.println("Setup complete for UserService Test");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Test complete for UserService Test");
	}

	@Test
	@DisplayName("Test The Email Validation With Valid Email")
	void testValidEmail() {
		assertTrue(us.isValidEmail("suhaila@gmail.com"));
	}

	@Test
	@DisplayName("Test The Email Validation With invalid input without (.)")
	void testInvalidEmail1() {
		assertFalse(us.isValidEmail("suhaila@gmailcom"));
	}

	@Test
	@DisplayName("Test The Email Validation With invalid input without (@)")
	void testInvalidEmail2() {
		assertFalse(us.isValidEmail("suhailagmail.com"));
	}

	@Test
	@DisplayName("Test The Email Validation With invalid inputs without (@) & (.)")
	void testInvalidEmail3() {
		assertFalse(us.isValidEmail("suhailagmailcom"));
	}

	@Test
	@DisplayName("Test The User Authontication With Valid Inputs")
	void testValidAuthontication() {
		assertTrue(us.authenticate("admin", "1234"));
	}

	@Test
	@DisplayName("Test The User Authontication With Invalid Inputs")
	void testInvalidAuthontication() {
		assertFalse(us.authenticate("suhaila", "100200300"));
	}

	@Test
	@DisplayName("Test The User Authontication With Invalid user name")
	void testinValidAuthontication1() {
		assertFalse(us.authenticate("suhaila", "1234"));
	}

	@Test
	@DisplayName("Test The User Authontication With Invalid password")
	void testinValidAuthontication2() {
		assertFalse(us.authenticate("admin", "12341234"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "admin1", "admin2", "admin3" })
	@DisplayName("Test User Authentication with Parameterized Usernames")
	void testAuthenticationWithParameterizedUsernames(String username) {
		assertFalse(us.authenticate(username, "1234"));
	}

	@Test
	@Timeout(100)
	@DisplayName("Test Timeout Method")
	void testTimeout() throws InterruptedException {
		Thread.sleep(50);
		assertTrue(true);
	}

	@Test
	@Disabled("Test intentionally failing due to bug")
	@DisplayName("Test intentionally failing")
	void testFailing() {
		assertFalse(true);
	}
}