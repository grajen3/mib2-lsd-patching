/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class AudioState_SetGet
implements SetGetProperty {
    public int currentAudioSource;
    public static final int CURRENT_AUDIO_SOURCE_TOTAL_MUTE_ADDED_IN_DF3_1;
    public static final int CURRENT_AUDIO_SOURCE_HU_PHONE;
    public static final int CURRENT_AUDIO_SOURCE_HU_INTERNAL;
    public static final int CURRENT_AUDIO_SOURCE_E_CALL_BOX_CALL;
    public static final int CURRENT_AUDIO_SOURCE_E_CALL_BOX_CALL_HIGH_PRIORITY;
    public static final int CURRENT_AUDIO_SOURCE_E_CALL_BOX_VOICE_PROMPT;
    public static final int CURRENT_AUDIO_SOURCE_E_CALL_BOX_VOICE_PROMPT_HIGH_PRIORITY;
    public static final int CURRENT_AUDIO_SOURCE_UNKNOWN_DEFAULT_VALUE_AFTER_STARTUP;
    public int reserve1;
    public static final int RESERVE1_MIN;

    public AudioState_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public AudioState_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.currentAudioSource = 0;
        this.reserve1 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        AudioState_SetGet audioState_SetGet = (AudioState_SetGet)bAPEntity;
        return this.currentAudioSource == audioState_SetGet.currentAudioSource && this.reserve1 == audioState_SetGet.reserve1;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "AudioState_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.currentAudioSource);
        bitStream.pushByte((byte)this.reserve1);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.currentAudioSource = bitStream.popFrontByte();
        this.reserve1 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 16;
    }

    @Override
    public int getFunctionId() {
        return AudioState_SetGet.functionId();
    }
}

