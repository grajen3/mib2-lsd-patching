/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.internal.navigation.util.IdentityHashSet;
import java.util.Iterator;

class IdentityHashSet$1
implements Iterator {
    int index = 0;
    private final /* synthetic */ Object[] val$data;
    private final /* synthetic */ IdentityHashSet this$0;

    IdentityHashSet$1(IdentityHashSet identityHashSet, Object[] objectArray) {
        this.this$0 = identityHashSet;
        this.val$data = objectArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean hasNext() {
        IdentityHashSet identityHashSet = this.this$0;
        synchronized (identityHashSet) {
            return this.index < this.val$data.length;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object next() {
        IdentityHashSet identityHashSet = this.this$0;
        synchronized (identityHashSet) {
            return this.val$data[this.index++];
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void remove() {
        IdentityHashSet identityHashSet = this.this$0;
        synchronized (identityHashSet) {
            this.this$0.remove(this.val$data[this.index - 1]);
        }
    }
}

