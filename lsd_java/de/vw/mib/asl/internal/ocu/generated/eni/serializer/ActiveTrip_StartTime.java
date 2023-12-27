/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveTrip_StartTime
implements BAPEntity {
    public static final int YEAR_MIN;
    public int year;
    public static final int MONTH_MIN;
    public int month;
    public static final int DAY_MIN;
    public int day;
    public static final int HOUR_MIN;
    public int hour;
    public static final int MINUTE_MIN;
    public int minute;
    public static final int SECOND_MIN;
    public int second;

    public ActiveTrip_StartTime() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveTrip_StartTime(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.year = 2000;
        this.month = 0;
        this.day = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveTrip_StartTime activeTrip_StartTime = (ActiveTrip_StartTime)bAPEntity;
        return this.year == activeTrip_StartTime.year && this.month == activeTrip_StartTime.month && this.day == activeTrip_StartTime.day && this.hour == activeTrip_StartTime.hour && this.minute == activeTrip_StartTime.minute && this.second == activeTrip_StartTime.second;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ActiveTrip_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.year);
        bitStream.pushByte((byte)this.month);
        bitStream.pushByte((byte)this.day);
        bitStream.pushByte((byte)this.hour);
        bitStream.pushByte((byte)this.minute);
        bitStream.pushByte((byte)this.second);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.year = bitStream.popFrontByte();
        this.month = bitStream.popFrontByte();
        this.day = bitStream.popFrontByte();
        this.hour = bitStream.popFrontByte();
        this.minute = bitStream.popFrontByte();
        this.second = bitStream.popFrontByte();
    }
}

