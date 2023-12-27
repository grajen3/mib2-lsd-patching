/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceTimeToDestination_Status$DistanceToDestination
implements BAPEntity {
    public int distance;
    public int unit;
    public static final int UNIT_METERS;
    public static final int UNIT_KILOMETERS;
    public static final int UNIT_YARDS;
    public static final int UNIT_FEET;
    public static final int UNIT_MILES;
    public static final int UNIT_NOT_SUPPORTED;

    public DistanceTimeToDestination_Status$DistanceToDestination() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceTimeToDestination_Status$DistanceToDestination(BitStream bitStream) {
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
        DistanceTimeToDestination_Status$DistanceToDestination distanceTimeToDestination_Status$DistanceToDestination = (DistanceTimeToDestination_Status$DistanceToDestination)bAPEntity;
        return this.distance == distanceTimeToDestination_Status$DistanceToDestination.distance && this.unit == distanceTimeToDestination_Status$DistanceToDestination.unit;
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

