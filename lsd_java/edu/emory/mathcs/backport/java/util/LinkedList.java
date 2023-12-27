/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.Deque;
import edu.emory.mathcs.backport.java.util.LinkedList$DescItr;
import edu.emory.mathcs.backport.java.util.LinkedList$Entry;
import edu.emory.mathcs.backport.java.util.LinkedList$Itr;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList
extends AbstractSequentialList
implements List,
Deque,
Cloneable,
Serializable {
    private static final long serialVersionUID;
    private transient int size = 0;
    private transient int modCount;
    private transient LinkedList$Entry head;

    public LinkedList() {
        LinkedList$Entry linkedList$Entry;
        linkedList$Entry.next = linkedList$Entry.prev = (linkedList$Entry = new LinkedList$Entry(null));
        this.head = linkedList$Entry;
    }

    public LinkedList(Collection collection) {
        this();
        this.addAll(collection);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object object) {
        return this.findFirst(object) != null;
    }

    private LinkedList$Entry getAt(int n) {
        int n2 = this.size;
        if (n < 0 || n >= n2) {
            throw new ArrayIndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append("; Size: ").append(n2).toString());
        }
        if (n < n2 >> 1) {
            LinkedList$Entry linkedList$Entry = this.head.next;
            while (n > 0) {
                linkedList$Entry = linkedList$Entry.next;
                --n;
            }
            return linkedList$Entry;
        }
        LinkedList$Entry linkedList$Entry = this.head.prev;
        for (n = n2 - n - 1; n > 0; --n) {
            linkedList$Entry = linkedList$Entry.prev;
        }
        return linkedList$Entry;
    }

    private LinkedList$Entry findFirst(Object object) {
        if (object == null) {
            LinkedList$Entry linkedList$Entry = this.head.next;
            while (linkedList$Entry != this.head) {
                if (linkedList$Entry.val == null) {
                    return linkedList$Entry;
                }
                linkedList$Entry = linkedList$Entry.next;
            }
        } else {
            LinkedList$Entry linkedList$Entry = this.head.next;
            while (linkedList$Entry != this.head) {
                if (object.equals(linkedList$Entry.val)) {
                    return linkedList$Entry;
                }
                linkedList$Entry = linkedList$Entry.next;
            }
        }
        return null;
    }

    private LinkedList$Entry findLast(Object object) {
        if (object == null) {
            LinkedList$Entry linkedList$Entry = this.head.prev;
            while (linkedList$Entry != this.head) {
                if (linkedList$Entry.val == null) {
                    return linkedList$Entry;
                }
                linkedList$Entry = linkedList$Entry.prev;
            }
        } else {
            LinkedList$Entry linkedList$Entry = this.head.prev;
            while (linkedList$Entry != this.head) {
                if (object.equals(linkedList$Entry.val)) {
                    return linkedList$Entry;
                }
                linkedList$Entry = linkedList$Entry.prev;
            }
        }
        return null;
    }

    @Override
    public int indexOf(Object object) {
        int n = 0;
        if (object == null) {
            LinkedList$Entry linkedList$Entry = this.head.next;
            while (linkedList$Entry != this.head) {
                if (linkedList$Entry.val == null) {
                    return n;
                }
                linkedList$Entry = linkedList$Entry.next;
                ++n;
            }
        } else {
            LinkedList$Entry linkedList$Entry = this.head.next;
            while (linkedList$Entry != this.head) {
                if (object.equals(linkedList$Entry.val)) {
                    return n;
                }
                linkedList$Entry = linkedList$Entry.next;
                ++n;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int n = this.size - 1;
        if (object == null) {
            LinkedList$Entry linkedList$Entry = this.head.prev;
            while (linkedList$Entry != this.head) {
                if (linkedList$Entry.val == null) {
                    return n;
                }
                linkedList$Entry = linkedList$Entry.prev;
                --n;
            }
        } else {
            LinkedList$Entry linkedList$Entry = this.head.prev;
            while (linkedList$Entry != this.head) {
                if (object.equals(linkedList$Entry.val)) {
                    return n;
                }
                linkedList$Entry = linkedList$Entry.prev;
                --n;
            }
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        Object[] objectArray = new Object[this.size];
        int n = 0;
        LinkedList$Entry linkedList$Entry = this.head.next;
        while (linkedList$Entry != this.head) {
            objectArray[n++] = linkedList$Entry.val;
            linkedList$Entry = linkedList$Entry.next;
        }
        return objectArray;
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        int n = this.size;
        if (objectArray.length < n) {
            objectArray = (Object[])Array.newInstance(super.getClass().getComponentType(), n);
        }
        int n2 = 0;
        LinkedList$Entry linkedList$Entry = this.head.next;
        while (linkedList$Entry != this.head) {
            objectArray[n2++] = linkedList$Entry.val;
            linkedList$Entry = linkedList$Entry.next;
        }
        if (n2 < objectArray.length) {
            objectArray[n2++] = null;
        }
        return objectArray;
    }

    @Override
    public boolean add(Object object) {
        this.insertBefore(this.head, object);
        return true;
    }

    private void insertAfter(LinkedList$Entry linkedList$Entry, Object object) {
        ++this.modCount;
        LinkedList$Entry linkedList$Entry2 = linkedList$Entry.next;
        LinkedList$Entry linkedList$Entry3 = new LinkedList$Entry(object);
        linkedList$Entry3.prev = linkedList$Entry;
        linkedList$Entry3.next = linkedList$Entry2;
        linkedList$Entry.next = linkedList$Entry3;
        linkedList$Entry2.prev = linkedList$Entry3;
        ++this.size;
    }

    private void insertBefore(LinkedList$Entry linkedList$Entry, Object object) {
        ++this.modCount;
        LinkedList$Entry linkedList$Entry2 = linkedList$Entry.prev;
        LinkedList$Entry linkedList$Entry3 = new LinkedList$Entry(object);
        linkedList$Entry3.prev = linkedList$Entry2;
        linkedList$Entry3.next = linkedList$Entry;
        linkedList$Entry2.next = linkedList$Entry3;
        linkedList$Entry.prev = linkedList$Entry3;
        ++this.size;
    }

    private Object remove(LinkedList$Entry linkedList$Entry) {
        if (linkedList$Entry == this.head) {
            throw new NoSuchElementException();
        }
        ++this.modCount;
        LinkedList$Entry linkedList$Entry2 = linkedList$Entry.next;
        LinkedList$Entry linkedList$Entry3 = linkedList$Entry.prev;
        linkedList$Entry3.next = linkedList$Entry2;
        linkedList$Entry2.prev = linkedList$Entry3;
        --this.size;
        return linkedList$Entry.val;
    }

    @Override
    public boolean remove(Object object) {
        LinkedList$Entry linkedList$Entry = this.findFirst(object);
        if (linkedList$Entry == null) {
            return false;
        }
        this.remove(linkedList$Entry);
        return true;
    }

    @Override
    public boolean addAll(Collection collection) {
        return this.insertAllBefore(this.head, collection);
    }

    @Override
    public boolean addAll(int n, Collection collection) {
        return this.insertAllBefore(n == this.size ? this.head : this.getAt(n), collection);
    }

    private boolean insertAllBefore(LinkedList$Entry linkedList$Entry, Collection collection) {
        LinkedList$Entry linkedList$Entry2;
        LinkedList$Entry linkedList$Entry3;
        Iterator iterator = collection.iterator();
        if (!iterator.hasNext()) {
            return false;
        }
        ++this.modCount;
        LinkedList$Entry linkedList$Entry4 = linkedList$Entry3 = new LinkedList$Entry(iterator.next());
        LinkedList$Entry linkedList$Entry5 = linkedList$Entry3;
        int n = 1;
        while (iterator.hasNext()) {
            linkedList$Entry4.next = linkedList$Entry5 = new LinkedList$Entry(iterator.next());
            linkedList$Entry5.prev = linkedList$Entry4;
            linkedList$Entry4 = linkedList$Entry5;
            ++n;
        }
        linkedList$Entry3.prev = linkedList$Entry2 = linkedList$Entry.prev;
        linkedList$Entry5.next = linkedList$Entry;
        linkedList$Entry2.next = linkedList$Entry3;
        linkedList$Entry.prev = linkedList$Entry5;
        this.size += n;
        return true;
    }

    @Override
    public void clear() {
        ++this.modCount;
        this.head.next = this.head.prev = this.head;
        this.size = 0;
    }

    @Override
    public Object get(int n) {
        return this.getAt((int)n).val;
    }

    @Override
    public Object set(int n, Object object) {
        LinkedList$Entry linkedList$Entry = this.getAt(n);
        Object object2 = linkedList$Entry.val;
        linkedList$Entry.val = object;
        return object2;
    }

    @Override
    public void add(int n, Object object) {
        if (n == this.size) {
            this.insertBefore(this.head, object);
        } else {
            this.insertBefore(n == this.size ? this.head : this.getAt(n), object);
        }
    }

    @Override
    public Object remove(int n) {
        return this.remove(this.getAt(n));
    }

    @Override
    public ListIterator listIterator() {
        return new LinkedList$Itr(this);
    }

    @Override
    public ListIterator listIterator(int n) {
        return new LinkedList$Itr(this, n == this.size ? this.head : this.getAt(n), n);
    }

    @Override
    public void addFirst(Object object) {
        this.insertAfter(this.head, object);
    }

    @Override
    public void addLast(Object object) {
        this.insertBefore(this.head, object);
    }

    @Override
    public boolean offerFirst(Object object) {
        this.insertAfter(this.head, object);
        return true;
    }

    @Override
    public boolean offerLast(Object object) {
        this.insertBefore(this.head, object);
        return true;
    }

    @Override
    public Object removeFirst() {
        return this.remove(this.head.next);
    }

    @Override
    public Object removeLast() {
        return this.remove(this.head.prev);
    }

    @Override
    public Object pollFirst() {
        return this.size == 0 ? null : this.remove(this.head.next);
    }

    @Override
    public Object pollLast() {
        return this.size == 0 ? null : this.remove(this.head.prev);
    }

    @Override
    public Object getFirst() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.head.next.val;
    }

    @Override
    public Object getLast() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.head.prev.val;
    }

    @Override
    public Object peekFirst() {
        return this.size == 0 ? null : this.head.next.val;
    }

    @Override
    public Object peekLast() {
        return this.size == 0 ? null : this.head.prev.val;
    }

    @Override
    public boolean removeFirstOccurrence(Object object) {
        LinkedList$Entry linkedList$Entry = this.findFirst(object);
        if (linkedList$Entry == null) {
            return false;
        }
        this.remove(linkedList$Entry);
        return true;
    }

    @Override
    public boolean removeLastOccurrence(Object object) {
        LinkedList$Entry linkedList$Entry = this.findLast(object);
        if (linkedList$Entry == null) {
            return false;
        }
        this.remove(linkedList$Entry);
        return true;
    }

    @Override
    public boolean offer(Object object) {
        return this.add(object);
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

    @Override
    public Iterator descendingIterator() {
        return new LinkedList$DescItr(this);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        LinkedList$Entry linkedList$Entry = this.head.next;
        while (linkedList$Entry != this.head) {
            objectOutputStream.writeObject(linkedList$Entry.val);
            linkedList$Entry = linkedList$Entry.next;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        LinkedList$Entry linkedList$Entry;
        objectInputStream.defaultReadObject();
        int n = objectInputStream.readInt();
        linkedList$Entry.next = linkedList$Entry.prev = (linkedList$Entry = new LinkedList$Entry(null));
        for (int i2 = 0; i2 < n; ++i2) {
            this.insertBefore(linkedList$Entry, objectInputStream.readObject());
        }
        this.size = n;
        this.head = linkedList$Entry;
    }

    public Object clone() {
        LinkedList$Entry linkedList$Entry;
        LinkedList linkedList = null;
        try {
            linkedList = (LinkedList)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        linkedList$Entry.next = linkedList$Entry.prev = (linkedList$Entry = new LinkedList$Entry(null));
        linkedList.head = linkedList$Entry;
        linkedList.addAll(this);
        return linkedList;
    }

    static /* synthetic */ int access$000(LinkedList linkedList) {
        return linkedList.modCount;
    }

    static /* synthetic */ LinkedList$Entry access$100(LinkedList linkedList) {
        return linkedList.head;
    }

    static /* synthetic */ void access$200(LinkedList linkedList, LinkedList$Entry entry, Object object) {
        linkedList.insertBefore(entry, object);
    }

    static /* synthetic */ Object access$300(LinkedList linkedList, LinkedList$Entry linkedList$Entry) {
        return linkedList.remove(linkedList$Entry);
    }

    static /* synthetic */ void access$400(LinkedList linkedList, LinkedList$Entry linkedList$Entry, Object object) {
        linkedList.insertAfter(linkedList$Entry, object);
    }
}

