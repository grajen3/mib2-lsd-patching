/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.DSIMapViewerManagerClientData;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.map.DSIMapViewerControl;

public class DSIMapViewerControlSwitchMapviewerStateMain
extends AbstractHsmState
implements TargetForResetNavigation {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerControlSwitchMapviewerStateMain]");
    private final DSIMapViewerControlSwitchMapviewerTargetHSM target;
    private FactoryResetParticipantWithCallback navigationResetParticipant;
    private int changeMapTypeMapViewerNewId;

    public DSIMapViewerControlSwitchMapviewerStateMain(DSIMapViewerControlSwitchMapviewerTargetHSM dSIMapViewerControlSwitchMapviewerTargetHSM, String string, HsmState hsmState) {
        super(dSIMapViewerControlSwitchMapviewerTargetHSM.getHsm(), string, hsmState);
        this.target = dSIMapViewerControlSwitchMapviewerTargetHSM;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 1073744487: {
                this.handleASLNavigationOnlineServiceChangeMapTypeAndRemoveRubberbandMarker(eventGeneric);
                break;
            }
            case 3499019: {
                this.handleGoogleEarthMapViewerRemove();
                break;
            }
            case 3499018: {
                this.handleGoogleEarthMapViewerReady();
                break;
            }
            case 100101: {
                this.handleChangeMapType();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleASLNavigationOnlineServiceChangeMapTypeAndRemoveRubberbandMarker(EventGeneric eventGeneric) {
        if (this.target.datapool.isSwitchInProgress()) {
            this.logger.warn("a MapViewer switch is already in progress");
            return;
        }
        this.changeMapTypeMapViewerNewId = eventGeneric.getInt(0);
        if (this.changeMapTypeMapViewerNewId == 1) {
            this.target.sendInternalEvent(-1354034176, 75956480);
        } else {
            this.handleChangeMapType();
        }
    }

    private void handleChangeMapType() {
        int n = this.target.datapool.getMapViewerNewId();
        List list = this.target.managerTarget.getMapTargtesMain();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            DSIMapViewerManagerClientData dSIMapViewerManagerClientData = (DSIMapViewerManagerClientData)iterator.next();
            DSIMapViewerControl[] dSIMapViewerControlArray = dSIMapViewerManagerClientData.getMapViewerControlAvailable();
            if (this.changeMapTypeMapViewerNewId < dSIMapViewerControlArray.length) continue;
            this.logger.makeError().append("handleASLNavigationOnlineServiceChangeMapType(mapViewerNewId=").append(this.changeMapTypeMapViewerNewId).append(", mapViewerCurrentId=").append(n).append(") tried to switch to a map viewer that was not existent in the mapViewersAvailable.").log();
            return;
        }
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapLastTypeChanged(n);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapTypeChanged(this.changeMapTypeMapViewerNewId);
        this.target.datapool.setSwitchInProgress(true);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationOnlineServiceChangeMapType(mapViewerNewId=").append(this.changeMapTypeMapViewerNewId).append(", mapViewerCurrentId=").append(n).append(")").log();
        }
        switch (this.changeMapTypeMapViewerNewId) {
            case 0: {
                this.target.datapool.setMapViewerNewId(0);
                break;
            }
            case 1: {
                this.target.datapool.setMapViewerNewId(1);
                break;
            }
            default: {
                this.logger.makeError().append("The mapViewerId '").append(this.changeMapTypeMapViewerNewId).append("' is not valid, using ONBOARD").log();
                this.target.datapool.setMapViewerNewId(0);
            }
        }
        this.target.transStateSwitchSuspend();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        this.logger.trace("handleDefault()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
        if (this.navigationResetParticipant == null) {
            this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
        }
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        if (this.navigationResetParticipant != null) {
            ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
            this.navigationResetParticipant = null;
        }
    }

    private void handleGoogleEarthMapViewerReady() {
        this.logger.trace("handleGoogleEarthMapViewerReady()");
        this.target.transStateGoogleEarthStart();
    }

    private void handleGoogleEarthMapViewerRemove() {
        this.logger.trace("handleGoogleEarthMapViewerRemove()");
        this.target.transStateGoogleEarthStop();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    @Override
    public void handleNavigationSettingsReset() {
        this.logger.trace("gotEventResetNavigationSettings()");
        if (!this.target.datapool.isGoogleEarthRegistered()) {
            this.logger.warn("The Google Earth Service is not available, we can't call DSIMapViewerGoogleCtrl.requestClearCache()");
            return;
        }
        int n = this.target.datapool.getDsiMapViewerControlCurrentMainMapInstanceId();
        if (n == 0) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainGoogleEarthClearCache();
            this.navigationResetParticipant.notifyResetDone();
        } else {
            this.logger.trace("Google Earth is currently active, we have to switch to the standard map before we can call requestClearCache()");
            this.target.datapool.setMapViewerNewId(0);
            this.target.datapool.setResetGoogleEarth(true);
            this.navigationResetParticipant.notifyResetDone();
            this.target.transStateSwitchSuspend();
            this.target.getHsm().activateTransition();
        }
    }
}

