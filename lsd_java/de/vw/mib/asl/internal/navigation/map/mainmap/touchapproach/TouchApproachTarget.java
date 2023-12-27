/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.touchapproach;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.proximity.ProximityService;
import de.vw.mib.asl.internal.navigation.AbstractResettableTarget;
import de.vw.mib.asl.internal.navigation.map.GoogleEarthUtils;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;

public class TouchApproachTarget
extends AbstractResettableTarget {
    private static final int[] ASL_OBSERVER = new int[]{194855168, 771883072, 627324160, 107230464};
    private DSIMapViewerControlVW dsiMapViewerControl;
    private IExtLogger LOGGER = null;
    private boolean newRequestedProximityState;
    private final PersistedMapSetup persistedMapSetup;
    private boolean waitingForTouchApproachResult;
    private final MapViewerDatapoolShared datapoolShared = MapViewerDatapoolShared.getInstance();
    private boolean stateChangedDuringWait = false;
    private ProximityService proximityService;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    private IExtLogger getLOGGER() {
        if (this.LOGGER == null) {
            this.LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[TouchApproachTarget] ");
        }
        return this.LOGGER;
    }

    public TouchApproachTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.persistedMapSetup = PersistedMapSetup.getInstance();
    }

    public void dsiMapViewerControlAsyncException(int n, String string, int n2) {
        if (n2 != 1063) {
            return;
        }
        this.getLOGGER().makeError().append("AsyncException for DSIMapViewerControl.touchApproach(boolean), errorMsg=").append(string).log();
        this.dsiMapViewerControlTouchApproachResult(false);
    }

    public HsmState dsiMapViewerControlTouchApproachResult(boolean bl) {
        this.getLOGGER().trace("dsiMapViewerControlTouchApproachResult()");
        this.waitingForTouchApproachResult = false;
        if (bl != this.newRequestedProximityState) {
            if (this.stateChangedDuringWait) {
                this.getLOGGER().trace("new requested proximity state differs from current. Requesting new state.");
                this.stateChangedDuringWait = false;
                this.handleProximityStateChanged(this.newRequestedProximityState);
            } else {
                this.datapoolShared.setTouchApproximated(bl);
            }
        }
        return null;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.handlePowerOn();
                break;
            }
            case 101003: {
                this.handlePrepareOn();
                break;
            }
            case 101001: {
                this.handleNaviTargetGoOn();
                break;
            }
            case 4300043: {
                this.handleSystemProximityStateChanged(eventGeneric);
                break;
            }
            case 1073742382: {
                this.handleSetContent(eventGeneric);
                break;
            }
            case 3499045: {
                this.handleMapSwitchDone(eventGeneric);
                break;
            }
            case 3499014: {
                this.handleMapReady(eventGeneric);
                break;
            }
            default: {
                this.handleDefault();
            }
        }
    }

    private void handleMapReady(EventGeneric eventGeneric) {
        this.getLOGGER().trace("handleMapReady()");
        this.initializeProximityState();
    }

    private void handleMapSwitchDone(EventGeneric eventGeneric) {
        this.getLOGGER().trace("handleMapSwitchDone()");
        this.initializeProximityState();
    }

    private void initializeProximityState() {
        this.waitingForTouchApproachResult = false;
        if (this.proximityService != null) {
            this.handleProximityStateChanged(this.proximityService.getCurrentProximityState());
        } else {
            this.handleProximityStateChanged(true);
        }
    }

    private void handleDefault() {
        this.getLOGGER().trace("handleDefault()");
    }

    private void handleNaviTargetGoOn() {
        this.getLOGGER().trace("handleNaviTargetGoOn()");
        this.initASL();
        this.initDSI();
        this.initProximityService();
    }

    private void handlePowerOn() {
        this.getLOGGER().trace("handlePowerOn()");
    }

    private void handlePrepareOn() {
        this.getLOGGER().trace("handlePrepareOn()");
    }

    private void handleProximityStateChanged(boolean bl) {
        if (this.getLOGGER().isTraceEnabled()) {
            this.getLOGGER().makeTrace().append("handleProximityStateChanged(state=").append(bl).append(")").log();
        }
        this.datapoolShared.setLatestTouchApproach(bl);
        if (this.waitingForTouchApproachResult) {
            this.getLOGGER().trace("Southside touchApproach req still ongoing. Storing new proxmity state and do nothing.");
            if (this.newRequestedProximityState != bl) {
                this.newRequestedProximityState = bl;
                this.stateChangedDuringWait = true;
            }
        } else if (this.persistedMapSetup.isMapLocatedInABT()) {
            this.getLOGGER().trace("touchApproach() requested");
            this.waitingForTouchApproachResult = true;
            this.newRequestedProximityState = bl;
            this.datapoolShared.setTouchApproximated(bl);
            if (GoogleEarthUtils.isGoogleEarthActive()) {
                this.waitingForTouchApproachResult = false;
                if (!this.datapoolShared.isStreetViewVisible()) {
                    ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainGoogleEarthCheckCrosshairVisibility();
                }
            } else {
                this.dsiMapViewerControl.touchApproach(bl);
            }
        }
    }

    private void handleSetContent(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (n == 0 || n == 34 || n == 36 || n == 30) {
            this.getLOGGER().trace("handleSetContent()");
            this.getLOGGER().trace("Set touchApproach to true, because Main Map or PNAV overview or Traffic DLV or Online DLV was entered.");
            this.handleProximityStateChanged(true);
        }
    }

    private void handleSystemProximityStateChanged(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (this.getLOGGER().isTraceEnabled()) {
            this.getLOGGER().makeTrace().append("handleSystemProximityStateChanged(approachState=").append(bl).append(")").log();
        }
        if (this.persistedMapSetup.getMainMapContent() == 0 || this.persistedMapSetup.getMainMapContent() == 34 || this.persistedMapSetup.getMainMapContent() == 36 || this.persistedMapSetup.getMainMapContent() == 30) {
            this.getLOGGER().trace("Entered ASL_SYSTEM_PROXIMITY_STATE_CHANGED in NAV_MAIN or PNAV overview or Traffic DLV or Online DLV");
            this.handleProximityStateChanged(bl);
        } else if (this.datapoolShared.isASLServiceProximityActive()) {
            this.getLOGGER().trace("Entered ASL_SYSTEM_PROXIMITY_STATE_CHANGED for ASL Services");
            this.handleProximityStateChanged(bl);
        } else {
            this.getLOGGER().trace("Entered ASL_SYSTEM_PROXIMITY_STATE_CHANGED not in NAV_MAIN or PNAV overview or Traffic DLV or Online DLV");
        }
    }

    private void initASL() {
        this.getLOGGER().trace("initASL()");
        this.addObservers(ASL_OBSERVER);
    }

    private void initDSI() {
        this.getLOGGER().trace("initDSI()");
        this.dsiMapViewerControl = DSIMapViewerControlFactoryVW.createMapViewerMain(this, null);
    }

    private void initProximityService() {
        this.getLOGGER().trace("initProximityService()");
        this.proximityService = ASLSystemFactory.getSystemApi().getProximityService();
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = TouchApproachTarget.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0)) {
            if (this.LOGGER.isTraceEnabled()) {
                this.LOGGER.trace("no reset neccessary");
            }
        } else if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.trace("no reset necessary because restarted DSI(s) is/are not used in target");
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

