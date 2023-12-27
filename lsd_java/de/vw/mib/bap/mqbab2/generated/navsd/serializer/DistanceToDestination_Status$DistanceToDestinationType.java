/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceToDestination_Status$DistanceToDestinationType
implements BAPEntity {
    private static final int RESERVED_BIT_1__3_BITSIZE;
    public boolean distanceToStopover;

    public DistanceToDestination_Status$DistanceToDestinationType() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceToDestination_Status$DistanceToDestinationType(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.distanceToStopover = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceToDestination_Status$DistanceToDestinationType distanceToDestination_Status$DistanceToDestinationType = (DistanceToDestination_Status$DistanceToDestinationType)bAPEntity;
        return this.distanceToStopover == distanceToDestination_Status$DistanceToDestinationType.distanceToStopover;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DistanceToDestinationType:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(3);
        bitStream.pushBoolean(this.distanceToStopover);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

