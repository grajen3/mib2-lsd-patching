/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.bap.transformer;

public interface RadioItem {
    public static final byte RADIOTYPE_UNKNOWN;
    public static final byte RADIOTYPE_ENSEMBLE;
    public static final byte RADIOTYPE_SERVICE;
    public static final byte RADIOTYPE_COMPONENT;
    public static final byte RADIOTYPE_AM_STATION;
    public static final byte RADIOTYPE_FM_STATION;
    public static final byte RADIOTYPE_SDARS_STATION;
    public static final byte RADIOTYPE_FREQUENCY;

    default public byte type() {
    }
}

