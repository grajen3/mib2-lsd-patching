/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid.clock;

public interface Clock {
    public static final String DEFAULT_CLOCK_IMPL;
    public static final long GREGORIAN_CHANGE_OFFSET;
    public static final long INTERVALS_PER_MILLI;

    default public long getUUIDTime() {
    }
}

