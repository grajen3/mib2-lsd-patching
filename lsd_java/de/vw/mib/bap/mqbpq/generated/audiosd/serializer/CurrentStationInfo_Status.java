/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.CurrentStationInfo_Status$StationInfoSwitches;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentStationInfo_Status
implements StatusProperty {
    public final BAPString infotext_1 = new BAPString(49);
    private static final int MAX_INFOTEXT_1_LENGTH;
    public final BAPString infotext_2 = new BAPString(49);
    private static final int MAX_INFOTEXT_2_LENGTH;
    public final BAPString infotext_3 = new BAPString(49);
    private static final int MAX_INFOTEXT_3_LENGTH;
    public final CurrentStationInfo_Status$StationInfoSwitches stationInfoSwitches = new CurrentStationInfo_Status$StationInfoSwitches();
    public int fsgHandle;

    public CurrentStationInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentStationInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.fsgHandle = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.infotext_1.reset();
        this.infotext_2.reset();
        this.infotext_3.reset();
        this.stationInfoSwitches.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentStationInfo_Status currentStationInfo_Status = (CurrentStationInfo_Status)bAPEntity;
        return this.infotext_1.equalTo(currentStationInfo_Status.infotext_1) && this.infotext_2.equalTo(currentStationInfo_Status.infotext_2) && this.infotext_3.equalTo(currentStationInfo_Status.infotext_3) && this.stationInfoSwitches.equalTo(currentStationInfo_Status.stationInfoSwitches) && this.fsgHandle == currentStationInfo_Status.fsgHandle;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CurrentStationInfo_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.infotext_1.serialize(bitStream);
        this.infotext_2.serialize(bitStream);
        this.infotext_3.serialize(bitStream);
        this.stationInfoSwitches.serialize(bitStream);
        bitStream.pushShort((short)this.fsgHandle);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 21;
    }

    @Override
    public int getFunctionId() {
        return CurrentStationInfo_Status.functionId();
    }
}

