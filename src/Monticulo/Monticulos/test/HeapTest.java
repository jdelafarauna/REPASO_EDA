import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author mayte
 */
public class HeapTest {

    public HeapTest() {
    }

    /**
     * Test of add method, of class Heap.
     */
    @Test
    public void testAdd() {
        System.out.println("add");

        Heap<Integer> instance = new Heap<>();
        assertTrue(instance.isEmpty());
        assertTrue(instance.add(3));
        assertFalse(instance.isEmpty());
        assertEquals(1, instance.size());
        Comparator<? super Integer> comparator = instance.comparator();
        assertTrue(comparator instanceof DefaultComparator);
        assertTrue(instance.add(3));
        assertEquals(2, instance.size());
    }

    /**
     * Test of comparator method, of class Heap.
     */
    @Test
    public void testComparator() {
        System.out.println("comparator");
        Heap<Integer> instance = new Heap<>(new MinimumComparator<>());
        assertTrue(instance.isEmpty());
        Comparator<? super Integer> comparator = instance.comparator();
        assertFalse(comparator instanceof DefaultComparator);
        assertTrue(comparator instanceof MinimumComparator);
    }

    /**
     * Test of iterator method, of class Heap.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        Heap<Integer> instance = new Heap<>(new MinimumComparator<>());
        assertTrue(instance.isEmpty());
        instance.add(1);
        instance.add(2);
        instance.add(3);
        instance.add(4);
        instance.add(5);
        instance.add(6);
        instance.add(7);
        List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Iterator<Integer> iterator = instance.iterator();
        int cont = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            Integer get = asList.get(cont);
            assertEquals(next, get);
            cont++;
        }
    }

    /**
     * Test of remove method, of class Heap.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Heap<Integer> instance = new Heap<>();
        assertTrue(instance.isEmpty());
        assertTrue(instance.add(3));
        assertFalse(instance.isEmpty());
        instance.remove();
        assertTrue(instance.isEmpty());
        instance.add(1);
        instance.add(2);
        instance.add(3);
        instance.add(4);
        instance.add(5);
        instance.add(6);
        instance.add(7);
        assertEquals(instance.size(), 7);
        assertEquals(7, (int) instance.remove());
        assertEquals(instance.size(), 6);
    }

    /**
     * Test of peak method, of class Heap.
     */
    @Test
    public void testPeakDefaultComparator() {
        System.out.println("peak");
        Heap<Integer> instance = new Heap<>();
        instance.add(1);
        assertEquals(1, (int) instance.peak());
        instance.add(2);
        assertEquals(2, (int) instance.peak());
        instance.add(3);
        assertEquals(3, (int) instance.peak());
        instance.add(4);
        assertEquals(4, (int) instance.peak());
        instance.add(5);
        assertEquals(5, (int) instance.peak());
        instance.add(6);
        assertEquals(6, (int) instance.peak());
        instance.add(7);
        assertEquals(7, (int) instance.peak());
    }

    /**
     * Test of peak method, of class Heap.
     */
    @Test
    public void testPeakMinimumComparator() {
        System.out.println("peak");
        Heap<Integer> instance = new Heap<>(new MinimumComparator<>());
        instance.add(7);
        assertEquals(7, (int) instance.peak());
        instance.add(6);
        assertEquals(6, (int) instance.peak());
        instance.add(5);
        assertEquals(5, (int) instance.peak());
        instance.add(4);
        assertEquals(4, (int) instance.peak());
        instance.add(3);
        assertEquals(3, (int) instance.peak());
        instance.add(2);
        assertEquals(2, (int) instance.peak());
        instance.add(1);
        assertEquals(1, (int) instance.peak());
    }


    /**
     * Test the shiftUp method, of class Heap.
     */
    @Test
    public void testShiftUp() {
        // check the shiftUp method with the default comparator. it should be a max heap (the default)
        System.out.println("shiftUp");
        Heap<Integer> instance = new Heap<>();
        instance.add(1);
        instance.add(2);
        instance.add(3);
        instance.add(4);
        instance.add(5);
        instance.add(6);
        instance.add(7);
        instance.printHeap();
        assertEquals(7, (int) instance.peak());
        instance.add(8);
        instance.printHeap();
        assertEquals(8, (int) instance.peak());
        // check that the property of the heap is still valid: the parent is greater than the children
        assertTrue(instance.isHeap());
    }


    /**
     * Test the shiftDown method, of class Heap.
     */
    @Test
    public void testShiftDown() {
        // check the shiftDown method with the default comparator. it should be a max heap (the default)
        System.out.println("shiftDown");
        Heap<Integer> instance = new Heap<>();
        instance.add(8);
        instance.add(7);
        instance.add(6);
        instance.add(5);
        instance.add(4);
        instance.add(3);
        instance.add(2);
        instance.add(1);
        instance.printHeap();
        assertEquals(8, (int) instance.peak());
        instance.remove();
        instance.printHeap();
        assertEquals(7, (int) instance.peak());
        // check that the property of the heap is still valid: the parent is greater than the children
        assertTrue(instance.isHeap());
    }

    /**
     * Test of isEmpty method, of class Heap.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Heap<Integer> instance = new Heap<>();
        assertTrue(instance.isEmpty());
        instance.add(3);
        instance.add(4);
        assertFalse(instance.isEmpty());
        instance.remove();
        instance.remove();
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of size method, of class Heap.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Heap<Integer> instance = new Heap<>(new MinimumComparator<>());
        assertEquals(instance.size(), 0);
        instance.add(7);
        assertEquals(instance.size(), 1);
        instance.add(6);
        assertEquals(instance.size(), 2);
        instance.add(5);
        assertEquals(instance.size(), 3);
        instance.add(4);
        assertEquals(instance.size(), 4);
        instance.add(3);
        assertEquals(instance.size(), 5);
        instance.add(2);
        assertEquals(instance.size(), 6);
        instance.add(1);
        assertEquals(instance.size(), 7);
    }

    /**
     * Test of clear method, of class Heap.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Heap<Integer> instance = new Heap<>(new MinimumComparator<>());
        assertEquals(instance.size(), 0);
        instance.add(7);
        assertEquals(instance.size(), 1);
        instance.add(6);
        assertEquals(instance.size(), 2);
        instance.add(5);
        assertEquals(instance.size(), 3);
        instance.add(4);
        assertEquals(instance.size(), 4);
        instance.add(3);
        assertEquals(instance.size(), 5);
        instance.add(2);
        assertEquals(instance.size(), 6);
        instance.add(1);
        assertEquals(instance.size(), 7);
        instance.clear();
        assertTrue(instance.isEmpty());
    }

}
