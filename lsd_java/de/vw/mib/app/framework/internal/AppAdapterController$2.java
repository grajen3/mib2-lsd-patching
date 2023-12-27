/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.AppAdapterController;

class AppAdapterController$2
implements Runnable {
    private final /* synthetic */ AppAdapterController this$0;

    AppAdapterController$2(AppAdapterController appAdapterController) {
        this.this$0 = appAdapterController;
    }

    @Override
    public void run() {
        this.this$0.appAdapter.start();
    }
}

