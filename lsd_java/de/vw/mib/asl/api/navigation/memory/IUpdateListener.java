/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.memory;

import org.dsi.ifc.organizer.AdbViewSize;

public interface IUpdateListener {
    default public void invalidateContactData() {
    }

    default public void updateProfileDownloadState(int n, int n2, int n3) {
    }

    default public void updateViewSizes(AdbViewSize adbViewSize, boolean bl) {
    }
}

