/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet$1;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet$WeakElement;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public class WeakIdentityHashSet
extends HashSet {
    ReferenceQueue queue = new ReferenceQueue();

    @Override
    public synchronized void clear() {
        super.clear();
    }

    @Override
    public synchronized Object clone() {
        return super.clone();
    }

    @Override
    public synchronized boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public synchronized int size() {
        return super.size();
    }

    @Override
    public synchronized Object[] toArray() {
        int n = this.size();
        int n2 = 0;
        Iterator iterator = super.iterator();
        Object[] objectArray = new Object[n];
        while (n2 < n) {
            objectArray[n2++] = this.getReferenceObject((WeakReference)iterator.next());
        }
        return objectArray;
    }

    @Override
    public synchronized Iterator iterator() {
        this.processQueue();
        Object[] objectArray = this.toArray();
        return new WeakIdentityHashSet$1(this, objectArray);
    }

    @Override
    public synchronized boolean contains(Object object) {
        return super.contains(WeakIdentityHashSet$WeakElement.create(object));
    }

    @Override
    public synchronized boolean add(Object object) {
        this.processQueue();
        return super.add(WeakIdentityHashSet$WeakElement.create(object, this.queue));
    }

    @Override
    public synchronized boolean remove(Object object) {
        boolean bl = super.remove(WeakIdentityHashSet$WeakElement.create(object));
        this.processQueue();
        return bl;
    }

    final Object getReferenceObject(WeakReference weakReference) {
        return weakReference == null ? null : weakReference.get();
    }

    private void processQueue() {
        WeakIdentityHashSet$WeakElement weakIdentityHashSet$WeakElement = null;
        while ((weakIdentityHashSet$WeakElement = (WeakIdentityHashSet$WeakElement)this.queue.poll()) != null) {
            super.remove(weakIdentityHashSet$WeakElement);
        }
    }
}

