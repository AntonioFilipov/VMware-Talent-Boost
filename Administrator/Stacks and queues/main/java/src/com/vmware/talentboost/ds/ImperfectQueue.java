package com.vmware.talentboost.ds;

/**
 * <p>An unbounded implementation of the queue ADT, using a linked memory
 * approach. Offers FIFO ordering, based on element admission criteria.</p>
 *
 * <p>P.S. There's something wrong with this class...</p>
 *
 * @param <E> The type of the elements, stored in this queue.
 */
public class ImperfectQueue<E> implements Queue<E> {

   /**
    * A counter for the number of elements in this queue.
    */
   private int size = 0;

   /**
    * A reference to the "head" node of the queue.
    * <ul>
    *    <li>It should be the node, added the earliest from the current nodes
    *       in the queue.</li>
    *    <li>It should also contain the element that will be retrieved, the
    *       next time an element is dequeued.</li>
    * </ul>
    */
   private Node<E> head;

   /**
    * A reference to the "tail" node of the queue.
    * <ul>
    *    <li>It should be the last added node in the queue.</li>
    * </ul>
    */
   private Node<E> tail;

   /**
    * Creates an empty {@link ImperfectQueue} instance.
    */
   public ImperfectQueue() {

   }

   @Override
   public void enqueue(E element) {
      final Node<E> oldTail = tail;
      final Node<E> newNode = new Node<>(element, null);

      tail = newNode;

      if (oldTail == null) {
         head = newNode;
      } else {
         oldTail.next = newNode;
      }

      ++size;
   }

   @Override
   public E dequeue() {
      final E element = peek();
      final Node<E> oldHead = head;
      final Node<E> newHead = oldHead.next;

      head = newHead;

      if (newHead == null) {
         tail = null;
      }

      --size;
      return element;
   }

   @Override
   public E peek() {
      return head.element;
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
    * Defines a node, used by this linked queue implementation. This node
    * implementation is single-linked, keeping track only of the node AFTER
    * in the queue.
    *
    * @param <E> The type of the elements, stored in this queue, and
    *       correspondingly, in one such node.
    */
   private static final class Node<E> {

      /**
       * The data structure element, contained in this node.
       */
      E element;

      /**
       * A reference to the next node in the queue, relative to this one.
       * <ul>
       *    <li>The next node for the "tail" node should be
       *       <code>null</code>.</li>
       *    <li>The next node for the "head" node should be the node, that was
       *       added immediately after the "head" node (given no special
       *       ordering criteria).</li>
       * </ul>
       */
      Node<E> next;

      /**
       * Creates a new queue node, given the element that the node will contain
       * and reference to the next node, relative to the new one.
       *
       * @param elementData The data structure element, contained in this node.
       * @param nextNode A reference to the next node.
       */
      Node(E elementData, Node<E> nextNode) {
         this.element = elementData;
         this.next = nextNode;
      }
   }

}
