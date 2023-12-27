/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.FunctionList_FctList;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionList_Status
implements StatusProperty {
    public FunctionList_FctList fctList = new FunctionList_FctList();

    public FunctionList_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionList_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.fctList.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_Status functionList_Status = (FunctionList_Status)bAPEntity;
        return this.fctList.equalTo(functionList_Status.fctList);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FunctionList_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.fctList.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.fctList.deserialize(bitStream);
    }

    public static int functionId() {
        return 3;
    }

    @Override
    public int getFunctionId() {
        return FunctionList_Status.functionId();
    }
}

