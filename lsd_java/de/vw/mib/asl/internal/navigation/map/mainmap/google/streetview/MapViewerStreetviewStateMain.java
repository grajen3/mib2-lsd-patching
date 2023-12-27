/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.DriverDistractionPreventionThresholdListener;
import de.vw.mib.asl.internal.navigation.map.GoogleEarthUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview.MapViewerStreetviewTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.PosInfo;

public final class MapViewerStreetviewStateMain
extends AbstractHsmState
implements ASLOnlineServiceListener,
DriverDistractionPreventionThresholdListener {
    private final IExtLogger logger;
    private final MapViewerStreetviewTargetHSM target;
    private boolean repeatGetInfoForScreenPosition;
    private boolean onlineServiceAvailable = false;
    private boolean onlineServiceFirstUpdate = true;
    private final ASLOnlineCoreServices onlineCoreServices = ASLOnlineFactory.getOnlineCoreServices();

    public MapViewerStreetviewStateMain(MapViewerStreetviewTargetHSM mapViewerStreetviewTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerStreetviewStateMain]");
        this.target = mapViewerStreetviewTargetHSM;
    }

    private HsmState checkStreetViewAvailable(NavLocationWgs84 navLocationWgs84) {
        this.logger.trace("checkStreetViewAvailable()");
        this.target.notifierModel.notifyStreetViewNotAvailable();
        boolean bl = this.isStreetViewCheckPossible();
        if (!bl) {
            this.logger.trace("the check of the street view availability is not enabled");
            return null;
        }
        if (navLocationWgs84 != null) {
            this.target.datapool.setStreetViewPosition(navLocationWgs84);
            this.target.notifierDSI.streetViewSetPosition(navLocationWgs84);
        }
        return null;
    }

    public HsmState dsiMapViewerControlUpdateMapPosition(NavLocationWgs84 navLocationWgs84, int n) {
        if (!GoogleEarthUtils.isGoogleEarthActive()) {
            return null;
        }
        if (this.target.datapool.isClickInMapMenuActive()) {
            this.logger.trace("Ignore Map update for streetview as click in map menu is opened");
            return null;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateMapPosition(mapPosition=").append(navLocationWgs84.toString()).append(")").log();
        }
        this.checkStreetViewAvailable(navLocationWgs84);
        return null;
    }

    public HsmState dsiMapViewerStreetViewCtrlStreetViewEnabled(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerStreetViewCtrlStreetViewEnabled(").append(bl).append(")").log();
        }
        return null;
    }

    public HsmState dsiMapViewerStreetViewCtrlUpdatePosition(NavLocationWgs84 navLocationWgs84, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerStreetViewCtrlUpdatePosition(position=").append(navLocationWgs84.toString()).append(")").log();
        }
        return null;
    }

    public HsmState dsiMapViewerStreetViewCtrlUpdateStreetViewAvailable(boolean bl, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerStreetViewCtrlUpdateStreetViewAvailable(").append(bl).append(")").log();
        }
        this.target.datapool.setStreetViewAvailable(bl && this.target.datapool.isStreetviewLicenceOK());
        NavLocationWgs84 navLocationWgs84 = this.target.datapool.getStreetViewPosition();
        if (navLocationWgs84 != null) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainGoogleStreetViewAvailable(bl && this.target.datapool.isStreetviewLicenceOK(), navLocationWgs84.latitude, navLocationWgs84.longitude);
        }
        if (bl && this.target.datapool.isStreetviewLicenceOK()) {
            this.target.notifierModel.notifyStreetViewAvailable();
        } else {
            this.target.notifierModel.notifyStreetViewNotAvailable();
        }
        return null;
    }

    public HsmState dsiMapViewerStreetViewCtrlUpdateStreetViewZoomList(float[] fArray, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerStreetViewCtrlUpdateStreetViewZoomList(streetViewZoomList[] length=").append(fArray.length).append(")").log();
        }
        if (fArray == null || fArray.length == 0) {
            return null;
        }
        if (fArray[0] == 0.0f) {
            for (int i2 = 0; i2 < fArray.length; ++i2) {
                fArray[i2] = fArray[i2] + 1.0f;
            }
        }
        this.target.datapool.setZoomList(fArray);
        this.target.datapool.setZoomListIndexMax(0);
        this.target.datapool.setZoomListIndexMin(fArray.length - 1);
        return null;
    }

    public HsmState dsiMapViewerStreetViewCtrlUpdateStreetViewZoomListIndex(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerStreetViewCtrlUpdateStreetViewZoomListIndex(streetViewZoomListIndex=").append(n).append(")").log();
        }
        this.target.datapool.setZoomListIndex(n);
        this.target.presetZoomLevelAndIndexStreetView();
        return null;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 1073744488: {
                this.handleSetStreetViewVisible(eventGeneric);
                break;
            }
            case 4300002: {
                this.handleASLSystemDemoGuidanceVelocityThreshold(eventGeneric);
                break;
            }
            case 3499035: {
                this.handleServiceAvailableChangedGoogleStreetView(eventGeneric);
                break;
            }
            case 3499042: {
                this.handleMapMainGoogleEarthMapPositionChanged();
                break;
            }
            case 3499022: {
                this.handleMapMainGetInfoForScreenPositionResult(eventGeneric);
                break;
            }
            case 3499054: {
                this.handleGetInfoForScreenPositionResultAsyncExcetion(eventGeneric);
                break;
            }
            case 2200001: {
                this.target.handleDataConnectionAvailable(eventGeneric);
                break;
            }
            case 1073742409: {
                this.handleCenterMapToCCP(eventGeneric);
                break;
            }
            case 3499073: {
                this.handleMapMainSetStreetViewPosition(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleMapMainSetStreetViewPosition(EventGeneric eventGeneric) {
        NavLocationWgs84 navLocationWgs84 = (NavLocationWgs84)eventGeneric.getObject(0);
        this.checkStreetViewAvailable(navLocationWgs84);
    }

    private void handleASLSystemDemoGuidanceVelocityThreshold(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLSystemDemoGuidanceVelocityThreshold(velocityThresholdExceeded=").append(bl).append(")").log();
        }
        this.target.datapool.setVelocityTresholdForStreetViewReached(bl);
        if (bl) {
            this.target.notifierModel.notifyStreetViewNotAvailable();
        } else if (this.isStreetViewCheckPossible()) {
            this.target.notifierDSI.mapViewerGetInfoForScreenPosition(this.target, this.target.datapool.getHotPoint());
        }
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainGoogleEarthCheckCrosshairVisibility();
    }

    private void handleCenterMapToCCP(EventGeneric eventGeneric) {
        this.logger.trace("handleCenterMapToCCP()");
        this.repeatGetInfoForScreenPosition = true;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
        this.onlineCoreServices.registerForServiceUpdate(this.onlineCoreServices.getServiceIDWithNumericServiceID(13), this);
    }

    protected void handleServiceStreetViewAvailable() {
        this.logger.trace("Google StreetView ApplicationState is: available, we'll reset the model");
        this.target.datapool.setStreetviewLicenceOK(true);
        if (this.target.datapool.getStreetviewDSIready()) {
            this.target.notifierModel.notifyStreetViewServiceAvailable();
            if (this.isStreetViewCheckPossible()) {
                this.target.notifierDSI.mapViewerGetInfoForScreenPosition(this.target, this.target.datapool.getHotPoint());
            }
        }
    }

    protected void handleServiceStreetViewNotAvailable(boolean bl) {
        this.logger.trace("Google StreetView ApplicationState is: not available");
        this.target.datapool.setStreetViewAvailable(false);
        this.target.datapool.setStreetviewLicenceOK(false);
        this.target.datapool.setStreetviewServiceAvailable(bl);
        if (bl) {
            this.target.notifierModel.notifyStreetViewServiceNotAvailable();
        } else {
            this.target.notifierModel.notifyStreetViewNotAvailable();
        }
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.onlineCoreServices.unRegisterForServiceUpdate(this.onlineCoreServices.getServiceIDWithNumericServiceID(13), this);
        try {
            ASLSystemFactory.getSystemApi().getDriverDistractionPreventionService().removeDriverDistractionPreventionListener(this);
        }
        catch (Exception exception) {
            this.logger.error("Removing listener for NHTSA DriverDistractionPrevention has failed");
        }
    }

    private void handleGetInfoForScreenPositionResultAsyncExcetion(EventGeneric eventGeneric) {
        this.logger.trace("handleGetInfoForScreenPositionResultAsyncExcetion()");
    }

    private void handleMapMainGetInfoForScreenPositionResult(EventGeneric eventGeneric) {
        this.logger.trace("handleMapMainGetInfoForScreenPositionResult()");
        if (!GoogleEarthUtils.isGoogleEarthActive()) {
            return;
        }
        PosInfo[] posInfoArray = (PosInfo[])eventGeneric.getObject(0);
        if (posInfoArray == null || posInfoArray.length == 0) {
            return;
        }
        PosInfo posInfo = posInfoArray[0];
        if (posInfo.tLocation == null) {
            this.logger.warn("handleMapMainGetInfoForScreenPositionResult() - the tLocation is empty, can't check for streetView");
            return;
        }
        this.target.notifierDSI.streetViewSetPosition(new NavLocationWgs84(posInfo.tLocation.longitude, posInfo.tLocation.latitude));
        if (this.repeatGetInfoForScreenPosition) {
            this.logger.trace("handleMapMainGetInfoForScreenPositionResult() - getInfoForScreenPosition will be invoked for the second time now");
            this.target.notifierDSI.mapViewerGetInfoForScreenPosition(this.target, this.target.datapool.getHotPoint());
            this.repeatGetInfoForScreenPosition = false;
        }
    }

    private void handleMapMainGoogleEarthMapPositionChanged() {
        this.logger.trace("handleMapMainGoogleEarthMapPositionChanged()");
        if (GoogleEarthUtils.isGoogleEarthActive()) {
            this.target.notifierModel.notifyStreetViewNotAvailable();
            if (!this.isStreetViewCheckPossible()) {
                return;
            }
            this.target.notifierDSI.mapViewerGetInfoForScreenPosition(this.target, this.target.datapool.getHotPoint());
        }
    }

    private void handleServiceAvailableChangedGoogleStreetView(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleServiceAvailableChangedGoogleStreetView(available=").append(bl).append(")").log();
        }
        if (bl) {
            this.target.notifierDSI.streetViewEnabled(true);
            this.target.notifierDSI.streetViewSetScreenViewport(MapViewerStreetviewTargetHSM.SCREEN_VIEW_PORT);
            this.target.notifierDSI.streetViewSetDayView();
            this.target.datapool.setStreetviewDSIready(true);
        } else {
            this.target.notifierModel.notifyStreetViewServiceNotAvailable();
            this.target.transStateStreetViewInvisible();
            this.target.datapool.setStreetviewDSIready(false);
        }
    }

    private void handleSetStreetViewVisible(EventGeneric eventGeneric) {
        this.logger.trace("handleSetStreetViewVisible()");
        boolean bl = eventGeneric.getBoolean(0);
        if (this.target.datapool.isVelocityTresholdForStreetViewReached() && bl) {
            this.logger.warn("set StreetView visible is not allowed while driving, this is an model bug an should be fixed");
            return;
        }
        if (bl) {
            this.target.transStateStreetView();
        } else {
            this.target.transStateStreetViewInvisible();
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.onlineServiceFirstUpdate = true;
        if (this.target.datapool.isDriverDistractionPreventionFeatureAvailable()) {
            try {
                ASLSystemFactory.getSystemApi().getDriverDistractionPreventionService().addDriverDistractionPreventionListener(this);
            }
            catch (Exception exception) {
                this.logger.error("Listener for NHTSA DriverDistractionPrevention has failed");
            }
        }
    }

    private boolean isStreetViewCheckPossible() {
        this.logger.trace("isStreetViewCheckPossible()");
        boolean bl = true;
        if (!GoogleEarthUtils.isGoogleEarthActive()) {
            this.logger.trace("The Google StreetView feature is not enabled on the onboard MapViewer");
            bl = false;
        } else if (!this.target.datapool.isStreetviewLicenceOK()) {
            this.logger.trace("StreetView licence nok");
            bl = false;
        } else if (!this.target.datapool.isDataConnectionAvailable()) {
            this.logger.trace("no data connection available");
            bl = false;
        } else if (this.target.datapool.isVelocityTresholdForStreetViewReached()) {
            this.logger.trace("velocity is above the limit");
            bl = false;
        }
        return bl;
    }

    @Override
    public void updateServiceStatusOnChange(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("updateServiceStatusOnChange:: result=").append(n).log();
        }
        switch (n) {
            case 0: 
            case 7: {
                if (this.onlineServiceAvailable && !this.onlineServiceFirstUpdate && this.target.datapool.isStreetviewLicenceOK()) break;
                this.onlineServiceFirstUpdate = false;
                this.onlineServiceAvailable = true;
                this.handleServiceStreetViewAvailable();
                break;
            }
            case 3: 
            case 5: {
                this.handleServiceStreetViewNotAvailable(false);
                break;
            }
            default: {
                if (!this.onlineServiceAvailable && !this.onlineServiceFirstUpdate) break;
                this.onlineServiceFirstUpdate = false;
                this.onlineServiceAvailable = false;
                this.handleServiceStreetViewNotAvailable(true);
            }
        }
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainGoogleEarthCheckCrosshairVisibility();
    }

    @Override
    public void onDriverDistractionPreventionRequired(boolean bl) {
        if (bl) {
            this.logger.info("NHTSA: disable street view while driving for safety reason");
            try {
                this.target.datapool.setStreetViewAvailable(false);
                this.target.notifierModel.notifyStreetViewNotAvailable();
                this.target.transStateStreetViewInvisible();
            }
            catch (Exception exception) {
                this.logger.error("NHTSA: disabling street view while driving for safety reason failed.");
            }
        } else {
            this.logger.info("NHTSA: street view available again");
            this.target.datapool.setStreetViewAvailable(true);
            this.target.notifierModel.notifyStreetViewAvailable();
        }
    }
}

