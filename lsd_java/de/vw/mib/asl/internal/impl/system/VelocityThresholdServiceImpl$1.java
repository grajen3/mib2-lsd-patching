/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system;

import de.vw.mib.asl.api.system.VelocityThresholdListener;
import de.vw.mib.asl.internal.impl.system.VelocityThresholdServiceImpl;
import de.vw.mib.asl.internal.system.util.AsyncServiceListeners$Notificator;

class VelocityThresholdServiceImpl$1
implements AsyncServiceListeners$Notificator {
    private final /* synthetic */ boolean val$isExceeded;
    private final /* synthetic */ VelocityThresholdServiceImpl this$0;

    VelocityThresholdServiceImpl$1(VelocityThresholdServiceImpl velocityThresholdServiceImpl, boolean bl) {
        this.this$0 = velocityThresholdServiceImpl;
        this.val$isExceeded = bl;
    }

    @Override
    public void notifyListener(Object object) {
        ((VelocityThresholdListener)object).onVelocityExceedanceChanged(this.val$isExceeded);
    }
}

