/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import de.vw.mib.genericevents.EventGeneric;

public interface TaskInterface {
    public static final String HSM_TASK_NAME;

    default public void start() {
    }

    default public void stop() {
    }

    default public String getId() {
    }

    default public int getQueueSize() {
    }

    default public void dispatch(EventGeneric eventGeneric) {
    }

    default public boolean isInCurrentMIBThread() {
    }

    default public boolean isQueueOverloaded() {
    }
}

