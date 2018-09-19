package com.example.javasample.utils;

import java.util.Comparator;
import java.util.List;

/**
 * @author YGX
 */

public class ObjectUtils {

    public static <T> T min(T t1, T t2, Comparator<T> cmptor) {
        if (t1 == null || t2 == null)
            throw new NullPointerException();

        if (cmptor == null) {
            if (t1 instanceof Comparable) {

                @SuppressWarnings("unchecked")
                int compareTo = ((Comparable) t1).compareTo(t2);
                if (compareTo > 0) return t2;
                else return t1;
            } else {
                throw new IllegalArgumentException(
                        "Comparator must not be null or "
                                + t1.getClass().getName()
                                + "must be instance of Conparable");
            }
        }

        int compare = cmptor.compare(t1, t2);
        if (compare > 0) return t2;
        else return t1;
    }

    public static <T> int min(int i1, int i2, T[] array,Comparator<T> cmptor) {
        if (array == null)
            throw new NullPointerException();

        if(i1 >= array.length || i2 >= array.length)
            throw new IndexOutOfBoundsException(
                    "i1: "+i1+", i2: "+i2+", arrar.length: "+array.length);

        T t1 = array[i1];
        T t2 = array[i2];
        if (cmptor == null) {
            if (t1 instanceof Comparable) {

                @SuppressWarnings("unchecked")
                int compareTo = ((Comparable) t1).compareTo(t2);
                if (compareTo > 0) return i2;
                else return i1;
            } else {
                throw new IllegalArgumentException(
                        "Comparator must not be null or "
                                + t1.getClass().getName()
                                + "must be instance of Conparable");
            }
        }

        int compare = cmptor.compare(t1, t2);
        if (compare > 0) return i2;
        else return i1;
    }
    public static <T> int min(int i1, int i2, List<T> list, Comparator<T> cmptor) {
        if (list == null)
            throw new NullPointerException();

        if(i1 >= list.size() || i2 >= list.size())
            throw new IndexOutOfBoundsException(
                    "i1: "+i1+", i2: "+i2+", list.size: "+list.size());

        T t1 = list.get(i1);
        T t2 = list.get(i2);
        if (cmptor == null) {
            if (t1 instanceof Comparable) {

                @SuppressWarnings("unchecked")
                int compareTo = ((Comparable) t1).compareTo(t2);
                if (compareTo > 0) return i2;
                else return i1;
            } else {
                throw new IllegalArgumentException(
                        "Comparator must not be null or "
                                + t1.getClass().getName()
                                + "must be instance of Conparable");
            }
        }

        int compare = cmptor.compare(t1, t2);
        if (compare > 0) return i2;
        else return i1;
    }
    public static <T> T max(T t1, T t2, Comparator<T> cmptor) {
        if (t1 == null || t2 == null)
            throw new NullPointerException();

        if (cmptor == null) {
            if (t1 instanceof Comparable) {

                @SuppressWarnings("unchecked")
                int compareTo = ((Comparable) t1).compareTo(t2);
                if (compareTo > 0) return t1;
                else return t2;
            } else {
                throw new IllegalArgumentException(
                        "Comparator must not be null or "
                                + t1.getClass().getName()
                                + "must be instance of Conparable");
            }
        }

        int compare = cmptor.compare(t1, t2);
        if (compare > 0) return t2;
        else return t1;
    }

    public static <T> int max(int i1, int i2, T[] array,Comparator<T> cmptor) {
        if (array == null)
            throw new NullPointerException();

        if(i1 >= array.length || i2 >= array.length)
            throw new IndexOutOfBoundsException(
                    "i1: "+i1+", i2: "+i2+", arrar.length: "+array.length);

        T t1 = array[i1];
        T t2 = array[i2];
        if (cmptor == null) {
            if (t1 instanceof Comparable) {

                @SuppressWarnings("unchecked")
                int compareTo = ((Comparable) t1).compareTo(t2);
                if (compareTo > 0) return i1;
                else return i2;
            } else {
                throw new IllegalArgumentException(
                        "Comparator must not be null or "
                                + t1.getClass().getName()
                                + "must be instance of Conparable");
            }
        }

        int compare = cmptor.compare(t1, t2);
        if (compare > 0) return i1;
        else return i2;
    }
    public static <T> int max(int i1, int i2, List<T> list, Comparator<T> cmptor) {
        if (list == null)
            throw new NullPointerException();

        if(i1 >= list.size() || i2 >= list.size())
            throw new IndexOutOfBoundsException(
                    "i1: "+i1+", i2: "+i2+", list.size: "+list.size());

        T t1 = list.get(i1);
        T t2 = list.get(i2);
        if (cmptor == null) {
            if (t1 instanceof Comparable) {

                @SuppressWarnings("unchecked")
                int compareTo = ((Comparable) t1).compareTo(t2);
                if (compareTo > 0) return i1;
                else return i2;
            } else {
                throw new IllegalArgumentException(
                        "Comparator must not be null or "
                                + t1.getClass().getName()
                                + "must be instance of Conparable");
            }
        }

        int compare = cmptor.compare(t1, t2);
        if (compare > 0) return i1;
        else return i2;
    }

    public static<T> void swap(int i1, int i2, List<T> list){
        T t1 = list.get(i1);
        T t2 = list.get(i2);

        list.set(i2, t1);
        list.set(i1, t2);
    }

    public static<T> void swap(int i1, int i2, T[] array){
        T t1 = array[i1];
        T t2 = array[i2];

        array[i1] = t2;
        array[i2] = t1;
    }
}
