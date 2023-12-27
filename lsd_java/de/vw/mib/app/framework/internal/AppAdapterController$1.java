/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.AppAdapterController;

class AppAdapterController$1
implements Runnable {
    private final /* synthetic */ AppAdapterController this$0;

    AppAdapterController$1(AppAdapterController appAdapterController) {
        this.this$0 = appAdapterController;
    }

    @Override
    public void run() {
        this.this$0.appAdapter.ready();
    }
}

