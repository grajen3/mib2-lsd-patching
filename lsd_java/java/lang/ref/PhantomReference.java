/*
 * Decompiled with CFR 0.152.
 */
package java.lang.ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomReference
extends Reference {
    @Override
    public Object get() {
        return null;
    }

    public PhantomReference(Object object, ReferenceQueue referenceQueue) {
        this.initReference(object, referenceQueue);
    }
}

