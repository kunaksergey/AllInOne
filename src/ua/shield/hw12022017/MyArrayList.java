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

    /**
     *
     * @return размер коллекции
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @return true-коллекция не пуста, иначе false
     */
    @Override
    public boolean isEmpty() {
        return (size>0)?false:true;
    }

    /**
     *
     * @param o-объект
     * @return true-если объект содержится в коллекции, иначе false
     */
    @Override
    public boolean contains(Object o) {
        if(indexOf(o)!=-1){
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        throw new MethodNotSupportExeption();
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
        if(size==arrayTmp.length){
            extendBoudOfArray(arrayTmp.length*3/2+1);
     }
        arrayTmp[size++]=t;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if(index>=size){
            throw new IndexOutOfBoundsException("index:"+index+" size:"+size);
        }
        System.arraycopy(arrayTmp,index,arrayTmp,index+1,size-index);
        arrayTmp[index]=element;
        size++;
    }

    @Override
    public boolean remove(Object o) {
        throw new MethodNotSupportExeption();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new MethodNotSupportExeption();
    }

    /**
     *
     * @param c-коллекция для добавленияв конец
     * @return
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        if((arrayTmp.length-size)>=c.size()){
            System.arraycopy(c.toArray(),0,arrayTmp,size,c.size());
            size+=+c.size();
            return true;
        }else{

        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if(arrayTmp.length-size<c.size()){
            extendBoudOfArray((c.size()-(arrayTmp.length-size))*3/2+1);
        }
        System.arraycopy(arrayTmp,index,arrayTmp,index+c.size(),size-index);
        System.arraycopy(c.toArray(),0,arrayTmp,index,c.size());
        size+=c.size();
        return true;
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
        throw new MethodNotSupportExeption();
    }

    @Override
    public void clear() {
        throw new MethodNotSupportExeption();
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
    public T remove(int index) {
        T tmpObj= (T) arrayTmp[index];
        System.arraycopy(arrayTmp,index,arrayTmp,index-1,size-index);
        return tmpObj;
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
        int lastIndex=-1;
        for (int i = 0; i <size ; i++) {
            if(arrayTmp[i].equals(o)&&arrayTmp[i].hashCode()==o.hashCode()){
                lastIndex=i;
            }
        }
        return lastIndex;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new MethodNotSupportExeption();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new MethodNotSupportExeption();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new MethodNotSupportExeption();
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new MethodNotSupportExeption();
    }

    @Override
    public Stream<T> stream() {
        throw new MethodNotSupportExeption();
    }

    @Override
    public Stream<T> parallelStream() {
        throw new MethodNotSupportExeption();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("{");
        for (int i=0;i<size;i++){
            stringBuffer.append(arrayTmp[i]);
            if(i<size-1){
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    private void extendBoudOfArray(int size){
        Object[] newArray=new Object[size];
        System.arraycopy(arrayTmp,0,newArray,0,size);
        arrayTmp=newArray;
    }
}
