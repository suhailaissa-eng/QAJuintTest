package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.najah.code.Recipe;
import main.najah.code.RecipeException;

class RecipeTest {

	Recipe recipe;
	
	@BeforeEach
	void setUp() throws Exception {
		 recipe = new Recipe();

	}
	
	@Test
	@DisplayName("Test Amount Of  Coffee")
	void testSettamtCoffee() throws RecipeException {
		recipe.setAmtCoffee("3");
		assertEquals(3, recipe.getAmtCoffee());
	}
	
	
	
	
	@Test
	@DisplayName("Test Amount Of  Milk")
	void testSettamtMilk() throws RecipeException {
		recipe.setAmtMilk("3");
		assertEquals(3, recipe.getAmtMilk());
	}
	

	

	@Test
	@DisplayName("Test Amount Of  Sugar")
	void testSettamtSugar() throws RecipeException {
		recipe.setAmtSugar("3");
		assertEquals(3, recipe.getAmtSugar());
	}
	


	@Test
	@DisplayName("Test Amount Of  Chocolate ")
	void testSettamtChocolate () throws RecipeException {
		recipe.setAmtChocolate ("3");
		assertEquals(3, recipe.getAmtChocolate ());
	}

	
    @Test
    @DisplayName("Test Amount Of Coffee with Negative OR Non Numeric Value")
    void testSetAmtCoffeeWithNegativeValue() {
        assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("-5"));
        assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("A"));
    }

    
    @Test
    @DisplayName("Test Amount Of Milk with Negative OR Non Numeric Value")
    void testSetAmtMilkWithNegativeValue() {
        assertThrows(RecipeException.class, () -> recipe.setAmtMilk("-5"));
        assertThrows(RecipeException.class, () -> recipe.setAmtMilk("A"));
    }
   

    @Test
    @DisplayName("Test Amount Of Sugar with Negative OR Non Numeric Value")
    void testSetAmtSugarWithNegativeValue() {
        assertThrows(RecipeException.class, () -> recipe.setAmtSugar("-5"));
        assertThrows(RecipeException.class, () -> recipe.setAmtSugar("A"));
    }
    
    @Test
    @DisplayName("Test Amount Of  Chocolate with Negative  OR Non Numeric Value")
    void testSetAmtChocolateWithNegativeValue() {
        assertThrows(RecipeException.class, () -> recipe.setAmtChocolate("-5"));
        assertThrows(RecipeException.class, () -> recipe.setAmtChocolate("A"));
    }
    
    
    @Test
    @DisplayName("Test Set Name")
    void testSetName() {
        recipe.setName("test");
        assertEquals("test", recipe.getName());
    }
    
    

    @DisplayName("Test To String Method")
    @Test
    void testToString() {
        recipe.setName("test");
        assertEquals("test", recipe.toString());
    }



    @Test
    @DisplayName("Test Set Price")
    void testSetPrice() throws RecipeException {
        recipe.setPrice("20");
        assertEquals(20, recipe.getPrice());
    }
    
    
    @Test
    @DisplayName("Test Set Price With Nigative OR Non Numeric Value")
    void testSetPriceWithNegative() throws RecipeException {
       assertThrows(RecipeException.class, () -> recipe.setPrice("-20"));
       assertThrows(RecipeException.class, () -> recipe.setPrice("A"));
    }
    
    
    @Test
    @DisplayName("Test hashCode with Same names")
    void testHashCodeWithIdenticalNames() {
        Recipe A = new Recipe();
        Recipe B = new Recipe();
        
        A.setName("A");
        B.setName("A");

        assertEquals(A.hashCode(), B.hashCode());
    }

    @Test
    @DisplayName("Test hashCode with different names")
    void testHashCodeWithDifferentNames() {
    	 Recipe A = new Recipe();
         Recipe B = new Recipe();
         
         A.setName("A");
         B.setName("B");

         assertNotEquals(A.hashCode(), B.hashCode());

      
    }

    @Test
    @DisplayName("Test hashCode when name is null")
    void testHashCodeWithNullName() {
    	 Recipe A = new Recipe();
         Recipe B = new Recipe();

         assertEquals(A.hashCode(), B.hashCode());
    }
    
    
  
    
    @Test
    @DisplayName("Test equals with the same object")
    void testEqualsSameObject() {
        Recipe A = new Recipe();
        A.setName("Espresso");
        assertTrue(A.equals(A));
    }

    @Test
    @DisplayName("Test equals with different object but with The Same name")
    void testEqualsDifferentObjectSameName() {
        Recipe A = new Recipe();
       A.setName("A");
        
        Recipe B = new Recipe();
        B.setName("A");
        
        assertTrue(A.equals(B));
    }

    @Test
    @DisplayName("Test equals with different object and different name")
    void testEqualsDifferentObjectDifferentName() {
        Recipe A = new Recipe();
        A.setName("A");
        
        Recipe B = new Recipe();
        B.setName("B");
        
        assertFalse(A.equals(B));
    }

    @Test
    @DisplayName("Test equals with null object")
    void testEqualsNull() {
        Recipe A = new Recipe();
        A.setName("A");
        
        assertFalse(A.equals(null));
    }

    @Test
    @DisplayName("Test equals with different class type")
    void testEqualsDifferentClass() {
        Recipe A = new Recipe();
        A.setName("A");
        
        String B = "B";
        
        assertFalse(A.equals(B));
    }
    
    @Test
    @DisplayName("Test equals with null name in the other object")
    void testEqualsWithNullNameInOtherObject() {
        Recipe A = new Recipe();
        A.setName("A");

        Recipe B = new Recipe();
        B.setName(null); 

        assertFalse(A.equals(B)); 
    }
}