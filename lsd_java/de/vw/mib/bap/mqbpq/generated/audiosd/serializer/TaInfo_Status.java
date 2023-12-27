/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.TaInfo_Status$TaMessageOnOff;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TaInfo_Status
implements StatusProperty {
    public final TaInfo_Status$TaMessageOnOff taMessageOnOff = new TaInfo_Status$TaMessageOnOff();
    public final BAPString sendername = new BAPString(31);
    private static final int MAX_SENDERNAME_LENGTH;

    public TaInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TaInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.taMessageOnOff.reset();
        this.sendername.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TaInfo_Status taInfo_Status = (TaInfo_Status)bAPEntity;
        return this.taMessageOnOff.equalTo(taInfo_Status.taMessageOnOff) && this.sendername.equalTo(taInfo_Status.sendername);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TaInfo_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.taMessageOnOff.serialize(bitStream);
        this.sendername.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 26;
    }

    @Override
    public int getFunctionId() {
        return TaInfo_Status.functionId();
    }
}

