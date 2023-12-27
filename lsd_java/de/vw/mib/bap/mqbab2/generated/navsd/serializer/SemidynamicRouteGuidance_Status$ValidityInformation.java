/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SemidynamicRouteGuidance_Status$ValidityInformation
implements BAPEntity {
    private static final int RESERVED_BIT_6__7_BITSIZE;
    public boolean newTimeToDestination_YearIsAvailableToBeDisplayed;
    public boolean newTimeToDestination_MonthIsAvailableToBeDisplayed;
    public boolean newTimeToDestination_DayIsAvailableToBeDisplayed;
    public boolean newTimeToDestination_HourIsValid;
    public boolean newTimeToDestination_MinuteIsValid;
    public boolean newDistanceToDestinationIsValid;

    public SemidynamicRouteGuidance_Status$ValidityInformation() {
        this.internalReset();
        this.customInitialization();
    }

    public SemidynamicRouteGuidance_Status$ValidityInformation(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.newTimeToDestination_YearIsAvailableToBeDisplayed = false;
        this.newTimeToDestination_MonthIsAvailableToBeDisplayed = false;
        this.newTimeToDestination_DayIsAvailableToBeDisplayed = false;
        this.newTimeToDestination_HourIsValid = false;
        this.newTimeToDestination_MinuteIsValid = false;
        this.newDistanceToDestinationIsValid = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SemidynamicRouteGuidance_Status$ValidityInformation semidynamicRouteGuidance_Status$ValidityInformation = (SemidynamicRouteGuidance_Status$ValidityInformation)bAPEntity;
        return this.newTimeToDestination_YearIsAvailableToBeDisplayed == semidynamicRouteGuidance_Status$ValidityInformation.newTimeToDestination_YearIsAvailableToBeDisplayed && this.newTimeToDestination_MonthIsAvailableToBeDisplayed == semidynamicRouteGuidance_Status$ValidityInformation.newTimeToDestination_MonthIsAvailableToBeDisplayed && this.newTimeToDestination_DayIsAvailableToBeDisplayed == semidynamicRouteGuidance_Status$ValidityInformation.newTimeToDestination_DayIsAvailableToBeDisplayed && this.newTimeToDestination_HourIsValid == semidynamicRouteGuidance_Status$ValidityInformation.newTimeToDestination_HourIsValid && this.newTimeToDestination_MinuteIsValid == semidynamicRouteGuidance_Status$ValidityInformation.newTimeToDestination_MinuteIsValid && this.newDistanceToDestinationIsValid == semidynamicRouteGuidance_Status$ValidityInformation.newDistanceToDestinationIsValid;
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
        bitStream.pushBoolean(this.newTimeToDestination_YearIsAvailableToBeDisplayed);
        bitStream.pushBoolean(this.newTimeToDestination_MonthIsAvailableToBeDisplayed);
        bitStream.pushBoolean(this.newTimeToDestination_DayIsAvailableToBeDisplayed);
        bitStream.pushBoolean(this.newTimeToDestination_HourIsValid);
        bitStream.pushBoolean(this.newTimeToDestination_MinuteIsValid);
        bitStream.pushBoolean(this.newDistanceToDestinationIsValid);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

