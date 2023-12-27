/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds;

import de.esolutions.fw.comm.asi.speech.onlinesds.AudioData;
import de.esolutions.fw.comm.asi.speech.onlinesds.LanguageInfo;

public interface OnlineSDSReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void setLanguage(LanguageInfo languageInfo) {
    }

    default public void speechDataUpdate(int n, int n2, AudioData audioData) {
    }

    default public void cancel(int n) {
    }
}

