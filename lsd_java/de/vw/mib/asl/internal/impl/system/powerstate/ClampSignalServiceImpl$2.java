/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.powerstate;

import de.vw.mib.asl.api.system.powerstate.ClampSignalListener;
import de.vw.mib.asl.internal.impl.system.powerstate.ClampSignalServiceImpl;

class ClampSignalServiceImpl$2
implements Runnable {
    private final /* synthetic */ ClampSignalListener val$clampSignalListener;
    private final /* synthetic */ boolean val$isClamp15Active;
    private final /* synthetic */ ClampSignalServiceImpl this$0;

    ClampSignalServiceImpl$2(ClampSignalServiceImpl clampSignalServiceImpl, ClampSignalListener clampSignalListener, boolean bl) {
        this.this$0 = clampSignalServiceImpl;
        this.val$clampSignalListener = clampSignalListener;
        this.val$isClamp15Active = bl;
    }

    @Override
    public void run() {
        this.val$clampSignalListener.onClamp15ValueChanged(this.val$isClamp15Active);
    }
}

