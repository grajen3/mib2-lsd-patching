/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.entryconditions;

import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.entryconditions.AbstractOneTimeApplyingEntryCondition;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.log4mib.Logger;

public class EntryConditionAllowLscInStd
extends AbstractOneTimeApplyingEntryCondition {
    private final Logger logger;
    private final ASLStartupv7rAPI aslStartupv7rAPI;
    private final EventDispatcherHSM eventDispatcher;
    private final EventFactory eventFactory;

    public EntryConditionAllowLscInStd(StartupServices startupServices) {
        this.logger = startupServices.getLogger();
        this.aslStartupv7rAPI = startupServices.getASLStartupv7rAPI();
        this.eventDispatcher = startupServices.getEventDispatcher();
        this.eventFactory = startupServices.getEventFactory();
    }

    @Override
    public int getBitmask() {
        return 4;
    }

    @Override
    protected void apply() {
        if (!this.aslStartupv7rAPI.isHighActivatorStarted()) {
            if (this.logger.isTraceEnabled(1)) {
                this.logger.trace(1, "Sending event to LSC as Audio in STD is ready now");
            }
            this.eventDispatcher.sendSafe(this.eventFactory.newEvent(0, 5150, 512164096));
        }
    }
}

