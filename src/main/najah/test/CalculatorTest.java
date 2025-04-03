package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.najah.code.Calculator;

@DisplayName("Calculator Tests")
public class CalculatorTest {

	Calculator calc;

	@BeforeEach
	void setUp() throws Exception {
		calc = new Calculator();
		System.out.println("Before Each Test ");

	}

	@BeforeAll
	static void beforeAll() {
		System.out.println("Before All");
	}

	@AfterEach
	void tearDown() {
		System.out.println("After Each Test");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("After All");
	}

	@Test
	@Order(1)
	@DisplayName("Test Add For  Positive Input")
	void testAddPositiveMethod() {
		assertEquals(12, calc.add(1, 2, 3, 6));

	}

	@Test
	@Order(2)
	@DisplayName("Test Add For Negative Input")
	void testAddNegativeMethod() {
		assertEquals(-10, calc.add(-5, -2, -1, -2));

	}

	@Test
	@Order(3)
	@DisplayName("Test Add For Empty Input")
	void testAddEmptyMethod() {
		assertEquals(0, calc.add());

	}

	@Test
	@Order(4)
	@DisplayName("Test Divide For Positive Input")
	void testDividePositiveMethod() {
		assertEquals(3, calc.divide(9, 3));

	}

	@Test
	@Order(5)
	@DisplayName("Test Divide For Negative Input")
	void testDivideNegativeMethod() {
		assertEquals(-3, calc.divide(-9, 3));

	}

	@Test
	@Order(6)
	@DisplayName("Test Divide at Zero Input")
	void testDivideAtZeroMethod() {
		assertThrows(ArithmeticException.class, () -> calc.divide(2, 0));

	}

	@Test
	@Order(7)
	@DisplayName("Test Factorial For Positive Input")
	void testFactorialPositiveMethod() {
		assertEquals(24, calc.factorial(4));

	}

	@Test
	@Order(8)
	@DisplayName("Test Factorial For Negative Input")
	void testFactorialNegativeMethod() {
		assertThrows(IllegalArgumentException.class, () -> calc.factorial(-2));

	}

	@Test
	@Order(19)
	@DisplayName("Test Factorial For Zero Input")
	void testFactorialZeroMethod() {
		assertEquals(1, calc.factorial(0));

	}

	@Test
	@Order(10)
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	@DisplayName("Test Long Running Operation")
	void testLongRunningOperation() {

		assertTrue(true);
	}

	@Test
	@Order(11)
	@Disabled("Test is disabled due to an error. Fix the method by changing the 'false' to 'true'")
	@DisplayName("Failing Test")
	void intentionalFailingTest() {
		assertTrue(false, "This test is intentionally failing. Change 'false' to 'true' to fix it.");
	}

	@ParameterizedTest
	@Order(12)
	@ValueSource(ints = { 1, 5, 10, -3, 0 })
	@DisplayName("Test Add With Parameterized Inputs")
	void testAddWithParameterizedInputs(int value) {
		assertEquals(value + 2, calc.add(value, 2));
	}
}