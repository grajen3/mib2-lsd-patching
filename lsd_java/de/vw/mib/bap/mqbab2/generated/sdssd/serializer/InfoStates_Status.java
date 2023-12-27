/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.sdssd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class InfoStates_Status
implements StatusProperty {
    public int states;
    public static final int STATES_NO_ERROR_NO_INFORMATION;
    public static final int STATES_SDS_NOT_AVAILABLE;
    public static final int STATES_LANGUAGE_CHANGE_ACTIVE;
    public static final int STATES_SDS_DOMAIN_NOT_AVAILABLE;
    public static final int STATES_SDS_NOT_AVAILABLE_SWAP_KEY_MISSING;
    public static final int STATES_UNKNOWN;
    public static final int EXTENSION1_MIN;
    public int extension1;
    public static final int EXTENSION2_MIN;
    public int extension2;
    public static final int EXTENSION3_MIN;
    public int extension3;
    public static final int EXTENSION4_MIN;
    public int extension4;
    public static final int EXTENSION5_MIN;
    public int extension5;

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
        this.extension1 = 0;
        this.extension2 = 0;
        this.extension3 = 0;
        this.extension4 = 0;
        this.extension5 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        InfoStates_Status infoStates_Status = (InfoStates_Status)bAPEntity;
        return this.states == infoStates_Status.states && this.extension1 == infoStates_Status.extension1 && this.extension2 == infoStates_Status.extension2 && this.extension3 == infoStates_Status.extension3 && this.extension4 == infoStates_Status.extension4 && this.extension5 == infoStates_Status.extension5;
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
        bitStream.pushByte((byte)this.extension1);
        bitStream.pushByte((byte)this.extension2);
        bitStream.pushByte((byte)this.extension3);
        bitStream.pushByte((byte)this.extension4);
        bitStream.pushByte((byte)this.extension5);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 20;
    }

    @Override
    public int getFunctionId() {
        return InfoStates_Status.functionId();
    }
}

