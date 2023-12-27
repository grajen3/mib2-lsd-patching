/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServiceManager;
import de.vw.mib.asl.framework.internal.startupv7r.operation.StartupLauncher;

class StartupLauncher$1
implements Runnable {
    private final /* synthetic */ StartupLauncher this$0;

    StartupLauncher$1(StartupLauncher startupLauncher) {
        this.this$0 = startupLauncher;
    }

    @Override
    public void run() {
        ServiceManager.eventMain.getTimerServer().stopTimedEvent(5900, -729349888);
        ServiceManager.aslPropertyManager.valueChangedBoolean(3671, true);
        ServiceManager.aslPropertyManager.valueChangedBoolean(3672, true);
        ServiceManager.eventMain.getServiceRegister().triggerObserver(1098324736);
        StartupServiceManager.startupDone = true;
    }
}

