/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.lsc;

import de.vw.mib.asl.framework.internal.impl.lsc.LscLogger;
import de.vw.mib.asl.framework.internal.impl.lsc.Preconditions;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;

public abstract class AbstractLscTarget
implements Target {
    private static final String TASK_ID;
    private static final boolean DONT_SEND_TARGET_REGISTERED_NOTIFICATION;
    private final int targetId;
    private final GenericEvents genericEvents;
    private final LscLogger logger;

    public AbstractLscTarget(int n, GenericEvents genericEvents, LscLogger lscLogger) {
        Preconditions.checkArgumentNotNull(genericEvents, "Argument >genericEvents< must not be null!");
        Preconditions.checkArgumentNotNull(lscLogger, "Argument >logger< must not be null!");
        this.targetId = n;
        this.genericEvents = genericEvents;
        this.logger = lscLogger;
        this.registerTarget();
    }

    @Override
    public abstract void gotEvent(EventGeneric eventGeneric) {
    }

    @Override
    public final void setTargetId(int n) {
    }

    @Override
    public final GenericEvents getMainObject() {
        return this.genericEvents;
    }

    @Override
    public final int getTargetId() {
        return this.targetId;
    }

    protected final LscLogger log() {
        return this.logger;
    }

    private void registerTarget() {
        EventDispatcherHSM eventDispatcherHSM = this.getMainObject().getEventDispatcher();
        try {
            eventDispatcherHSM.registerTarget(this.getTargetId(), this, "hsmtask", false);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}

