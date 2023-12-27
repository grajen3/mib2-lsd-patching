/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tts;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.tts.TTSPrompt;

public interface DSITTS
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_LANGUAGE;
    public static final int ATTR_AVAILABLELANGUAGES;
    public static final int ATTR_AUDIOREQUEST;
    public static final int ATTR_MARKERPASSED;
    public static final int AUDIOINFO_IDLE;
    public static final int AUDIOINFO_PROMPT_STARTED;
    public static final int AUDIOINFO_PROMPT_FINISHED;
    public static final int AUDIOINFO_PROMPT_ABORTED;
    public static final int AUDIOINFO_TONE_STARTED;
    public static final int AUDIOINFO_TONE_FINISHED;
    public static final int AUDIOINFO_PROCESSING;
    public static final int AUDIOINFO_PROMPT_FAILED;
    public static final int AUDIOINFO_PAUSED;
    public static final int RESULT_OK;
    public static final int RESULT_ABORTED;
    public static final int RESULT_PAUSED;
    public static final int RESULT_ERROR_GENERAL;
    public static final int RESULT_ERROR_TTSALREADYRUNNING;
    public static final int RESULT_ERROR_LANGUAGENOTSUPPORTED;
    public static final int RESULT_ERROR_UNKNOWNVOICE;
    public static final int RESULT_WARNING_INIT_ALREADY_DONE;
    public static final int RESULT_ERROR_NOT_INIT;
    public static final int RESULT_ERROR_VALUEOUTOFRANGE;
    public static final int RESULT_ERROR_NOT_POSSIBLE;
    public static final int RESULT_ERROR_REGISTRATION_MISSING;
    public static final int RESULT_ERROR_INTERNAL;
    public static final int RESULT_ERROR_ILLEGAL_SKIN_ID;
    public static final int RESULT_ERROR_ILLEGAL_PROMPT_TYPE;
    public static final int SKINID_1;
    public static final int SKINID_2;
    public static final int SKINID_3;
    public static final int AUDIOMODE_START;
    public static final int AUDIOMODE_REPEAT;
    public static final int AUDIOMODE_ABORT;
    public static final int AUDIOMODE_PAUSE;
    public static final int PROMPTMODE_NONE;
    public static final int PROMPTMODE_SHORT;
    public static final int PROMPTMODE_LONG;
    public static final int VOICEID_FEMALE;
    public static final int VOICEID_MALE;
    public static final int VOICEID_OTHER_1;
    public static final int VOICEID_OTHER_2;
    public static final int VOICEID_OTHER_3;
    public static final int TONEID_STARTTONE;
    public static final int TONEID_ENDTONE;
    public static final int TONEID_RECOGNIZER_READY_TONE;
    public static final int TONEID_WAITING_TONE;
    public static final int TONEID_ERROR_TONE;
    public static final int PLAYBACKTYPE_TEXT;
    public static final int PLAYBACKTYPE_STARTTONE;
    public static final int PLAYBACKTYPE_ENDTONE;
    public static final int PLAYBACKTYPE_RECOGNIZER_READY_TONE;
    public static final int PROMPTTYPE_INVALID;
    public static final int PROMPTTYPE_SSML_TEXT;
    public static final int PROMPTTYPE_SSML_TEXT_ID;
    public static final int PROMPTTYPE_SSML_REMOTE_TEXT;
    public static final int SKIPDIRECTION_FORWARD;
    public static final int SKIPDIRECTION_BACKWARD;
    public static final int RT_SETLANGUAGE;
    public static final int RT_INIT;
    public static final int RT_REQUESTAUDIOTRIGGER;
    public static final int RT_REQUESTPLAYTONE;
    public static final int RT_SPEAKPROMPT;
    public static final int RT_REQUESTSKIPSPEAKING;
    public static final int RP_RESPONSESETLANGUAGE;
    public static final int RP_RESPONSEINIT;
    public static final int RP_RESPONSEAUDIOTRIGGER;
    public static final int RP_RESPONSEPLAYTONE;
    public static final int RP_RESPONSESPEAKPROMPT;
    public static final int RP_RESPONSESKIPSPEAKING;

    default public void speakPrompt(short s, TTSPrompt tTSPrompt) {
    }

    default public void setLanguage(short s, String string, int n, int n2, int n3) {
    }

    default public void init(short s) {
    }

    default public void requestAudioTrigger(short s, int n) {
    }

    default public void requestPlayTone(short s, int n) {
    }

    default public void requestSkipSpeaking(short s, int n, int n2) {
    }
}

