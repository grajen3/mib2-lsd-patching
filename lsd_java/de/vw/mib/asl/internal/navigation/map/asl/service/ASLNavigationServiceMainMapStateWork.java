/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.asl.service;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapEvents;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.StringBuilder;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.PosInfo;

public class ASLNavigationServiceMainMapStateWork
extends AbstractHsmState {
    private final ASLNavigationServiceMainMapTarget target;
    private final IExtLogger LOGGER;

    public ASLNavigationServiceMainMapStateWork(ASLNavigationServiceMainMapTarget aSLNavigationServiceMainMapTarget, String string, HsmState hsmState) {
        super(aSLNavigationServiceMainMapTarget.getHsm(), string, hsmState);
        String string2 = new StringBuilder("[ASLNavigationServiceMainMapStateWork-").append(aSLNavigationServiceMainMapTarget.targetId).append("]").toString();
        this.LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, string2);
        this.target = aSLNavigationServiceMainMapTarget;
    }

    public void dsiMapViewerControlAsyncException(int n, String string, int n2) {
        if (!this.target.datapool.isMapViewerLocked()) {
            return;
        }
        switch (n2) {
            case 1024: 
            case 1026: 
            case 1027: 
            case 1060: {
                return;
            }
        }
        this.LOGGER.makeError().append("dsiMapViewerControlAsyncException(errorCode=").append(n).append(", errorMsg=").append(string).append(", requestType=").append(n2).append(")").log();
        ASLNavigationServiceMainMapEvents.sendEventServiceErrorAPICall(this.target.getClientTarget(), n2, n);
    }

    public HsmState dsiMapViewerControlUpdateMapLayerAvailable(int[] nArray, int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("updateMapLayerAvailable(avail=").append(nArray.length).append(")").log();
        }
        this.target.datapool.setMapLayerAvailable(nArray);
        if (this.target.datapool.isMapViewerLocked() && this.target.isSubscribed(1323381504)) {
            ASLNavigationServiceMainMapEvents.sendEventMapLayersAvailable(this.target.getClientTarget(), nArray);
        }
        return null;
    }

    public HsmState dsiMapViewerControlUpdateMapLayerVisible(int[] nArray, int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("updateMapLayerVisible(visible=").append(nArray.length).append(")").log();
        }
        if (this.target.datapool.isMapViewerLocked() && this.target.isSubscribed(1340158720)) {
            ASLNavigationServiceMainMapEvents.sendEventMapLayersVisibleUpdate(this.target.getClientTarget(), nArray);
        }
        return null;
    }

    public HsmState dsiMapViewerControlUpdateMapPosition(NavLocationWgs84 navLocationWgs84, int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("updateMapPosition(navLoc=").append(navLocationWgs84).append(")").log();
        }
        if (this.target.datapool.isMapViewerLocked() && this.target.isSubscribed(1356935936)) {
            ASLNavigationServiceMainMapEvents.sendEventMapPositionUpdate(this.target.getClientTarget(), navLocationWgs84);
        }
        return null;
    }

    public HsmState dsiMapViewerControlUpdateReady(boolean bl, int n) {
        this.target.datapool.setMapReady(bl);
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("dsiMapViewerControlUpdateReady(ready=").append(bl).append(" )").log();
        }
        this.sendEventServiceStatusChangedTrue();
        return null;
    }

    public HsmState dsiMapViewerControlUpdateSoftZoomRunning(boolean bl, int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("updateSoftZoomRunning(running=").append(bl).append(")").log();
        }
        if (this.target.datapool.isMapViewerLocked()) {
            // empty if block
        }
        return null;
    }

    public HsmState dsiMapViewerControlUpdateViewFreeze(boolean bl, int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("updateViewFreeze(), arg=").append(bl).log();
        }
        if (!bl && this.target.datapool.isMapViewerLocked() && this.target.isSubscribed(1306604288)) {
            ASLNavigationServiceMainMapEvents.sendEventMapGoToLocationMapReady(this.target.getClientTarget());
        }
        return null;
    }

    public HsmState dsiMapViewerControlUpdateZoomLevel(float f2, int n) {
        if (this.target.datapool.isMapViewerLocked() && this.target.isSubscribed(1407267584)) {
            int n2 = this.target.datapool.getMapLayerVisible();
            int n3 = MapViewerUtils.calculateZoomIndexByZoomLevel(f2);
            float f3 = MapViewerUtils.calculateZoomLevelByZoomIndex(n3);
            int n4 = (int)(f3 / 51266);
            if (this.LOGGER.isTraceEnabled()) {
                this.LOGGER.makeTrace().append("updateZoomLevel(levelInMeters=").append(n4).append(", layer=").append(n2).append(")").log();
            }
            ASLNavigationServiceMainMapEvents.sendEventMapZoomLevelUpdate(this.target.getClientTarget(), n4, n2);
        }
        return null;
    }

    public HsmState dsiMapViewerControlUpdateZoomList(float[] fArray, int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("updateZoomList(zoomList[], length=").append(fArray.length).append(")").log();
        }
        if (this.target.isSubscribed(1424044800)) {
            int[] nArray = new int[fArray.length];
            for (int i2 = 0; i2 < fArray.length; ++i2) {
                nArray[i2] = (int)(fArray[i2] / 51266);
            }
            ASLNavigationServiceMainMapEvents.sendEventMapZoomListUpdate(this.target.getClientTarget(), nArray);
        }
        return null;
    }

    public HsmState dsiNavigationUpdateNavstateOfOperation(int n, int n2) {
        this.target.datapool.setNavStateOfOperation(n);
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("dsiNavigationUpdateNavstateOfOperation(navstateOfOperation=").append(n).append(")").log();
        }
        if (n == 5) {
            this.sendEventServiceStatusChangedTrue();
            return null;
        }
        ASLNavigationServiceMainMapEvents.sendEventServiceStatusChange(false);
        this.sendErrorCode(n);
        return null;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 4: {
                break;
            }
            case 3: {
                break;
            }
            case 3499022: {
                this.handleGetInfoForScreenPositionResult(eventGeneric);
                break;
            }
            case 3499054: {
                this.handleGetInfoForScreenPositionResultAsyncExcetion(eventGeneric);
                break;
            }
            case 3499030: {
                this.handleTwoFingersZoomDone();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("handleDefault(), event=").append(eventGeneric.toString()).log();
        }
    }

    private void handleGetInfoForScreenPositionResult(EventGeneric eventGeneric) {
        this.LOGGER.trace("handleGetInfoForScreenPositionResult()");
        PosInfo[] posInfoArray = (PosInfo[])eventGeneric.getObject(0);
        if (this.target.datapool.isMapViewerLocked()) {
            ASLNavigationServiceMainMapEvents.sendEventMapClickInMapResult(this.target.getClientTarget(), posInfoArray);
        }
    }

    private void handleGetInfoForScreenPositionResultAsyncExcetion(EventGeneric eventGeneric) {
        this.LOGGER.error("handleGetInfoForScreenPositionResultAsyncExcetion()");
        if (this.target.datapool.isMapViewerLocked() && this.target.isSubscribed(1273049856)) {
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.target.getClientTarget(), 6);
        }
    }

    private void handleTwoFingersZoomDone() {
        int n = this.target.datapool.getMapLayerVisible();
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("handleTwoFingersZoomDone(layer=").append(n).append(")").log();
        }
        if (this.target.datapool.isMapViewerLocked() && this.target.isSubscribed(1407267584)) {
            ASLNavigationServiceMainMapEvents.sendEventMapZoomLevelUpdate(this.target.getClientTarget(), this.target.datapool.getZoomLevel(), n);
        }
    }

    private void sendErrorCode(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("sendErrorCode( errorCode=").append(n).append(" )").log();
        }
        this.sendErrorCodeC1CustomerUpdate(n);
        this.sendErrorCodeC2DatabaseAccessNotGranted(n);
        this.sendErrorCodeC3DatabaseFailure(n);
        this.sendErrorCodeC4DatabaseRemoved(n);
        this.sendErrorCodeC5CheckingDatabase(n);
    }

    private void sendErrorCodeC1CustomerUpdate(int n) {
        if (n == 14) {
            this.LOGGER.error("sendErrorCodeC1CustomerUpdate( REINIT_CUSTOMERUPDATE )");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.target.getClientTarget(), 1);
        }
    }

    private void sendErrorCodeC2DatabaseAccessNotGranted(int n) {
        if (n == 1) {
            this.LOGGER.error("sendErrorCodeC2DatabaseAccessNotGranted( DISKREQUEST_NOT_ACTIVATED )");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.target.getClientTarget(), 2);
        } else if (n == 12) {
            this.LOGGER.error("sendErrorCodeC2DatabaseAccessNotGranted( READY4NAV )");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.target.getClientTarget(), 2);
        }
    }

    private void sendErrorCodeC3DatabaseFailure(int n) {
        if (n == 4) {
            this.LOGGER.error("sendErrorCodeC3DatabaseFailure( DISKREQUEST_DISKERROR )");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.target.getClientTarget(), 3);
        } else if (n == 2) {
            this.LOGGER.error("sendErrorCodeC3DatabaseFailure( DISKREQUEST_DAMAGED )");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.target.getClientTarget(), 3);
        } else if (n == 6) {
            this.LOGGER.error("sendErrorCodeC3DatabaseFailure( NOT_COMPATIBLE )");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.target.getClientTarget(), 3);
        }
    }

    private void sendErrorCodeC4DatabaseRemoved(int n) {
        if (n == 3) {
            this.LOGGER.error("sendErrorCodeC4DatabaseRemoved( DISKREQUEST_EJECT )");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.target.getClientTarget(), 4);
        }
    }

    private void sendErrorCodeC5CheckingDatabase(int n) {
        if (n == 8) {
            this.LOGGER.error("sendErrorCodeC5CheckingDatabase( CHECKING_MEDIUM )");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.target.getClientTarget(), 5);
        }
    }

    private void sendEventServiceStatusChangedTrue() {
        this.LOGGER.trace("sendEventServiceStatusChangedTrue()");
        if (!this.target.datapool.isMapReady()) {
            this.LOGGER.trace("sendEventServiceStatusChangedTrue() - waiting, the DSIMapViewerControl is not yet ready");
            return;
        }
        if (this.target.datapool.getNavStateOfOperation() != 5) {
            this.LOGGER.trace("sendEventServiceStatusChangedTrue() - waiting, the DSINavigation is not yet fully operable");
            return;
        }
        ASLNavigationServiceMainMapEvents.sendEventServiceStatusChange(true);
    }
}

