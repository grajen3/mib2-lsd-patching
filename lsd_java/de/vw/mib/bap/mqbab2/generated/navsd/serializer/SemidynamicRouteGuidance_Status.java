/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.SemidynamicRouteGuidance_Status$Delay;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.SemidynamicRouteGuidance_Status$NewDistanceToDestination;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.SemidynamicRouteGuidance_Status$NewTimeToDestination;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.SemidynamicRouteGuidance_Status$TrafficImpact;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.SemidynamicRouteGuidance_Status$ValidityInformation;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SemidynamicRouteGuidance_Status
implements StatusProperty {
    public final SemidynamicRouteGuidance_Status$TrafficImpact trafficImpact = new SemidynamicRouteGuidance_Status$TrafficImpact();
    public final SemidynamicRouteGuidance_Status$Delay delay = new SemidynamicRouteGuidance_Status$Delay();
    public final SemidynamicRouteGuidance_Status$NewDistanceToDestination newDistanceToDestination = new SemidynamicRouteGuidance_Status$NewDistanceToDestination();
    public final SemidynamicRouteGuidance_Status$NewTimeToDestination newTimeToDestination = new SemidynamicRouteGuidance_Status$NewTimeToDestination();
    public final SemidynamicRouteGuidance_Status$ValidityInformation validityInformation = new SemidynamicRouteGuidance_Status$ValidityInformation();

    public SemidynamicRouteGuidance_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SemidynamicRouteGuidance_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.trafficImpact.reset();
        this.delay.reset();
        this.newDistanceToDestination.reset();
        this.newTimeToDestination.reset();
        this.validityInformation.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SemidynamicRouteGuidance_Status semidynamicRouteGuidance_Status = (SemidynamicRouteGuidance_Status)bAPEntity;
        return this.trafficImpact.equalTo(semidynamicRouteGuidance_Status.trafficImpact) && this.delay.equalTo(semidynamicRouteGuidance_Status.delay) && this.newDistanceToDestination.equalTo(semidynamicRouteGuidance_Status.newDistanceToDestination) && this.newTimeToDestination.equalTo(semidynamicRouteGuidance_Status.newTimeToDestination) && this.validityInformation.equalTo(semidynamicRouteGuidance_Status.validityInformation);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SemidynamicRouteGuidance_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.trafficImpact.serialize(bitStream);
        this.delay.serialize(bitStream);
        this.newDistanceToDestination.serialize(bitStream);
        this.newTimeToDestination.serialize(bitStream);
        this.validityInformation.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 50;
    }

    @Override
    public int getFunctionId() {
        return SemidynamicRouteGuidance_Status.functionId();
    }
}

