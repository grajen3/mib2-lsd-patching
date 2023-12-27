/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation.lum;

import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateListener;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.api.impl.StartupStateServiceImpl;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitStarter;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitStarterListener;
import de.vw.mib.asl.framework.internal.startupv7r.operation.lum.AbstractLumReadyOperation$1;
import de.vw.mib.asl.framework.internal.startupv7r.operation.lum.AbstractLumReadyOperation$2;
import de.vw.mib.event.dispatcher.StartupEventDispatcher;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractLumReadyOperation {
    private final String LOG_PREFIX;
    private final StartupEventDispatcher startupEventDispatcher;
    private final Logger logger;
    private StartupStateServiceImpl startupStateService;
    private boolean lumReadySent;

    public AbstractLumReadyOperation(StartupServices startupServices, WorkUnitStarter workUnitStarter) {
        this.LOG_PREFIX = "[AbstractLumReadyOperation] ";
        this.startupEventDispatcher = startupServices.getStartupEventDispatcher();
        this.logger = startupServices.getLogger();
        this.startupStateService = startupServices.getStartupStateService();
        this.startupStateService.addListener(this.createStartupStateListener());
        workUnitStarter.addListener(this.createWorkUnitStarterListener());
    }

    protected void sendLumReady() {
        if (!this.lumReadySent) {
            this.startupEventDispatcher.createAndSubmitStartupEvent(3);
            this.startupStateService.notifyLastUserModeReady();
            this.logger.info(1, "[AbstractLumReadyOperation] Sending LUM ready event.");
            this.lumReadySent = true;
        }
    }

    void logError(String string) {
        this.logger.error(1, string);
    }

    boolean wasLumReadySent() {
        return this.lumReadySent;
    }

    private StartupStateListener createStartupStateListener() {
        return new AbstractLumReadyOperation$1(this);
    }

    private WorkUnitStarterListener createWorkUnitStarterListener() {
        return new AbstractLumReadyOperation$2(this);
    }
}

