public class CustomArrayList<T> implements CustomList<T> {

    private final T[] vector;
    private int pos;

    public CustomArrayList(int tam) {
        vector = (T[]) new Object[tam];
        pos = 0;
    }

    @Override
    public int size() {
        return pos;
    }

    @Override
    public boolean isEmpty() {
        return (pos == 0);
    }

    @Override
    public void add(T value) {
        vector[pos] = value;
        pos++;
    }

    private void limits(int index) {
        if ((index < 1) || (index > pos + 1))
            throw new RuntimeException("The index is out of limits.");
    }

    @Override
    public void add(int index, T value) {
        limits(index);
        int mov = pos;
        for (int i = 1; i < index; i++) {
            vector[mov] = vector[mov - 1];
            mov--;
        }
        vector[mov] = value;
        pos++;
    }

    @Override
    public T remove() {
        if (isEmpty())
            throw new RuntimeException("It is not allowed remove elements from a empty list.");
        pos--;
        return vector[pos];
    }

    @Override
    public T remove(int index) {
        if ((isEmpty()) || (index > pos))
            throw new RuntimeException("This operation cannot be done.");
        T value = vector[pos - index];
        for (int i = pos - index; i < (pos - 1); i++) {
            vector[i] = vector[i + 1];
        }
        pos--;
        return value;
    }

    @Override
    public T get() {
        if (isEmpty())
            throw new RuntimeException("There is not element in the list.");
        return vector[pos - 1];
    }

    @Override
    public T get(int index) {
        if ((isEmpty()) || (index > pos))
            throw new RuntimeException("There is not element in the list.");
        return vector[pos - index];
    }

    @Override
    public int search(T value) {
        if (isEmpty())
            return 0;
        int cont = 1;
        int i = pos - 1;
        while ((i > 0) && (!value.equals(vector[i]))) {
            i--;
            cont++;
        }
        if (!value.equals(vector[i]))
            return 0;
        else
            return cont;
    }

    @Override
    public boolean contains(T value) {
        return (search(value) != 0);
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < pos; i++) {
            result.append(vector[i]);
            if (i < pos - 1)
                result.append(", ");
        }
        result.append("]");
        return result.toString();
    }
}