/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.specialmethods;

import de.vw.mib.asl.framework.internal.startupv7r.AbstractStartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServiceManager;
import de.vw.mib.asl.framework.internal.startupv7r.api.impl.StartupStateServiceImpl;
import de.vw.mib.asl.framework.internal.startupv7r.specialmethods.SpecialMethodWaitForLateLoadFinished$1;
import de.vw.mib.log4mib.Logger;

public class SpecialMethodWaitForLateLoadFinished
extends AbstractStartupTask {
    private final StartupStateServiceImpl startupStateService;

    public SpecialMethodWaitForLateLoadFinished(Logger logger, StartupStateServiceImpl startupStateServiceImpl) {
        super(logger);
        this.startupStateService = startupStateServiceImpl;
    }

    @Override
    public void runTask() {
        if (!StartupServiceManager.swdlPowerstateDetected) {
            if (this.startupStateService.isBundleLateLoadDone()) {
                this.finish();
            } else {
                this.startupStateService.addListener(new SpecialMethodWaitForLateLoadFinished$1(this));
            }
        } else {
            this.finish();
        }
    }

    static /* synthetic */ void access$000(SpecialMethodWaitForLateLoadFinished specialMethodWaitForLateLoadFinished) {
        specialMethodWaitForLateLoadFinished.finish();
    }
}

