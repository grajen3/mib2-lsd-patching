/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.androidauto;

import de.vw.mib.bap.mqbab2.common.api.androidauto.AndroidAutoServiceListener;

public interface AndroidAutoService {
    default public void addAndroidAutoServiceListener(AndroidAutoServiceListener androidAutoServiceListener, int[] nArray) {
    }

    default public void removeAndroidAutoServiceListener(AndroidAutoServiceListener androidAutoServiceListener, int[] nArray) {
    }

    default public boolean isAndroidAutoRouteGuidanceActive() {
    }
}

