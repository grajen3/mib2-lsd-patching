/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status$VoiceGuidance
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE;
    public boolean voiceGuidanceOnTrafficAvailable;
    public boolean voiceGuidanceOnReducedAvailable;
    public boolean voiceGuidanceOnAvailable;

    public FSG_Setup_Status$VoiceGuidance() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status$VoiceGuidance(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.voiceGuidanceOnTrafficAvailable = false;
        this.voiceGuidanceOnReducedAvailable = false;
        this.voiceGuidanceOnAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status$VoiceGuidance fSG_Setup_Status$VoiceGuidance = (FSG_Setup_Status$VoiceGuidance)bAPEntity;
        return this.voiceGuidanceOnTrafficAvailable == fSG_Setup_Status$VoiceGuidance.voiceGuidanceOnTrafficAvailable && this.voiceGuidanceOnReducedAvailable == fSG_Setup_Status$VoiceGuidance.voiceGuidanceOnReducedAvailable && this.voiceGuidanceOnAvailable == fSG_Setup_Status$VoiceGuidance.voiceGuidanceOnAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "VoiceGuidance:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(5);
        bitStream.pushBoolean(this.voiceGuidanceOnTrafficAvailable);
        bitStream.pushBoolean(this.voiceGuidanceOnReducedAvailable);
        bitStream.pushBoolean(this.voiceGuidanceOnAvailable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

