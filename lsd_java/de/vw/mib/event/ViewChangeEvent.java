/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface ViewChangeEvent
extends Event {
    public static final int DRIVER_DISTRACTION_GROUP_ID_NONE;
    public static final int SEQUENCE_NUMBER_NON;
    public static final int LEAVE;
    public static final int ENTER;
    public static final int REENTER;
    public static final int TIMEOUT;

    default public int getCommand() {
    }

    default public int getDriverDistractionPreventionGroupId() {
    }

    default public String getFollowingView() {
    }

    default public int getSequenceNumber() {
    }

    default public boolean shouldResetView() {
    }
}

