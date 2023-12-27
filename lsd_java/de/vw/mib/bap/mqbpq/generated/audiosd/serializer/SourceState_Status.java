/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SourceState_Status
implements StatusProperty {
    public int stateInfo;
    public static final int STATE_INFO_UNKNOWN;
    public static final int STATE_INFO_SCAN;
    public static final int STATE_INFO_MIX;
    public static final int STATE_INFO_REPEAT;
    public static final int STATE_INFO_REPEAT_MIX;

    public SourceState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SourceState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.stateInfo = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SourceState_Status sourceState_Status = (SourceState_Status)bAPEntity;
        return this.stateInfo == sourceState_Status.stateInfo;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SourceState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.stateInfo);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 20;
    }

    @Override
    public int getFunctionId() {
        return SourceState_Status.functionId();
    }
}

