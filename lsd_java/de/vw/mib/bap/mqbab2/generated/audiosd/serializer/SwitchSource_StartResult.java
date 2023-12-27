/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class SwitchSource_StartResult
implements StartResultMethod {
    public int sourceList_Reference;
    public static final int SOURCE_LIST_REFERENCE_MIN;

    public SwitchSource_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public SwitchSource_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.sourceList_Reference = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SwitchSource_StartResult switchSource_StartResult = (SwitchSource_StartResult)bAPEntity;
        return this.sourceList_Reference == switchSource_StartResult.sourceList_Reference;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SwitchSource_StartResult:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.sourceList_Reference);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.sourceList_Reference = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 34;
    }

    @Override
    public int getFunctionId() {
        return SwitchSource_StartResult.functionId();
    }
}

