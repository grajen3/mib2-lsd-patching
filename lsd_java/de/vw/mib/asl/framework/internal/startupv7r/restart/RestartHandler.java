/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.restart;

import de.vw.mib.asl.framework.internal.startupv7r.restart.RestartWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.ContextInformationWorkUnit;
import java.util.ArrayList;

public class RestartHandler {
    public static RestartWorkUnit RESTART_NAV_WITH_SPLITSCREEN = new RestartWorkUnit("RESTART_NAV_WITH_SPLITSCREEN");
    public static RestartWorkUnit RESTART_NAV_WITH_KOMONAV = new RestartWorkUnit("RESTART_NAV_WITH_KOMONAV");
    public static RestartWorkUnit RESTART_GEMMI = new RestartWorkUnit("RESTART_GEMMI");
    public static RestartWorkUnit RESTART_EXLAP = new RestartWorkUnit("RESTART_EXLAP");
    public static RestartWorkUnit RESTART_SPEECH = new RestartWorkUnit("RESTART_SPEECH");
    private ArrayList modulesQueuedForRestart = new ArrayList(1);

    public void restart(RestartWorkUnit restartWorkUnit) {
        if (restartWorkUnit == null) {
            throw new IllegalArgumentException("Given restart work unit must not be null.");
        }
        ContextInformationWorkUnit contextInformationWorkUnit = restartWorkUnit.getStartupWorkUnit();
        contextInformationWorkUnit.resetThisWorkUnitForReuseDuringRun();
        contextInformationWorkUnit.doNextWorkStep();
    }

    public void performRestartAfterStartup() {
        if (this.modulesQueuedForRestart.size() != 0) {
            for (int i2 = 0; i2 < this.modulesQueuedForRestart.size(); ++i2) {
                RestartWorkUnit restartWorkUnit = (RestartWorkUnit)this.modulesQueuedForRestart.get(i2);
                this.restart(restartWorkUnit);
            }
            this.modulesQueuedForRestart = null;
        }
    }

    public void queueForRestart(RestartWorkUnit restartWorkUnit) {
        this.modulesQueuedForRestart.add(restartWorkUnit);
    }
}

