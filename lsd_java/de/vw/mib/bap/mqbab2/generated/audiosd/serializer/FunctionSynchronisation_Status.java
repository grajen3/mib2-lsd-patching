/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.FunctionSynchronisation_FctList_1;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.FunctionSynchronisation_FctList_2;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.FunctionSynchronisation_FctList_3;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionSynchronisation_Status
implements StatusProperty {
    public FunctionSynchronisation_FctList_1 fctList_1 = new FunctionSynchronisation_FctList_1();
    public FunctionSynchronisation_FctList_2 fctList_2 = new FunctionSynchronisation_FctList_2();
    public FunctionSynchronisation_FctList_3 fctList_3 = new FunctionSynchronisation_FctList_3();

    public FunctionSynchronisation_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionSynchronisation_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.fctList_1.reset();
        this.fctList_2.reset();
        this.fctList_3.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionSynchronisation_Status functionSynchronisation_Status = (FunctionSynchronisation_Status)bAPEntity;
        return this.fctList_1.equalTo(functionSynchronisation_Status.fctList_1) && this.fctList_2.equalTo(functionSynchronisation_Status.fctList_2) && this.fctList_3.equalTo(functionSynchronisation_Status.fctList_3);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FunctionSynchronisation_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.fctList_1.serialize(bitStream);
        this.fctList_2.serialize(bitStream);
        this.fctList_3.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.fctList_1.deserialize(bitStream);
        this.fctList_2.deserialize(bitStream);
        this.fctList_3.deserialize(bitStream);
    }

    public static int functionId() {
        return 42;
    }

    @Override
    public int getFunctionId() {
        return FunctionSynchronisation_Status.functionId();
    }
}

