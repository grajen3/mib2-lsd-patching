/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.sdssd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SDS_ContextState_Status$Attributes
implements BAPEntity {
    public boolean reserved_bit_1;
    public boolean reserved_bit_2;
    public boolean reserved_bit_3;
    public boolean reserved_bit_4;
    public boolean reserved_bit_5;
    public boolean reserved_bit_6;
    public boolean reserved_bit_7;
    public boolean stateIsBeingLoaded;
    private static final int RESERVED_BIT_8__15_BITSIZE;

    public SDS_ContextState_Status$Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public SDS_ContextState_Status$Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_1 = false;
        this.reserved_bit_2 = false;
        this.reserved_bit_3 = false;
        this.reserved_bit_4 = false;
        this.reserved_bit_5 = false;
        this.reserved_bit_6 = false;
        this.reserved_bit_7 = false;
        this.stateIsBeingLoaded = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SDS_ContextState_Status$Attributes sDS_ContextState_Status$Attributes = (SDS_ContextState_Status$Attributes)bAPEntity;
        return this.reserved_bit_1 == sDS_ContextState_Status$Attributes.reserved_bit_1 && this.reserved_bit_2 == sDS_ContextState_Status$Attributes.reserved_bit_2 && this.reserved_bit_3 == sDS_ContextState_Status$Attributes.reserved_bit_3 && this.reserved_bit_4 == sDS_ContextState_Status$Attributes.reserved_bit_4 && this.reserved_bit_5 == sDS_ContextState_Status$Attributes.reserved_bit_5 && this.reserved_bit_6 == sDS_ContextState_Status$Attributes.reserved_bit_6 && this.reserved_bit_7 == sDS_ContextState_Status$Attributes.reserved_bit_7 && this.stateIsBeingLoaded == sDS_ContextState_Status$Attributes.stateIsBeingLoaded;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Attributes:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_1);
        bitStream.pushBoolean(this.reserved_bit_2);
        bitStream.pushBoolean(this.reserved_bit_3);
        bitStream.pushBoolean(this.reserved_bit_4);
        bitStream.pushBoolean(this.reserved_bit_5);
        bitStream.pushBoolean(this.reserved_bit_6);
        bitStream.pushBoolean(this.reserved_bit_7);
        bitStream.pushBoolean(this.stateIsBeingLoaded);
        bitStream.resetBits(8);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

