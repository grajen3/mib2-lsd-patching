/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentStation_Handle2_Status
implements StatusProperty {
    public int siriusAlertList_FsgHandle;
    public static final int SIRIUS_ALERT_LIST_FSG_HANDLE_MIN;
    public int siriusAlertList_FsgHandle_absolutePosition;
    public static final int SIRIUS_ALERT_LIST_FSG_HANDLE_ABSOLUTE_POSITION_MIN;
    public int lastStationList_FsgHandle;
    public static final int LAST_STATION_LIST_FSG_HANDLE_MIN;
    public int lastStationList_FsgHandle_absolutePosition;
    public static final int LAST_STATION_LIST_FSG_HANDLE_ABSOLUTE_POSITION_MIN;

    public CurrentStation_Handle2_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentStation_Handle2_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.siriusAlertList_FsgHandle = 0;
        this.siriusAlertList_FsgHandle_absolutePosition = 0;
        this.lastStationList_FsgHandle = 0;
        this.lastStationList_FsgHandle_absolutePosition = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentStation_Handle2_Status currentStation_Handle2_Status = (CurrentStation_Handle2_Status)bAPEntity;
        return this.siriusAlertList_FsgHandle == currentStation_Handle2_Status.siriusAlertList_FsgHandle && this.siriusAlertList_FsgHandle_absolutePosition == currentStation_Handle2_Status.siriusAlertList_FsgHandle_absolutePosition && this.lastStationList_FsgHandle == currentStation_Handle2_Status.lastStationList_FsgHandle && this.lastStationList_FsgHandle_absolutePosition == currentStation_Handle2_Status.lastStationList_FsgHandle_absolutePosition;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CurrentStation_Handle2_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.siriusAlertList_FsgHandle);
        bitStream.pushShort((short)this.siriusAlertList_FsgHandle_absolutePosition);
        bitStream.pushByte((byte)this.lastStationList_FsgHandle);
        bitStream.pushByte((byte)this.lastStationList_FsgHandle_absolutePosition);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.siriusAlertList_FsgHandle = bitStream.popFrontShort();
        this.siriusAlertList_FsgHandle_absolutePosition = bitStream.popFrontShort();
        this.lastStationList_FsgHandle = bitStream.popFrontByte();
        this.lastStationList_FsgHandle_absolutePosition = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 51;
    }

    @Override
    public int getFunctionId() {
        return CurrentStation_Handle2_Status.functionId();
    }
}

