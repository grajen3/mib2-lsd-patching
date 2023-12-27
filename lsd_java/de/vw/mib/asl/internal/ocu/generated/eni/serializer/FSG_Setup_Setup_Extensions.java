/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Setup_Extensions
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean fleetModeEnabledDf3_4;

    public FSG_Setup_Setup_Extensions() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Setup_Extensions(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.fleetModeEnabledDf3_4 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Setup_Extensions fSG_Setup_Setup_Extensions = (FSG_Setup_Setup_Extensions)bAPEntity;
        return this.fleetModeEnabledDf3_4 == fSG_Setup_Setup_Extensions.fleetModeEnabledDf3_4;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FSG_Setup_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.fleetModeEnabledDf3_4);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.fleetModeEnabledDf3_4 = bitStream.popFrontBoolean();
    }
}

