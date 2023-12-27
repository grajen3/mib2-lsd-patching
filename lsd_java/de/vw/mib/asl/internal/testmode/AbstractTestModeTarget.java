/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractTestModeTarget
implements Target {
    private static final String TASK_ID;
    private final Logger logger;
    private final GenericEvents genericEvents;
    private final int targetId;

    public AbstractTestModeTarget(GenericEvents genericEvents, Logger logger, int n) {
        this.genericEvents = genericEvents;
        this.logger = logger;
        this.targetId = n;
        this.registerTarget();
    }

    @Override
    public final void setTargetId(int n) {
    }

    @Override
    public final int getTargetId() {
        return this.targetId;
    }

    @Override
    public final GenericEvents getMainObject() {
        return this.genericEvents;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    private void registerTarget() {
        try {
            this.genericEvents.getEventDispatcher().registerTarget(this.getTargetId(), this, "hsmtask");
        }
        catch (Exception exception) {
            this.logger.error(64).append("Could not regsiter target ").append(super.getClass().getName()).attachThrowable(exception).log();
        }
    }
}

