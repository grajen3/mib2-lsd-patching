/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SemidynamicRouteGuidance_Status$NewTimeToDestination
implements BAPEntity {
    public int timeInfoType;
    private static final int TIME_INFO_TYPE_BITSIZE;
    public static final int TIME_INFO_TYPE_TIME_TO_DESTINATION;
    public static final int TIME_INFO_TYPE_ARRIVAL_TIME;
    public static final int TIME_INFO_TYPE_ARRIVAL_TIME_IS_LOCAL_TIME_IN_ANOTHER_TIME_ZONE;
    public static final int TIME_INFO_TYPE_NOT_SUPPORTED_ANY_TIME_INFO_TYPE;
    public int navigationTimeFormat;
    private static final int NAVIGATION_TIME_FORMAT_BITSIZE;
    public static final int NAVIGATION_TIME_FORMAT_24_HOUR_FORMAT;
    public static final int NAVIGATION_TIME_FORMAT_12_HOUR_FORMAT;
    public int minute;
    public int hour;
    public int day;
    public int month;
    public int year;

    public SemidynamicRouteGuidance_Status$NewTimeToDestination() {
        this.internalReset();
        this.customInitialization();
    }

    public SemidynamicRouteGuidance_Status$NewTimeToDestination(BitStream bitStream) {
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
        SemidynamicRouteGuidance_Status$NewTimeToDestination semidynamicRouteGuidance_Status$NewTimeToDestination = (SemidynamicRouteGuidance_Status$NewTimeToDestination)bAPEntity;
        return this.timeInfoType == semidynamicRouteGuidance_Status$NewTimeToDestination.timeInfoType && this.navigationTimeFormat == semidynamicRouteGuidance_Status$NewTimeToDestination.navigationTimeFormat && this.minute == semidynamicRouteGuidance_Status$NewTimeToDestination.minute && this.hour == semidynamicRouteGuidance_Status$NewTimeToDestination.hour && this.day == semidynamicRouteGuidance_Status$NewTimeToDestination.day && this.month == semidynamicRouteGuidance_Status$NewTimeToDestination.month && this.year == semidynamicRouteGuidance_Status$NewTimeToDestination.year;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "NewTimeToDestination:";
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

