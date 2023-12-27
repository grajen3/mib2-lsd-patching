/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.appstate;

import de.vw.mib.asl.internal.speechengine.dialogsystem.appstate.ApplicationStateTracker;

class ApplicationStateTracker$1
implements Runnable {
    private final /* synthetic */ ApplicationStateTracker this$0;

    ApplicationStateTracker$1(ApplicationStateTracker applicationStateTracker) {
        this.this$0 = applicationStateTracker;
    }

    @Override
    public void run() {
        this.this$0.onRtMethodValueChangedInASLThread();
    }
}

