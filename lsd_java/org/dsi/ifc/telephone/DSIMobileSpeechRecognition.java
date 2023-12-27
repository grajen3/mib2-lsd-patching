/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

import org.dsi.ifc.base.DSIBase;

public interface DSIMobileSpeechRecognition
extends DSIBase {
    public static final String VERSION;
    public static final int RT_REQUESTSTARTSPEECHRECOGNITION;
    public static final int RT_REQUESTSTOPSPEECHRECOGNITION;
    public static final int ATTR_SPEECHRECOGNITIONAVAILABLE;
    public static final int ATTR_SPEECHRECOGNITIONACTIVE;
    public static final int ATTR_SPEECHRECOGNITIONTYPE;
    public static final int RP_RESPONSESTARTSPEECHRECOGNITION;
    public static final int RP_RESPONSESTOPSPEECHRECOGNITION;
    public static final int RESULT_OK;
    public static final int RESULT_ABORTED;
    public static final int RESULT_ERROR_UNSPECIFIED;
    public static final int RESULT_ERROR_SPEECHRECOGNITION_NOT_STARTED;
    public static final int RESULT_ERROR_SPEECH_RECOGNITION_NOT_AVAILABLE;
    public static final int RESULT_ERROR_SPEECH_RECOGNITION_ALREADY_ACTIVE;
    public static final int MOBILESPEECHRECOGNITIONSTATUS_NOT_ACTIVE;
    public static final int MOBILESPEECHRECOGNITIONSTATUS_ACTIVE;
    public static final int MOBILESPEECHRECOGNITIONAVAILABILITY_NOT_AVAILABLE;
    public static final int MOBILESPEECHRECOGNITIONAVAILABILITY_AVAILABLE;
    public static final int MOBILESPEECHRECOGNITIONAVAILABILITY_UNKNOWN;
    public static final int MOBILESPEECHRECOGNITIONTYPE_UNKNOWN;
    public static final int MOBILESPEECHRECOGNITIONTYPE_GENERIC;
    public static final int MOBILESPEECHRECOGNITIONTYPE_SIRI;
    public static final int MOBILESPEECHRECOGNITIONTYPE_GOOGLE_NOW;

    default public void requestStartSpeechRecognition() {
    }

    default public void requestStopSpeechRecognition() {
    }
}

