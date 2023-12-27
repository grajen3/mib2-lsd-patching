/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class HeartBeat_Status
implements StatusProperty {
    public int heartBeatTime;
    public static final int HEART_BEAT_TIME_MIN;

    public HeartBeat_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public HeartBeat_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.heartBeatTime = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        HeartBeat_Status heartBeat_Status = (HeartBeat_Status)bAPEntity;
        return this.heartBeatTime == heartBeat_Status.heartBeatTime;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "HeartBeat_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.heartBeatTime);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.heartBeatTime = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 4;
    }

    @Override
    public int getFunctionId() {
        return HeartBeat_Status.functionId();
    }
}

