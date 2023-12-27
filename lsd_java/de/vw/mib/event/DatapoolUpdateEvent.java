/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event;

import de.vw.mib.event.Event;

public interface DatapoolUpdateEvent
extends Event {
    public static final int TYPE_BOOLEAN;
    public static final int TYPE_FLOAT;
    public static final int TYPE_INTEGER;
    public static final int TYPE_LONG;
    public static final int TYPE_OBJECT;

    default public boolean getBooleanValue() {
    }

    default public float getFloatValue() {
    }

    default public int getPropertyId() {
    }

    default public int getIntegerValue() {
    }

    default public long getLongValue() {
    }

    default public Object getObjectValue() {
    }

    default public int getType() {
    }
}

