/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class RouteGuidance_Status_Status
implements StatusProperty {
    public int rg_Status;
    public static final int RG_STATUS_RG_NOT_ACTIVE;
    public static final int RG_STATUS_RG_ACTIVE;
    public static final int RG_STATUS_NOT_SUPPORTED;

    public RouteGuidance_Status_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public RouteGuidance_Status_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.rg_Status = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        RouteGuidance_Status_Status routeGuidance_Status_Status = (RouteGuidance_Status_Status)bAPEntity;
        return this.rg_Status == routeGuidance_Status_Status.rg_Status;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "RouteGuidance_Status_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.rg_Status);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 17;
    }

    @Override
    public int getFunctionId() {
        return RouteGuidance_Status_Status.functionId();
    }
}

