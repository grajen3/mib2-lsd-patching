/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio.amFm;

public interface FmFrequencyScale {
    public static final int FM_FREQUENCYSCALE_UNDEFINED;
    public static final int FM_FREQUENCYSCALE_EU_RDW;
    public static final int FM_FREQUENCYSCALE_NAR;
    public static final int FM_FREQUENCYSCALE_JP;
    public static final int FM_FREQUENCYSCALE_KOR;
    public static final int FM_FREQUENCYSCALE_CHN;
    public static final int FM_FREQUENCYSCALE_JP_EXTENDED;

    default public int getFmFrequencyScale() {
    }
}

