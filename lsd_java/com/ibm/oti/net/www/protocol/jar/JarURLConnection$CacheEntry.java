/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.jar;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class JarURLConnection$CacheEntry
extends WeakReference {
    Object key;

    JarURLConnection$CacheEntry(Object object, String string, ReferenceQueue referenceQueue) {
        super(object, referenceQueue);
        this.key = string;
    }
}

