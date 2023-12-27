/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.stream.BitStream;

public final class AudioState_Ack
implements AckProperty {
    public int currentAudioSource;
    public static final int CURRENT_AUDIO_SOURCE_TOTAL_MUTE_ADDED_IN_DF3_1;
    public static final int CURRENT_AUDIO_SOURCE_HU_PHONE;
    public static final int CURRENT_AUDIO_SOURCE_HU_INTERNAL;
    public static final int CURRENT_AUDIO_SOURCE_E_CALL_BOX_CALL;
    public static final int CURRENT_AUDIO_SOURCE_E_CALL_BOX_CALL_HIGH_PRIORITY;
    public static final int CURRENT_AUDIO_SOURCE_E_CALL_BOX_VOICE_PROMPT;
    public static final int CURRENT_AUDIO_SOURCE_E_CALL_BOX_VOICE_PROMPT_HIGH_PRIORITY;
    public static final int CURRENT_AUDIO_SOURCE_UNKNOWN_DEFAULT_VALUE_AFTER_STARTUP;
    public int audioRequest;
    public static final int AUDIO_REQUEST_TOTAL_MUTE_ADDED_IN_DF3_1;
    public static final int AUDIO_REQUEST_E_CALL_BOX_CALL_ADDED_IN_DF3_2;
    public static final int AUDIO_REQUEST_E_CALL_BOX_CALL_HIGH_PRIORITY_ADDED_IN_DF3_2;
    public static final int AUDIO_REQUEST_VOICE_PROMPT;
    public static final int AUDIO_REQUEST_VOICE_PROMPT_HIGH_PRIORITY;
    public static final int AUDIO_REQUEST_NO_AUDIO_REQUEST_PENDING_DEFAULT;

    public AudioState_Ack() {
        this.internalReset();
        this.customInitialization();
    }

    public AudioState_Ack(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.currentAudioSource = 0;
        this.audioRequest = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        AudioState_Ack audioState_Ack = (AudioState_Ack)bAPEntity;
        return this.currentAudioSource == audioState_Ack.currentAudioSource && this.audioRequest == audioState_Ack.audioRequest;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "AudioState_Ack:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.currentAudioSource);
        bitStream.pushByte((byte)this.audioRequest);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.currentAudioSource = bitStream.popFrontByte();
        this.audioRequest = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 16;
    }

    @Override
    public int getFunctionId() {
        return AudioState_Ack.functionId();
    }
}

