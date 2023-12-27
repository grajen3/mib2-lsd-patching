/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.speech;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechServiceListener;
import java.util.List;

public interface SpeechService {
    public static final int SPEECH_SERVICE__PERFORMING_BAP_ACTION__AUDIO_SWITCH_SOURCE;
    public static final int SPEECH_SERVICE__PERFORMING_BAP_ACTION__AUDIO_RADIO_PREV_NEXT_SEEK;
    public static final int SPEECH_SERVICE__PERFORMING_BAP_ACTION__AUDIO_MEDIA_PREV_NEXT_SEEK;
    public static final int SPEECH_SERVICE__PERFORMING_BAP_ACTION__NAVIGATION_RG_STARTED_STOPPED;
    public static final int SPEECH_SERVICE__PERFORMING_BAP_ACTION__PHONE_CHANGED_CALL_STATE;

    default public void addSpeechServiceListener(SpeechServiceListener speechServiceListener, int[] nArray) {
    }

    default public void removeSpeechServiceListener(SpeechServiceListener speechServiceListener, int[] nArray) {
    }

    default public void addHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public void removeHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public boolean isSpeechDomainAvailable() {
    }

    default public int getIndicatorState() {
    }

    default public int getSpeechApplicationState() {
    }

    default public boolean isSpeechActive() {
    }

    default public int getTeleprompterType() {
    }

    default public String getHeadline() {
    }

    default public boolean isHeadlineDynamic() {
    }

    default public List getCommands() {
    }

    default public boolean isSdsSdInMenuActive() {
    }

    default public void performingBAPAction(int n) {
    }
}

