/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.lsctng.internal.SkinClassLoaderInternal;

public interface CachableSkinClassLoaderInternal
extends SkinClassLoaderInternal {
    default public ClassLoader getCurrentClassLoader() {
    }

    default public boolean initializeClassLoaderForSkinId(int n, ClassLoader classLoader) {
    }
}

