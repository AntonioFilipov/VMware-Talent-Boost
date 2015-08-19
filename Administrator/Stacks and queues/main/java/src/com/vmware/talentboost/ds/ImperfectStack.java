package com.vmware.talentboost.ds;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * <p>An unbounded implementation of the stack ADT, using a sequential memory
 * approach. This implementation relies on dynamically resizing the
 * sequential memory backing, in order to be unbounded.</p>
 *
 * <p>P.S. There are some problems with this class... Check
 * <strong>Item 6</strong> from <strong>"Effective Java, 2nd Edition"</strong>
 * to learn about one of the problems. Can you also find another problem?</p>
 *
 * @param <E> The type of the elements, stored in this stack.
 */
public class ImperfectStack<E> implements Stack<E> {

   /**
    * A counter for the number of elements in this stack. Also used for finding
    * and retrieving the element on the top of the stack. The top element
    * should always be placed on position "size minus one" in the backing array.
    */
   private int size = 0;

   /**
    * The backing array, used for storing the elements of this stack.
    */
   private Object[] elements;

   /**
    * Creates an empty {@link com.vmware.talentboost.ds.ImperfectStack} instance
    * with default initial capacity.
    */
   // Q: Is it bad that we didn't document what is the default initial capacity?
   public ImperfectStack() {
      this(10);
   }

   /**
    * Creates an empty {@link com.vmware.talentboost.ds.ImperfectStack} instance
    * with the given initial capacity.
    *
    * @param capacity The initial capacity of this stack.
    *
    * @throws IllegalArgumentException If the provided initial capacity is
    *       negative.
    */
   public ImperfectStack(int capacity) {
      if (capacity < 0) {
         throw new IllegalArgumentException(
               "Illegal negative capacity: " + capacity);
      }
      elements = new Object[capacity];
   }

   @Override
   public void push(E element) {
      ensureCapacity();
      elements[size++] = element;
   }

   @Override
   public E pop() {
      E topElement = peek();
      --size;
      return topElement;
   }

   @SuppressWarnings("unchecked")
   @Override
   public E peek() {
      if (size == 0) {
         throw new EmptyStackException();
      }
      // We can safely cast elements from the backing array, as the stack
      // allows only elements of type the type parameter to be added in it.
      return (E) elements[size - 1];
   }

   @Override
   public int size() {
      return size;
   }

   @Override
   public boolean isEmpty() {
      return size == 0;
   }

   /**
    * Ensures space for at least one more element, roughly doubling the stack
    * capacity each time the backing array needs to grow.
    */
   private final void ensureCapacity() {
      if (size == elements.length) {
          elements = Arrays.copyOf(elements, 2 * size + 1);
      }
   }

}
