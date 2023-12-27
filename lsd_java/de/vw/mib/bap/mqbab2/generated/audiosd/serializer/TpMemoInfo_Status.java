/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.TpMemoInfo_MessageTime;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.TpMemoInfo_TpCounters;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TpMemoInfo_Status
implements StatusProperty {
    public TpMemoInfo_TpCounters tpCounters = new TpMemoInfo_TpCounters();
    public TpMemoInfo_MessageTime messageTime = new TpMemoInfo_MessageTime();
    public final BAPString stationName = new BAPString(49);
    private static final int MAX_STATIONNAME_LENGTH;

    public TpMemoInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TpMemoInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.tpCounters.reset();
        this.messageTime.reset();
        this.stationName.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TpMemoInfo_Status tpMemoInfo_Status = (TpMemoInfo_Status)bAPEntity;
        return this.tpCounters.equalTo(tpMemoInfo_Status.tpCounters) && this.messageTime.equalTo(tpMemoInfo_Status.messageTime) && this.stationName.equalTo(tpMemoInfo_Status.stationName);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TpMemoInfo_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.tpCounters.serialize(bitStream);
        this.messageTime.serialize(bitStream);
        this.stationName.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.tpCounters.deserialize(bitStream);
        this.messageTime.deserialize(bitStream);
        this.stationName.deserialize(bitStream);
    }

    public static int functionId() {
        return 26;
    }

    @Override
    public int getFunctionId() {
        return TpMemoInfo_Status.functionId();
    }
}

