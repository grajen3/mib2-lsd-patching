/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceToNextManeuver_Status$ValidityInformation
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean distanceToNextManeuverValid;

    public DistanceToNextManeuver_Status$ValidityInformation() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceToNextManeuver_Status$ValidityInformation(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.distanceToNextManeuverValid = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceToNextManeuver_Status$ValidityInformation distanceToNextManeuver_Status$ValidityInformation = (DistanceToNextManeuver_Status$ValidityInformation)bAPEntity;
        return this.distanceToNextManeuverValid == distanceToNextManeuver_Status$ValidityInformation.distanceToNextManeuverValid;
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
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.distanceToNextManeuverValid);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

