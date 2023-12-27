/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import de.vw.mib.genericevents.Target;
import de.vw.mib.threads.MIBInvoker;
import de.vw.mib.timer.Invoker;

public interface ThreadSwitchingTarget
extends Target,
MIBInvoker,
Invoker {
    public static final String OSGI_PROPERTY_GENERICEVENTS_TASK;

    default public void enqueue(Runnable runnable) {
    }

    default public boolean isThreadChangeNecessary() {
    }
}

