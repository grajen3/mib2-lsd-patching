/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;

public class GPSInputStateSetClickInMapSelected
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[GPSInputStateSetClickInMapSelected] ");
    private final GPSInputTargetHSM target;

    public GPSInputStateSetClickInMapSelected(GPSInputTargetHSM gPSInputTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = gPSInputTargetHSM;
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
                this.handleHSMStart();
                break;
            }
            case 1073744379: {
                return this.handleSetClickInMap(eventGeneric);
            }
            case 3499022: {
                this.handleGetInfoForScreenPositionResult(eventGeneric);
                break;
            }
            case 3499054: {
                this.handleGetInfoForScreenPositionResultAsyncExcetion(eventGeneric);
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

    private void handleGetInfoForScreenPositionResult(EventGeneric eventGeneric) {
        this.logger.trace("handleGetInfoForScreenPositionResult");
        PosInfo[] posInfoArray = (PosInfo[])eventGeneric.getObject(0);
        this.target.updateLocationCurrentByPosInfo(posInfoArray);
        this.target.notifierDSI.setLocationByLocation(this.target.datapool.getLocationCurrent().getLocation());
        this.target.notifierModel.notifyMapInputLocationChanged();
        this.target.notifierModel.notifyCoordinatesChanged();
        this.target.notifierModel.notifyMapIsReady();
    }

    private void handleGetInfoForScreenPositionResultAsyncExcetion(EventGeneric eventGeneric) {
        this.logger.trace("handleGetInfoForScreenPositionResultAsyncExcetion()");
    }

    private void handleHSMStart() {
        this.logger.trace("handleHSMStart()");
        this.target.notifierModel.notifyMapIsNotReady();
        int n = this.target.datapool.getSelectedX();
        int n2 = this.target.datapool.getSelectedY();
        Point point = new Point(n, n2);
        this.target.notifierDSI.getInfoForScreenPosition(this.target, point);
    }

    private void handleSetClickInMainMapClicked(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMainMapClicked()");
        this.target.updateXandY(eventGeneric);
        this.moveMapToClickedCoordinates();
    }

    private void handleSetClickInMainMapSelected(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMainMapSelected()");
        this.target.updateXandY(eventGeneric);
        this.moveMapToClickedCoordinates();
    }

    private HsmState handleSetClickInMap(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMap()");
        int n = eventGeneric.getInt(0);
        if (n == 4) {
            this.handleSetClickInMainMapSelected(eventGeneric);
            return null;
        }
        if (n == 3) {
            this.handleSetClickInMainMapClicked(eventGeneric);
            return null;
        }
        return this.myParent;
    }

    private void moveMapToClickedCoordinates() {
        this.logger.trace("moveMapToClickedCoordinates()");
        this.target.notifierModel.notifyMapIsNotReady();
        int n = this.target.datapool.getSelectedX();
        int n2 = this.target.datapool.getSelectedY();
        Point point = new Point(n, n2);
        this.target.notifierDSI.getInfoForScreenPosition(this.target, point);
    }
}

