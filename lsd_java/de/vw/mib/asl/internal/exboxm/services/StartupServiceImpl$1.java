/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.services;

import de.vw.mib.asl.internal.exboxm.services.StartupListener;
import de.vw.mib.asl.internal.exboxm.services.StartupServiceImpl;

class StartupServiceImpl$1
implements Runnable {
    private final /* synthetic */ StartupListener val$listener;
    private final /* synthetic */ StartupServiceImpl this$0;

    StartupServiceImpl$1(StartupServiceImpl startupServiceImpl, StartupListener startupListener) {
        this.this$0 = startupServiceImpl;
        this.val$listener = startupListener;
    }

    @Override
    public void run() {
        this.val$listener.notifyPowerOnEvent();
    }
}

