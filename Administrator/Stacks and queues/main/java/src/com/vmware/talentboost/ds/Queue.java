package com.vmware.talentboost.ds;

/**
 * An interface, defining a queue ADT (abstract data structure).
 * 
 * @param <E> The type of the elements, stored in this queue.
 */
//Q: If we say that the queue ADT is based on the general list ADT, can we 
//define a general list interface and make this Queue interface extend it?
public interface Queue<E> {

   /**
    * Inserts an element in this queue, adding it to the "tail" of the queue.
    * 
    * @param element The element that is being inserted.
    */
   public void enqueue(E element);
   
   /**
    * Removes the "head" of this queue.
    * 
    * @return The element, removed from the "head" of this queue.
    */
   // Q: What happens if the queue is empty and there is no head element?
   public E dequeue();
   
   /**
    * Gets the "head" element of this queue, without removing it.
    * 
    * @return The "head" element of this queue.
    */
   // Q: What happens if the queue is empty and there is no head element?
   public E peek();
   
   /**
    * Returns the number of elements in this queue.
    * 
    * @return The number of elements in this queue.
    */
   public int size();
   
   /**
    * Tests if this queue is empty (contains no elements).
    * 
    * @return <code>true</code> if this queue is empty, <code>false</code>
    *       otherwise.
    */
   public boolean isEmpty();
   
}
