/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.DistanceToNextManeuver_Status$BargraphInfo;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.DistanceToNextManeuver_Status$DistanceToNextManeuver;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceToNextManeuver_Status
implements StatusProperty {
    public final DistanceToNextManeuver_Status$DistanceToNextManeuver distanceToNextManeuver = new DistanceToNextManeuver_Status$DistanceToNextManeuver();
    public final DistanceToNextManeuver_Status$BargraphInfo bargraphInfo = new DistanceToNextManeuver_Status$BargraphInfo();

    public DistanceToNextManeuver_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceToNextManeuver_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.distanceToNextManeuver.reset();
        this.bargraphInfo.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceToNextManeuver_Status distanceToNextManeuver_Status = (DistanceToNextManeuver_Status)bAPEntity;
        return this.distanceToNextManeuver.equalTo(distanceToNextManeuver_Status.distanceToNextManeuver) && this.bargraphInfo.equalTo(distanceToNextManeuver_Status.bargraphInfo);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DistanceToNextManeuver_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.distanceToNextManeuver.serialize(bitStream);
        this.bargraphInfo.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 18;
    }

    @Override
    public int getFunctionId() {
        return DistanceToNextManeuver_Status.functionId();
    }
}

