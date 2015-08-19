package com.vmware.talentboost.algo;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for that bad, bad quicksort.
 */
public class BadQSort {

   int[] arr;

   @Before
   public void setUp() {
      BadQSort arr = new BadQSort();
   }

   @Test
   public void testSort() {
      int[] array = new int[]{4,3,2,5,6,2,1};
      assert.equals(new int[]{1,2,2,3,4,5,6}, arr.sort(array));
   }

}
