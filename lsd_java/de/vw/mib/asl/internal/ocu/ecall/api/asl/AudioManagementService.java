/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.api.asl;

public interface AudioManagementService {
    public static final int AUDIO_CONNECTION_OCU_TOTAL_MUTE;
    public static final int AUDIO_CONNECTION_OCU_EMERGENCY;
    public static final int AUDIO_CONNECTION_OCU_VOICE_PROMPT_HIGH_PRIO;
    public static final int AUDIO_CONNECTION_OCU_CALL;
    public static final int AUDIO_CONNECTION_OCU_VOICE_PROMPT_LOW_PRIO;
    public static final int AUDIO_CONNECTION_PHONE_VOICE;
    public static final int AUDIO_CONNECTION_PHONE_HFP_VOICE;
    public static final int AUDIO_CONNECTION_USER_MUTE;
    public static final int AUDIO_CONNECTION_PHONE_SPEECH_INPUT_DIO_PHONE;
    public static final int AUDIO_CONNECTION_PHONE_SPEECH_INPUT_DIO_SIRI;
    public static final int AUDIO_CONNECTION_PHONE_SPEECH_INPUT_GAL_PHONE;
    public static final int AUDIO_CONNECTION_PHONE_SPEECH_INPUT_GAL;
    public static final int AUDIO_CONNECTION_PHONE_SPEECH_INPUT_MIRRORLINK;
    public static final int AUDIO_CONNECTION_PHONE_SPEECH_INPUT_PHONE;
    public static final int AUDIO_CONNECTION_PHONE_SPEECH_INPUT_SIRI;
    public static final int AUDIO_CONNECTION_PHONE_SPEECH_INPUT_TTS_SDS;

    default public void requestConnection(int n) {
    }

    default public void releaseConnection(int n) {
    }
}

