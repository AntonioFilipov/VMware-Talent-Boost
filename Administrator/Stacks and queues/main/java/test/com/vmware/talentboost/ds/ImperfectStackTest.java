package com.vmware.talentboost.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

/**
 * Contains tests for {@link ImperfectStack}. For the sake of simplicity, and
 * because element type is of little importance, strings are used for the stack
 * elements.
 */
public class ImperfectStackTest {

   private Stack<String> stack;

   private static final String FIRST_STRING = "Crime and Punishment";
   private static final String SECOND_STRING = "The Great Gatsby";
   private static final String THIRD_STRING = "The Bible";

   private static final String TEST_STRING = "Effective Java";

   private static final void addElements(Stack<? super String> someStack) {
      someStack.push(FIRST_STRING);
      someStack.push(SECOND_STRING);
      someStack.push(THIRD_STRING);
   }

   /**
    * Executed before each test method, setting up a stack with some elements.
    */
   @Before
   public void setUp() {
      stack = new LinkedListStack<>();
      addElements(stack);
   }

   @Test
   public void testSetup() {
      assertEquals(THIRD_STRING, stack.pop());
      assertEquals(SECOND_STRING, stack.pop());
      assertEquals(FIRST_STRING, stack.pop());
      assertEquals(0, stack.size());
   }

   @Test(expected = IllegalArgumentException.class)
   public void testConstructor_ThrowsIae_WhenCapacityNegative() {
      stack = new ImperfectStack<>(-1);
   }

   @Test
   public void testPush_Succeeds_WhenStackNotEmpty() {
      stack.push(TEST_STRING);
      String topElement = stack.peek();

      assertEquals(TEST_STRING, topElement);
   }

   @Test
   public void testPush_Succeeds_WhenStackEmpty() {
      stack = new ImperfectStack<>(0);
      stack.push(TEST_STRING);
      String topElement = stack.peek();

      assertEquals(TEST_STRING, topElement);
      assertEquals(1, stack.size());
   }

   @Test
   public void testPush_Succeeds_WhenStackResized() {
      stack = new ImperfectStack<>(0);
      // Add a breakpoint in ensureCapacity() and notice how the backing array
      // of the stack is resized here. Using test mocking frameworks, we can
      // even test that the ensureCapacity() method is being called in this
      // specific scenario.
      stack.push(TEST_STRING);
      String topElement = stack.peek();

      assertEquals(TEST_STRING, topElement);
   }

   @Test
   public void testPop_Succeeds_WhenStackNotEmpty() {
      stack.push(TEST_STRING);
      String topElement = stack.pop();

      assertEquals(TEST_STRING, topElement);
   }

   @Test(expected = EmptyStackException.class)
   public void testPop_ThrowsEse_WhenStackEmpty() {
      stack = new ImperfectStack<>(1000);
      stack.pop();
   }

   @Test
   public void testPeek_Succeeds_WhenStackNotEmpty() {
      stack.push(TEST_STRING);
      String topElement = stack.peek();

      assertEquals(TEST_STRING, topElement);
   }

   @Test(expected = EmptyStackException.class)
   public void testPeek_ThrowsEse_WhenStackEmpty() {
      stack = new ImperfectStack<>(1000);
      stack.peek();
   }

   @Test
   public void testSize_ReturnsZero_WhenStackEmpty() {
      stack = new ImperfectStack<>(1000);

      assertEquals(0, stack.size());
   }

   @Test
   public void testSize_Succeeds_WhenStackNotEmpty() {
      assertEquals(3, stack.size());

      int i = 0;
      for (; i < 1000; ++i) {
         addElements(stack);
      }

      int expectedSize = 3 * (i + 1);
      assertEquals(expectedSize, stack.size());
   }

   @Test
   public void testIsEmpty_ReturnsTrue_WhenStackEmpty() {
      stack = new ImperfectStack<>(1000);

      assertTrue(stack.isEmpty());
   }

   @Test
   public void testIsEmpty_ReturnsFalse_WhenStackNotEmpty() {
      assertFalse(stack.isEmpty());
   }

}
