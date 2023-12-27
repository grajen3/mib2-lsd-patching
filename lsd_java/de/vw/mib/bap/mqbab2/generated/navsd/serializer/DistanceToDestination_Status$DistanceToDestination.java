/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceToDestination_Status$DistanceToDestination
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

    public DistanceToDestination_Status$DistanceToDestination() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceToDestination_Status$DistanceToDestination(BitStream bitStream) {
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
        DistanceToDestination_Status$DistanceToDestination distanceToDestination_Status$DistanceToDestination = (DistanceToDestination_Status$DistanceToDestination)bAPEntity;
        return this.distance == distanceToDestination_Status$DistanceToDestination.distance && this.unit == distanceToDestination_Status$DistanceToDestination.unit;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DistanceToDestination:";
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

