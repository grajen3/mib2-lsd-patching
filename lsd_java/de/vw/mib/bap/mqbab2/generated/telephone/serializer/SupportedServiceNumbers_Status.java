/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.SupportedServiceNumbers_Status$ServiceNumbers;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SupportedServiceNumbers_Status
implements StatusProperty {
    public final SupportedServiceNumbers_Status$ServiceNumbers serviceNumbers = new SupportedServiceNumbers_Status$ServiceNumbers();
    public static final int EXTENSION_1_MIN;
    public int extension_1;
    public static final int EXTENSION_2_MIN;
    public int extension_2;

    public SupportedServiceNumbers_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SupportedServiceNumbers_Status(BitStream bitStream) {
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
        this.serviceNumbers.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SupportedServiceNumbers_Status supportedServiceNumbers_Status = (SupportedServiceNumbers_Status)bAPEntity;
        return this.serviceNumbers.equalTo(supportedServiceNumbers_Status.serviceNumbers) && this.extension_1 == supportedServiceNumbers_Status.extension_1 && this.extension_2 == supportedServiceNumbers_Status.extension_2;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SupportedServiceNumbers_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.serviceNumbers.serialize(bitStream);
        bitStream.pushByte((byte)this.extension_1);
        bitStream.pushByte((byte)this.extension_2);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 59;
    }

    @Override
    public int getFunctionId() {
        return SupportedServiceNumbers_Status.functionId();
    }
}

