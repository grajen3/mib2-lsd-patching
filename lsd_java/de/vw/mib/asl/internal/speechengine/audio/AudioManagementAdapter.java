/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio;

import de.vw.mib.asl.internal.speechengine.audio.AudioManagementAdapterListener;

public interface AudioManagementAdapter {
    public static final int EV_SPEECH_REQUEST_AC_RETURN;
    public static final int EV_SPEECH_RELEASE_AC_RETURN;
    public static final int RESULT_UNKNOWN;
    public static final int RESULT_OK;
    public static final int RESULT_NOK;
    public static final int RESULT_CANCEL;

    default public void requestConnection(int n) {
    }

    default public void releaseConnection(int n) {
    }

    default public void setAdapterListener(AudioManagementAdapterListener audioManagementAdapterListener) {
    }
}

