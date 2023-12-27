/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.prioritizer;

import de.vw.mib.asl.framework.internal.startupv7r.PersistableEarlyData;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.api.impl.InternalStartupStateAdapter;
import de.vw.mib.asl.framework.internal.startupv7r.api.impl.StartupStateServiceImpl;
import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.model.LastUserModeMapping;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitQueue;
import de.vw.mib.asl.framework.internal.startupv7r.prioritizer.LastUserModePrioritizer$1;
import de.vw.mib.asl.framework.internal.startupv7r.prioritizer.StartupPrioritizer;

public class LastUserModePrioritizer
implements StartupPrioritizer {
    private final WorkUnitQueue workUnitQueue;
    private final StartupStateServiceImpl startupStateService;
    private final PersistableEarlyData persistableEarlyData;
    private final StartupServices startupServices;
    private final LastUserModeMapping lastUserModeMapping;

    public LastUserModePrioritizer(StartupServices startupServices, WorkUnitQueue workUnitQueue, LastUserModeMapping lastUserModeMapping) {
        this.workUnitQueue = workUnitQueue;
        this.lastUserModeMapping = lastUserModeMapping;
        this.startupServices = startupServices;
        this.startupStateService = startupServices.getStartupStateService();
        this.persistableEarlyData = startupServices.getPersistableEarlyData();
    }

    @Override
    public void run() {
        this.startupStateService.addListener(this.createStartupStateListener());
    }

    void prioritizeLastUserMode() {
        this.prioritizeContent(this.retrieveLastAudioMode());
        this.prioritizeContent(this.retrieveLastUserMode());
    }

    private String retrieveLastUserMode() {
        return this.startupServices.getSystemStateService().getLastContentId();
    }

    private String retrieveLastAudioMode() {
        if (this.persistableEarlyData.isLastConnRadio()) {
            return "HMI_RADIO";
        }
        return "HMI_MEDIA";
    }

    private void prioritizeContent(String string) {
        AbstractWorkUnit abstractWorkUnit = this.lastUserModeMapping.retrieveWorkUnit(string);
        if (abstractWorkUnit != null) {
            this.workUnitQueue.prioritize(abstractWorkUnit);
        }
    }

    private InternalStartupStateAdapter createStartupStateListener() {
        return new LastUserModePrioritizer$1(this);
    }
}

