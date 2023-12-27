/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class SwitchRadioMedia_StartResult
implements StartResultMethod {
    public int source;
    public static final int SOURCE_LAST_STATION_LIST_DF4_5;
    public static final int SOURCE_SIRIUS_ALERT_LIST_DF4_5;
    public static final int SOURCE_RADIO_PRESET_LIST;
    public static final int SOURCE_MEDIA_LAST_MODE;
    public static final int SOURCE_RADIO_LAST_MODE;

    public SwitchRadioMedia_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public SwitchRadioMedia_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.source = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SwitchRadioMedia_StartResult switchRadioMedia_StartResult = (SwitchRadioMedia_StartResult)bAPEntity;
        return this.source == switchRadioMedia_StartResult.source;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SwitchRadioMedia_StartResult:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.source);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.source = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 45;
    }

    @Override
    public int getFunctionId() {
        return SwitchRadioMedia_StartResult.functionId();
    }
}

