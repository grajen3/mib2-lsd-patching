/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.TpInfo_Status$MessageTime;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.TpInfo_Status$TpCounters;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TpInfo_Status
implements StatusProperty {
    public final TpInfo_Status$TpCounters tpCounters = new TpInfo_Status$TpCounters();
    public final TpInfo_Status$MessageTime messageTime = new TpInfo_Status$MessageTime();
    public final BAPString sendername = new BAPString(31);
    private static final int MAX_SENDERNAME_LENGTH;

    public TpInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TpInfo_Status(BitStream bitStream) {
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
        this.sendername.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TpInfo_Status tpInfo_Status = (TpInfo_Status)bAPEntity;
        return this.tpCounters.equalTo(tpInfo_Status.tpCounters) && this.messageTime.equalTo(tpInfo_Status.messageTime) && this.sendername.equalTo(tpInfo_Status.sendername);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TpInfo_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.tpCounters.serialize(bitStream);
        this.messageTime.serialize(bitStream);
        this.sendername.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 25;
    }

    @Override
    public int getFunctionId() {
        return TpInfo_Status.functionId();
    }
}

