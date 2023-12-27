/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TimeToDestination_Status$ValidityInformation
implements BAPEntity {
    private static final int RESERVED_BIT_6__7_BITSIZE;
    public boolean timeInfo_YearIsAvailableToBeDisplayed;
    public boolean timeInfo_MonthIsAvailableToBeDisplayed;
    public boolean timeInfo_DayIsAvailableToBeDisplayed;
    public boolean timeInfo_HourIsValid;
    public boolean timeInfo_MinuteIsValid;
    public boolean reserved_bit_0;

    public TimeToDestination_Status$ValidityInformation() {
        this.internalReset();
        this.customInitialization();
    }

    public TimeToDestination_Status$ValidityInformation(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.timeInfo_YearIsAvailableToBeDisplayed = false;
        this.timeInfo_MonthIsAvailableToBeDisplayed = false;
        this.timeInfo_DayIsAvailableToBeDisplayed = false;
        this.timeInfo_HourIsValid = false;
        this.timeInfo_MinuteIsValid = false;
        this.reserved_bit_0 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TimeToDestination_Status$ValidityInformation timeToDestination_Status$ValidityInformation = (TimeToDestination_Status$ValidityInformation)bAPEntity;
        return this.timeInfo_YearIsAvailableToBeDisplayed == timeToDestination_Status$ValidityInformation.timeInfo_YearIsAvailableToBeDisplayed && this.timeInfo_MonthIsAvailableToBeDisplayed == timeToDestination_Status$ValidityInformation.timeInfo_MonthIsAvailableToBeDisplayed && this.timeInfo_DayIsAvailableToBeDisplayed == timeToDestination_Status$ValidityInformation.timeInfo_DayIsAvailableToBeDisplayed && this.timeInfo_HourIsValid == timeToDestination_Status$ValidityInformation.timeInfo_HourIsValid && this.timeInfo_MinuteIsValid == timeToDestination_Status$ValidityInformation.timeInfo_MinuteIsValid && this.reserved_bit_0 == timeToDestination_Status$ValidityInformation.reserved_bit_0;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ValidityInformation:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(2);
        bitStream.pushBoolean(this.timeInfo_YearIsAvailableToBeDisplayed);
        bitStream.pushBoolean(this.timeInfo_MonthIsAvailableToBeDisplayed);
        bitStream.pushBoolean(this.timeInfo_DayIsAvailableToBeDisplayed);
        bitStream.pushBoolean(this.timeInfo_HourIsValid);
        bitStream.pushBoolean(this.timeInfo_MinuteIsValid);
        bitStream.pushBoolean(this.reserved_bit_0);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

