/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ASG_Capabilities_FurtherCapabilities
implements BAPEntity {
    public boolean reserved_bit_3;
    public boolean reserved_bit_2;
    public boolean reserved_bit_1;
    public boolean reserved_bit_0;

    public ASG_Capabilities_FurtherCapabilities() {
        this.internalReset();
        this.customInitialization();
    }

    public ASG_Capabilities_FurtherCapabilities(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_3 = false;
        this.reserved_bit_2 = false;
        this.reserved_bit_1 = false;
        this.reserved_bit_0 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ASG_Capabilities_FurtherCapabilities aSG_Capabilities_FurtherCapabilities = (ASG_Capabilities_FurtherCapabilities)bAPEntity;
        return this.reserved_bit_3 == aSG_Capabilities_FurtherCapabilities.reserved_bit_3 && this.reserved_bit_2 == aSG_Capabilities_FurtherCapabilities.reserved_bit_2 && this.reserved_bit_1 == aSG_Capabilities_FurtherCapabilities.reserved_bit_1 && this.reserved_bit_0 == aSG_Capabilities_FurtherCapabilities.reserved_bit_0;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ASG_Capabilities_FurtherCapabilities:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_3);
        bitStream.pushBoolean(this.reserved_bit_2);
        bitStream.pushBoolean(this.reserved_bit_1);
        bitStream.pushBoolean(this.reserved_bit_0);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_3 = bitStream.popFrontBoolean();
        this.reserved_bit_2 = bitStream.popFrontBoolean();
        this.reserved_bit_1 = bitStream.popFrontBoolean();
        this.reserved_bit_0 = bitStream.popFrontBoolean();
    }
}

