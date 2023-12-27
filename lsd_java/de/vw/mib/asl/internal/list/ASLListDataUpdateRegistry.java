/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list;

import de.vw.mib.asl.internal.list.ASLListDataUpdateListener;

public interface ASLListDataUpdateRegistry {
    default public void addASLListDataUpdateListener(ASLListDataUpdateListener aSLListDataUpdateListener) {
    }

    default public void removeASLListDataUpdateListener(ASLListDataUpdateListener aSLListDataUpdateListener) {
    }
}

