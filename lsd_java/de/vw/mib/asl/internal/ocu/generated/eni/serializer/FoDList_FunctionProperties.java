/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FoDList_FunctionProperties
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean licenseExpiryWarningMustNotBeDisabled;
    public boolean licenseExpiryWarningNecessary;

    public FoDList_FunctionProperties() {
        this.internalReset();
        this.customInitialization();
    }

    public FoDList_FunctionProperties(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.licenseExpiryWarningMustNotBeDisabled = false;
        this.licenseExpiryWarningNecessary = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FoDList_FunctionProperties foDList_FunctionProperties = (FoDList_FunctionProperties)bAPEntity;
        return this.licenseExpiryWarningMustNotBeDisabled == foDList_FunctionProperties.licenseExpiryWarningMustNotBeDisabled && this.licenseExpiryWarningNecessary == foDList_FunctionProperties.licenseExpiryWarningNecessary;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FoDList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.licenseExpiryWarningMustNotBeDisabled);
        bitStream.pushBoolean(this.licenseExpiryWarningNecessary);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.licenseExpiryWarningMustNotBeDisabled = bitStream.popFrontBoolean();
        this.licenseExpiryWarningNecessary = bitStream.popFrontBoolean();
    }
}

