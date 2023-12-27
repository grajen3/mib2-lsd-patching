/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.DistanceTimeToDestination_Status$DistanceToDestination;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.DistanceTimeToDestination_Status$TimeInfo;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceTimeToDestination_Status
implements StatusProperty {
    public final DistanceTimeToDestination_Status$DistanceToDestination distanceToDestination = new DistanceTimeToDestination_Status$DistanceToDestination();
    public final DistanceTimeToDestination_Status$TimeInfo timeInfo = new DistanceTimeToDestination_Status$TimeInfo();

    public DistanceTimeToDestination_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceTimeToDestination_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.distanceToDestination.reset();
        this.timeInfo.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceTimeToDestination_Status distanceTimeToDestination_Status = (DistanceTimeToDestination_Status)bAPEntity;
        return this.distanceToDestination.equalTo(distanceTimeToDestination_Status.distanceToDestination) && this.timeInfo.equalTo(distanceTimeToDestination_Status.timeInfo);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DistanceTimeToDestination_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.distanceToDestination.serialize(bitStream);
        this.timeInfo.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 21;
    }

    @Override
    public int getFunctionId() {
        return DistanceTimeToDestination_Status.functionId();
    }
}

