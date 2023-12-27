/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class InfoStates_Status
implements StatusProperty {
    public int states;
    public static final int STATES_NO_ERROR;
    public static final int STATES_ERROR_UNSPECIFIED;
    public static final int STATES_NO_CD;
    public static final int STATES_NO_DVD;
    public static final int STATES_NO_SD;
    public static final int STATES_CHECK_MEDIA;
    public static final int STATES_TEMPERATURE_TOO_HIGH;
    public static final int STATES_SD_CARD_FULL;
    public static final int STATES_SD_CARD_WRITE_PROTECTED;
    public static final int STATES_SIRIUS_NOT_SUBSCRIBED;
    public static final int STATES_XM_NOT_SUBSCRIBED;
    public static final int STATES_GCI_UPDATE_IN_PROGRESS;
    public static final int STATES_AUX_IN_AUDIO;
    public static final int STATES_AUX_IN_VIDEO;
    public static final int STATES_ENTER_CODE;
    public static final int STATES_PLEASE_WAIT;
    public static final int STATES_INSERT_DISK;
    public static final int STATES_SELECT_DISK;
    public static final int STATES_SELECT_CD_POSITION;
    public static final int STATES_REMOVE_DISK;
    public static final int STATES_SAVING_DATA;
    public static final int STATES_RETRIEVING_DATA;
    public static final int STATES_INTIALISING;
    public static final int STATES_SHUTTING_DOWN;
    public static final int STATES_CREATING_AUTO_STORE_LIST;
    public static final int STATES_CREATING_INITIAL_AUTO_STORE_LIST;
    public static final int STATES_NO_SAT_RADIO_AVAILABLE_NO_SAT_TUNER_CONNECTED;
    public static final int STATES_DIAGNOSIS_SESSION_ACTIVE;
    public static final int STATES_MDI_SOFTWARE_UPDATE_IN_PROGRESS;

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
        return 28;
    }

    @Override
    public int getFunctionId() {
        return InfoStates_Status.functionId();
    }
}

