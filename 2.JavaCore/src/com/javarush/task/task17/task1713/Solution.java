package com.javarush.task.task17.task1713;

/* 
Общий список
*/

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Solution implements List<Long> {
    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {

    }

    public synchronized void trimToSize() {
        original.trimToSize();
    }

    public synchronized void ensureCapacity(int minCapacity) {
        original.ensureCapacity(minCapacity);
    }

    @Override
    public synchronized int size() {
        original.size();
        return 0;
    }

    @Override
    public synchronized boolean isEmpty() {
        original.isEmpty();
        return false;
    }

    @Override
    public synchronized boolean contains(Object o) {
        original.contains(o);
        return false;
    }

    @Override
    public synchronized Iterator<Long> iterator() {
        original.iterator();
        return null;
    }

    @Override
    public synchronized void forEach(Consumer<? super Long> action) {
        original.forEach(action);

    }

    @Override
    public synchronized Object[] toArray() {
        original.toArray();
        return new Object[0];
    }

    @Override
    public synchronized <T> T[] toArray(T[] a) {
        original.toArray( a);
        return null;
    }

    //@Override
   //public synchronized <T> T[] toArray(IntFunction<T[]> generator) {
     //   return null;
    //}

    @Override
    public synchronized boolean add(Long aLong) {
        original.add(aLong);
        return false;
    }

    @Override
    public synchronized boolean remove(Object o) {
        original.remove(o);
        return false;
    }

    @Override
    public synchronized boolean containsAll(Collection<?> c) {
        original.containsAll(c);
        return false;
    }

    @Override
    public synchronized String toString() {
        return original.toString();
    }

    //public synchronized static <E> List<E> of() {
      //  return List.of();
    //}

   // public synchronized static <E> List<E> of(E e1) {
    //    return List.of(e1);
   // }

   // public synchronized static <E> List<E> of(E e1, E e2) {
   //     return List.of(e1, e2);
   // }

   // public synchronized static <E> List<E> of(E e1, E e2, E e3) {
   //     return List.of(e1, e2, e3);
   // }

  //  public synchronized static <E> List<E> of(E e1, E e2, E e3, E e4) {
  //      return List.of(e1, e2, e3, e4);
   // }

   // public synchronized static <E> List<E> of(E e1, E e2, E e3, E e4, E e5) {
   //     return List.of(e1, e2, e3, e4, e5);
   // }

   // public synchronized static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6) {
   //     return List.of(e1, e2, e3, e4, e5, e6);
   // }

   // public synchronized static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7) {
   //     return List.of(e1, e2, e3, e4, e5, e6, e7);
   // }

   // public synchronized static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
    //    return List.of(e1, e2, e3, e4, e5, e6, e7, e8);
   // }

  //  public synchronized static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
   //     return List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9);
    //}

    //public synchronized static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
     //   return List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
   // }

   // @SafeVarargs
   // public synchronized static <E> List<E> of(E... elements) {
    //    return List.of(elements);
    //}

   // public synchronized static <E> List<E> copyOf(Collection<? extends E> coll) {
  //return List.copyOf(coll);
  //  }

    @Override
    public synchronized boolean addAll(Collection<? extends Long> c) {
        original.addAll(c);
        return false;
    }

    @Override
    public synchronized boolean addAll(int index, Collection<? extends Long> c) {
        original.addAll(index, c);
        return false;
    }

    @Override
    public synchronized boolean removeAll(Collection<?> c) {
        original.removeAll(c);
        return false;
    }

    @Override
    public synchronized boolean removeIf(Predicate<? super Long> filter) {
        original.removeIf(filter);
        return false;
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        original.retainAll(c);
        return false;
    }

    @Override
    public synchronized void replaceAll(UnaryOperator<Long> operator) {
        original.replaceAll(operator);

    }

    @Override
    public synchronized void sort(Comparator<? super Long> c) {
        original.sort(c);

    }

    @Override
    public synchronized void clear() {
        original.clear();

    }

    @Override
    public synchronized Long get(int index) {
        original.get(index);
        return null;
    }

    @Override
    public synchronized Long set(int index, Long element) {
        original.set(index, element);
        return null;
    }

    @Override
    public synchronized void add(int index, Long element) {
        original.add(index, element);

    }

    @Override
    public synchronized Long remove(int index) {
        original.remove(index);
        return null;
    }

    @Override
    public synchronized boolean equals(Object o) {
        return original.equals(o);
    }

    @Override
    public synchronized int hashCode() {
        return original.hashCode();
    }

    @Override
    public synchronized int indexOf(Object o) {
        original.indexOf(o);
        return 0;
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        original.lastIndexOf(o);
        return 0;
    }

    @Override
    public synchronized Object clone() {
        return original.clone();
    }

    @Override
    public synchronized ListIterator<Long> listIterator() {
        original.listIterator();
        return null;
    }

    @Override
    public synchronized ListIterator<Long> listIterator(int index) {
        original.listIterator(index);
        return null;
    }

    @Override
    public synchronized List<Long> subList(int fromIndex, int toIndex) {
        original.subList(fromIndex,  toIndex);
        return null;
    }

    @Override
    public synchronized Spliterator<Long> spliterator() {
        original.spliterator();
        return null;
    }

    @Override
    public synchronized Stream<Long> stream() {
        original.stream();
        return null;
    }

    @Override
    public synchronized Stream<Long> parallelStream() {
        original.parallelStream();
        return null;
    }
}
