/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.androidauto;

import de.vw.mib.bap.mqbab2.common.api.androidauto.AndroidAutoService;
import de.vw.mib.bap.mqbab2.common.api.androidauto.AndroidAutoServiceListener;

public class AndroidAutoDummyService
implements AndroidAutoService {
    @Override
    public void addAndroidAutoServiceListener(AndroidAutoServiceListener androidAutoServiceListener, int[] nArray) {
    }

    @Override
    public void removeAndroidAutoServiceListener(AndroidAutoServiceListener androidAutoServiceListener, int[] nArray) {
    }

    @Override
    public boolean isAndroidAutoRouteGuidanceActive() {
        return false;
    }
}

