/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections$9;
import java.util.Collections$CopiesList;
import java.util.Collections$EmptyList;
import java.util.Collections$EmptyMap;
import java.util.Collections$EmptySet;
import java.util.Collections$ReverseComparator;
import java.util.Collections$SingletonList;
import java.util.Collections$SingletonMap;
import java.util.Collections$SingletonSet;
import java.util.Collections$SynchronizedCollection;
import java.util.Collections$SynchronizedList;
import java.util.Collections$SynchronizedMap;
import java.util.Collections$SynchronizedRandomAccessList;
import java.util.Collections$SynchronizedSet;
import java.util.Collections$SynchronizedSortedMap;
import java.util.Collections$SynchronizedSortedSet;
import java.util.Collections$UnmodifiableCollection;
import java.util.Collections$UnmodifiableList;
import java.util.Collections$UnmodifiableMap;
import java.util.Collections$UnmodifiableRandomAccessList;
import java.util.Collections$UnmodifiableSet;
import java.util.Collections$UnmodifiableSortedMap;
import java.util.Collections$UnmodifiableSortedSet;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public class Collections {
    public static final List EMPTY_LIST = new Collections$EmptyList();
    public static final Set EMPTY_SET = new Collections$EmptySet();
    public static final Map EMPTY_MAP = new Collections$EmptyMap();

    private Collections() {
    }

    public static int binarySearch(List list, Object object) {
        if (list == null) {
            throw new NullPointerException();
        }
        Comparable comparable = (Comparable)object;
        if (!(list instanceof RandomAccess)) {
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                int n = comparable.compareTo(listIterator.next());
                if (n > 0) continue;
                if (n == 0) {
                    return listIterator.previousIndex();
                }
                return -listIterator.previousIndex() - 1;
            }
            return -list.size() - 1;
        }
        int n = 0;
        int n2 = list.size();
        int n3 = n2 - 1;
        int n4 = -1;
        while (n <= n3) {
            n2 = n + n3 >> 1;
            n4 = comparable.compareTo(list.get(n2));
            if (n4 > 0) {
                n = n2 + 1;
                continue;
            }
            if (n4 == 0) {
                return n2;
            }
            n3 = n2 - 1;
        }
        return -n2 - (n4 < 0 ? 1 : 2);
    }

    public static int binarySearch(List list, Object object, Comparator comparator) {
        if (comparator == null) {
            return Collections.binarySearch(list, object);
        }
        if (!(list instanceof RandomAccess)) {
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                int n = comparator.compare(object, listIterator.next());
                if (n > 0) continue;
                if (n == 0) {
                    return listIterator.previousIndex();
                }
                return -listIterator.previousIndex() - 1;
            }
            return -list.size() - 1;
        }
        int n = 0;
        int n2 = list.size();
        int n3 = n2 - 1;
        int n4 = -1;
        while (n <= n3) {
            n2 = n + n3 >> 1;
            n4 = comparator.compare(object, list.get(n2));
            if (n4 > 0) {
                n = n2 + 1;
                continue;
            }
            if (n4 == 0) {
                return n2;
            }
            n3 = n2 - 1;
        }
        return -n2 - (n4 < 0 ? 1 : 2);
    }

    public static void copy(List list, List list2) {
        if (list.size() < list2.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Iterator iterator = list2.iterator();
        ListIterator listIterator = list.listIterator();
        while (iterator.hasNext()) {
            try {
                listIterator.next();
            }
            catch (NoSuchElementException noSuchElementException) {
                throw new ArrayIndexOutOfBoundsException();
            }
            listIterator.set(iterator.next());
        }
    }

    public static Enumeration enumeration(Collection collection) {
        return new Collections$9(collection);
    }

    public static void fill(List list, Object object) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(object);
        }
    }

    public static Object max(Collection collection) {
        Iterator iterator = collection.iterator();
        Comparable comparable = (Comparable)iterator.next();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (comparable.compareTo(object) >= 0) continue;
            comparable = (Comparable)object;
        }
        return comparable;
    }

    public static Object max(Collection collection, Comparator comparator) {
        Iterator iterator = collection.iterator();
        Object object = iterator.next();
        while (iterator.hasNext()) {
            Object object2 = iterator.next();
            if (comparator.compare(object, object2) >= 0) continue;
            object = object2;
        }
        return object;
    }

    public static Object min(Collection collection) {
        Iterator iterator = collection.iterator();
        Comparable comparable = (Comparable)iterator.next();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (comparable.compareTo(object) <= 0) continue;
            comparable = (Comparable)object;
        }
        return comparable;
    }

    public static Object min(Collection collection, Comparator comparator) {
        Iterator iterator = collection.iterator();
        Object object = iterator.next();
        while (iterator.hasNext()) {
            Object object2 = iterator.next();
            if (comparator.compare(object, object2) <= 0) continue;
            object = object2;
        }
        return object;
    }

    public static List nCopies(int n, Object object) {
        return new Collections$CopiesList(n, object);
    }

    public static void reverse(List list) {
        int n = list.size();
        ListIterator listIterator = list.listIterator();
        ListIterator listIterator2 = list.listIterator(n);
        int n2 = 0;
        while (n2 < n / 2) {
            Object object = listIterator.next();
            listIterator.set(listIterator2.previous());
            listIterator2.set(object);
            ++n2;
        }
    }

    public static Comparator reverseOrder() {
        return new Collections$ReverseComparator();
    }

    public static void shuffle(List list) {
        Collections.shuffle(list, new Random());
    }

    public static void shuffle(List list, Random random) {
        if (!(list instanceof RandomAccess)) {
            Object[] objectArray = list.toArray();
            int n = objectArray.length - 1;
            while (n > 0) {
                int n2 = random.nextInt() % (n + 1);
                if (n2 < 0) {
                    n2 = -n2;
                }
                Object object = objectArray[n];
                objectArray[n] = objectArray[n2];
                objectArray[n2] = object;
                --n;
            }
            n = 0;
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next();
                listIterator.set(objectArray[n++]);
            }
        } else {
            int n = list.size() - 1;
            while (n > 0) {
                int n3 = random.nextInt() % (n + 1);
                if (n3 < 0) {
                    n3 = -n3;
                }
                list.set(n3, list.set(n, list.get(n3)));
                --n;
            }
        }
    }

    public static Set singleton(Object object) {
        return new Collections$SingletonSet(object);
    }

    public static List singletonList(Object object) {
        return new Collections$SingletonList(object);
    }

    public static Map singletonMap(Object object, Object object2) {
        return new Collections$SingletonMap(object, object2);
    }

    public static void sort(List list) {
        Object[] objectArray = list.toArray();
        Arrays.sort(objectArray);
        int n = 0;
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(objectArray[n++]);
        }
    }

    public static void sort(List list, Comparator comparator) {
        Object[] objectArray = list.toArray();
        Arrays.sort(objectArray, comparator);
        int n = 0;
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(objectArray[n++]);
        }
    }

    public static void swap(List list, int n, int n2) {
        if (list == null) {
            throw new NullPointerException();
        }
        if (n == n2) {
            return;
        }
        list.set(n2, list.set(n, list.get(n2)));
    }

    public static boolean replaceAll(List list, Object object, Object object2) {
        int n;
        boolean bl = false;
        while ((n = list.indexOf(object)) > -1) {
            bl = true;
            list.set(n, object2);
        }
        return bl;
    }

    public static void rotate(List list, int n) {
        int n2 = list.size();
        if (n2 == 0) {
            return;
        }
        n = n > 0 ? (n %= n2) : n2 - n % n2 * -1;
        if (n == 0 || n == n2) {
            return;
        }
        if (list instanceof RandomAccess) {
            Object object = list.get(0);
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            while (n5 < n2) {
                n3 = (n3 + n) % n2;
                object = list.set(n3, object);
                if (n3 == n4) {
                    n3 = ++n4;
                    object = list.get(n4);
                }
                ++n5;
            }
        } else {
            int n6 = (n2 - n) % n2;
            List list2 = list.subList(0, n6);
            List list3 = list.subList(n6, n2);
            Collections.reverse(list2);
            Collections.reverse(list3);
            Collections.reverse(list);
        }
    }

    /*
     * Unable to fully structure code
     */
    public static int indexOfSubList(List var0, List var1_1) {
        var2_2 = var0.size();
        var3_3 = var1_1.size();
        if (var3_3 > var2_2) {
            return -1;
        }
        if (var3_3 == 0) {
            return 0;
        }
        var4_4 = var1_1.get(0);
        var5_5 = var0.indexOf(var4_4);
        if (var5_5 != -1) ** GOTO lbl25
        return -1;
lbl-1000:
        // 1 sources

        {
            var6_6 = var0.listIterator(var5_5);
            if (var4_4 == null ? var6_6.next() == null : var4_4.equals(var6_6.next()) != false) {
                var7_7 = var1_1.listIterator(1);
                var8_8 = false;
                while (var7_7.hasNext()) {
                    var9_9 = var7_7.next();
                    if (!var6_6.hasNext()) {
                        return -1;
                    }
                    if (!(var9_9 == null ? var6_6.next() != null : var9_9.equals(var6_6.next()) == false)) continue;
                    var8_8 = true;
                    break;
                }
                if (!var8_8) {
                    return var5_5;
                }
            }
            ++var5_5;
lbl25:
            // 2 sources

            ** while (var5_5 < var2_2 && var2_2 - var5_5 >= var3_3)
        }
lbl26:
        // 1 sources

        return -1;
    }

    public static int lastIndexOfSubList(List list, List list2) {
        int n;
        int n2 = list2.size();
        if (n2 > (n = list.size())) {
            return -1;
        }
        if (n2 == 0) {
            return n;
        }
        Object object = list2.get(n2 - 1);
        int n3 = list.lastIndexOf(object);
        while (n3 > -1 && n3 + 1 >= n2) {
            ListIterator listIterator = list.listIterator(n3 + 1);
            if (object == null ? listIterator.previous() == null : object.equals(listIterator.previous())) {
                ListIterator listIterator2 = list2.listIterator(n2 - 1);
                boolean bl = false;
                while (listIterator2.hasPrevious()) {
                    Object object2 = listIterator2.previous();
                    if (!listIterator.hasPrevious()) {
                        return -1;
                    }
                    if (!(object2 == null ? listIterator.previous() != null : !object2.equals(listIterator.previous()))) continue;
                    bl = true;
                    break;
                }
                if (!bl) {
                    return listIterator.nextIndex();
                }
            }
            --n3;
        }
        return -1;
    }

    public static ArrayList list(Enumeration enumeration) {
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList;
    }

    public static Collection synchronizedCollection(Collection collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        return new Collections$SynchronizedCollection(collection);
    }

    public static List synchronizedList(List list) {
        if (list == null) {
            throw new NullPointerException();
        }
        if (list instanceof RandomAccess) {
            return new Collections$SynchronizedRandomAccessList(list);
        }
        return new Collections$SynchronizedList(list);
    }

    public static Map synchronizedMap(Map map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new Collections$SynchronizedMap(map);
    }

    public static Set synchronizedSet(Set set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new Collections$SynchronizedSet(set);
    }

    public static SortedMap synchronizedSortedMap(SortedMap sortedMap) {
        if (sortedMap == null) {
            throw new NullPointerException();
        }
        return new Collections$SynchronizedSortedMap(sortedMap);
    }

    public static SortedSet synchronizedSortedSet(SortedSet sortedSet) {
        if (sortedSet == null) {
            throw new NullPointerException();
        }
        return new Collections$SynchronizedSortedSet(sortedSet);
    }

    public static Collection unmodifiableCollection(Collection collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        return new Collections$UnmodifiableCollection(collection);
    }

    public static List unmodifiableList(List list) {
        if (list == null) {
            throw new NullPointerException();
        }
        if (list instanceof RandomAccess) {
            return new Collections$UnmodifiableRandomAccessList(list);
        }
        return new Collections$UnmodifiableList(list);
    }

    public static Map unmodifiableMap(Map map) {
        if (map == null) {
            throw new NullPointerException();
        }
        return new Collections$UnmodifiableMap(map);
    }

    public static Set unmodifiableSet(Set set) {
        if (set == null) {
            throw new NullPointerException();
        }
        return new Collections$UnmodifiableSet(set);
    }

    public static SortedMap unmodifiableSortedMap(SortedMap sortedMap) {
        if (sortedMap == null) {
            throw new NullPointerException();
        }
        return new Collections$UnmodifiableSortedMap(sortedMap);
    }

    public static SortedSet unmodifiableSortedSet(SortedSet sortedSet) {
        if (sortedSet == null) {
            throw new NullPointerException();
        }
        return new Collections$UnmodifiableSortedSet(sortedSet);
    }
}

