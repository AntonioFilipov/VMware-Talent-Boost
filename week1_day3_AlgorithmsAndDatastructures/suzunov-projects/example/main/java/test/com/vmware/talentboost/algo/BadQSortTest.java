package com.vmware.talentboost.algo;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for that bad, bad quicksort.
 */
public class BadQSortTest {

   int[] arr;

   @Before
   public void setUp() {
      // ???
   }

   @Test
   public void testSort() {
      int[] arr = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
      int[] arr2 = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
      BadQSort.sort(arr);
      
      Assert.assertArrayEquals(arr2, arr);
   }

}
