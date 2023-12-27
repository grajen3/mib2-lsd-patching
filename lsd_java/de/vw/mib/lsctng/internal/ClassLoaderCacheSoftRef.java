/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.lsctng.internal.ClassLoaderCache;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class ClassLoaderCacheSoftRef
extends ClassLoaderCache {
    @Override
    protected void storeClassloader(int n, ClassLoader classLoader, ArrayList arrayList) {
        arrayList.set(n, new SoftReference(classLoader));
    }

    @Override
    protected ClassLoader getClassloader(int n, ArrayList arrayList) {
        SoftReference softReference = (SoftReference)arrayList.get(n);
        if (null == softReference) {
            return null;
        }
        return (ClassLoader)softReference.get();
    }
}

