/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.statusbar;

import de.vw.mib.asl.api.online.services.statusbar.OnlineStatusService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.statusbar.TargetASLStatusbar;

class TargetASLStatusbar$6
implements ASLComponentAPICallback {
    private final /* synthetic */ TargetASLStatusbar this$0;

    TargetASLStatusbar$6(TargetASLStatusbar targetASLStatusbar) {
        this.this$0 = targetASLStatusbar;
    }

    @Override
    public void registered(Class clazz, Object object) {
        ((OnlineStatusService)object).registerOnlineStatusListener(this.this$0.onlineStatusListener);
    }
}

