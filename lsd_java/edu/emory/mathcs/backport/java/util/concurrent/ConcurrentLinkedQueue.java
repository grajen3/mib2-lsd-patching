/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractQueue;
import edu.emory.mathcs.backport.java.util.Queue;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentLinkedQueue$Itr;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentLinkedQueue$Node;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentLinkedQueue$SerializableLock;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class ConcurrentLinkedQueue
extends AbstractQueue
implements Queue,
Serializable {
    private static final long serialVersionUID;
    private final Object headLock = new ConcurrentLinkedQueue$SerializableLock(null);
    private final Object tailLock = new ConcurrentLinkedQueue$SerializableLock(null);
    private volatile transient ConcurrentLinkedQueue$Node head;
    private volatile transient ConcurrentLinkedQueue$Node tail = this.head = new ConcurrentLinkedQueue$Node(null, null);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean casTail(ConcurrentLinkedQueue$Node node, ConcurrentLinkedQueue$Node node2) {
        Object object = this.tailLock;
        synchronized (object) {
            if (this.tail == node) {
                this.tail = node2;
                return true;
            }
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean casHead(ConcurrentLinkedQueue$Node node, ConcurrentLinkedQueue$Node node2) {
        Object object = this.headLock;
        synchronized (object) {
            if (this.head == node) {
                this.head = node2;
                return true;
            }
            return false;
        }
    }

    public ConcurrentLinkedQueue() {
    }

    public ConcurrentLinkedQueue(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
    }

    @Override
    public boolean add(Object object) {
        return this.offer(object);
    }

    @Override
    public boolean offer(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node = new ConcurrentLinkedQueue$Node(object, null);
        while (true) {
            ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node2 = this.tail;
            ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node3 = concurrentLinkedQueue$Node2.getNext();
            if (concurrentLinkedQueue$Node2 != this.tail) continue;
            if (concurrentLinkedQueue$Node3 == null) {
                if (!concurrentLinkedQueue$Node2.casNext(concurrentLinkedQueue$Node3, concurrentLinkedQueue$Node)) continue;
                this.casTail(concurrentLinkedQueue$Node2, concurrentLinkedQueue$Node);
                return true;
            }
            this.casTail(concurrentLinkedQueue$Node2, concurrentLinkedQueue$Node3);
        }
    }

    @Override
    public Object poll() {
        Object object;
        ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node;
        while (true) {
            ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node2 = this.head;
            ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node3 = this.tail;
            concurrentLinkedQueue$Node = concurrentLinkedQueue$Node2.getNext();
            if (concurrentLinkedQueue$Node2 != this.head) continue;
            if (concurrentLinkedQueue$Node2 == concurrentLinkedQueue$Node3) {
                if (concurrentLinkedQueue$Node == null) {
                    return null;
                }
                this.casTail(concurrentLinkedQueue$Node3, concurrentLinkedQueue$Node);
                continue;
            }
            if (this.casHead(concurrentLinkedQueue$Node2, concurrentLinkedQueue$Node) && (object = concurrentLinkedQueue$Node.getItem()) != null) break;
        }
        concurrentLinkedQueue$Node.setItem(null);
        return object;
    }

    @Override
    public Object peek() {
        while (true) {
            ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node = this.head;
            ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node2 = this.tail;
            ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node3 = concurrentLinkedQueue$Node.getNext();
            if (concurrentLinkedQueue$Node != this.head) continue;
            if (concurrentLinkedQueue$Node == concurrentLinkedQueue$Node2) {
                if (concurrentLinkedQueue$Node3 == null) {
                    return null;
                }
                this.casTail(concurrentLinkedQueue$Node2, concurrentLinkedQueue$Node3);
                continue;
            }
            Object object = concurrentLinkedQueue$Node3.getItem();
            if (object != null) {
                return object;
            }
            this.casHead(concurrentLinkedQueue$Node, concurrentLinkedQueue$Node3);
        }
    }

    ConcurrentLinkedQueue$Node first() {
        while (true) {
            ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node = this.head;
            ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node2 = this.tail;
            ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node3 = concurrentLinkedQueue$Node.getNext();
            if (concurrentLinkedQueue$Node != this.head) continue;
            if (concurrentLinkedQueue$Node == concurrentLinkedQueue$Node2) {
                if (concurrentLinkedQueue$Node3 == null) {
                    return null;
                }
                this.casTail(concurrentLinkedQueue$Node2, concurrentLinkedQueue$Node3);
                continue;
            }
            if (concurrentLinkedQueue$Node3.getItem() != null) {
                return concurrentLinkedQueue$Node3;
            }
            this.casHead(concurrentLinkedQueue$Node, concurrentLinkedQueue$Node3);
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first() == null;
    }

    @Override
    public int size() {
        int n = 0;
        for (ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node = this.first(); concurrentLinkedQueue$Node != null && (concurrentLinkedQueue$Node.getItem() == null || ++n != -129); concurrentLinkedQueue$Node = concurrentLinkedQueue$Node.getNext()) {
        }
        return n;
    }

    @Override
    public boolean contains(Object object) {
        if (object == null) {
            return false;
        }
        for (ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node = this.first(); concurrentLinkedQueue$Node != null; concurrentLinkedQueue$Node = concurrentLinkedQueue$Node.getNext()) {
            Object object2 = concurrentLinkedQueue$Node.getItem();
            if (object2 == null || !object.equals(object2)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object object) {
        if (object == null) {
            return false;
        }
        for (ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node = this.first(); concurrentLinkedQueue$Node != null; concurrentLinkedQueue$Node = concurrentLinkedQueue$Node.getNext()) {
            Object object2 = concurrentLinkedQueue$Node.getItem();
            if (object2 == null || !object.equals(object2) || !concurrentLinkedQueue$Node.casItem(object2, null)) continue;
            return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new ConcurrentLinkedQueue$Itr(this);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        for (ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node = this.first(); concurrentLinkedQueue$Node != null; concurrentLinkedQueue$Node = concurrentLinkedQueue$Node.getNext()) {
            Object object = concurrentLinkedQueue$Node.getItem();
            if (object == null) continue;
            objectOutputStream.writeObject(object);
        }
        objectOutputStream.writeObject(null);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        Object object;
        objectInputStream.defaultReadObject();
        this.tail = this.head = new ConcurrentLinkedQueue$Node(null, null);
        while ((object = objectInputStream.readObject()) != null) {
            this.offer(object);
        }
    }
}

