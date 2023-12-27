/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.FunctionalRestrictions_Restrictions;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionalRestrictions_Status
implements StatusProperty {
    public FunctionalRestrictions_Restrictions restrictions = new FunctionalRestrictions_Restrictions();
    public int extension_1;
    public static final int EXTENSION_1_MIN;
    public int extension_2;
    public static final int EXTENSION_2_MIN;

    public FunctionalRestrictions_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionalRestrictions_Status(BitStream bitStream) {
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
        this.restrictions.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionalRestrictions_Status functionalRestrictions_Status = (FunctionalRestrictions_Status)bAPEntity;
        return this.restrictions.equalTo(functionalRestrictions_Status.restrictions) && this.extension_1 == functionalRestrictions_Status.extension_1 && this.extension_2 == functionalRestrictions_Status.extension_2;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FunctionalRestrictions_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.restrictions.serialize(bitStream);
        bitStream.pushByte((byte)this.extension_1);
        bitStream.pushByte((byte)this.extension_2);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.restrictions.deserialize(bitStream);
        this.extension_1 = bitStream.popFrontByte();
        this.extension_2 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 28;
    }

    @Override
    public int getFunctionId() {
        return FunctionalRestrictions_Status.functionId();
    }
}

