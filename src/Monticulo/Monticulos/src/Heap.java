import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Heap<E> implements HeapInterface<E> {

    // Watch these videos to understand the code:
    // https://youtu.be/t0Cq6tVNRBA
    // https://youtu.be/WCm3TqScBM8
    // https://youtu.be/0wPlzMU-k00

    private ArrayList<E> heap;
    private Comparator<E> comparator;

    public Heap(Comparator<E> c) {
        this.heap = new ArrayList<>();
        this.comparator = c;
    }

    public Heap() {
        this(new DefaultComparator<>());
    }

    /**
     * Returns the index of the parent node for the given index.
     *
     * @param i The index of the node.
     * @return The index of the parent node.
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Returns the index of the left child node for the given index.
     *
     * @param i The index of the parent node.
     * @return The index of the left child node.
     */
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * Returns the index of the right child node for the given index.
     *
     * @param i The index of the parent node.
     * @return The index of the right child node.
     */
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    /**
     * Sifts up the element at the given index in the heap, maintaining the heap property.
     * If the element at the given index is smaller than its parent, the element is swapped with its parent.
     * This process is repeated until the element is in its correct position or until the index reaches 0 (the root).
     *
     * @param i The index of the element to sift up.
     */
    private void siftUp(int i) {
        if (i > 0) { // If the element is at the root, it is already in its correct position.
            int parent = parent(i); // Get the index of the parent node.
            if (comparator.compare(heap.get(i), heap.get(parent)) > 0) { // If the parent is larger than the element,
                swap(i, parent); // swap the element with its parent and sift up the parent.
                siftUp(parent); // Sift up the parent.
            }
        }
    }

    /**
     * Sifts down the element at the given index in the heap, maintaining the heap property.
     * If the element at the given index is larger than either of its children,
     * the element is swapped with its smallest child.
     * This process is repeated until the element is in its correct position or until it reaches a leaf node.
     *
     * @param i The index of the element to sift down.
     */
    private void siftDown(int i) {
        int left = leftChild(i); // Get the index of the left child.
        int right = rightChild(i); // Get the index of the right child.
        int smallest = i; // Assume the element at the given index is the smallest.
        if (left < size() && comparator.compare(heap.get(i), heap.get(left)) < 0) { // If the left child is smaller than the element,
            smallest = left; // the left child is the smallest.
        }
        if (right < size() && comparator.compare(heap.get(smallest), heap.get(right)) < 0) { // If the right child is smaller than the element,
            smallest = right; // the right child is the smallest.
        } // If the element is not the smallest,
        if (smallest != i) { // swap it with its smallest child and sift down the child.
            swap(i, smallest); // Swap the element with its smallest child.
            siftDown(smallest); // Sift down the child.
        }
    }

    /**
     * Swaps the elements at the given indices in the heap.
     *
     * @param i The index of the first element to swap.
     * @param j The index of the second element to swap.
     */
    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    @Override
    public boolean add(E e) {
        heap.add(e);
        siftUp(heap.size() - 1);
        return true;
    }

    @Override
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    @Override
    public Iterator<E> iterator() {
        return this.heap.iterator();
    }

    /**
     * Removes and returns the top element of the heap.
     *
     * @return The top element of the heap.
     */
    @Override
    public E remove() {
        if (heap.isEmpty()) {
            throw new RuntimeException();
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }
        E sustituto = heap.get(heap.size() - 1);//cojes el último
        heap.remove(heap.size() - 1); //borras el último
        E toReturn = heap.set(0, sustituto);//sustituyes la cima
        siftDown(0);
        return toReturn;
    }

    /**
     * Returns the top element of the heap without removing it.
     *
     * @return The top element of the heap, or null if the heap is empty.
     */
    @Override
    public E peak() {
        if (isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public void clear() {
        heap.clear();
    }


    // To String method with debugging purposes
    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < heap.size(); i++) {
            sb.append(heap.get(i));
            if (i < heap.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    /**
     * Checks if the heap property is valid for all nodes.
     *
     * @return True if the heap property is valid for all nodes, false otherwise.
     */
    public boolean isHeap() {
        return isHeap(0);
    }

    /**
     * Checks if the heap property is valid for the node at the given index and all its descendants.
     *
     * @param i The index of the node to check.
     * @return True if the heap property is valid for the node at the given index and all its descendants, false otherwise.
     */
    private boolean isHeap(int i) {
        if (i >= size()) { // If the index is out of bounds, return true.
            return true;
        }
        int left = leftChild(i); // Get the index of the left child.
        int right = rightChild(i); // Get the index of the right child.
        if (left < size() && comparator.compare(heap.get(i), heap.get(left)) < 0) { // If the left child is smaller than the element,
            return false; // the heap property is violated.
        }
        if (right < size() && comparator.compare(heap.get(i), heap.get(right)) < 0) { // If the right child is smaller than the element,
            return false; // the heap property is violated.
        }
        return isHeap(left) && isHeap(right); // Check if the heap property is valid for the children.
    }

    public void printHeap() {
        if (heap.isEmpty()) {
            System.out.println("(heap is empty)");
            return;
        }
        System.out.println("------");
        int depth = (int) Math.floor(Math.log(heap.size() + 1) / Math.log(2));
        printHeap(0, depth, "");
        System.out.println("------");
    }

    private void printHeap(int i, int depth, String indent) {
        if (i < heap.size()) {
            printHeap(rightChild(i), depth - 1, indent + "   ");

            for (int j = 0; j < depth; j++) {
                System.out.print("   ");
            }
            System.out.println(heap.get(i));

            printHeap(leftChild(i), depth - 1, indent + "   ");
        }
    }

}