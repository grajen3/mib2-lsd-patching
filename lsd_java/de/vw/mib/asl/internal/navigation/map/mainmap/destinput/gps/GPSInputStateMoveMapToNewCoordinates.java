/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.PosInfo;

public class GPSInputStateMoveMapToNewCoordinates
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[GPSInputStateMoveMapToNewCoordinates] ");
    private final GPSInputTargetHSM target;

    public GPSInputStateMoveMapToNewCoordinates(GPSInputTargetHSM gPSInputTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = gPSInputTargetHSM;
    }

    public HsmState dsiMapViewerControlUpdateMapPosition(NavLocationWgs84 navLocationWgs84, int n) {
        this.logger.trace("dsiMapViewerControlUpdateMapPosition()");
        this.target.notifierDSI.getInfoForScreenPosition();
        return null;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleHSMStart();
                break;
            }
            case 3499022: {
                this.handleGetInfoForScreenPositionResult(eventGeneric);
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
        this.logger.trace("handleDefault()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleHSMStart() {
        this.logger.trace("handleHSMStart()");
        boolean bl = this.updateLocationCurrentByGPSCoordinates();
        if (!bl) {
            return;
        }
        ILocationWrapper iLocationWrapper = this.target.datapool.getLocationCurrent();
        this.target.notifierDSI.setLocationByLocation(iLocationWrapper.getLocation());
        this.target.notifierModel.updateListCoordinates();
        this.target.notifierModel.notifyMapInputLocationChanged();
    }

    private boolean updateLocationCurrentByGPSCoordinates() {
        boolean bl;
        this.logger.trace("updateLocationCurrentByGPSCoordinates()");
        ILocationWrapper iLocationWrapper = this.target.incrementDecrementor.getMapLocationNew();
        ILocationWrapper iLocationWrapper2 = this.target.datapool.getLocationCurrent();
        if (iLocationWrapper2.getLatitude() == iLocationWrapper.getLatitude() && iLocationWrapper2.getLongitude() == iLocationWrapper.getLongitude()) {
            this.logger.trace("The Location hasn't changed");
            bl = false;
        } else {
            this.logger.trace("The Location was changed");
            this.target.updateLocationCurrentAndSendEvent(iLocationWrapper);
            bl = true;
        }
        return bl;
    }

    private void handleGetInfoForScreenPositionResult(EventGeneric eventGeneric) {
        this.logger.trace("handleGetInfoForScreenPositionResult()");
        PosInfo[] posInfoArray = (PosInfo[])eventGeneric.getObject(0);
        this.target.updateLocationCurrentByPosInfo(posInfoArray);
        this.target.notifierModel.notifyMapInputLocationChanged();
        this.target.notifierModel.notifyMapIsReady();
    }
}

