public class CustomLinkedList<T> implements CustomList<T> {

    private class Node {

        private T elem;
        private Node next;

        public T getElem() {
            return elem;
        }

        public void setElem(T elem) {
            this.elem = elem;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(T e, Node sig) {
            this.elem = e;
            this.next = sig;
        }

    }

    private Node forward(int index) {
        if ((index < 1) || (index > (size + 1)))
            throw new RuntimeException("The index is out of limits.");
        Node ant = null;
        Node act = head;
        for (int i = 1; i < index; i++) {
            ant = act;
            act = act.getNext();
        }
        return ant;
    }

    private int size;
    private Node head;

    public CustomLinkedList() {
        this.size = 0;
        this.head = null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public void add(T value) {
        this.head = new Node(value, head);
        this.size++;
    }

    @Override
    public void add(int index, T value) {
        Node ant = forward(index);
        if (ant == null)
            add(value);
        else {
            Node aux = new Node(value, ant.getNext());
            this.size++;
            ant.setNext(aux);
        }
    }

    @Override
    public T remove() {
        if (this.isEmpty())
            throw new RuntimeException("It is not allowed remove elements from an empty list.");
        Node aux = head;
        size--;
        head = head.getNext();
        return aux.getElem();
    }

    @Override
    public T remove(int index) {
        Node ant = forward(index);
        if (ant == null)
            return remove();
        else {
            this.size--;
            Node aux = ant.getNext();
            ant.setNext(aux.getNext());
            return aux.getElem();
        }
    }

    @Override
    public T get() {
        if (this.isEmpty())
            throw new RuntimeException("The index is out of limits.");
        return head.getElem();
    }

    @Override
    public T get(int index) {
        Node ant = forward(index + 1);
        if (ant != null && ant.getNext() != null) {
            return ant.getElem();
        } else {
            throw new RuntimeException("Invalid index specified.");
        }
    }

    @Override
    public int search(T value) {
        if (isEmpty())
            return 0;
        Node aux = head;
        int i = 1;
        while ((aux != null) && (!aux.getElem().equals(value))) {
            aux = aux.getNext();
            i++;
        }
        if (aux != null)
            return i;
        return 0;
    }

    @Override
    public boolean contains(T value) {
        return (search(value) != 0);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node aux = head;
        while (aux != null) {
            result.append(aux.getElem());
            aux = aux.getNext();
            if (aux != null)
                result.append(",");
        }
        result.append("]");
        return result.toString();
    }
}