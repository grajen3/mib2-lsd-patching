/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status$PhoneCharacteristics
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean reserved_bit_6;
    public boolean googleLinkConnectionToMobilePossible;
    public boolean appleLinkConnectionToMobilePossible;
    public boolean rsapConnectionToMobilePossible;
    public boolean hfpConnectionToMobilePossible;
    public boolean cableConnectionToMobilePossible;
    public boolean internalSimcardReader;

    public FSG_Setup_Status$PhoneCharacteristics() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status$PhoneCharacteristics(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.reserved_bit_6 = false;
        this.googleLinkConnectionToMobilePossible = false;
        this.appleLinkConnectionToMobilePossible = false;
        this.rsapConnectionToMobilePossible = false;
        this.hfpConnectionToMobilePossible = false;
        this.cableConnectionToMobilePossible = false;
        this.internalSimcardReader = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status$PhoneCharacteristics fSG_Setup_Status$PhoneCharacteristics = (FSG_Setup_Status$PhoneCharacteristics)bAPEntity;
        return this.reserved_bit_7 == fSG_Setup_Status$PhoneCharacteristics.reserved_bit_7 && this.reserved_bit_6 == fSG_Setup_Status$PhoneCharacteristics.reserved_bit_6 && this.googleLinkConnectionToMobilePossible == fSG_Setup_Status$PhoneCharacteristics.googleLinkConnectionToMobilePossible && this.appleLinkConnectionToMobilePossible == fSG_Setup_Status$PhoneCharacteristics.appleLinkConnectionToMobilePossible && this.rsapConnectionToMobilePossible == fSG_Setup_Status$PhoneCharacteristics.rsapConnectionToMobilePossible && this.hfpConnectionToMobilePossible == fSG_Setup_Status$PhoneCharacteristics.hfpConnectionToMobilePossible && this.cableConnectionToMobilePossible == fSG_Setup_Status$PhoneCharacteristics.cableConnectionToMobilePossible && this.internalSimcardReader == fSG_Setup_Status$PhoneCharacteristics.internalSimcardReader;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "PhoneCharacteristics:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_7);
        bitStream.pushBoolean(this.reserved_bit_6);
        bitStream.pushBoolean(this.googleLinkConnectionToMobilePossible);
        bitStream.pushBoolean(this.appleLinkConnectionToMobilePossible);
        bitStream.pushBoolean(this.rsapConnectionToMobilePossible);
        bitStream.pushBoolean(this.hfpConnectionToMobilePossible);
        bitStream.pushBoolean(this.cableConnectionToMobilePossible);
        bitStream.pushBoolean(this.internalSimcardReader);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

