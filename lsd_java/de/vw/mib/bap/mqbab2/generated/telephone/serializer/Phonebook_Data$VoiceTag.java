/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class Phonebook_Data$VoiceTag
implements BAPEntity {
    public boolean voiceTagAvailable;
    private static final int VOICE_TAG_NOT_DEFINED_BITSIZE;

    public Phonebook_Data$VoiceTag() {
        this.internalReset();
        this.customInitialization();
    }

    public Phonebook_Data$VoiceTag(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.voiceTagAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Phonebook_Data$VoiceTag phonebook_Data$VoiceTag = (Phonebook_Data$VoiceTag)bAPEntity;
        return this.voiceTagAvailable == phonebook_Data$VoiceTag.voiceTagAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "VoiceTag:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(3, 0);
        bitStream.pushBoolean(this.voiceTagAvailable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

