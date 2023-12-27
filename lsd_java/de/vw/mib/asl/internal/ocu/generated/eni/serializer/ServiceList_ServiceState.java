/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceList_ServiceState
implements BAPEntity {
    public boolean serviceAllocatedToGroup1Df3_5;
    public boolean licenseRequiredDf3_4;
    public boolean disablingByDriverAllowedDf3_3;
    public boolean reserved_bit_4;
    public boolean protectedService;
    public boolean licenseExpirationWarning;
    public boolean roamingAllowed;
    public boolean serviceEnabled;
    public boolean reserved_bit_15;
    public boolean reserved_bit_14;
    public boolean reserved_bit_13;
    public boolean serviceAllocatedToGroup6Df3_5;
    public boolean serviceAllocatedToGroup5Df3_5;
    public boolean serviceAllocatedToGroup4Df3_5;
    public boolean serviceAllocatedToGroup3Df3_5;
    public boolean serviceAllocatedToGroup2Df3_5;

    public ServiceList_ServiceState() {
        this.internalReset();
        this.customInitialization();
    }

    public ServiceList_ServiceState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.serviceAllocatedToGroup1Df3_5 = false;
        this.licenseRequiredDf3_4 = false;
        this.disablingByDriverAllowedDf3_3 = false;
        this.reserved_bit_4 = false;
        this.protectedService = false;
        this.licenseExpirationWarning = false;
        this.roamingAllowed = false;
        this.serviceEnabled = false;
        this.reserved_bit_15 = false;
        this.reserved_bit_14 = false;
        this.reserved_bit_13 = false;
        this.serviceAllocatedToGroup6Df3_5 = false;
        this.serviceAllocatedToGroup5Df3_5 = false;
        this.serviceAllocatedToGroup4Df3_5 = false;
        this.serviceAllocatedToGroup3Df3_5 = false;
        this.serviceAllocatedToGroup2Df3_5 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ServiceList_ServiceState serviceList_ServiceState = (ServiceList_ServiceState)bAPEntity;
        return this.serviceAllocatedToGroup1Df3_5 == serviceList_ServiceState.serviceAllocatedToGroup1Df3_5 && this.licenseRequiredDf3_4 == serviceList_ServiceState.licenseRequiredDf3_4 && this.disablingByDriverAllowedDf3_3 == serviceList_ServiceState.disablingByDriverAllowedDf3_3 && this.reserved_bit_4 == serviceList_ServiceState.reserved_bit_4 && this.protectedService == serviceList_ServiceState.protectedService && this.licenseExpirationWarning == serviceList_ServiceState.licenseExpirationWarning && this.roamingAllowed == serviceList_ServiceState.roamingAllowed && this.serviceEnabled == serviceList_ServiceState.serviceEnabled && this.reserved_bit_15 == serviceList_ServiceState.reserved_bit_15 && this.reserved_bit_14 == serviceList_ServiceState.reserved_bit_14 && this.reserved_bit_13 == serviceList_ServiceState.reserved_bit_13 && this.serviceAllocatedToGroup6Df3_5 == serviceList_ServiceState.serviceAllocatedToGroup6Df3_5 && this.serviceAllocatedToGroup5Df3_5 == serviceList_ServiceState.serviceAllocatedToGroup5Df3_5 && this.serviceAllocatedToGroup4Df3_5 == serviceList_ServiceState.serviceAllocatedToGroup4Df3_5 && this.serviceAllocatedToGroup3Df3_5 == serviceList_ServiceState.serviceAllocatedToGroup3Df3_5 && this.serviceAllocatedToGroup2Df3_5 == serviceList_ServiceState.serviceAllocatedToGroup2Df3_5;
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
        bitStream.pushBoolean(this.serviceAllocatedToGroup1Df3_5);
        bitStream.pushBoolean(this.licenseRequiredDf3_4);
        bitStream.pushBoolean(this.disablingByDriverAllowedDf3_3);
        bitStream.pushBoolean(this.reserved_bit_4);
        bitStream.pushBoolean(this.protectedService);
        bitStream.pushBoolean(this.licenseExpirationWarning);
        bitStream.pushBoolean(this.roamingAllowed);
        bitStream.pushBoolean(this.serviceEnabled);
        bitStream.pushBoolean(this.reserved_bit_15);
        bitStream.pushBoolean(this.reserved_bit_14);
        bitStream.pushBoolean(this.reserved_bit_13);
        bitStream.pushBoolean(this.serviceAllocatedToGroup6Df3_5);
        bitStream.pushBoolean(this.serviceAllocatedToGroup5Df3_5);
        bitStream.pushBoolean(this.serviceAllocatedToGroup4Df3_5);
        bitStream.pushBoolean(this.serviceAllocatedToGroup3Df3_5);
        bitStream.pushBoolean(this.serviceAllocatedToGroup2Df3_5);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.serviceAllocatedToGroup1Df3_5 = bitStream.popFrontBoolean();
        this.licenseRequiredDf3_4 = bitStream.popFrontBoolean();
        this.disablingByDriverAllowedDf3_3 = bitStream.popFrontBoolean();
        this.reserved_bit_4 = bitStream.popFrontBoolean();
        this.protectedService = bitStream.popFrontBoolean();
        this.licenseExpirationWarning = bitStream.popFrontBoolean();
        this.roamingAllowed = bitStream.popFrontBoolean();
        this.serviceEnabled = bitStream.popFrontBoolean();
        this.reserved_bit_15 = bitStream.popFrontBoolean();
        this.reserved_bit_14 = bitStream.popFrontBoolean();
        this.reserved_bit_13 = bitStream.popFrontBoolean();
        this.serviceAllocatedToGroup6Df3_5 = bitStream.popFrontBoolean();
        this.serviceAllocatedToGroup5Df3_5 = bitStream.popFrontBoolean();
        this.serviceAllocatedToGroup4Df3_5 = bitStream.popFrontBoolean();
        this.serviceAllocatedToGroup3Df3_5 = bitStream.popFrontBoolean();
        this.serviceAllocatedToGroup2Df3_5 = bitStream.popFrontBoolean();
    }
}

