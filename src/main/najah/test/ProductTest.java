
package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.*;

import main.najah.code.Product;

@Execution(value = ExecutionMode.CONCURRENT)
public class ProductTest {
	Product p;

	@BeforeEach
	void setUp() throws Exception {
		p = new Product("product test", 20);

	}

	@Test
	@DisplayName("Test Product Constructor With Valid Price and Name")
	void testProductValidInputMethod() {
		assertEquals("product test", p.getName());
		assertEquals(20, p.getPrice());
	}

	@Test
	@DisplayName("Test Product Constructor With Negative Price ")
	void testProductNegativePriceMethod() {
		assertThrows(IllegalArgumentException.class, () -> new Product("Invalid Product Price", -20));
	}

	@Test
	@DisplayName("Test Discount Method With Valid Input")
	void testapplyDiscountValidInputMethod() {
		p.applyDiscount(40);
		assertEquals(12, p.getFinalPrice());
	}

	@Test
	@DisplayName("Test Discount Method With Invalid Input")
	void testapplyDiscountInvalidInputMethod() {

		assertThrows(IllegalArgumentException.class, () -> p.applyDiscount(-20));
		assertThrows(IllegalArgumentException.class, () -> p.applyDiscount(90));
	}

	@Test
	@DisplayName("Test Discount Method With Zero Input")
	void testapplyDiscountZeroInputMethod() {
		p.applyDiscount(0);
		assertEquals(20, p.getFinalPrice());
	}

	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	@DisplayName("Test Product Final Price Calculation Timeout")
	void testTimeoutForFinalPriceCalculation() {
		p.applyDiscount(30);
		assertEquals(14, p.getFinalPrice());
	}

	@ParameterizedTest
	@ValueSource(ints = { 10, 20, 30, 40 })
	@DisplayName("Test Discount Method with Different Percentage Values")
	void testApplyDiscountWithParameterizedInput(int discountPercentage) {
		p.applyDiscount(discountPercentage);
		assertTrue(p.getFinalPrice() <= p.getPrice());
	}

	@Test
	@DisplayName("Test Discount Value After Applying Discount")
	void testDiscountValueAfterApplying() {
		p.applyDiscount(30);
		assertEquals(30, p.getDiscount());
	}



}