/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceToNextManeuver_Status$DistanceToNextManeuver
implements BAPEntity {
    public int distance;
    public int unit;
    public static final int UNIT_METER;
    public static final int UNIT_KILOMETER;
    public static final int UNIT_YARD;
    public static final int UNIT_FEET;
    public static final int UNIT_MILE_UK_AND_US_STATUTE_MILE;
    public static final int UNIT_QUARTER_MILES_N_1_4MILE;
    public static final int UNIT_NOT_SUPPORTED;

    public DistanceToNextManeuver_Status$DistanceToNextManeuver() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceToNextManeuver_Status$DistanceToNextManeuver(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.distance = 0;
        this.unit = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceToNextManeuver_Status$DistanceToNextManeuver distanceToNextManeuver_Status$DistanceToNextManeuver = (DistanceToNextManeuver_Status$DistanceToNextManeuver)bAPEntity;
        return this.distance == distanceToNextManeuver_Status$DistanceToNextManeuver.distance && this.unit == distanceToNextManeuver_Status$DistanceToNextManeuver.unit;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DistanceToNextManeuver:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushInt(this.distance);
        bitStream.pushByte((byte)this.unit);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

