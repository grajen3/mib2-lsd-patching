/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ASG_Capabilities_PresentationCapabilities
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean sdarsLongPsMax_16CharsDf4_1;
    public boolean dabLongPsMax_16Chars;

    public ASG_Capabilities_PresentationCapabilities() {
        this.internalReset();
        this.customInitialization();
    }

    public ASG_Capabilities_PresentationCapabilities(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.sdarsLongPsMax_16CharsDf4_1 = false;
        this.dabLongPsMax_16Chars = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ASG_Capabilities_PresentationCapabilities aSG_Capabilities_PresentationCapabilities = (ASG_Capabilities_PresentationCapabilities)bAPEntity;
        return this.sdarsLongPsMax_16CharsDf4_1 == aSG_Capabilities_PresentationCapabilities.sdarsLongPsMax_16CharsDf4_1 && this.dabLongPsMax_16Chars == aSG_Capabilities_PresentationCapabilities.dabLongPsMax_16Chars;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ASG_Capabilities_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.sdarsLongPsMax_16CharsDf4_1);
        bitStream.pushBoolean(this.dabLongPsMax_16Chars);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.sdarsLongPsMax_16CharsDf4_1 = bitStream.popFrontBoolean();
        this.dabLongPsMax_16Chars = bitStream.popFrontBoolean();
    }
}

