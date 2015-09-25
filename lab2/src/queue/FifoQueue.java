package queue;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E>implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		private int counter;

		private QueueIterator() {
			pos = last.next;
			counter = 0;
		}

		public boolean hasNext() {
			if (size == 0) {
				return false;
			}
			return (size>counter);
		}

		public E next() {
			E temp = pos.element;
			pos = pos.next;
			counter++;
			return temp;
		}

	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param x
	 *            the element to insert
	 * @return true if it was possible to add the element to this queue, else
	 *         false
	 */
	public boolean offer(E x) {
		QueueNode<E> ny = new QueueNode<E>(x);
		if (size == 0) {
			size = 1;
			last = ny;
			ny.next = ny;
			return true;
		}
		size = size + 1;
		QueueNode<E> temp = last.next;
		last.next = ny;
		ny.next = temp;
		return true;
	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is
	 * empty. post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		if (size != 0) {
			size = size - 1;
			E t = last.element;
			QueueNode<E> temp = last;
			while (temp.next != last) {
				temp = temp.next;
			}
			temp.next = last.next;
			last = temp;
			return t;
		} else
			return null;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */
	public E peek() {
		if (size != 0) {
			return last.element;
		} else
			return null;
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}

	}

	public void append(FifoQueue<E> q) {
		if (q.size != 0) {
			if (size != 0) {
				QueueNode<E> temp1 = last.next;
				QueueNode<E> temp2 = q.last.next;
				last.next = temp2;
				q.last.next = temp1;
			} else {
				last = q.last;
			}
		}
		size = size + q.size();
	}

}
