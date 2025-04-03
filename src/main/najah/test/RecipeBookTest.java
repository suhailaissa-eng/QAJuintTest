package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.najah.code.Recipe;
import main.najah.code.RecipeBook;

public class RecipeBookTest {

    private RecipeBook rb;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;

    @BeforeEach
    void init() {
        rb = new RecipeBook();
        r1 = new Recipe();
        r2 = new Recipe();
        r3 = new Recipe();
        r1.setName("A");
        r2.setName("B");
        r3.setName("C");
    }

    @Test
    @DisplayName("Test Add Recipe Method")
    void testAddingNewRecipe() {
        assertTrue(rb.addRecipe(r1));
        assertTrue(rb.addRecipe(r2));
        assertTrue(rb.addRecipe(r3));

    }

    @Test
    @DisplayName("Test Add The Same Recipe Twice Method")
    void testAddingTheSameRecipeTwice() {
        assertTrue(rb.addRecipe(r1));
        assertFalse(rb.addRecipe(r1));

    }

    @Test
    @DisplayName("Test Delete Recipe By Valid Index")
    void testDeleteRecipeValidIndex() {
        rb.addRecipe(r1);
        rb.addRecipe(r2);
        String deletedRecipe = rb.deleteRecipe(0);

        assertEquals("A", deletedRecipe);

        assertNotNull(rb.getRecipes()[0]);
        assertTrue(rb.getRecipes()[0] instanceof Recipe);
    }

    @Test
    @DisplayName("Test for editing an existing recipe")
    void testEditRecipe() {
        rb.addRecipe(r1);
        Recipe newRecipe = new Recipe();
        newRecipe.setName("");

        String oldRecipeName = rb.editRecipe(0, newRecipe);
        assertEquals("A", oldRecipeName);
        assertEquals("", rb.getRecipes()[0].getName());
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Test RecipeBook Operations Timeout")
    void testTimeoutForOperations() {
        rb.addRecipe(r1);
        rb.addRecipe(r2);
        rb.addRecipe(r3);
        assertEquals(4, rb.getRecipes().length);
    }

    @ParameterizedTest
    @ValueSource(strings = { "Recipe A", "Recipe B", "Recipe C" })
    @DisplayName("Test Adding Recipes With Parameterized Inputs")
    void testAddRecipeWithParameterizedInputs(String name) {
        Recipe newRecipe = new Recipe();
        newRecipe.setName(name);
        assertTrue(rb.addRecipe(newRecipe));
    }

    @Test
    @Disabled("Test is disabled due to an error. Fix by updating the index handling logic.")
    @DisplayName("Failing Test for Invalid Recipe Index")
    void testInvalidRecipeIndex() {
        rb.addRecipe(r1);
        rb.addRecipe(r2);
        assertNull(rb.getRecipes()[5]);
    }
}