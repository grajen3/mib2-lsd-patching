/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveMonitorings_MonitoringStatus
implements BAPEntity {
    public boolean reservedActive;
    public boolean driverEfficiencyReportActiveDf3_6;
    public boolean driverSLogbookActiveDf3_6;
    public boolean timefenceActiveDf3_6;
    public boolean vehicleLocationAndTrackingActiveDf3_6;
    public boolean valetAlertActive;
    public boolean speedAlertActive;
    public boolean geofenceActive;

    public ActiveMonitorings_MonitoringStatus() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveMonitorings_MonitoringStatus(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reservedActive = false;
        this.driverEfficiencyReportActiveDf3_6 = false;
        this.driverSLogbookActiveDf3_6 = false;
        this.timefenceActiveDf3_6 = false;
        this.vehicleLocationAndTrackingActiveDf3_6 = false;
        this.valetAlertActive = false;
        this.speedAlertActive = false;
        this.geofenceActive = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveMonitorings_MonitoringStatus activeMonitorings_MonitoringStatus = (ActiveMonitorings_MonitoringStatus)bAPEntity;
        return this.reservedActive == activeMonitorings_MonitoringStatus.reservedActive && this.driverEfficiencyReportActiveDf3_6 == activeMonitorings_MonitoringStatus.driverEfficiencyReportActiveDf3_6 && this.driverSLogbookActiveDf3_6 == activeMonitorings_MonitoringStatus.driverSLogbookActiveDf3_6 && this.timefenceActiveDf3_6 == activeMonitorings_MonitoringStatus.timefenceActiveDf3_6 && this.vehicleLocationAndTrackingActiveDf3_6 == activeMonitorings_MonitoringStatus.vehicleLocationAndTrackingActiveDf3_6 && this.valetAlertActive == activeMonitorings_MonitoringStatus.valetAlertActive && this.speedAlertActive == activeMonitorings_MonitoringStatus.speedAlertActive && this.geofenceActive == activeMonitorings_MonitoringStatus.geofenceActive;
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
        bitStream.pushBoolean(this.reservedActive);
        bitStream.pushBoolean(this.driverEfficiencyReportActiveDf3_6);
        bitStream.pushBoolean(this.driverSLogbookActiveDf3_6);
        bitStream.pushBoolean(this.timefenceActiveDf3_6);
        bitStream.pushBoolean(this.vehicleLocationAndTrackingActiveDf3_6);
        bitStream.pushBoolean(this.valetAlertActive);
        bitStream.pushBoolean(this.speedAlertActive);
        bitStream.pushBoolean(this.geofenceActive);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reservedActive = bitStream.popFrontBoolean();
        this.driverEfficiencyReportActiveDf3_6 = bitStream.popFrontBoolean();
        this.driverSLogbookActiveDf3_6 = bitStream.popFrontBoolean();
        this.timefenceActiveDf3_6 = bitStream.popFrontBoolean();
        this.vehicleLocationAndTrackingActiveDf3_6 = bitStream.popFrontBoolean();
        this.valetAlertActive = bitStream.popFrontBoolean();
        this.speedAlertActive = bitStream.popFrontBoolean();
        this.geofenceActive = bitStream.popFrontBoolean();
    }
}

