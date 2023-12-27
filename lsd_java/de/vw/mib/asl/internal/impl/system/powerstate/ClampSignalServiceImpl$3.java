/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.powerstate;

import de.vw.mib.asl.api.system.powerstate.ClampSignalListener;
import de.vw.mib.asl.internal.impl.system.powerstate.ClampSignalServiceImpl;

class ClampSignalServiceImpl$3
implements Runnable {
    private final /* synthetic */ ClampSignalListener val$clampSignalListener;
    private final /* synthetic */ boolean val$isClampSActive;
    private final /* synthetic */ ClampSignalServiceImpl this$0;

    ClampSignalServiceImpl$3(ClampSignalServiceImpl clampSignalServiceImpl, ClampSignalListener clampSignalListener, boolean bl) {
        this.this$0 = clampSignalServiceImpl;
        this.val$clampSignalListener = clampSignalListener;
        this.val$isClampSActive = bl;
    }

    @Override
    public void run() {
        this.val$clampSignalListener.onClampSValueChanged(this.val$isClampSActive);
    }
}

