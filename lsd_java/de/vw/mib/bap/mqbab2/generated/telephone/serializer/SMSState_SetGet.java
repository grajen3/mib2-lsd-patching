/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SMSState_SetGet
implements SetGetProperty {
    public int reserve_1;
    public int reserve_2;
    public int numberOfNewSms;

    public SMSState_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public SMSState_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserve_1 = 0;
        this.reserve_2 = 0;
        this.numberOfNewSms = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SMSState_SetGet sMSState_SetGet = (SMSState_SetGet)bAPEntity;
        return this.reserve_1 == sMSState_SetGet.reserve_1 && this.reserve_2 == sMSState_SetGet.reserve_2 && this.numberOfNewSms == sMSState_SetGet.numberOfNewSms;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SMSState_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserve_1 = bitStream.popFrontByte();
        this.reserve_2 = bitStream.popFrontByte();
        this.numberOfNewSms = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 55;
    }

    @Override
    public int getFunctionId() {
        return SMSState_SetGet.functionId();
    }
}

