/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;

public interface DSIOnlineDictation
extends DSIBase {
    public static final String VERSION;
    public static final int STATUS_OK_INIT;
    public static final int STATUS_OK_DICTATION_COMPLETE;
    public static final int STATUS_OK_DICTATION_CANCELED;
    public static final int STATUS_ERROR_CAR_HARDWARE;
    public static final int STATUS_ERROR_CAR_DSI;
    public static final int STATUS_ERROR_CAR_CONNECTIVITY_SETUP;
    public static final int STATUS_ERROR_CAR_CONNECTIVITY_ERROR;
    public static final int STATUS_ERROR_DICTATION_SSL_HANDSHAKE_FAILED;
    public static final int STATUS_ERROR_DICTATION_TIMEOUT;
    public static final int STATUS_ERROR_DICTATION_CONNECTION_CLOSED;
    public static final int STATUS_ERROR_DICTATION_CONNECTION_REJECTED;
    public static final int STATUS_ERROR_DICTATION_PARSE;
    public static final int STATUS_ERROR_DICTATION_HOST_UNRESOLVABLE;
    public static final int STATUS_ERROR_DICTATION_UNKNOWN_ERROR;
    public static final int STATUS_ERROR_DICTATION_INVALID_INPUT;
    public static final int STATUS_ERROR_DICTATION_URL_INVALID;
    public static final int STATUS_ERROR_DICTATION_PROVIDER_TIMEOUT;
    public static final int STATUS_ERROR_DICTATION_PROVIDER_CONNECTION_CLOSED;
    public static final int STATUS_ERROR_DICTATION_PROVIDER_CONNECTION_REJECTED;
    public static final int STATUS_ERROR_DICTATION_PROVIDER_PARSE;
    public static final int STATUS_ERROR_DICTATION_PROVIDER_HOST_UNRESOLVABLE;
    public static final int STATUS_ERROR_DICTATION_PROVIDER_UNKNOWN_ERROR;
    public static final int STATUS_ERROR_LANGUAGE_NOT_SUPPORTED;
    public static final int STATUS_ERROR_VOICE_RECOGNITION_FAILED;
    public static final int STATUS_ERROR_PROFANITY_DETECTED;
    public static final int STATUS_ERROR_DICTATION_DISABLED;
    public static final int STATUS_ERROR_DICTATION_UPLOAD_FAILED;
    public static final int STATUS_ERROR_DICTATION_CHECKSUM_FAILED;
    public static final int STATUS_ERROR_DICTATION_FORCED_UPLOAD;
    public static final int RT_STOPDICTATION;
    public static final int RT_SETFALLBACKLANGUAGE;
    public static final int RT_SETLANGUAGE;
    public static final int RT_ACTIVATEDICTATION;
    public static final int RT_STARTDICTATION;
    public static final int RT_FINISHDICTATION;
    public static final int RT_RAWVOICEDATAAVAILABLE;
    public static final int RP_DICTATIONRESULT;
    public static final int RP_FINISHDICTATIONRESPONSE;
    public static final int RP_DICTATIONVALUELIST;

    default public void stopDictation() {
    }

    default public void setFallbackLanguage(String string) {
    }

    default public void setLanguage(String string) {
    }

    default public void activateDictation() {
    }

    default public void startDictation(String string, String string2, String string3, String string4) {
    }

    default public void finishDictation() {
    }

    default public void rawVoiceDataAvailable(String string, int n) {
    }
}

