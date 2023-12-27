/*
 * Decompiled with CFR 0.152.
 */
package java.lang.ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class SoftReference
extends Reference {
    private volatile int age;

    public SoftReference(Object object, ReferenceQueue referenceQueue) {
        this.initReference(object, referenceQueue);
    }

    public SoftReference(Object object) {
        this.initReference(object);
    }

    @Override
    public Object get() {
        this.age = 0;
        return super.get();
    }
}

