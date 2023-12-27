/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.specialmethods;

import de.vw.mib.asl.framework.api.persistence2.startup.PersistenceStartupListener;
import de.vw.mib.asl.framework.api.persistence2.startup.PersistenceStartupService;
import de.vw.mib.asl.framework.internal.startupv7r.AbstractTimedStartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.specialmethods.SpecialMethodInitialStartupProfileReady$1;

public class SpecialMethodInitialStartupProfileReady
extends AbstractTimedStartupTask {
    private static final String LOG_PREFIX;
    private static final long TIMEOUT;
    private final PersistenceStartupService persistenceStartupService;

    public SpecialMethodInitialStartupProfileReady(StartupServices startupServices) {
        super(startupServices.getLogger(), startupServices.getTimerManager(), startupServices.getAslThreadSwitchingTarget());
        this.persistenceStartupService = startupServices.getPersistenceApi().getPersistenceStartupService();
    }

    @Override
    public void runTask() {
        if (this.persistenceStartupService.isInitialStartupProfileSet()) {
            this.info("[SpecialMethodInitialStartupProfileReady] Persistence initial profile already set. Continuing.");
            this.finish();
        } else {
            this.info("[SpecialMethodInitialStartupProfileReady] Persistence initial profile not set. Watching persistence startup for 5000ms.");
            this.persistenceStartupService.addListener(this.createPersistenceStartupListener());
        }
    }

    @Override
    protected long getTimeout() {
        return 0;
    }

    private PersistenceStartupListener createPersistenceStartupListener() {
        return new SpecialMethodInitialStartupProfileReady$1(this);
    }

    static /* synthetic */ void access$000(SpecialMethodInitialStartupProfileReady specialMethodInitialStartupProfileReady, String string) {
        specialMethodInitialStartupProfileReady.info(string);
    }

    static /* synthetic */ void access$100(SpecialMethodInitialStartupProfileReady specialMethodInitialStartupProfileReady) {
        specialMethodInitialStartupProfileReady.finish();
    }
}

