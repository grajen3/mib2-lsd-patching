/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.specialmethods;

import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI;
import de.vw.mib.asl.framework.internal.startupv7r.AbstractStartupTarget;
import de.vw.mib.asl.framework.internal.startupv7r.AbstractTimedStartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServiceManager;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.specialmethods.SpecialMethodWaitForCodingWasRead$1;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;

public class SpecialMethodWaitForCodingWasRead
extends AbstractTimedStartupTask {
    private static final int EVENT_CODING_READ;
    private static final int TIMEOUT;
    private final GenericEvents genericEvents;
    private final Logger logger;
    private final ASLDiagnosisAPI diagnosisApi;
    private AbstractStartupTarget target;

    public SpecialMethodWaitForCodingWasRead(StartupServices startupServices) {
        super(startupServices.getLogger(), startupServices.getTimerManager(), startupServices.getAslThreadSwitchingTarget());
        this.genericEvents = startupServices.getGenericEvents();
        this.logger = startupServices.getLogger();
        this.diagnosisApi = startupServices.getDiagnosisAPI();
    }

    @Override
    public void runTask() {
        this.target = this.createTarget();
        if (!StartupServiceManager.swdlPowerstateDetected) {
            this.info("[ASLStartup v8]Waiting for initial coding .. max 30 seconds");
            try {
                this.diagnosisApi.getAdaptionApi().requestConfigManagerPersCoding(this.target.getTargetId(), -1585053440);
            }
            catch (GenericEventException genericEventException) {
                this.error("Error while requesting coding");
            }
        } else {
            this.finish();
        }
    }

    @Override
    protected long getTimeout() {
        return 0;
    }

    @Override
    protected void cleanUp() {
        super.cleanUp();
        try {
            this.genericEvents.getEventDispatcher().unregisterTarget(this.target.getTargetId());
        }
        catch (Exception exception) {
            this.error("Could not unregister target");
        }
    }

    private AbstractStartupTarget createTarget() {
        return new SpecialMethodWaitForCodingWasRead$1(this, this.genericEvents, this.logger);
    }

    static /* synthetic */ void access$000(SpecialMethodWaitForCodingWasRead specialMethodWaitForCodingWasRead, String string) {
        specialMethodWaitForCodingWasRead.info(string);
    }

    static /* synthetic */ void access$100(SpecialMethodWaitForCodingWasRead specialMethodWaitForCodingWasRead) {
        specialMethodWaitForCodingWasRead.finish();
    }
}

