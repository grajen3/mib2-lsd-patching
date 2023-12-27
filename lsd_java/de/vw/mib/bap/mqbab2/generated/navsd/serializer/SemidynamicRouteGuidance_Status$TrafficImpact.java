/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SemidynamicRouteGuidance_Status$TrafficImpact
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean alternativeRouteAvailable;
    public boolean trafficImpactOnCurrentRoute;

    public SemidynamicRouteGuidance_Status$TrafficImpact() {
        this.internalReset();
        this.customInitialization();
    }

    public SemidynamicRouteGuidance_Status$TrafficImpact(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.alternativeRouteAvailable = false;
        this.trafficImpactOnCurrentRoute = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SemidynamicRouteGuidance_Status$TrafficImpact semidynamicRouteGuidance_Status$TrafficImpact = (SemidynamicRouteGuidance_Status$TrafficImpact)bAPEntity;
        return this.alternativeRouteAvailable == semidynamicRouteGuidance_Status$TrafficImpact.alternativeRouteAvailable && this.trafficImpactOnCurrentRoute == semidynamicRouteGuidance_Status$TrafficImpact.trafficImpactOnCurrentRoute;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TrafficImpact:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.alternativeRouteAvailable);
        bitStream.pushBoolean(this.trafficImpactOnCurrentRoute);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

