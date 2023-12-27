/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractCollection;
import edu.emory.mathcs.backport.java.util.ArrayDeque$DeqIterator;
import edu.emory.mathcs.backport.java.util.ArrayDeque$DescendingIterator;
import edu.emory.mathcs.backport.java.util.Arrays;
import edu.emory.mathcs.backport.java.util.Deque;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque
extends AbstractCollection
implements Deque,
Cloneable,
Serializable {
    private transient Object[] elements;
    private transient int head;
    private transient int tail;
    private static final int MIN_INITIAL_CAPACITY;
    private static final long serialVersionUID;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$edu$emory$mathcs$backport$java$util$ArrayDeque;

    private void allocateElements(int n) {
        int n2 = 8;
        if (n >= n2) {
            n2 = n;
            n2 |= n2 >>> 1;
            n2 |= n2 >>> 2;
            n2 |= n2 >>> 4;
            n2 |= n2 >>> 8;
            n2 |= n2 >>> 16;
            if (++n2 < 0) {
                n2 >>>= 1;
            }
        }
        this.elements = new Object[n2];
    }

    private void doubleCapacity() {
        if (!$assertionsDisabled && this.head != this.tail) {
            throw new AssertionError();
        }
        int n = this.head;
        int n2 = this.elements.length;
        int n3 = n2 - n;
        int n4 = n2 << 1;
        if (n4 < 0) {
            throw new IllegalStateException("Sorry, deque too big");
        }
        Object[] objectArray = new Object[n4];
        System.arraycopy((Object)this.elements, n, (Object)objectArray, 0, n3);
        System.arraycopy((Object)this.elements, 0, (Object)objectArray, n3, n);
        this.elements = objectArray;
        this.head = 0;
        this.tail = n2;
    }

    private Object[] copyElements(Object[] objectArray) {
        if (this.head < this.tail) {
            System.arraycopy((Object)this.elements, this.head, (Object)objectArray, 0, this.size());
        } else if (this.head > this.tail) {
            int n = this.elements.length - this.head;
            System.arraycopy((Object)this.elements, this.head, (Object)objectArray, 0, n);
            System.arraycopy((Object)this.elements, 0, (Object)objectArray, n, this.tail);
        }
        return objectArray;
    }

    public ArrayDeque() {
        this.elements = new Object[16];
    }

    public ArrayDeque(int n) {
        this.allocateElements(n);
    }

    public ArrayDeque(Collection collection) {
        this.allocateElements(collection.size());
        this.addAll(collection);
    }

    @Override
    public void addFirst(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        this.head = this.head - 1 & this.elements.length - 1;
        this.elements[this.head] = object;
        if (this.head == this.tail) {
            this.doubleCapacity();
        }
    }

    @Override
    public void addLast(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        this.elements[this.tail] = object;
        this.tail = this.tail + 1 & this.elements.length - 1;
        if (this.tail == this.head) {
            this.doubleCapacity();
        }
    }

    @Override
    public boolean offerFirst(Object object) {
        this.addFirst(object);
        return true;
    }

    @Override
    public boolean offerLast(Object object) {
        this.addLast(object);
        return true;
    }

    @Override
    public Object removeFirst() {
        Object object = this.pollFirst();
        if (object == null) {
            throw new NoSuchElementException();
        }
        return object;
    }

    @Override
    public Object removeLast() {
        Object object = this.pollLast();
        if (object == null) {
            throw new NoSuchElementException();
        }
        return object;
    }

    @Override
    public Object pollFirst() {
        int n = this.head;
        Object object = this.elements[n];
        if (object == null) {
            return null;
        }
        this.elements[n] = null;
        this.head = n + 1 & this.elements.length - 1;
        return object;
    }

    @Override
    public Object pollLast() {
        int n = this.tail - 1 & this.elements.length - 1;
        Object object = this.elements[n];
        if (object == null) {
            return null;
        }
        this.elements[n] = null;
        this.tail = n;
        return object;
    }

    @Override
    public Object getFirst() {
        Object object = this.elements[this.head];
        if (object == null) {
            throw new NoSuchElementException();
        }
        return object;
    }

    @Override
    public Object getLast() {
        Object object = this.elements[this.tail - 1 & this.elements.length - 1];
        if (object == null) {
            throw new NoSuchElementException();
        }
        return object;
    }

    @Override
    public Object peekFirst() {
        return this.elements[this.head];
    }

    @Override
    public Object peekLast() {
        return this.elements[this.tail - 1 & this.elements.length - 1];
    }

    @Override
    public boolean removeFirstOccurrence(Object object) {
        Object object2;
        if (object == null) {
            return false;
        }
        int n = this.elements.length - 1;
        int n2 = this.head;
        while ((object2 = this.elements[n2]) != null) {
            if (object.equals(object2)) {
                this.delete(n2);
                return true;
            }
            n2 = n2 + 1 & n;
        }
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object object) {
        Object object2;
        if (object == null) {
            return false;
        }
        int n = this.elements.length - 1;
        int n2 = this.tail - 1 & n;
        while ((object2 = this.elements[n2]) != null) {
            if (object.equals(object2)) {
                this.delete(n2);
                return true;
            }
            n2 = n2 - 1 & n;
        }
        return false;
    }

    @Override
    public boolean add(Object object) {
        this.addLast(object);
        return true;
    }

    @Override
    public boolean offer(Object object) {
        return this.offerLast(object);
    }

    @Override
    public Object remove() {
        return this.removeFirst();
    }

    @Override
    public Object poll() {
        return this.pollFirst();
    }

    @Override
    public Object element() {
        return this.getFirst();
    }

    @Override
    public Object peek() {
        return this.peekFirst();
    }

    @Override
    public void push(Object object) {
        this.addFirst(object);
    }

    @Override
    public Object pop() {
        return this.removeFirst();
    }

    private void checkInvariants() {
        if (!$assertionsDisabled && this.elements[this.tail] != null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && !(this.head != this.tail ? this.elements[this.head] != null && this.elements[this.tail - 1 & this.elements.length - 1] != null : this.elements[this.head] == null)) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.elements[this.head - 1 & this.elements.length - 1] != null) {
            throw new AssertionError();
        }
    }

    private boolean delete(int n) {
        this.checkInvariants();
        Object[] objectArray = this.elements;
        int n2 = objectArray.length - 1;
        int n3 = this.head;
        int n4 = this.tail;
        int n5 = n - n3 & n2;
        int n6 = n4 - n & n2;
        if (n5 >= (n4 - n3 & n2)) {
            throw new ConcurrentModificationException();
        }
        if (n5 < n6) {
            if (n3 <= n) {
                System.arraycopy((Object)objectArray, n3, (Object)objectArray, n3 + 1, n5);
            } else {
                System.arraycopy((Object)objectArray, 0, (Object)objectArray, 1, n);
                objectArray[0] = objectArray[n2];
                System.arraycopy((Object)objectArray, n3, (Object)objectArray, n3 + 1, n2 - n3);
            }
            objectArray[n3] = null;
            this.head = n3 + 1 & n2;
            return false;
        }
        if (n < n4) {
            System.arraycopy((Object)objectArray, n + 1, (Object)objectArray, n, n6);
            this.tail = n4 - 1;
        } else {
            System.arraycopy((Object)objectArray, n + 1, (Object)objectArray, n, n2 - n);
            objectArray[n2] = objectArray[0];
            System.arraycopy((Object)objectArray, 1, (Object)objectArray, 0, n4);
            this.tail = n4 - 1 & n2;
        }
        return true;
    }

    @Override
    public int size() {
        return this.tail - this.head & this.elements.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    @Override
    public Iterator iterator() {
        return new ArrayDeque$DeqIterator(this, null);
    }

    @Override
    public Iterator descendingIterator() {
        return new ArrayDeque$DescendingIterator(this, null);
    }

    @Override
    public boolean contains(Object object) {
        Object object2;
        if (object == null) {
            return false;
        }
        int n = this.elements.length - 1;
        int n2 = this.head;
        while ((object2 = this.elements[n2]) != null) {
            if (object.equals(object2)) {
                return true;
            }
            n2 = n2 + 1 & n;
        }
        return false;
    }

    @Override
    public boolean remove(Object object) {
        return this.removeFirstOccurrence(object);
    }

    @Override
    public void clear() {
        int n = this.head;
        int n2 = this.tail;
        if (n != n2) {
            this.tail = 0;
            this.head = 0;
            int n3 = n;
            int n4 = this.elements.length - 1;
            do {
                this.elements[n3] = null;
            } while ((n3 = n3 + 1 & n4) != n2);
        }
    }

    @Override
    public Object[] toArray() {
        return this.copyElements(new Object[this.size()]);
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        int n = this.size();
        if (objectArray.length < n) {
            objectArray = (Object[])Array.newInstance(super.getClass().getComponentType(), n);
        }
        this.copyElements(objectArray);
        if (objectArray.length > n) {
            objectArray[n] = null;
        }
        return objectArray;
    }

    public Object clone() {
        try {
            ArrayDeque arrayDeque = (ArrayDeque)super.clone();
            arrayDeque.elements = Arrays.copyOf(this.elements, this.elements.length);
            return arrayDeque;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size());
        int n = this.elements.length - 1;
        int n2 = this.head;
        while (n2 != this.tail) {
            objectOutputStream.writeObject(this.elements[n2]);
            n2 = n2 + 1 & n;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int n = objectInputStream.readInt();
        this.allocateElements(n);
        this.head = 0;
        this.tail = n;
        for (int i2 = 0; i2 < n; ++i2) {
            this.elements[i2] = objectInputStream.readObject();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ int access$200(ArrayDeque arrayDeque) {
        return arrayDeque.head;
    }

    static /* synthetic */ int access$300(ArrayDeque arrayDeque) {
        return arrayDeque.tail;
    }

    static /* synthetic */ Object[] access$400(ArrayDeque arrayDeque) {
        return arrayDeque.elements;
    }

    static /* synthetic */ boolean access$500(ArrayDeque arrayDeque, int n) {
        return arrayDeque.delete(n);
    }

    static {
        $assertionsDisabled = !(class$edu$emory$mathcs$backport$java$util$ArrayDeque == null ? (class$edu$emory$mathcs$backport$java$util$ArrayDeque = ArrayDeque.class$("edu.emory.mathcs.backport.java.util.ArrayDeque")) : class$edu$emory$mathcs$backport$java$util$ArrayDeque).desiredAssertionStatus();
    }
}

