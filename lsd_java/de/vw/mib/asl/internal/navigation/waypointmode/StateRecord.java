/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.waypointmode;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForFullFactoryReset;
import de.vw.mib.asl.internal.navigation.waypointmode.HsmTargetWayPointMode;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.NavTraceMemoryUtilization;
import org.dsi.ifc.navigation.PosPosition;

public class StateRecord
extends AbstractHsmState
implements TargetForFullFactoryReset {
    private final HsmTargetWayPointMode target;
    private NavLocation recordDest;
    private FactoryResetParticipantWithCallback fullFactoryResetParticipant;

    public StateRecord(HsmTargetWayPointMode hsmTargetWayPointMode, String string, HsmState hsmState) {
        super(hsmTargetWayPointMode.getHsm(), string, hsmState);
        this.target = hsmTargetWayPointMode;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState(this, "HSM_ENTRY");
                if (this.fullFactoryResetParticipant != null) break;
                this.fullFactoryResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForFullFactoryResetAndAddToService(this);
                break;
            }
            case 3: {
                this.target.traceState(this, "HSM_START");
                this.target.getDsiNotifier().startRecord(this.target.getDataPool().getRecordMode());
                this.recordDest = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getWpmLocation();
                boolean bl = this.recordDest != null;
                this.target.getModelNotifier().setRecordWithDestination(bl);
                this.target.getInternalAPINotifier().setRecordWithDestination(bl);
                this.setDestinationFlag();
                this.updateDistanceAndDirection(ASLNavigationUtilFactory.getNavigationUtilApi().getPosPosition());
                EventGeneric eventGeneric2 = ASLNavigationEventFactory.createEvent(912012544);
                ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric2);
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setWpmLocation(null);
                this.resetDestinationFlag();
                if (this.fullFactoryResetParticipant == null) break;
                ASLNavigationUtilFactory.getNavigationUtilApi().removeFullFactoryResetParticipantFromService(this.fullFactoryResetParticipant);
                this.fullFactoryResetParticipant = null;
                break;
            }
            case 1073744731: {
                this.target.traceState(this, "SET_MANUAL_WAY_POINT");
                this.target.getDsiNotifier().setManualWaypoint();
                break;
            }
            case 1073744730: {
                this.target.traceState(this, "STOP_RECORD");
                this.target.getDsiNotifier().stopRecord();
                break;
            }
            case 100100: {
                this.target.traceState(this, "EV_ASL_INT_STOP");
                this.target.getDsiNotifier().stopRecord();
                break;
            }
            case 4300004: {
                this.target.traceState(this, "ASL_SYSTEM_POWERMANAGEMENT_CLAMPSTATE_15");
                boolean bl = eventGeneric.getBoolean(0);
                if (bl) break;
                this.target.getDsiNotifier().stopRecord();
                break;
            }
            default: {
                return this.myParent;
            }
        }
        return null;
    }

    public HsmState dsiNavigationTrStartTraceRecordingResult(int n, long l, int n2) {
        if (n == 0) {
            this.target.getModelNotifier().setCurrentWPMModeRecord();
            this.target.getInternalAPINotifier().setCurrentWPMModeRecord();
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setWpmMode(2);
        } else {
            this.trans(this.target.stateDefault);
        }
        return this.myParent;
    }

    public HsmState dsiNavigationTrStopTraceRecordingResult(int n, long l, int n2) {
        if (n == 0) {
            this.target.getDsiNotifier().storeTour(this.target.getDataPool().getStoreTourName());
            this.target.getDataPool().setStoreTourName("");
        } else {
            this.target.getModelNotifier().setActionResultOk();
            this.trans(this.target.stateDefault);
        }
        return this.myParent;
    }

    public HsmState dsiNavigationTrStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
        this.target.getModelNotifier().setActionResultOk();
        this.trans(this.target.stateDefault);
        return this.myParent;
    }

    public HsmState dsiNavigationUpdateTrRecordingState(int n, int n2) {
        return this.myParent;
    }

    public HsmState dsiNavigationUpdateSoPosPosition(PosPosition posPosition, int n) {
        this.target.traceState(this, "updateSoPosPosition()");
        this.updateDistanceAndDirection(posPosition);
        return null;
    }

    private void updateDistanceAndDirection(PosPosition posPosition) {
        if (posPosition != null && this.recordDest != null) {
            int n = (int)((double)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDirectionIndexCCP2Loc(this.recordDest, 16) * 22.5);
            int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDistance(posPosition.getLongitude(), posPosition.getLatitude(), this.recordDest.getLongitude(), this.recordDest.getLatitude());
            if (n2 < 50) {
                this.target.traceState(this, "Distance to the destination < 50m -> stop recording");
                this.target.getDsiNotifier().stopRecord();
                n = 0;
                n2 = 0;
            }
            this.target.getModelNotifier().setDirectionToWP(n);
            this.target.getInternalAPINotifier().setDirectionToWP(n);
            this.target.getModelNotifier().setDistanceToWP(n2);
            this.target.getInternalAPINotifier().setDistanceToWP(n2);
        } else {
            this.target.traceState(this, "CCP or WPM location is null");
        }
    }

    public HsmState dsiNavigationUpdateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization, int n) {
        if (navTraceMemoryUtilization != null) {
            boolean bl;
            int n2 = (int)(navTraceMemoryUtilization.getMaximumNumberOfTrackPoints() - navTraceMemoryUtilization.getTotalNumberOfTrackPoints());
            boolean bl2 = bl = n2 <= 200;
            if (bl != this.target.getDataPool().isOldBelowThreshold() && bl && ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().isWpmActive()) {
                this.target.sendHMIEvent(49287168);
            }
            if (n2 == 0 && ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().isWpmActive()) {
                this.target.getDsiNotifier().stopRecord();
            }
        }
        return this.myParent;
    }

    private void resetDestinationFlag() {
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainWaypointModeRecordDestinationFlag(null, 29);
    }

    private void setDestinationFlag() {
        if (this.recordDest != null) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainWaypointModeRecordDestinationFlag(this.recordDest, 25);
        }
    }

    @Override
    public void handleFullFacotryReset() {
        this.target.getDsiNotifier().stopRecord();
        this.fullFactoryResetParticipant.notifyResetDone();
        this.trans(this.target.stateDefault);
        this.target.getHsm().activateTransition();
    }
}

