/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Control_Controlcode
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean setDefault;

    public FSG_Control_Controlcode() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Control_Controlcode(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.setDefault = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Control_Controlcode fSG_Control_Controlcode = (FSG_Control_Controlcode)bAPEntity;
        return this.setDefault == fSG_Control_Controlcode.setDefault;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FSG_Control_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.setDefault);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.setDefault = bitStream.popFrontBoolean();
    }
}

