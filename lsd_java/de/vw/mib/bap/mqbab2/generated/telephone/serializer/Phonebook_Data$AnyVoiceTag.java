/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class Phonebook_Data$AnyVoiceTag
implements BAPEntity {
    public boolean reserved_bit_3;
    public boolean reserved_bit_2;
    public boolean voiceTagForStandardNumberAvailable;
    public boolean anyVoiceTagAvailable;

    public Phonebook_Data$AnyVoiceTag() {
        this.internalReset();
        this.customInitialization();
    }

    public Phonebook_Data$AnyVoiceTag(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_3 = false;
        this.reserved_bit_2 = false;
        this.voiceTagForStandardNumberAvailable = false;
        this.anyVoiceTagAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Phonebook_Data$AnyVoiceTag phonebook_Data$AnyVoiceTag = (Phonebook_Data$AnyVoiceTag)bAPEntity;
        return this.reserved_bit_3 == phonebook_Data$AnyVoiceTag.reserved_bit_3 && this.reserved_bit_2 == phonebook_Data$AnyVoiceTag.reserved_bit_2 && this.voiceTagForStandardNumberAvailable == phonebook_Data$AnyVoiceTag.voiceTagForStandardNumberAvailable && this.anyVoiceTagAvailable == phonebook_Data$AnyVoiceTag.anyVoiceTagAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "AnyVoiceTag:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_3);
        bitStream.pushBoolean(this.reserved_bit_2);
        bitStream.pushBoolean(this.voiceTagForStandardNumberAvailable);
        bitStream.pushBoolean(this.anyVoiceTagAvailable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

