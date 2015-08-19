package com.vmware.talentboost.ds;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Contains tests for {@link com.vmware.talentboost.ds.ImperfectStack}. For the
 * sake of simplicity, and because element type is of little importance,
 * strings are used for the queue elements.
 */
public class UnfinishedImperfectQueueTest {

   private ImperfectQueue<String> queue;

   private static final String FIRST_STRING = "Crime and Punishment";
   private static final String SECOND_STRING = "The Great Gatsby";
   private static final String THIRD_STRING = "The Bible";

   private static final void addElements(Queue<? super String> someQueue) {
      someQueue.enqueue(FIRST_STRING);
      someQueue.enqueue(SECOND_STRING);
      someQueue.enqueue(THIRD_STRING);
   }

   /**
    * Executed before each test method, setting up a stack with some elements.
    */
   @Before
   public void setUp() {
      queue = new ImperfectQueue<>();
      addElements(queue);
   }

   @Test
   public void testSetup() {
      assertEquals(3, queue.size());
      assertEquals(FIRST_STRING, queue.dequeue());
      assertEquals(SECOND_STRING, queue.dequeue());
      assertEquals(THIRD_STRING, queue.dequeue());
      assertEquals(0, queue.size());
   }

   //---------------------------------------------------------------------------
   //                        IMPLEMENT TESTS BELOW
   //---------------------------------------------------------------------------
   @Test
   public void testPeekWhenQueueIsNotEmpty(){
	   assertEquals(FIRST_STRING, queue.peek());
   }
   
   @Test
   public void testIsEmpty_ReturnsFalse_WhenStackNotEmpty() {
      assertFalse(queue.isEmpty());
   }

}
