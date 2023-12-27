/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.skin;

import de.vw.mib.viewmanager.internal.ViewHandler;

public interface SkinClassLoader {
    default public ViewHandler getViewHandler(String string) {
    }

    default public ViewHandler getViewHandler(String string, String string2) {
    }

    default public int getSkin() {
    }

    default public boolean unloadDataForClass(String string) {
    }
}

