/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.speech;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechService;

public interface SpeechServiceListener
extends HMIEventListener {
    public static final int SPEECH_SERVICE__SPEECH_DOMAIN_AVAILABLE;
    public static final int SPEECH_SERVICE__INDICATOR_STATE;
    public static final int SPEECH_SERVICE__APPLICATION_STATE;
    public static final int SPEECH_SERVICE__SPEECH_ACTIVATION_STATE;
    public static final int SPEECH_SERVICE__TELEPROMPTER_DATA;
    public static final int SPEECH_SERVICE__SDS_SD_IN_MENU_ACTIVE;
    public static final int SPEECH_SERVICE__HMI_EVENT__PUSH_TO_TALK_HARDKEY_PRESSED;

    default public void updateSpeechData(SpeechService speechService, int n) {
    }
}

