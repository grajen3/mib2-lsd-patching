/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceList_UserSettings
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean serviceAllowedByVehicle;
    public boolean serviceActivatedAllowedByDriver;

    public ServiceList_UserSettings() {
        this.internalReset();
        this.customInitialization();
    }

    public ServiceList_UserSettings(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.serviceAllowedByVehicle = false;
        this.serviceActivatedAllowedByDriver = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ServiceList_UserSettings serviceList_UserSettings = (ServiceList_UserSettings)bAPEntity;
        return this.serviceAllowedByVehicle == serviceList_UserSettings.serviceAllowedByVehicle && this.serviceActivatedAllowedByDriver == serviceList_UserSettings.serviceActivatedAllowedByDriver;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ServiceList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.serviceAllowedByVehicle);
        bitStream.pushBoolean(this.serviceActivatedAllowedByDriver);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.serviceAllowedByVehicle = bitStream.popFrontBoolean();
        this.serviceActivatedAllowedByDriver = bitStream.popFrontBoolean();
    }
}

