/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.DistanceToDestination_Status$DistanceToDestination;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.DistanceToDestination_Status$DistanceToDestinationType;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.DistanceToDestination_Status$ValidityInformation;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceToDestination_Status
implements StatusProperty {
    public final DistanceToDestination_Status$DistanceToDestination distanceToDestination = new DistanceToDestination_Status$DistanceToDestination();
    public final DistanceToDestination_Status$DistanceToDestinationType distanceToDestinationType = new DistanceToDestination_Status$DistanceToDestinationType();
    public final DistanceToDestination_Status$ValidityInformation validityInformation = new DistanceToDestination_Status$ValidityInformation();

    public DistanceToDestination_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceToDestination_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.distanceToDestination.reset();
        this.distanceToDestinationType.reset();
        this.validityInformation.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceToDestination_Status distanceToDestination_Status = (DistanceToDestination_Status)bAPEntity;
        return this.distanceToDestination.equalTo(distanceToDestination_Status.distanceToDestination) && this.distanceToDestinationType.equalTo(distanceToDestination_Status.distanceToDestinationType) && this.validityInformation.equalTo(distanceToDestination_Status.validityInformation);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DistanceToDestination_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.distanceToDestination.serialize(bitStream);
        this.distanceToDestinationType.serialize(bitStream);
        this.validityInformation.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 21;
    }

    @Override
    public int getFunctionId() {
        return DistanceToDestination_Status.functionId();
    }
}

