/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.entertainmentmanager;

import de.vw.mib.log4mib.Loggable;

public interface EntertainmentActivation
extends Loggable {
    public static final int CONTEXT_C0_TUNER;
    public static final int CONTEXT_C1_MEDIA;
    public static final int CONTEXT_C2_VIDEO;
    public static final int CONTEXT_C3_EXBOX;
    public static final int CONTEXT_C4_TV_TUNER;
    public static final int CONTEXT_C5_MIRRORLINK;
    public static final int CONTEXT_CX_RESERVED;
    public static final int CONTEXT_MAX_CONTEXT;

    default public int getContext() {
    }

    default public boolean isContextSwitch() {
    }

    default public int getSubcontext() {
    }

    default public int getCause() {
    }

    default public boolean isCanceled() {
    }
}

