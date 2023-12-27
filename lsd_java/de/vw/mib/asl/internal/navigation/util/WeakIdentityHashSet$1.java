/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import java.util.Iterator;

class WeakIdentityHashSet$1
implements Iterator {
    int index = 0;
    private final /* synthetic */ Object[] val$data;
    private final /* synthetic */ WeakIdentityHashSet this$0;

    WeakIdentityHashSet$1(WeakIdentityHashSet weakIdentityHashSet, Object[] objectArray) {
        this.this$0 = weakIdentityHashSet;
        this.val$data = objectArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean hasNext() {
        WeakIdentityHashSet weakIdentityHashSet = this.this$0;
        synchronized (weakIdentityHashSet) {
            return this.index < this.val$data.length;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object next() {
        WeakIdentityHashSet weakIdentityHashSet = this.this$0;
        synchronized (weakIdentityHashSet) {
            return this.val$data[this.index++];
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void remove() {
        WeakIdentityHashSet weakIdentityHashSet = this.this$0;
        synchronized (weakIdentityHashSet) {
            this.this$0.remove(this.val$data[this.index - 1]);
        }
    }
}

