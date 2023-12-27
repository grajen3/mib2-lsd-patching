/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.specialmethods;

import de.vw.mib.asl.framework.internal.startupv7r.AbstractTimedStartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServiceManager;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;

public class SpecialMethodWaitForNavToFinish
extends AbstractTimedStartupTask {
    private static final int TIMEOUT;
    private static SpecialMethodWaitForNavToFinish waitingInstance;

    public SpecialMethodWaitForNavToFinish(StartupServices startupServices) {
        super(startupServices.getLogger(), startupServices.getTimerManager(), startupServices.getAslThreadSwitchingTarget());
    }

    @Override
    public void runTask() {
        if (!StartupServiceManager.swdlPowerstateDetected) {
            if (StartupServiceManager.aslNavStartupWasDoneAlready) {
                this.finish();
            } else {
                waitingInstance = this;
            }
        } else {
            this.finish();
        }
    }

    public static void onNavStartupDone() {
        if (waitingInstance != null) {
            waitingInstance.finish();
            waitingInstance = null;
        } else {
            StartupServiceManager.aslNavStartupWasDoneAlready = true;
        }
    }

    @Override
    protected long getTimeout() {
        return 0;
    }
}

