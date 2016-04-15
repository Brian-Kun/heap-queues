package structures;

import java.util.Comparator;
import java.util.Iterator;

import comparators.IntegerComparator;

public class MaxQueue<V> implements PriorityQueue<Integer, V> {
	
	IntegerComparator integerComparator = new IntegerComparator();
	protected StudentArrayHeap<Integer, V> heap = new StudentArrayHeap<Integer, V>(integerComparator);
	

	@Override
	public PriorityQueue<Integer, V> enqueue(Integer priority, V value) {
		heap.add(priority, value);
		heap.bubbleDown(size()-1);
		return this;
	}

	@Override
	public V dequeue() {
		return heap.remove();
	}

	@Override
	public V peek() {
		// TODO Auto-generated method stub
		return heap.peek();
	}

	@Override
	public Iterator<Entry<Integer, V>> iterator() {
		// TODO Auto-generated method stub
		return heap.asList().iterator() ;
	}

	@Override
	public Comparator<Integer> getComparator() {
		// TODO Auto-generated method stub
		return integerComparator;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return heap.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size() == 0);
	}
}

