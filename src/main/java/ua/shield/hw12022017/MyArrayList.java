package ua.shield.hw12022017;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Created by sa on 12.02.17.
 */

public class MyArrayList<T> implements List<T> {
    private int size = 0;
    private final int DEFAULTLENGTH = 10;
    private final boolean PERMITNULL = true;
    private Object[] arrayTmp;

    {
        arrayTmp = new Object[DEFAULTLENGTH];
    }

    public MyArrayList() {

    }

    /**
     *
     * @param capacity начальный размер коллекции
     */
    public MyArrayList(int capacity) {
        arrayTmp = new Object[capacity];
    }

    /**
     * создаем коллекцию на основе коллекции
     * @param c коллекция типа Т
     */
    public MyArrayList(Collection<? extends T> c) {
        addAll(c);
    }

    /**
     * @return размер коллекции
     */
    @Override
    public int size() {
        return (size > Integer.MAX_VALUE) ? Integer.MAX_VALUE : size;
    }

    /**
     * @return true-коллекция не пуста, иначе false
     */
    @Override
    public boolean isEmpty() {
        return (size > 0) ? false : true;
    }

    /**
     * @param o-объект
     * @return true-если объект содержится в коллекции, иначе false
     */
    @Override
    public boolean contains(Object o) {
        if (!PERMITNULL && o == null) throw new NullPointerException();
        if (indexOf(o) != -1) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return массив из коллекции
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arrayTmp, size);
    }

    /**
     *
     * @param element для добавления
     * @return //true-если елемент добавлен
     */
    @Override
    public boolean add(T element) {
        if (!PERMITNULL && element == null) throw new NullPointerException();
        if (size == arrayTmp.length) {
            arrayTmp = getExtendBoudOfArray(arrayTmp.length * 3 / 2 + 1);
        }
        arrayTmp[size++] = element;
        return true;
    }

    /**
     * @param index   индекс с которого вставить елемент
     * @param element
     */
    @Override
    public void add(int index, T element) {
        if (!PERMITNULL && element == null) throw new NullPointerException();
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("index:" + index + " size:" + size);
        }
        System.arraycopy(arrayTmp, index, arrayTmp, index + 1, size - index);
        arrayTmp[index] = element;
        size++;
    }

    @Override
    public boolean remove(Object o) {
        if (!PERMITNULL && o == null) throw new NullPointerException();
        for (int i = 0; i < size; i++) {
            if (o == null ? get(i) == null :get(i)==null?false: o.equals(get(i))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * @param c-коллекция для добавленияв конец
     * @return
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (!PERMITNULL && c.contains(null)) throw new NullPointerException();
        if (arrayTmp.length - size < c.size()) {
            arrayTmp = getExtendBoudOfArray((c.size() - (arrayTmp.length - size) + arrayTmp.length) * 3 / 2 + 1);
        }
        System.arraycopy(c.toArray(), 0, arrayTmp, size, c.size());
        size += c.size();
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (!PERMITNULL && c.contains(null)) throw new NullPointerException();
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("index:" + index + " size:" + size);
        }
        if (arrayTmp.length - size < c.size()) {
            arrayTmp = getExtendBoudOfArray((c.size() - (arrayTmp.length - size) + arrayTmp.length) * 3 / 2 + 1);
        }
        System.arraycopy(arrayTmp, index, arrayTmp, index + c.size(), size - index);
        System.arraycopy(c.toArray(), 0, arrayTmp, index, c.size());
        size += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (!PERMITNULL && c.contains(null)) throw new NullPointerException();
        boolean remoted = false;
        Object tmp;
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            tmp = iterator.next();
            while (contains(tmp)) {
                remove(tmp);
                remoted = true;
            }
        }
        return remoted;
    }

    @Override
    public T get(int index) {
        return (T) arrayTmp[index];
    }

    @Override
    public T set(int index, T element) {
        if (!PERMITNULL && element == null) throw new NullPointerException();
        arrayTmp[index] = element;
        return get(index);
    }


    @Override
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("index:" + index + " size:" + size);
        }
        T tmpObj = get(index);
        System.arraycopy(arrayTmp, index + 1, arrayTmp, index, size - index - 1);
        size--;
        return tmpObj;
    }

    @Override
    public int indexOf(Object o) {
        if (!PERMITNULL) throw new NullPointerException();
        for (int i = 0; i < size; i++) {
            if (o == null ? get(i) == null :get(i)==null?false: o.equals(get(i)))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (!PERMITNULL) throw new NullPointerException();
        for (int i = size - 1; i >= 0; i--) {
            if (o == null ? get(i) == null :get(i)==null?false: o.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        for (int i = 0; i < size; i++) {
            stringBuffer.append(arrayTmp[i]);
            if (i < size - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    /**
     * Расширяем массив до дужного размера
     *
     * @param newSize новый размер массива
     * @return новый массив
     */
    private Object[] getExtendBoudOfArray(int newSize) {
        Object[] newArray = new Object[newSize];
        System.arraycopy(arrayTmp, 0, newArray, 0, size);
        return newArray;
    }

    @Override
    public Iterator<T> iterator() {

        class MyIterator<T> implements Iterator<T> {
            int index = -1;

            public MyIterator() {

            }

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (!PERMITNULL) throw new NullPointerException();
                index++;
                return (get(index) == null) ? null : (T) get(index);
            }

            @Override
            public void remove() {
                MyArrayList.this.remove(index);
                index--;
            }

            @Override
            public void forEachRemaining(Consumer<? super T> action) {
                throw new UnsupportedOperationException();
            }
        }
        return new MyIterator<T>();

    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<T> stream() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<T> parallelStream() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sort(Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    void pr(int x) {
        System.out.println(x);
    }


}
