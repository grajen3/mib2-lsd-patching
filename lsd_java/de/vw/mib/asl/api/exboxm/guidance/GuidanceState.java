/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.exboxm.guidance;

public final class GuidanceState {
    static final int VALUE_INACTIVE;
    static final int VALUE_ACTIVE;
    public static final GuidanceState INACTIVE;
    public static final GuidanceState ACTIVE;
    private final int value;
    private final String name;

    private GuidanceState(int n, String string) {
        this.value = n;
        this.name = string;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return this.name;
    }

    static {
        INACTIVE = new GuidanceState(0, "INACTIVE");
        ACTIVE = new GuidanceState(1, "ACTIVE");
    }
}

