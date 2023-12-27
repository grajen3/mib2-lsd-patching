/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.event.Event;

public interface HMIEvent
extends Event {
    public static final int TYPE_HARDKEY;
    public static final int TYPE_HMI;
    public static final int TYPE_POINT;
    public static final int TYPE_PROXIMITY;
    public static final int TYPE_ROTATION;
    public static final int TYPE_VALUE;
    public static final int INVALID_ID;

    default public int getId() {
    }

    default public int getType() {
    }

    default public boolean isConsumed() {
    }

    default public void setConsumed(boolean bl) {
    }

    default public void setId(int n) {
    }

    default public AppDefinition getSender() {
    }

    default public AppDefinition getReceiver() {
    }
}

