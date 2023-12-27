/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.skin.SkinClassLoader;
import de.vw.mib.skin.SkinDatapoolUpdater;
import java.io.File;

interface SkinClassLoaderInternal
extends SkinClassLoader {
    default public boolean initializeClassLoaderForSkinId(int n) {
    }

    default public SkinDatapoolUpdater getSkinDatapoolUpdater() {
    }

    default public File getLanguageFile(String string) {
    }
}

