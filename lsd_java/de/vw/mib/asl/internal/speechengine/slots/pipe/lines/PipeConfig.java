/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.lines;

public class PipeConfig {
    public static final long ALLOWED_GAP_IN_MILLISECONDS;
    public static final int FULL_UPDATE_FREQUENCY;
    private final long allowedGapInMilliseconds;
    private final long fullUpdateFrequency;
    private final String name;

    public PipeConfig(long l, long l2, String string) {
        this.fullUpdateFrequency = l2;
        this.allowedGapInMilliseconds = l;
        this.name = string;
    }

    public long getAllowedGapInMilliseconds() {
        return this.allowedGapInMilliseconds;
    }

    public long getFullUpdateFrequency() {
        return this.fullUpdateFrequency;
    }

    public String getName() {
        return this.name;
    }
}

