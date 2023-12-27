/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceRequest_ServiceType
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean testModePendingDf3_4;
    public boolean mecPending;
    public boolean acnPending;
    public boolean infoCallPending;
    public boolean usmPending;
    public boolean serviceBreakdownCallPending;
    public boolean reserved_bit_0;

    public ServiceRequest_ServiceType() {
        this.internalReset();
        this.customInitialization();
    }

    public ServiceRequest_ServiceType(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.testModePendingDf3_4 = false;
        this.mecPending = false;
        this.acnPending = false;
        this.infoCallPending = false;
        this.usmPending = false;
        this.serviceBreakdownCallPending = false;
        this.reserved_bit_0 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ServiceRequest_ServiceType serviceRequest_ServiceType = (ServiceRequest_ServiceType)bAPEntity;
        return this.reserved_bit_7 == serviceRequest_ServiceType.reserved_bit_7 && this.testModePendingDf3_4 == serviceRequest_ServiceType.testModePendingDf3_4 && this.mecPending == serviceRequest_ServiceType.mecPending && this.acnPending == serviceRequest_ServiceType.acnPending && this.infoCallPending == serviceRequest_ServiceType.infoCallPending && this.usmPending == serviceRequest_ServiceType.usmPending && this.serviceBreakdownCallPending == serviceRequest_ServiceType.serviceBreakdownCallPending && this.reserved_bit_0 == serviceRequest_ServiceType.reserved_bit_0;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ServiceRequest_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_7);
        bitStream.pushBoolean(this.testModePendingDf3_4);
        bitStream.pushBoolean(this.mecPending);
        bitStream.pushBoolean(this.acnPending);
        bitStream.pushBoolean(this.infoCallPending);
        bitStream.pushBoolean(this.usmPending);
        bitStream.pushBoolean(this.serviceBreakdownCallPending);
        bitStream.pushBoolean(this.reserved_bit_0);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_7 = bitStream.popFrontBoolean();
        this.testModePendingDf3_4 = bitStream.popFrontBoolean();
        this.mecPending = bitStream.popFrontBoolean();
        this.acnPending = bitStream.popFrontBoolean();
        this.infoCallPending = bitStream.popFrontBoolean();
        this.usmPending = bitStream.popFrontBoolean();
        this.serviceBreakdownCallPending = bitStream.popFrontBoolean();
        this.reserved_bit_0 = bitStream.popFrontBoolean();
    }
}

