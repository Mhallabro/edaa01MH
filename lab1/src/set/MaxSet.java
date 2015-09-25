package set;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class MaxSet<E extends Comparable<E>> extends ArraySet<E> {
	private E maxElement = null;

	/**
	 * Constructs a new empty set.
	 */
	public MaxSet() {
		super();
	}

	/**
	 * Returns the currently largest element in this set. pre: the set is not
	 * empty post: the set is unchanged
	 * 
	 * @return the currently largest element in this set
	 * @throws NoSuchElementException
	 *             if this set is empty
	 */
	public E getMax() {
		if (maxElement == null) {
			throw new NoSuchElementException();
		}
		return maxElement;
	}

	/**
	 * Adds the specified element to this set, if it is not already present.
	 * post: x is added to the set if it is not already present
	 * 
	 * @param x
	 *            the element to be added
	 * @return true if the specified element was added
	 */
	@Override
	public boolean add(E x) {
		if (isEmpty()) {
			maxElement = x;
			super.add(x);
			return true;
		}
		if (x.compareTo(maxElement) > 0) {
			maxElement = x;
			super.add(x);
			return true;
		}
		super.add(x);
		return false;

	}

	/**
	 * Removes the specified element from this set if it is present. post: x is
	 * removed if it was present
	 * 
	 * @param x
	 *            the element to remove - if present
	 * @return true if the set contained the specified element
	 */
	@Override
	public boolean remove(Object x) {
		if (super.remove(x)) {
			if (x.equals(maxElement)) {
				maxElement = null;
				Iterator<E> itr = super.iterator();
				while(itr.hasNext()){
					E e = itr.next();
					if(maxElement == null || e.compareTo(maxElement) == 1){
						maxElement = e;
					}
				}
				
				return true;
			}
			
		}
		return false;
	}

	/**
	 * Adds all of the elements in the specified set, for which it is possible,
	 * to this set. post: all elements, for which it is possible, in the
	 * specified set are added to this set.
	 * 
	 * @return true if this set changed as a result of the call
	 */
	@Override
	public boolean addAll(SimpleSet<? extends E> c) {
		if(super.addAll(c)){
			for (E e : c) {
				if (e.compareTo(maxElement) > 0) {
					maxElement = e;
				}
			}
			super.addAll(c);
			return true;
		}
		super.addAll(c);
		return false;
	}

}