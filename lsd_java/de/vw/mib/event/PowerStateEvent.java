/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface PowerStateEvent
extends Event {
    public static final int SYSTEM_HMI_OFF;
    public static final int SYSTEM_HMI_ON;
    public static final int SYSTEM_HMI_OFF_CLOCK;
    public static final int SYSTEM_HMI_ON_DIAG;
    public static final int SYSTEM_HMI_ON_SWDL;
    public static final int SYSTEM_HMI_ON_RESTRICTED;
    public static final int SYSTEM_HMI_ON_ERROR;

    default public int getState() {
    }
}

