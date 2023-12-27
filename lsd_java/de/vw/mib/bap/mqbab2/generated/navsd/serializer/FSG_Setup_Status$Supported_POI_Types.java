/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status$Supported_POI_Types
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean fuelStationAndParkingAreaSupported;

    public FSG_Setup_Status$Supported_POI_Types() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status$Supported_POI_Types(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.fuelStationAndParkingAreaSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status$Supported_POI_Types fSG_Setup_Status$Supported_POI_Types = (FSG_Setup_Status$Supported_POI_Types)bAPEntity;
        return this.fuelStationAndParkingAreaSupported == fSG_Setup_Status$Supported_POI_Types.fuelStationAndParkingAreaSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Supported_POI_Types:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.fuelStationAndParkingAreaSupported);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

