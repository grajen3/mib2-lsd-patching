/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.lsctng.internal.ClassLoaderCache;
import java.util.ArrayList;

public class ClassLoaderCacheStrongRef
extends ClassLoaderCache {
    @Override
    protected void storeClassloader(int n, ClassLoader classLoader, ArrayList arrayList) {
        arrayList.set(n, classLoader);
    }

    @Override
    protected ClassLoader getClassloader(int n, ArrayList arrayList) {
        return (ClassLoader)arrayList.get(n);
    }
}

