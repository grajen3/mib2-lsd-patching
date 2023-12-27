/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.internal.ocu.common.api.services.InternalServiceProvider;
import de.vw.mib.asl.internal.ocu.eni.api.online.ActiveMonitoringsServiceListener;
import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ActiveMonitorings_GeneralMonitoringStatus;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ActiveMonitorings_MonitoringStatus;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ActiveMonitorings_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public final class ActiveMonitorings
extends ENIFunction
implements PropertyListener,
InternalServiceProvider {
    private ActiveMonitorings_MonitoringStatus _monitoringStatus;
    private ActiveMonitorings_GeneralMonitoringStatus _generalMonitoringStatus;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$ActiveMonitoringsServiceListener;

    private ActiveMonitorings_MonitoringStatus getMonitoringStatus() {
        if (this._monitoringStatus == null) {
            this._monitoringStatus = new ActiveMonitorings_MonitoringStatus();
        }
        return this._monitoringStatus;
    }

    private ActiveMonitorings_GeneralMonitoringStatus getGeneralMonitoringStatus() {
        if (this._generalMonitoringStatus == null) {
            this._generalMonitoringStatus = new ActiveMonitorings_GeneralMonitoringStatus();
        }
        return this._generalMonitoringStatus;
    }

    private void setMonitoringStatus(ActiveMonitorings_MonitoringStatus activeMonitorings_MonitoringStatus) {
        this._monitoringStatus = activeMonitorings_MonitoringStatus;
    }

    private void setGeneralMonitoringStatus(ActiveMonitorings_GeneralMonitoringStatus activeMonitorings_GeneralMonitoringStatus) {
        this._generalMonitoringStatus = activeMonitorings_GeneralMonitoringStatus;
    }

    private ActiveMonitoringsServiceListener getActiveMonitoringsServiceListener() {
        return (ActiveMonitoringsServiceListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$eni$api$online$ActiveMonitoringsServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ActiveMonitoringsServiceListener = ActiveMonitorings.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ActiveMonitoringsServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ActiveMonitoringsServiceListener);
    }

    private void _informServices() {
        ActiveMonitorings_MonitoringStatus activeMonitorings_MonitoringStatus = this.getMonitoringStatus();
        ActiveMonitorings_GeneralMonitoringStatus activeMonitorings_GeneralMonitoringStatus = this.getGeneralMonitoringStatus();
        this.getActiveMonitoringsServiceListener().updateEniActiveMonitorings(activeMonitorings_MonitoringStatus.valetAlertActive, activeMonitorings_MonitoringStatus.speedAlertActive, activeMonitorings_MonitoringStatus.geofenceActive, activeMonitorings_MonitoringStatus.vehicleLocationAndTrackingActiveDf3_6, activeMonitorings_MonitoringStatus.timefenceActiveDf3_6, activeMonitorings_MonitoringStatus.driverSLogbookActiveDf3_6, activeMonitorings_MonitoringStatus.driverEfficiencyReportActiveDf3_6, activeMonitorings_GeneralMonitoringStatus.personalDataBasedServicesActive, activeMonitorings_GeneralMonitoringStatus.positioningDataBasedServicesActive);
        if (this.getLogger().isTraceEnabled(256)) {
            this.getLogger().trace(256).append("ActiveMonitorings: Update with new monitoringStatus=").append("geofenceActive=").append(activeMonitorings_MonitoringStatus.geofenceActive).append(", speedAlertActive=").append(activeMonitorings_MonitoringStatus.speedAlertActive).append(", valetAlertActive=").append(activeMonitorings_MonitoringStatus.valetAlertActive).append(", vehicleLocationAndTrackingActive=").append(activeMonitorings_MonitoringStatus.vehicleLocationAndTrackingActiveDf3_6).append(", timefenceActive=").append(activeMonitorings_MonitoringStatus.timefenceActiveDf3_6).append(", driverSLogbookActive=").append(activeMonitorings_MonitoringStatus.driverSLogbookActiveDf3_6).append(", driverEfficiencyReportActive=").append(activeMonitorings_MonitoringStatus.driverEfficiencyReportActiveDf3_6).append(", personalDataBasedServicesActive=").append(activeMonitorings_GeneralMonitoringStatus.personalDataBasedServicesActive).append(", positioningDataBasedServicesActive=").append(activeMonitorings_GeneralMonitoringStatus.positioningDataBasedServicesActive).log();
        }
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
        } else {
            this.getDelegate().registerServiceProviderListener(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$ActiveMonitoringsServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ActiveMonitoringsServiceListener = ActiveMonitorings.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ActiveMonitoringsServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ActiveMonitoringsServiceListener, ActiveMonitoringsServiceListener.SERVICE_CONSTANTS);
        }
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public int getFunctionId() {
        return 23;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        ActiveMonitorings_Status activeMonitorings_Status = (ActiveMonitorings_Status)bAPEntity;
        this.setMonitoringStatus(activeMonitorings_Status.monitoringStatus);
        this.setGeneralMonitoringStatus(activeMonitorings_Status.generalMonitoringStatus);
        this._informServices();
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }

    @Override
    public void serviceListenerRegistered(int n) {
        if (ActiveMonitoringsServiceListener.SERVICE_CONSTANTS[0] == n) {
            this._informServices();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

