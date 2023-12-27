/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface PopupViewEvent
extends Event {
    public static final int OPEN;
    public static final int CLOSED;
    public static final int SUSPEND;
    public static final int RESUME;

    default public int getCommand() {
    }

    default public int getDynamicStateId() {
    }

    default public int getPopupInfoId() {
    }

    default public String getPopupViewId() {
    }
}

