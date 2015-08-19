package com.vmware.talentboost.ds;

/**
 * An interface, defining a stack ADT (abstract data structure).
 * 
 * @param <E> The type of the elements, stored in this stack.
 */
// Q: If we say that the stack ADT is based on the general list ADT, can we 
// define a general list interface and make this Stack interface extend it?
public interface Stack<E> {

   /**
    * Pushes an element onto the top of this stack.
    * 
    * @param element The element to be pushed.
    */
   public void push(E element);
   
   /**
    * Removes the top element of this stack.
    * 
    * @return The element, removed from the top of this stack.
    */
   // Q: What happens if the stack is empty and there is no top element?
   public E pop();
   
   /**
    * Gets the top element of this stack, without removing it.
    * 
    * @return The element currently on the top of this stack.
    */
   // Q: What happens if the stack is empty and there is no top element?
   public E peek();
   
   /**
    * Returns the number of elements in this stack.
    * 
    * @return The number of elements in this stack.
    */
   public int size();
   
   /**
    * Tests if this stack is empty (contains no elements).
    * 
    * @return <code>true</code> if this stack is empty, <code>false</code>
    *       otherwise.
    */
   public boolean isEmpty();
}
