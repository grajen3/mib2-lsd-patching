/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SemidynamicRouteGuidance_Status$NewDistanceToDestination
implements BAPEntity {
    public int distance;
    public int unit;
    public static final int UNIT_METER;
    public static final int UNIT_KILOMETER;
    public static final int UNIT_YARD;
    public static final int UNIT_FEET;
    public static final int UNIT_MILE_UK_AND_US_STATUTE_MILE;
    public static final int UNIT_QUARTER_MILES_N_1_4MILE;
    public static final int UNIT_NOT_SUPPORTED_NO_INFORMATION_ABOUT_UNIT_AVAILABLE;
    public int typeOfDistance;
    public static final int TYPE_OF_DISTANCE_ROAD_DISTANCE;
    public static final int TYPE_OF_DISTANCE_LINEAR_DISTANCE;
    public static final int TYPE_OF_DISTANCE_DISTANCE_INVALID;

    public SemidynamicRouteGuidance_Status$NewDistanceToDestination() {
        this.internalReset();
        this.customInitialization();
    }

    public SemidynamicRouteGuidance_Status$NewDistanceToDestination(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.distance = 0;
        this.unit = 0;
        this.typeOfDistance = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SemidynamicRouteGuidance_Status$NewDistanceToDestination semidynamicRouteGuidance_Status$NewDistanceToDestination = (SemidynamicRouteGuidance_Status$NewDistanceToDestination)bAPEntity;
        return this.distance == semidynamicRouteGuidance_Status$NewDistanceToDestination.distance && this.unit == semidynamicRouteGuidance_Status$NewDistanceToDestination.unit && this.typeOfDistance == semidynamicRouteGuidance_Status$NewDistanceToDestination.typeOfDistance;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "NewDistanceToDestination:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushInt(this.distance);
        bitStream.pushByte((byte)this.unit);
        bitStream.pushByte((byte)this.typeOfDistance);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

