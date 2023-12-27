/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.statusbar;

import de.vw.mib.asl.api.online.services.statusbar.OnlineStatusListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.statusbar.TargetASLStatusbar;

class TargetASLStatusbar$4
implements OnlineStatusListener {
    private final /* synthetic */ TargetASLStatusbar this$0;

    TargetASLStatusbar$4(TargetASLStatusbar targetASLStatusbar) {
        this.this$0 = targetASLStatusbar;
    }

    @Override
    public void updateOnlineStatus(int n) {
        AbstractASLTarget.writeIntegerToDatapool(-50836224, n);
    }
}

