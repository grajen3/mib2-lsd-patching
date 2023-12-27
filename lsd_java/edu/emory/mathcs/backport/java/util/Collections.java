/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.Collections$AsLifoQueue;
import edu.emory.mathcs.backport.java.util.Collections$CheckedCollection;
import edu.emory.mathcs.backport.java.util.Collections$CheckedList;
import edu.emory.mathcs.backport.java.util.Collections$CheckedMap;
import edu.emory.mathcs.backport.java.util.Collections$CheckedSet;
import edu.emory.mathcs.backport.java.util.Collections$CheckedSortedMap;
import edu.emory.mathcs.backport.java.util.Collections$CheckedSortedSet;
import edu.emory.mathcs.backport.java.util.Collections$ReverseComparator;
import edu.emory.mathcs.backport.java.util.Collections$SetFromMap;
import edu.emory.mathcs.backport.java.util.Deque;
import edu.emory.mathcs.backport.java.util.Queue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public class Collections {
    static /* synthetic */ Class class$edu$emory$mathcs$backport$java$util$Collections$CheckedMap$EntryView;

    private Collections() {
    }

    public static void sort(List list) {
        java.util.Collections.sort(list);
    }

    public static void sort(List list, Comparator comparator) {
        java.util.Collections.sort(list, comparator);
    }

    public static int binarySearch(List list, Object object) {
        return java.util.Collections.binarySearch(list, object);
    }

    public static int binarySearch(List list, Object object, Comparator comparator) {
        return java.util.Collections.binarySearch(list, object, comparator);
    }

    public static void reverse(List list) {
        java.util.Collections.reverse(list);
    }

    public static void shuffle(List list) {
        java.util.Collections.shuffle(list);
    }

    public static void shuffle(List list, Random random) {
        java.util.Collections.shuffle(list, random);
    }

    public static void swap(List list, int n, int n2) {
        java.util.Collections.swap(list, n, n);
    }

    public static void fill(List list, Object object) {
        java.util.Collections.fill(list, object);
    }

    public static void copy(List list, List list2) {
        java.util.Collections.copy(list, list2);
    }

    public static Object min(Collection collection) {
        return java.util.Collections.min(collection);
    }

    public static Object min(Collection collection, Comparator comparator) {
        return java.util.Collections.min(collection, comparator);
    }

    public static Object max(Collection collection) {
        return java.util.Collections.max(collection);
    }

    public static Object max(Collection collection, Comparator comparator) {
        return java.util.Collections.max(collection, comparator);
    }

    public static void rotate(List list, int n) {
        java.util.Collections.rotate(list, n);
    }

    public static boolean replaceAll(List list, Object object, Object object2) {
        return java.util.Collections.replaceAll(list, object, object2);
    }

    public static int indexOfSubList(List list, List list2) {
        return java.util.Collections.indexOfSubList(list, list2);
    }

    public static int lastIndexOfSubList(List list, List list2) {
        return java.util.Collections.lastIndexOfSubList(list, list2);
    }

    public static Collection unmodifiableCollection(Collection collection) {
        return java.util.Collections.unmodifiableCollection(collection);
    }

    public static Set unmodifiableSet(Set set) {
        return java.util.Collections.unmodifiableSet(set);
    }

    public static SortedSet unmodifiableSortedSet(SortedSet sortedSet) {
        return java.util.Collections.unmodifiableSortedSet(sortedSet);
    }

    public static List unmodifiableList(List list) {
        return java.util.Collections.unmodifiableList(list);
    }

    public static Map unmodifiableMap(Map map) {
        return java.util.Collections.unmodifiableMap(map);
    }

    public static SortedMap unmodifiableSortedMap(SortedMap sortedMap) {
        return java.util.Collections.unmodifiableSortedMap(sortedMap);
    }

    public static Collection synchronizedCollection(Collection collection) {
        return java.util.Collections.synchronizedCollection(collection);
    }

    public static Set synchronizedSet(Set set) {
        return java.util.Collections.synchronizedSet(set);
    }

    public static SortedSet synchronizedSortedSet(SortedSet sortedSet) {
        return java.util.Collections.synchronizedSortedSet(sortedSet);
    }

    public static List synchronizedList(List list) {
        return java.util.Collections.synchronizedList(list);
    }

    public static Map synchronizedMap(Map map) {
        return java.util.Collections.synchronizedMap(map);
    }

    public static SortedMap synchronizedSortedMap(SortedMap sortedMap) {
        return java.util.Collections.synchronizedSortedMap(sortedMap);
    }

    public static Collection checkedCollection(Collection collection, Class clazz) {
        return new Collections$CheckedCollection(collection, clazz);
    }

    public static Set checkedSet(Set set, Class clazz) {
        return new Collections$CheckedSet(set, clazz);
    }

    public static SortedSet checkedSortedSet(SortedSet sortedSet, Class clazz) {
        return new Collections$CheckedSortedSet(sortedSet, clazz);
    }

    public static List checkedList(List list, Class clazz) {
        return new Collections$CheckedList(list, clazz);
    }

    public static Map checkedMap(Map map, Class clazz, Class clazz2) {
        return new Collections$CheckedMap(map, clazz, clazz2);
    }

    public static SortedMap checkedSortedMap(SortedMap sortedMap, Class clazz, Class clazz2) {
        return new Collections$CheckedSortedMap(sortedMap, clazz, clazz2);
    }

    public static Set emptySet() {
        return java.util.Collections.EMPTY_SET;
    }

    public static List emptyList() {
        return java.util.Collections.EMPTY_LIST;
    }

    public static Map emptyMap() {
        return java.util.Collections.EMPTY_MAP;
    }

    public static Set singleton(Object object) {
        return java.util.Collections.singleton(object);
    }

    public static List singletonList(Object object) {
        return java.util.Collections.singletonList(object);
    }

    public static Map singletonMap(Object object, Object object2) {
        return java.util.Collections.singletonMap(object, object2);
    }

    public static List nCopies(int n, Object object) {
        return java.util.Collections.nCopies(n, object);
    }

    public static Comparator reverseOrder() {
        return java.util.Collections.reverseOrder();
    }

    public static Comparator reverseOrder(Comparator comparator) {
        return comparator instanceof Collections$ReverseComparator ? ((Collections$ReverseComparator)comparator).cmp : (comparator == null ? Collections.reverseOrder() : new Collections$ReverseComparator(comparator));
    }

    public static Enumeration enumeration(Collection collection) {
        return java.util.Collections.enumeration(collection);
    }

    public static ArrayList list(Enumeration enumeration) {
        return java.util.Collections.list(enumeration);
    }

    public static int frequency(Collection collection, Object object) {
        int n = 0;
        if (object == null) {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() != null) continue;
                ++n;
            }
        } else {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (!object.equals(iterator.next())) continue;
                ++n;
            }
        }
        return n;
    }

    public static boolean disjoint(Collection collection, Collection object) {
        Object object2;
        if (collection instanceof Set && (!(object instanceof Set) || collection.size() < object.size())) {
            object2 = collection;
            collection = object;
            object = object2;
        }
        object2 = collection.iterator();
        while (object2.hasNext()) {
            if (!object.contains(object2.next())) continue;
            return false;
        }
        return true;
    }

    public static boolean addAll(Collection collection, Object[] objectArray) {
        boolean bl = false;
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            bl |= collection.add(objectArray[i2]);
        }
        return bl;
    }

    public static Set newSetFromMap(Map map) {
        return new Collections$SetFromMap(map);
    }

    public static Queue asLifoQueue(Deque deque) {
        return new Collections$AsLifoQueue(deque);
    }

    private static boolean eq(Object object, Object object2) {
        return object == null ? object2 == null : object.equals(object2);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ boolean access$100(Object object, Object object2) {
        return Collections.eq(object, object2);
    }
}

