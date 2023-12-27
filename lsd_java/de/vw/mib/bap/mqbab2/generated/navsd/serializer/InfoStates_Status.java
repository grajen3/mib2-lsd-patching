/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class InfoStates_Status
implements StatusProperty {
    public int states;
    public static final int STATES_NO_ERROR_NO_INFORMATION;
    public static final int STATES_NO_NAVIGATION_DATA_MEDIUM_INSERTED;
    public static final int STATES_NAVIGATION_DATABASE_CORRUPTED;
    public static final int STATES_NO_GPS_SIGNAL_AVAILABLE;
    public static final int STATES_NAVIGATION_DATABASE_UPDATE_ONGOING_IN_PROGRESS_DF4_1;
    public static final int STATES_INITIALIZING_MOST_MAP_DF4_2;
    public static final int STATES_NAVIGATION_IN_MOBILE_DEVICE_ACTIVE_DF_4_3;
    public static final int STATES_UNKNOWN;

    public InfoStates_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public InfoStates_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.states = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        InfoStates_Status infoStates_Status = (InfoStates_Status)bAPEntity;
        return this.states == infoStates_Status.states;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "InfoStates_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.states);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 38;
    }

    @Override
    public int getFunctionId() {
        return InfoStates_Status.functionId();
    }
}

