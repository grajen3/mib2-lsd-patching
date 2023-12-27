/*
 * Decompiled with CFR 0.152.
 */
package java.lang.ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class WeakReference
extends Reference {
    public WeakReference(Object object, ReferenceQueue referenceQueue) {
        this.initReference(object, referenceQueue);
    }

    public WeakReference(Object object) {
        this.initReference(object);
    }
}

