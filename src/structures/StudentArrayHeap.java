package structures;

import java.util.Comparator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {

	protected StudentArrayHeap(Comparator<P> comparator) {
		super(comparator);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int getLeftChildOf(int index) {
		if(index < 0) throw new IndexOutOfBoundsException();
		//as explained in the power point
		return (2*index+1);
	}

	@Override
	protected int getRightChildOf(int index) {
		if(index < 0) throw new IndexOutOfBoundsException();
		//as explained in the power point
		return (2*index+2);
	}

	@Override
	protected int getParentOf(int index) {
		if(index <= 0) throw new IndexOutOfBoundsException();
		//as explained in the power point
		return ((index-1)/2);
	}

	@Override
	protected void bubbleUp(int index) {
		int hole = index;
		//whilethe parent is less than the child and the hole is not at the root
		while((hole > 0) && (super.comparator.compare(heap.get(getParentOf(hole)).getPriority(), heap.get(hole).getPriority())) < 0){
			int parent = getParentOf(hole);
			//swap the parent and the hole
			swap(hole,parent);
			//change the hole to be the parent
			hole = parent;
		}	
	}

	@Override
	protected void bubbleDown(int index) {
		//base case
		if(getLeftChildOf(index) < heap.size()){
			return;
		}
		//if the node at index has less priority than it's right children sawp
		if(super.comparator.compare(heap.get(index).getPriority(), heap.get(getRightChildOf(index)).getPriority()) < 0){
			swap(getRightChildOf(index),index);
			bubbleDown(getRightChildOf(index));
			
			//if the node at index has less priority than it's left children sawp
		}else if(super.comparator.compare(heap.get(index).getPriority(), heap.get(getLeftChildOf(index)).getPriority()) < 0){
			swap(getLeftChildOf(index),index);
			bubbleDown(getLeftChildOf(index));
		}
		
		
	}
	
	
	
}
