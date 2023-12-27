/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceToDestination_Status$ValidityInformation
implements BAPEntity {
    private static final int RESERVED_BIT_1__3_BITSIZE;
    public boolean distanceToDestinationValid;

    public DistanceToDestination_Status$ValidityInformation() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceToDestination_Status$ValidityInformation(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.distanceToDestinationValid = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceToDestination_Status$ValidityInformation distanceToDestination_Status$ValidityInformation = (DistanceToDestination_Status$ValidityInformation)bAPEntity;
        return this.distanceToDestinationValid == distanceToDestination_Status$ValidityInformation.distanceToDestinationValid;
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
        bitStream.resetBits(3);
        bitStream.pushBoolean(this.distanceToDestinationValid);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

