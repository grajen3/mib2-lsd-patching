/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.sdssd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status$SetupValue
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean _commandIdsSupported;

    public FSG_Setup_Status$SetupValue() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status$SetupValue(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this._commandIdsSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status$SetupValue fSG_Setup_Status$SetupValue = (FSG_Setup_Status$SetupValue)bAPEntity;
        return this._commandIdsSupported == fSG_Setup_Status$SetupValue._commandIdsSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SetupValue:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this._commandIdsSupported);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

