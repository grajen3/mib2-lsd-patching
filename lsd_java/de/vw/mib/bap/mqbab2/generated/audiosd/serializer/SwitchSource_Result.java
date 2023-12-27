/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class SwitchSource_Result
implements ResultMethod {
    public int switchSourceResult;
    public static final int SWITCH_SOURCE_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int SWITCH_SOURCE_RESULT_ABORT_SUCCESSFUL;
    public static final int SWITCH_SOURCE_RESULT_NOT_SUCCESSFUL;
    public static final int SWITCH_SOURCE_RESULT_SUCCESSFUL;

    public SwitchSource_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public SwitchSource_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.switchSourceResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SwitchSource_Result switchSource_Result = (SwitchSource_Result)bAPEntity;
        return this.switchSourceResult == switchSource_Result.switchSourceResult;
    }

    private void customInitialization() {
    }

    @Override
    public int getResultCode() {
        return this.switchSourceResult;
    }

    @Override
    public String toString() {
        return "SwitchSource_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.switchSourceResult);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.switchSourceResult = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 34;
    }

    @Override
    public int getFunctionId() {
        return SwitchSource_Result.functionId();
    }
}

