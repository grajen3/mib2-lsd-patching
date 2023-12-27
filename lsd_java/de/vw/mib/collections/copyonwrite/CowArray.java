/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.copyonwrite;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CowArray {
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    private Object[] elements;

    public CowArray() {
        this(0);
    }

    public CowArray(int n) {
        this.init(n);
    }

    private void init(int n) {
        this.elements = n == 0 ? EMPTY_OBJECT_ARRAY : new Object[n];
    }

    public synchronized void set(int n, Object object) {
        Object[] objectArray = this.elements;
        objectArray = this.copyElements(objectArray, objectArray.length);
        objectArray[n] = object;
        this.elements = objectArray;
    }

    private Object[] copyElements(Object[] objectArray, int n) {
        Object[] objectArray2 = new Object[n];
        System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, objectArray.length);
        return objectArray2;
    }

    public Object get(int n) {
        return this.elements[n];
    }

    public Object[] getArray() {
        return this.elements;
    }

    public synchronized void add(Object object) {
        Object[] objectArray = this.elements;
        objectArray = this.copyElements(objectArray, objectArray.length + 1);
        objectArray[objectArray.length - 1] = object;
        this.elements = objectArray;
    }

    public synchronized void addIfNotAlreadyIn(Object object) {
        Object[] objectArray = this.elements;
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            if (objectArray[i2] != object) continue;
            return;
        }
        this.add(object);
    }

    public synchronized void remove(Object object) {
        int n = -1;
        Object[] objectArray = this.elements;
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            if (objectArray[i2] != object) continue;
            n = i2;
            break;
        }
        if (n < 0) {
            return;
        }
        Object[] objectArray2 = new Object[objectArray.length - 1];
        System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n);
        System.arraycopy((Object)objectArray, n + 1, (Object)objectArray2, n, objectArray.length - n - 1);
        this.elements = objectArray2;
    }

    public synchronized void removeAll(Object object) {
        Object[] objectArray = this.elements;
        int n = this.countOccurances(object, objectArray);
        if (n < 1) {
            return;
        }
        Object[] objectArray2 = new Object[objectArray.length - n];
        int n2 = objectArray.length - 1;
        int n3 = objectArray2.length - 1;
        while (n3 >= 0) {
            if (objectArray[n2] != object) {
                objectArray2[n3] = objectArray[n2];
                --n3;
            }
            --n2;
        }
        this.elements = objectArray2;
    }

    private int countOccurances(Object object, Object[] objectArray) {
        int n = 0;
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            if (objectArray[i2] != object) continue;
            ++n;
        }
        return n;
    }

    public synchronized void removeAllElements() {
        this.init(0);
    }

    public synchronized void setAllElementsToNull() {
        this.init(this.elements.length);
    }

    public void clear() {
        throw new UnsupportedOperationException("Use removeAllElements() or setAllElementsToNull() instead.");
    }

    public int size() {
        return this.elements.length;
    }

    public int length() {
        return this.elements.length;
    }

    public String toString() {
        Object[] objectArray = this.elements;
        StringBuilder stringBuilder = new StringBuilder("[");
        String string = "";
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            stringBuilder.append(string).append(objectArray[i2]);
            string = ", ";
        }
        return stringBuilder.append("]").toString();
    }

    public int hashCode() {
        return (int)HashCodeBuilder.hash(this.elements);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        CowArray cowArray = (CowArray)object;
        return Arrays.equals(this.elements, cowArray.elements);
    }

    public List toList() {
        Object[] objectArray = this.elements;
        int n = objectArray.length;
        ArrayList arrayList = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            arrayList.add(objectArray[i2]);
        }
        return arrayList;
    }
}

