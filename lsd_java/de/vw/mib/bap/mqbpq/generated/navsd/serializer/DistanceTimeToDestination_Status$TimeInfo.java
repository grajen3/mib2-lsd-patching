/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceTimeToDestination_Status$TimeInfo
implements BAPEntity {
    public int timeInfoType;
    private static final int TIME_INFO_TYPE_BITSIZE;
    public static final int TIME_INFO_TYPE_TIME_TO_DESTINATION;
    public static final int TIME_INFO_TYPE_ARRIVAL_TIME;
    public static final int TIME_INFO_TYPE_NOT_SUPPORTED;
    public int navigationTimeFormat;
    private static final int NAVIGATION_TIME_FORMAT_BITSIZE;
    public static final int NAVIGATION_TIME_FORMAT_24_HOUR_FORMAT;
    public static final int NAVIGATION_TIME_FORMAT_12_HOUR_FORMAT;
    public int minute;
    public int hour;
    public int day;
    public int month;
    public int year;

    public DistanceTimeToDestination_Status$TimeInfo() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceTimeToDestination_Status$TimeInfo(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.timeInfoType = 0;
        this.navigationTimeFormat = 0;
        this.minute = 0;
        this.hour = 0;
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceTimeToDestination_Status$TimeInfo distanceTimeToDestination_Status$TimeInfo = (DistanceTimeToDestination_Status$TimeInfo)bAPEntity;
        return this.timeInfoType == distanceTimeToDestination_Status$TimeInfo.timeInfoType && this.navigationTimeFormat == distanceTimeToDestination_Status$TimeInfo.navigationTimeFormat && this.minute == distanceTimeToDestination_Status$TimeInfo.minute && this.hour == distanceTimeToDestination_Status$TimeInfo.hour && this.day == distanceTimeToDestination_Status$TimeInfo.day && this.month == distanceTimeToDestination_Status$TimeInfo.month && this.year == distanceTimeToDestination_Status$TimeInfo.year;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TimeInfo:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.timeInfoType);
        bitStream.pushBits(4, this.navigationTimeFormat);
        bitStream.pushByte((byte)this.minute);
        bitStream.pushByte((byte)this.hour);
        bitStream.pushByte((byte)this.day);
        bitStream.pushByte((byte)this.month);
        bitStream.pushByte((byte)this.year);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

