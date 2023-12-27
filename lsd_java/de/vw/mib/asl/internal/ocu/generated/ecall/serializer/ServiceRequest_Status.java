/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.ServiceRequest_Extension1;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.ServiceRequest_Extension2;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.ServiceRequest_ServiceType;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceRequest_Status
implements StatusProperty {
    public int durationBeforeCallStart;
    public static final int DURATION_BEFORE_CALL_START_MIN;
    public ServiceRequest_Extension1 extension1 = new ServiceRequest_Extension1();
    public ServiceRequest_Extension2 extension2 = new ServiceRequest_Extension2();
    public ServiceRequest_ServiceType serviceType = new ServiceRequest_ServiceType();

    public ServiceRequest_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ServiceRequest_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.durationBeforeCallStart = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.extension1.reset();
        this.extension2.reset();
        this.serviceType.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ServiceRequest_Status serviceRequest_Status = (ServiceRequest_Status)bAPEntity;
        return this.durationBeforeCallStart == serviceRequest_Status.durationBeforeCallStart && this.extension1.equalTo(serviceRequest_Status.extension1) && this.extension2.equalTo(serviceRequest_Status.extension2) && this.serviceType.equalTo(serviceRequest_Status.serviceType);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ServiceRequest_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.durationBeforeCallStart);
        this.extension1.serialize(bitStream);
        this.extension2.serialize(bitStream);
        this.serviceType.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.durationBeforeCallStart = bitStream.popFrontByte();
        this.extension1.deserialize(bitStream);
        this.extension2.deserialize(bitStream);
        this.serviceType.deserialize(bitStream);
    }

    public static int functionId() {
        return 24;
    }

    @Override
    public int getFunctionId() {
        return ServiceRequest_Status.functionId();
    }
}

