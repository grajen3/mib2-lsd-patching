/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.SupportedServices_Services;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SupportedServices_Status
implements StatusProperty {
    public SupportedServices_Services services = new SupportedServices_Services();
    public int extension_1;
    public static final int EXTENSION_1_MIN;
    public int extension_2;
    public static final int EXTENSION_2_MIN;

    public SupportedServices_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SupportedServices_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.extension_1 = 0;
        this.extension_2 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.services.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SupportedServices_Status supportedServices_Status = (SupportedServices_Status)bAPEntity;
        return this.services.equalTo(supportedServices_Status.services) && this.extension_1 == supportedServices_Status.extension_1 && this.extension_2 == supportedServices_Status.extension_2;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SupportedServices_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.services.serialize(bitStream);
        bitStream.pushByte((byte)this.extension_1);
        bitStream.pushByte((byte)this.extension_2);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.services.deserialize(bitStream);
        this.extension_1 = bitStream.popFrontByte();
        this.extension_2 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 27;
    }

    @Override
    public int getFunctionId() {
        return SupportedServices_Status.functionId();
    }
}

