/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

public interface GlobalProfileChangeListener {
    public static final int LISTENER_TYPE__COMMON;
    public static final int LISTENER_TYPE__AUDIO;

    default public void onProfileChangeStarted() {
    }

    default public void onProfileChangeCompleted() {
    }
}

