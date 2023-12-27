/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractQueue;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingQueue$Itr;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingQueue$Node;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingQueue$SerializableLock;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public class LinkedBlockingQueue
extends AbstractQueue
implements BlockingQueue,
Serializable {
    private static final long serialVersionUID;
    private final int capacity;
    private volatile int count = 0;
    private transient LinkedBlockingQueue$Node head;
    private transient LinkedBlockingQueue$Node last;
    private final Object takeLock = new LinkedBlockingQueue$SerializableLock(null);
    private final Object putLock = new LinkedBlockingQueue$SerializableLock(null);
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$edu$emory$mathcs$backport$java$util$concurrent$LinkedBlockingQueue;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalNotEmpty() {
        Object object = this.takeLock;
        synchronized (object) {
            this.takeLock.notify();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalNotFull() {
        Object object = this.putLock;
        synchronized (object) {
            this.putLock.notify();
        }
    }

    private void insert(Object object) {
        this.last = this.last.next = new LinkedBlockingQueue$Node(object);
    }

    private Object extract() {
        LinkedBlockingQueue$Node linkedBlockingQueue$Node;
        this.head = linkedBlockingQueue$Node = this.head.next;
        Object object = linkedBlockingQueue$Node.item;
        linkedBlockingQueue$Node.item = null;
        return object;
    }

    public LinkedBlockingQueue() {
        this(-129);
    }

    public LinkedBlockingQueue(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = n;
        this.last = this.head = new LinkedBlockingQueue$Node(null);
    }

    public LinkedBlockingQueue(Collection collection) {
        this(-129);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            this.add(object);
        }
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public int remainingCapacity() {
        return this.capacity - this.count;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void put(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        int n = -1;
        Object object2 = this.putLock;
        synchronized (object2) {
            try {
                while (this.count == this.capacity) {
                    this.putLock.wait();
                }
            }
            catch (InterruptedException interruptedException) {
                this.putLock.notify();
                throw interruptedException;
            }
            this.insert(object);
            LinkedBlockingQueue linkedBlockingQueue = this;
            synchronized (linkedBlockingQueue) {
                n = this.count++;
            }
            if (n + 1 < this.capacity) {
                this.putLock.notify();
            }
        }
        if (n == 0) {
            this.signalNotEmpty();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean offer(Object object, long l, TimeUnit timeUnit) {
        if (object == null) {
            throw new NullPointerException();
        }
        long l2 = timeUnit.toNanos(l);
        int n = -1;
        Object object2 = this.putLock;
        synchronized (object2) {
            long l3 = Utils.nanoTime() + l2;
            while (true) {
                if (this.count < this.capacity) {
                    this.insert(object);
                    LinkedBlockingQueue linkedBlockingQueue = this;
                    synchronized (linkedBlockingQueue) {
                        n = this.count++;
                    }
                    if (n + 1 >= this.capacity) break;
                    this.putLock.notify();
                    break;
                }
                if (l2 <= 0L) {
                    return false;
                }
                try {
                    TimeUnit.NANOSECONDS.timedWait(this.putLock, l2);
                    l2 = l3 - Utils.nanoTime();
                }
                catch (InterruptedException interruptedException) {
                    this.putLock.notify();
                    throw interruptedException;
                }
            }
        }
        if (n == 0) {
            this.signalNotEmpty();
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean offer(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        if (this.count == this.capacity) {
            return false;
        }
        int n = -1;
        Object object2 = this.putLock;
        synchronized (object2) {
            if (this.count < this.capacity) {
                this.insert(object);
                LinkedBlockingQueue linkedBlockingQueue = this;
                synchronized (linkedBlockingQueue) {
                    n = this.count++;
                }
                if (n + 1 < this.capacity) {
                    this.putLock.notify();
                }
            }
        }
        if (n == 0) {
            this.signalNotEmpty();
        }
        return n >= 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object take() {
        Object object;
        int n = -1;
        Object object2 = this.takeLock;
        synchronized (object2) {
            try {
                while (this.count == 0) {
                    this.takeLock.wait();
                }
            }
            catch (InterruptedException interruptedException) {
                this.takeLock.notify();
                throw interruptedException;
            }
            object = this.extract();
            LinkedBlockingQueue linkedBlockingQueue = this;
            synchronized (linkedBlockingQueue) {
                n = this.count--;
            }
            if (n > 1) {
                this.takeLock.notify();
            }
        }
        if (n == this.capacity) {
            this.signalNotFull();
        }
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object poll(long l, TimeUnit timeUnit) {
        Object object = null;
        int n = -1;
        long l2 = timeUnit.toNanos(l);
        Object object2 = this.takeLock;
        synchronized (object2) {
            long l3 = Utils.nanoTime() + l2;
            while (true) {
                if (this.count > 0) {
                    object = this.extract();
                    LinkedBlockingQueue linkedBlockingQueue = this;
                    synchronized (linkedBlockingQueue) {
                        n = this.count--;
                    }
                    if (n <= 1) break;
                    this.takeLock.notify();
                    break;
                }
                if (l2 <= 0L) {
                    return null;
                }
                try {
                    TimeUnit.NANOSECONDS.timedWait(this.takeLock, l2);
                    l2 = l3 - Utils.nanoTime();
                }
                catch (InterruptedException interruptedException) {
                    this.takeLock.notify();
                    throw interruptedException;
                }
            }
        }
        if (n == this.capacity) {
            this.signalNotFull();
        }
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object poll() {
        if (this.count == 0) {
            return null;
        }
        Object object = null;
        int n = -1;
        Object object2 = this.takeLock;
        synchronized (object2) {
            if (this.count > 0) {
                object = this.extract();
                LinkedBlockingQueue linkedBlockingQueue = this;
                synchronized (linkedBlockingQueue) {
                    n = this.count--;
                }
                if (n > 1) {
                    this.takeLock.notify();
                }
            }
        }
        if (n == this.capacity) {
            this.signalNotFull();
        }
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object peek() {
        if (this.count == 0) {
            return null;
        }
        Object object = this.takeLock;
        synchronized (object) {
            LinkedBlockingQueue$Node linkedBlockingQueue$Node = this.head.next;
            if (linkedBlockingQueue$Node == null) {
                return null;
            }
            return linkedBlockingQueue$Node.item;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl = false;
        Object object2 = this.putLock;
        synchronized (object2) {
            Object object3 = this.takeLock;
            synchronized (object3) {
                LinkedBlockingQueue$Node linkedBlockingQueue$Node = this.head;
                LinkedBlockingQueue$Node linkedBlockingQueue$Node2 = this.head.next;
                while (linkedBlockingQueue$Node2 != null) {
                    if (object.equals(linkedBlockingQueue$Node2.item)) {
                        bl = true;
                        break;
                    }
                    linkedBlockingQueue$Node = linkedBlockingQueue$Node2;
                    linkedBlockingQueue$Node2 = linkedBlockingQueue$Node2.next;
                }
                if (bl) {
                    linkedBlockingQueue$Node2.item = null;
                    linkedBlockingQueue$Node.next = linkedBlockingQueue$Node2.next;
                    if (this.last == linkedBlockingQueue$Node2) {
                        this.last = linkedBlockingQueue$Node;
                    }
                    LinkedBlockingQueue linkedBlockingQueue = this;
                    synchronized (linkedBlockingQueue) {
                        if (this.count-- == this.capacity) {
                            this.putLock.notifyAll();
                        }
                    }
                }
            }
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray() {
        Object object = this.putLock;
        synchronized (object) {
            Object object2 = this.takeLock;
            synchronized (object2) {
                int n = this.count;
                Object[] objectArray = new Object[n];
                int n2 = 0;
                LinkedBlockingQueue$Node linkedBlockingQueue$Node = this.head.next;
                while (linkedBlockingQueue$Node != null) {
                    objectArray[n2++] = linkedBlockingQueue$Node.item;
                    linkedBlockingQueue$Node = linkedBlockingQueue$Node.next;
                }
                return objectArray;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray(Object[] objectArray) {
        Object object = this.putLock;
        synchronized (object) {
            Object object2 = this.takeLock;
            synchronized (object2) {
                int n = this.count;
                if (objectArray.length < n) {
                    objectArray = (Object[])Array.newInstance(super.getClass().getComponentType(), n);
                }
                int n2 = 0;
                LinkedBlockingQueue$Node linkedBlockingQueue$Node = this.head.next;
                while (linkedBlockingQueue$Node != null) {
                    objectArray[n2++] = linkedBlockingQueue$Node.item;
                    linkedBlockingQueue$Node = linkedBlockingQueue$Node.next;
                }
                if (objectArray.length > n2) {
                    objectArray[n2] = null;
                }
                return objectArray;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String toString() {
        Object object = this.putLock;
        synchronized (object) {
            Object object2 = this.takeLock;
            synchronized (object2) {
                return super.toString();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        Object object = this.putLock;
        synchronized (object) {
            Object object2 = this.takeLock;
            synchronized (object2) {
                int n;
                this.head.next = null;
                if (!$assertionsDisabled && this.head.item != null) {
                    throw new AssertionError();
                }
                this.last = this.head;
                LinkedBlockingQueue linkedBlockingQueue = this;
                synchronized (linkedBlockingQueue) {
                    n = this.count;
                    this.count = 0;
                }
                if (n == this.capacity) {
                    this.putLock.notifyAll();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int drainTo(Collection collection) {
        LinkedBlockingQueue$Node linkedBlockingQueue$Node;
        Object object;
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        Object object2 = this.putLock;
        synchronized (object2) {
            object = this.takeLock;
            synchronized (object) {
                int n;
                linkedBlockingQueue$Node = this.head.next;
                this.head.next = null;
                if (!$assertionsDisabled && this.head.item != null) {
                    throw new AssertionError();
                }
                this.last = this.head;
                LinkedBlockingQueue linkedBlockingQueue = this;
                synchronized (linkedBlockingQueue) {
                    n = this.count;
                    this.count = 0;
                }
                if (n == this.capacity) {
                    this.putLock.notifyAll();
                }
            }
        }
        int n = 0;
        object = linkedBlockingQueue$Node;
        while (object != null) {
            collection.add(((LinkedBlockingQueue$Node)object).item);
            ((LinkedBlockingQueue$Node)object).item = null;
            ++n;
            object = ((LinkedBlockingQueue$Node)object).next;
        }
        return n;
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
        Object object = this.putLock;
        synchronized (object) {
            Object object2 = this.takeLock;
            synchronized (object2) {
                int n2;
                LinkedBlockingQueue$Node linkedBlockingQueue$Node = this.head.next;
                for (n2 = 0; linkedBlockingQueue$Node != null && n2 < n; ++n2) {
                    collection.add(linkedBlockingQueue$Node.item);
                    linkedBlockingQueue$Node.item = null;
                    linkedBlockingQueue$Node = linkedBlockingQueue$Node.next;
                }
                if (n2 != 0) {
                    int n3;
                    this.head.next = linkedBlockingQueue$Node;
                    if (!$assertionsDisabled && this.head.item != null) {
                        throw new AssertionError();
                    }
                    if (linkedBlockingQueue$Node == null) {
                        this.last = this.head;
                    }
                    LinkedBlockingQueue linkedBlockingQueue = this;
                    synchronized (linkedBlockingQueue) {
                        n3 = this.count;
                        this.count -= n2;
                    }
                    if (n3 == this.capacity) {
                        this.putLock.notifyAll();
                    }
                }
                return n2;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new LinkedBlockingQueue$Itr(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void writeObject(ObjectOutputStream objectOutputStream) {
        Object object = this.putLock;
        synchronized (object) {
            Object object2 = this.takeLock;
            synchronized (object2) {
                objectOutputStream.defaultWriteObject();
                LinkedBlockingQueue$Node linkedBlockingQueue$Node = this.head.next;
                while (linkedBlockingQueue$Node != null) {
                    objectOutputStream.writeObject(linkedBlockingQueue$Node.item);
                    linkedBlockingQueue$Node = linkedBlockingQueue$Node.next;
                }
                objectOutputStream.writeObject(null);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Object object = this;
        synchronized (object) {
            this.count = 0;
        }
        this.last = this.head = new LinkedBlockingQueue$Node(null);
        while ((object = objectInputStream.readObject()) != null) {
            this.add(object);
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

    static /* synthetic */ Object access$100(LinkedBlockingQueue linkedBlockingQueue) {
        return linkedBlockingQueue.putLock;
    }

    static /* synthetic */ Object access$200(LinkedBlockingQueue linkedBlockingQueue) {
        return linkedBlockingQueue.takeLock;
    }

    static /* synthetic */ LinkedBlockingQueue$Node access$300(LinkedBlockingQueue linkedBlockingQueue) {
        return linkedBlockingQueue.head;
    }

    static /* synthetic */ LinkedBlockingQueue$Node access$400(LinkedBlockingQueue linkedBlockingQueue) {
        return linkedBlockingQueue.last;
    }

    static /* synthetic */ LinkedBlockingQueue$Node access$402(LinkedBlockingQueue linkedBlockingQueue, LinkedBlockingQueue$Node node) {
        linkedBlockingQueue.last = node;
        return linkedBlockingQueue.last;
    }

    static /* synthetic */ int access$510(LinkedBlockingQueue linkedBlockingQueue) {
        return linkedBlockingQueue.count--;
    }

    static /* synthetic */ int access$600(LinkedBlockingQueue linkedBlockingQueue) {
        return linkedBlockingQueue.capacity;
    }

    static {
        $assertionsDisabled = !(class$edu$emory$mathcs$backport$java$util$concurrent$LinkedBlockingQueue == null ? (class$edu$emory$mathcs$backport$java$util$concurrent$LinkedBlockingQueue = LinkedBlockingQueue.class$("edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingQueue")) : class$edu$emory$mathcs$backport$java$util$concurrent$LinkedBlockingQueue).desiredAssertionStatus();
    }
}

