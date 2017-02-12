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
    private int size=0;
    private final int length=10;
    private Object [] arrayTmp;


    public MyArrayList() {
        arrayTmp=new Object[length];
    }
    public MyArrayList(int capacity) {
        arrayTmp=new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size>0)?false:true;
    }

    @Override
    public boolean contains(Object o) {
        if(indexOf(o)!=-1){
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Object[] toArray() {
        return arrayTmp;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if(size==length){
            Object[] newArray=new Object[length*3/2+1];
            System.arraycopy(arrayTmp,0,newArray,0,size);
            arrayTmp=newArray;
        }

        arrayTmp[size++]=t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if((length-size)>c.size()){
            System.arraycopy(c.toArray(),0,arrayTmp,size,c.size());
            size=size()+c.size();
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }

    @Override
    public void sort(Comparator<? super T> c) {

    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return (T) arrayTmp[index];
    }

    @Override
    public T set(int index, T element) {
        arrayTmp[index]=element;
        return (T) arrayTmp[index];
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i <size ; i++) {
            if(arrayTmp[i].equals(o)&&arrayTmp[i].hashCode()==o.hashCode()){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public Stream<T> stream() {
        return null;
    }

    @Override
    public Stream<T> parallelStream() {
        return null;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("{");
        for (int i=0;i<size;i++){
            stringBuffer.append(arrayTmp[i]);
            if(i<size-1){
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
