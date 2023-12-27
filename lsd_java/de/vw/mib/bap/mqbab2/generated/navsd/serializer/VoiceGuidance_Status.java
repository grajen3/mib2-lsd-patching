/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class VoiceGuidance_Status
implements StatusProperty {
    public int voiceGuidance_State;
    public static final int VOICE_GUIDANCE_STATE_VOICE_GUIDANCE_ON_FULL_COMPLETE_ANNOUNCEMENTS;
    public static final int VOICE_GUIDANCE_STATE_VOICE_GUIDANCE_OFF;
    public static final int VOICE_GUIDANCE_STATE_VOICE_GUIDANCE_ON_REDUCED_ANNOUNCEMENTS_REDUCED_MODE;
    public static final int VOICE_GUIDANCE_STATE_VOICE_GUIDANCE_ON_REDUCED_ANNOUNCEMENT_TRAFFIC_DF4_1;

    public VoiceGuidance_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public VoiceGuidance_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.voiceGuidance_State = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        VoiceGuidance_Status voiceGuidance_Status = (VoiceGuidance_Status)bAPEntity;
        return this.voiceGuidance_State == voiceGuidance_Status.voiceGuidance_State;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "VoiceGuidance_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.voiceGuidance_State);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 36;
    }

    @Override
    public int getFunctionId() {
        return VoiceGuidance_Status.functionId();
    }
}

