/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class ChangeInfoListType_StartResult
implements StartResultMethod {
    public int controlType;
    public static final int CONTROL_TYPE_NEXT;
    public static final int CONTROL_TYPE_PREVIOUS;

    public ChangeInfoListType_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public ChangeInfoListType_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.controlType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ChangeInfoListType_StartResult changeInfoListType_StartResult = (ChangeInfoListType_StartResult)bAPEntity;
        return this.controlType == changeInfoListType_StartResult.controlType;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ChangeInfoListType_StartResult:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.controlType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 31;
    }

    @Override
    public int getFunctionId() {
        return ChangeInfoListType_StartResult.functionId();
    }
}

