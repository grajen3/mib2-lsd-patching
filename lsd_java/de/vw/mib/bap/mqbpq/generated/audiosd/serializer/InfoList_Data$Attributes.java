/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class InfoList_Data$Attributes
implements BAPEntity {
    public boolean reserved_bit_3;
    public boolean reserved_bit_2;
    public boolean reserved_bit_1;
    public boolean selectable;

    public InfoList_Data$Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public InfoList_Data$Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_3 = false;
        this.reserved_bit_2 = false;
        this.reserved_bit_1 = false;
        this.selectable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        InfoList_Data$Attributes infoList_Data$Attributes = (InfoList_Data$Attributes)bAPEntity;
        return this.reserved_bit_3 == infoList_Data$Attributes.reserved_bit_3 && this.reserved_bit_2 == infoList_Data$Attributes.reserved_bit_2 && this.reserved_bit_1 == infoList_Data$Attributes.reserved_bit_1 && this.selectable == infoList_Data$Attributes.selectable;
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
        bitStream.pushBoolean(this.reserved_bit_3);
        bitStream.pushBoolean(this.reserved_bit_2);
        bitStream.pushBoolean(this.reserved_bit_1);
        bitStream.pushBoolean(this.selectable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

