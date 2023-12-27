/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ActiveMonitorings_Extension1;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ActiveMonitorings_Extension2;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ActiveMonitorings_GeneralMonitoringStatus;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ActiveMonitorings_MonitoringStatus;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveMonitorings_Status
implements StatusProperty {
    public ActiveMonitorings_GeneralMonitoringStatus generalMonitoringStatus = new ActiveMonitorings_GeneralMonitoringStatus();
    public ActiveMonitorings_Extension1 extension1 = new ActiveMonitorings_Extension1();
    public ActiveMonitorings_Extension2 extension2 = new ActiveMonitorings_Extension2();
    public ActiveMonitorings_MonitoringStatus monitoringStatus = new ActiveMonitorings_MonitoringStatus();

    public ActiveMonitorings_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveMonitorings_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.generalMonitoringStatus.reset();
        this.extension1.reset();
        this.extension2.reset();
        this.monitoringStatus.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveMonitorings_Status activeMonitorings_Status = (ActiveMonitorings_Status)bAPEntity;
        return this.generalMonitoringStatus.equalTo(activeMonitorings_Status.generalMonitoringStatus) && this.extension1.equalTo(activeMonitorings_Status.extension1) && this.extension2.equalTo(activeMonitorings_Status.extension2) && this.monitoringStatus.equalTo(activeMonitorings_Status.monitoringStatus);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ActiveMonitorings_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.generalMonitoringStatus.serialize(bitStream);
        this.extension1.serialize(bitStream);
        this.extension2.serialize(bitStream);
        this.monitoringStatus.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.generalMonitoringStatus.deserialize(bitStream);
        this.extension1.deserialize(bitStream);
        this.extension2.deserialize(bitStream);
        this.monitoringStatus.deserialize(bitStream);
    }

    public static int functionId() {
        return 23;
    }

    @Override
    public int getFunctionId() {
        return ActiveMonitorings_Status.functionId();
    }
}

