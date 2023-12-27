/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveMonitorings_GeneralMonitoringStatus
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean personalDataBasedServicesActive;
    public boolean positioningDataBasedServicesActive;

    public ActiveMonitorings_GeneralMonitoringStatus() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveMonitorings_GeneralMonitoringStatus(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.personalDataBasedServicesActive = false;
        this.positioningDataBasedServicesActive = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveMonitorings_GeneralMonitoringStatus activeMonitorings_GeneralMonitoringStatus = (ActiveMonitorings_GeneralMonitoringStatus)bAPEntity;
        return this.personalDataBasedServicesActive == activeMonitorings_GeneralMonitoringStatus.personalDataBasedServicesActive && this.positioningDataBasedServicesActive == activeMonitorings_GeneralMonitoringStatus.positioningDataBasedServicesActive;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ActiveMonitorings_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.personalDataBasedServicesActive);
        bitStream.pushBoolean(this.positioningDataBasedServicesActive);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.personalDataBasedServicesActive = bitStream.popFrontBoolean();
        this.positioningDataBasedServicesActive = bitStream.popFrontBoolean();
    }
}

