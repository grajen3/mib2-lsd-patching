/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Vector;

final class Vector$1
implements Enumeration {
    int pos = 0;
    final /* synthetic */ Vector this$0;

    Vector$1(Vector vector) {
        this.this$0 = vector;
    }

    @Override
    public boolean hasMoreElements() {
        return this.pos < this.this$0.elementCount;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object nextElement() {
        Vector vector = this.this$0;
        synchronized (vector) {
            if (this.pos < this.this$0.elementCount) {
                return this.this$0.elementData[this.pos++];
            }
        }
        throw new NoSuchElementException();
    }
}

