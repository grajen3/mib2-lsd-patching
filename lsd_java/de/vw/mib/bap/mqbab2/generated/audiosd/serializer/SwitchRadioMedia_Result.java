/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class SwitchRadioMedia_Result
implements ResultMethod {
    public int switchRadioMediaResult;
    public static final int SWITCH_RADIO_MEDIA_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int SWITCH_RADIO_MEDIA_RESULT_ABORT_SUCCESSFUL;
    public static final int SWITCH_RADIO_MEDIA_RESULT_NOT_SUCCESSFUL;
    public static final int SWITCH_RADIO_MEDIA_RESULT_SUCCESSFUL;

    public SwitchRadioMedia_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public SwitchRadioMedia_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.switchRadioMediaResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SwitchRadioMedia_Result switchRadioMedia_Result = (SwitchRadioMedia_Result)bAPEntity;
        return this.switchRadioMediaResult == switchRadioMedia_Result.switchRadioMediaResult;
    }

    private void customInitialization() {
    }

    @Override
    public int getResultCode() {
        return this.switchRadioMediaResult;
    }

    @Override
    public String toString() {
        return "SwitchRadioMedia_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.switchRadioMediaResult);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.switchRadioMediaResult = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 45;
    }

    @Override
    public int getFunctionId() {
        return SwitchRadioMedia_Result.functionId();
    }
}

