/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ActiveTrip_Reserve3;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ActiveTrip_StartTime;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ActiveTrip_StopTime;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveTrip_SetGet
implements SetGetProperty {
    public int reserve1;
    public static final int RESERVE1_MIN;
    public int reserve2;
    public static final int RESERVE2_MIN;
    public ActiveTrip_Reserve3 reserve3 = new ActiveTrip_Reserve3();
    public ActiveTrip_StartTime startTime = new ActiveTrip_StartTime();
    public ActiveTrip_StopTime stopTime = new ActiveTrip_StopTime();
    public int mileageAtStart;
    public static final int MILEAGE_AT_START_MIN;
    public int reserve4;
    public static final int RESERVE4_MIN;
    public int reserve5;
    public static final int RESERVE5_MIN;

    public ActiveTrip_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveTrip_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserve1 = 0;
        this.reserve2 = 0;
        this.mileageAtStart = 1;
        this.reserve4 = 0;
        this.reserve5 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.reserve3.reset();
        this.startTime.reset();
        this.stopTime.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveTrip_SetGet activeTrip_SetGet = (ActiveTrip_SetGet)bAPEntity;
        return this.reserve1 == activeTrip_SetGet.reserve1 && this.reserve2 == activeTrip_SetGet.reserve2 && this.reserve3.equalTo(activeTrip_SetGet.reserve3) && this.startTime.equalTo(activeTrip_SetGet.startTime) && this.stopTime.equalTo(activeTrip_SetGet.stopTime) && this.mileageAtStart == activeTrip_SetGet.mileageAtStart && this.reserve4 == activeTrip_SetGet.reserve4 && this.reserve5 == activeTrip_SetGet.reserve5;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ActiveTrip_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.reserve1);
        bitStream.pushByte((byte)this.reserve2);
        this.reserve3.serialize(bitStream);
        this.startTime.serialize(bitStream);
        this.stopTime.serialize(bitStream);
        bitStream.pushInt(this.mileageAtStart);
        bitStream.pushInt(this.reserve4);
        bitStream.pushByte((byte)this.reserve5);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserve1 = bitStream.popFrontByte();
        this.reserve2 = bitStream.popFrontByte();
        this.reserve3.deserialize(bitStream);
        this.startTime.deserialize(bitStream);
        this.stopTime.deserialize(bitStream);
        this.mileageAtStart = bitStream.popFrontInt();
        this.reserve4 = bitStream.popFrontInt();
        this.reserve5 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 33;
    }

    @Override
    public int getFunctionId() {
        return ActiveTrip_SetGet.functionId();
    }
}

