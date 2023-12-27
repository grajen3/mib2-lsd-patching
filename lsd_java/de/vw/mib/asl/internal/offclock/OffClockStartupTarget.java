/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.offclock;

import de.vw.mib.asl.internal.offclock.OffClockPersistenceTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;

public class OffClockStartupTarget
implements Target {
    private final String taskId;
    private final GenericEvents genericEvents;

    public OffClockStartupTarget(GenericEvents genericEvents, String string) {
        this.genericEvents = genericEvents;
        this.taskId = string;
        genericEvents.getEventDispatcher().registerTarget(this.getTargetId(), this, string);
    }

    @Override
    public GenericEvents getMainObject() {
        return this.genericEvents;
    }

    @Override
    public int getTargetId() {
        return -1028711424;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() == 106) {
            this.processPowerOn();
        }
    }

    private void processPowerOn() {
        try {
            new OffClockPersistenceTarget(this.genericEvents, this.taskId);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void setTargetId(int n) {
    }
}

