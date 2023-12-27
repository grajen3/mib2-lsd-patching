/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.entertainmentmanager;

public interface EntertainmentContext {
    public static final int C0_TUNER;
    public static final int C1_MEDIA;
    public static final int C3_EXBOX;
    public static final int C4_TV_TUNER;
    public static final int C5_MIRRORLINK;
    public static final int C5_APPCONNECT;
    public static final int C6_CARPLAY;
    public static final int C7_ANDROIDAUTO;
    public static final int C8_MIRRORLINK;
    public static final int C9_CARLIFE;
    public static final int CX_RESERVED;
    public static final int MAX_CONTEXT;

    default public int contextId() {
    }

    default public boolean preActivate(int n, boolean bl) {
    }

    default public int answer(int n) {
    }

    default public int skipSources(int n) {
    }

    default public int targetId() {
    }

    default public boolean isDeactivateOnSubcontextSwitch() {
    }

    default public void changeView() {
    }

    default public void setDatapoolValue(int n) {
    }
}

