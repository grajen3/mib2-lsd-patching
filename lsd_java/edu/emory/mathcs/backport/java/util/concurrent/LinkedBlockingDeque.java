/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractQueue;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingDeque;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingDeque$DescendingItr;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingDeque$Itr;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingDeque$Node;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Condition;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBlockingDeque
extends AbstractQueue
implements BlockingDeque,
Serializable {
    private static final long serialVersionUID;
    private transient LinkedBlockingDeque$Node first;
    private transient LinkedBlockingDeque$Node last;
    private transient int count;
    private final int capacity;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = this.lock.newCondition();
    private final Condition notFull = this.lock.newCondition();

    public LinkedBlockingDeque() {
        this(-129);
    }

    public LinkedBlockingDeque(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = n;
    }

    public LinkedBlockingDeque(Collection collection) {
        this(-129);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            this.add(object);
        }
    }

    private boolean linkFirst(Object object) {
        LinkedBlockingDeque$Node linkedBlockingDeque$Node;
        if (this.count >= this.capacity) {
            return false;
        }
        ++this.count;
        LinkedBlockingDeque$Node linkedBlockingDeque$Node2 = this.first;
        this.first = linkedBlockingDeque$Node = new LinkedBlockingDeque$Node(object, null, linkedBlockingDeque$Node2);
        if (this.last == null) {
            this.last = linkedBlockingDeque$Node;
        } else {
            linkedBlockingDeque$Node2.prev = linkedBlockingDeque$Node;
        }
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(Object object) {
        LinkedBlockingDeque$Node linkedBlockingDeque$Node;
        if (this.count >= this.capacity) {
            return false;
        }
        ++this.count;
        LinkedBlockingDeque$Node linkedBlockingDeque$Node2 = this.last;
        this.last = linkedBlockingDeque$Node = new LinkedBlockingDeque$Node(object, linkedBlockingDeque$Node2, null);
        if (this.first == null) {
            this.first = linkedBlockingDeque$Node;
        } else {
            linkedBlockingDeque$Node2.next = linkedBlockingDeque$Node;
        }
        this.notEmpty.signal();
        return true;
    }

    private Object unlinkFirst() {
        LinkedBlockingDeque$Node linkedBlockingDeque$Node;
        LinkedBlockingDeque$Node linkedBlockingDeque$Node2 = this.first;
        if (linkedBlockingDeque$Node2 == null) {
            return null;
        }
        this.first = linkedBlockingDeque$Node = linkedBlockingDeque$Node2.next;
        if (linkedBlockingDeque$Node == null) {
            this.last = null;
        } else {
            linkedBlockingDeque$Node.prev = null;
        }
        --this.count;
        this.notFull.signal();
        return linkedBlockingDeque$Node2.item;
    }

    private Object unlinkLast() {
        LinkedBlockingDeque$Node linkedBlockingDeque$Node;
        LinkedBlockingDeque$Node linkedBlockingDeque$Node2 = this.last;
        if (linkedBlockingDeque$Node2 == null) {
            return null;
        }
        this.last = linkedBlockingDeque$Node = linkedBlockingDeque$Node2.prev;
        if (linkedBlockingDeque$Node == null) {
            this.first = null;
        } else {
            linkedBlockingDeque$Node.next = null;
        }
        --this.count;
        this.notFull.signal();
        return linkedBlockingDeque$Node2.item;
    }

    private void unlink(LinkedBlockingDeque$Node linkedBlockingDeque$Node) {
        LinkedBlockingDeque$Node linkedBlockingDeque$Node2 = linkedBlockingDeque$Node.prev;
        LinkedBlockingDeque$Node linkedBlockingDeque$Node3 = linkedBlockingDeque$Node.next;
        if (linkedBlockingDeque$Node2 == null) {
            if (linkedBlockingDeque$Node3 == null) {
                this.last = null;
                this.first = null;
            } else {
                linkedBlockingDeque$Node3.prev = null;
                this.first = linkedBlockingDeque$Node3;
            }
        } else if (linkedBlockingDeque$Node3 == null) {
            linkedBlockingDeque$Node2.next = null;
            this.last = linkedBlockingDeque$Node2;
        } else {
            linkedBlockingDeque$Node2.next = linkedBlockingDeque$Node3;
            linkedBlockingDeque$Node3.prev = linkedBlockingDeque$Node2;
        }
        --this.count;
        this.notFull.signalAll();
    }

    @Override
    public void addFirst(Object object) {
        if (!this.offerFirst(object)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override
    public void addLast(Object object) {
        if (!this.offerLast(object)) {
            throw new IllegalStateException("Deque full");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean offerFirst(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        this.lock.lock();
        try {
            boolean bl = this.linkFirst(object);
            return bl;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean offerLast(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        this.lock.lock();
        try {
            boolean bl = this.linkLast(object);
            return bl;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void putFirst(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        this.lock.lock();
        try {
            while (!this.linkFirst(object)) {
                this.notFull.await();
            }
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void putLast(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        this.lock.lock();
        try {
            while (!this.linkLast(object)) {
                this.notFull.await();
            }
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override
    public boolean offerFirst(Object object, long l, TimeUnit timeUnit) {
        if (object == null) {
            throw new NullPointerException();
        }
        long l2 = timeUnit.toNanos(l);
        long l3 = Utils.nanoTime() + l2;
        this.lock.lockInterruptibly();
        try {
            while (true) {
                if (this.linkFirst(object)) {
                    boolean bl = true;
                    return bl;
                }
                if (l2 <= 0L) {
                    boolean bl = false;
                    return bl;
                }
                this.notFull.await(l2, TimeUnit.NANOSECONDS);
                l2 = l3 - Utils.nanoTime();
            }
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override
    public boolean offerLast(Object object, long l, TimeUnit timeUnit) {
        if (object == null) {
            throw new NullPointerException();
        }
        long l2 = timeUnit.toNanos(l);
        long l3 = Utils.nanoTime() + l2;
        this.lock.lockInterruptibly();
        try {
            while (true) {
                if (this.linkLast(object)) {
                    boolean bl = true;
                    return bl;
                }
                if (l2 <= 0L) {
                    boolean bl = false;
                    return bl;
                }
                this.notFull.await(l2, TimeUnit.NANOSECONDS);
                l2 = l3 - Utils.nanoTime();
            }
        }
        finally {
            this.lock.unlock();
        }
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object pollFirst() {
        this.lock.lock();
        try {
            Object object = this.unlinkFirst();
            return object;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object pollLast() {
        this.lock.lock();
        try {
            Object object = this.unlinkLast();
            return object;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object takeFirst() {
        this.lock.lock();
        try {
            Object object;
            while ((object = this.unlinkFirst()) == null) {
                this.notEmpty.await();
            }
            Object object2 = object;
            return object2;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object takeLast() {
        this.lock.lock();
        try {
            Object object;
            while ((object = this.unlinkLast()) == null) {
                this.notEmpty.await();
            }
            Object object2 = object;
            return object2;
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override
    public Object pollFirst(long l, TimeUnit timeUnit) {
        long l2 = timeUnit.toNanos(l);
        long l3 = Utils.nanoTime() + l2;
        this.lock.lockInterruptibly();
        try {
            while (true) {
                Object object;
                if ((object = this.unlinkFirst()) != null) {
                    Object object2 = object;
                    return object2;
                }
                if (l2 <= 0L) {
                    Object var9_7 = null;
                    return var9_7;
                }
                this.notEmpty.await(l2, TimeUnit.NANOSECONDS);
                l2 = l3 - Utils.nanoTime();
            }
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override
    public Object pollLast(long l, TimeUnit timeUnit) {
        long l2 = timeUnit.toNanos(l);
        long l3 = Utils.nanoTime() + l2;
        this.lock.lockInterruptibly();
        try {
            while (true) {
                Object object;
                if ((object = this.unlinkLast()) != null) {
                    Object object2 = object;
                    return object2;
                }
                if (l2 <= 0L) {
                    Object var9_7 = null;
                    return var9_7;
                }
                this.notEmpty.await(l2, TimeUnit.NANOSECONDS);
                l2 = l3 - Utils.nanoTime();
            }
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override
    public Object getFirst() {
        Object object = this.peekFirst();
        if (object == null) {
            throw new NoSuchElementException();
        }
        return object;
    }

    @Override
    public Object getLast() {
        Object object = this.peekLast();
        if (object == null) {
            throw new NoSuchElementException();
        }
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object peekFirst() {
        this.lock.lock();
        try {
            Object object = this.first == null ? null : this.first.item;
            return object;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object peekLast() {
        this.lock.lock();
        try {
            Object object = this.last == null ? null : this.last.item;
            return object;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean removeFirstOccurrence(Object object) {
        if (object == null) {
            return false;
        }
        this.lock.lock();
        try {
            LinkedBlockingDeque$Node linkedBlockingDeque$Node = this.first;
            while (linkedBlockingDeque$Node != null) {
                if (object.equals(linkedBlockingDeque$Node.item)) {
                    this.unlink(linkedBlockingDeque$Node);
                    boolean bl = true;
                    return bl;
                }
                linkedBlockingDeque$Node = linkedBlockingDeque$Node.next;
            }
            boolean bl = false;
            return bl;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean removeLastOccurrence(Object object) {
        if (object == null) {
            return false;
        }
        this.lock.lock();
        try {
            LinkedBlockingDeque$Node linkedBlockingDeque$Node = this.last;
            while (linkedBlockingDeque$Node != null) {
                if (object.equals(linkedBlockingDeque$Node.item)) {
                    this.unlink(linkedBlockingDeque$Node);
                    boolean bl = true;
                    return bl;
                }
                linkedBlockingDeque$Node = linkedBlockingDeque$Node.prev;
            }
            boolean bl = false;
            return bl;
        }
        finally {
            this.lock.unlock();
        }
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
    public void put(Object object) {
        this.putLast(object);
    }

    @Override
    public boolean offer(Object object, long l, TimeUnit timeUnit) {
        return this.offerLast(object, l, timeUnit);
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
    public Object take() {
        return this.takeFirst();
    }

    @Override
    public Object poll(long l, TimeUnit timeUnit) {
        return this.pollFirst(l, timeUnit);
    }

    @Override
    public Object element() {
        return this.getFirst();
    }

    @Override
    public Object peek() {
        return this.peekFirst();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int remainingCapacity() {
        this.lock.lock();
        try {
            int n = this.capacity - this.count;
            return n;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int drainTo(Collection collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        this.lock.lock();
        try {
            LinkedBlockingDeque$Node linkedBlockingDeque$Node = this.first;
            while (linkedBlockingDeque$Node != null) {
                collection.add(linkedBlockingDeque$Node.item);
                linkedBlockingDeque$Node = linkedBlockingDeque$Node.next;
            }
            int n = this.count;
            this.count = 0;
            this.last = null;
            this.first = null;
            this.notFull.signalAll();
            int n2 = n;
            return n2;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int drainTo(Collection collection, int n) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        this.lock.lock();
        try {
            int n2;
            for (n2 = 0; n2 < n && this.first != null; ++n2) {
                collection.add(this.first.item);
                this.first.prev = null;
                this.first = this.first.next;
                --this.count;
            }
            if (this.first == null) {
                this.last = null;
            }
            this.notFull.signalAll();
            int n3 = n2;
            return n3;
        }
        finally {
            this.lock.unlock();
        }
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
    public boolean remove(Object object) {
        return this.removeFirstOccurrence(object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int size() {
        this.lock.lock();
        try {
            int n = this.count;
            return n;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean contains(Object object) {
        if (object == null) {
            return false;
        }
        this.lock.lock();
        try {
            LinkedBlockingDeque$Node linkedBlockingDeque$Node = this.first;
            while (linkedBlockingDeque$Node != null) {
                if (object.equals(linkedBlockingDeque$Node.item)) {
                    boolean bl = true;
                    return bl;
                }
                linkedBlockingDeque$Node = linkedBlockingDeque$Node.next;
            }
            boolean bl = false;
            return bl;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean removeNode(LinkedBlockingDeque$Node linkedBlockingDeque$Node) {
        this.lock.lock();
        try {
            LinkedBlockingDeque$Node linkedBlockingDeque$Node2 = this.first;
            while (linkedBlockingDeque$Node2 != null) {
                if (linkedBlockingDeque$Node2 == linkedBlockingDeque$Node) {
                    this.unlink(linkedBlockingDeque$Node2);
                    boolean bl = true;
                    return bl;
                }
                linkedBlockingDeque$Node2 = linkedBlockingDeque$Node2.next;
            }
            boolean bl = false;
            return bl;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray() {
        this.lock.lock();
        try {
            Object[] objectArray = new Object[this.count];
            int n = 0;
            Object object = this.first;
            while (object != null) {
                objectArray[n++] = object.item;
                object = object.next;
            }
            object = objectArray;
            return object;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray(Object[] objectArray) {
        this.lock.lock();
        try {
            if (objectArray.length < this.count) {
                objectArray = (Object[])Array.newInstance(super.getClass().getComponentType(), this.count);
            }
            int n = 0;
            Object[] objectArray2 = this.first;
            while (objectArray2 != null) {
                objectArray[n++] = objectArray2.item;
                objectArray2 = objectArray2.next;
            }
            if (objectArray.length > n) {
                objectArray[n] = null;
            }
            objectArray2 = objectArray;
            return objectArray2;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String toString() {
        this.lock.lock();
        try {
            String string = super.toString();
            return string;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        this.lock.lock();
        try {
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override
    public Iterator iterator() {
        return new LinkedBlockingDeque$Itr(this, null);
    }

    @Override
    public Iterator descendingIterator() {
        return new LinkedBlockingDeque$DescendingItr(this, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void writeObject(ObjectOutputStream objectOutputStream) {
        this.lock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            LinkedBlockingDeque$Node linkedBlockingDeque$Node = this.first;
            while (linkedBlockingDeque$Node != null) {
                objectOutputStream.writeObject(linkedBlockingDeque$Node.item);
                linkedBlockingDeque$Node = linkedBlockingDeque$Node.next;
            }
            objectOutputStream.writeObject(null);
        }
        finally {
            this.lock.unlock();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        Object object;
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while ((object = objectInputStream.readObject()) != null) {
            this.add(object);
        }
    }

    static /* synthetic */ ReentrantLock access$200(LinkedBlockingDeque linkedBlockingDeque) {
        return linkedBlockingDeque.lock;
    }

    static /* synthetic */ LinkedBlockingDeque$Node access$300(LinkedBlockingDeque linkedBlockingDeque) {
        return linkedBlockingDeque.first;
    }

    static /* synthetic */ LinkedBlockingDeque$Node access$400(LinkedBlockingDeque linkedBlockingDeque) {
        return linkedBlockingDeque.last;
    }
}

