/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps;

import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocation;

public class GPSInputStateMain
extends AbstractHsmState {
    final IExtLogger logger;
    private final GPSInputTargetHSM target;

    public GPSInputStateMain(GPSInputTargetHSM gPSInputTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = gPSInputTargetHSM;
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[GPSInputStateMain] ");
    }

    public HsmState dsiMapViewerControlUpdateZoomListIndex(int n, int n2) {
        this.target.notifierModel.presetZoomLevel(n);
        return null;
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
                this.handleSetClickInMap(eventGeneric);
                break;
            }
            case 1073744383: {
                this.handleConfirmMapInputLocationOk(eventGeneric);
                break;
            }
            case 1073744375: {
                this.handleChangeMapWindowSize(eventGeneric);
                break;
            }
            case 1073744376: {
                this.handleCoordianteDecrement(eventGeneric);
                break;
            }
            case 1073744377: {
                this.handleCoordinateIncrement(eventGeneric);
                break;
            }
            case 1073744378: {
                this.handleInit(eventGeneric);
                break;
            }
            case 1073744414: {
                this.handleMoveMapToNewCoordinate(eventGeneric);
                break;
            }
            case 1073744380: {
                this.handleZoomIn();
                break;
            }
            case 1073744381: {
                this.handleZoomOut();
                break;
            }
            case 1073742300: {
                this.handleSaveMapInput();
                break;
            }
            case 1073742289: {
                this.handleConfirmMapInputOk();
                break;
            }
            case 1073742414: {
                this.handleSetScope(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleChangeMapWindowSize(EventGeneric eventGeneric) {
        this.logger.trace("handleChangeMapWindowSize()");
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        int n4 = eventGeneric.getInt(3);
        this.target.updateWindowValues(n, n2, n4, n3);
        this.target.notifierDSI.setZoomArea(this.target.datapool.getZoomArea());
        this.target.notifierDSI.setHotPoint(this.target.datapool.getHotPoint());
        this.target.notifierDSI.setLocationByLocation(this.target.datapool.getLocationCurrent().getLocation());
    }

    private void handleConfirmMapInputLocationOk(EventGeneric eventGeneric) {
        this.logger.trace("handleConfirmMapInputLocationOk()");
        NavLocation navLocation = this.target.datapool.getLocationCurrent().getLocation();
        MapConfiguration mapConfiguration = new MapConfiguration(navLocation, 25, 0);
        this.target.sendEvMapMainContentGotoLocation(14, mapConfiguration);
        this.target.datapool.setMapInputLocation(navLocation);
    }

    private void handleConfirmMapInputOk() {
        this.logger.trace("handleConfirmMapInputOk()");
        NavLocation navLocation = this.target.datapool.getLocationCurrent().getLocation();
        int n = this.target.datapool.getScope();
        switch (n) {
            case 1: {
                this.target.datapool.setDestInputLocation(navLocation);
                MapConfiguration mapConfiguration = new MapConfiguration(navLocation, 25, 0);
                this.target.sendEvMapMainContentGotoLocation(14, mapConfiguration);
                break;
            }
            case 2: {
                this.target.datapool.setDestInputLocation(navLocation);
                break;
            }
            case 3: {
                ASLNavigationPoiFactory.getNavigationPoiApi().getPoiSetup().setLocationForSearchAreaMap(navLocation);
                break;
            }
            case 4: {
                this.target.datapool.setSpellerLocation(navLocation);
                break;
            }
            default: {
                this.logger.trace("handleConfirmMapInputOk() Default, nothing happens");
            }
        }
    }

    private void handleCoordianteDecrement(EventGeneric eventGeneric) {
        this.logger.trace("handleDecrementCoordinate()");
        int n = eventGeneric.getInt(0);
        switch (n) {
            case 0: {
                this.target.incrementDecrementor.latitudeDegreeTenDecrement();
                break;
            }
            case 1: {
                this.target.incrementDecrementor.latitudeDegreeOneDecrement();
                break;
            }
            case 2: {
                this.target.incrementDecrementor.latitudeMinutesTenDecrement();
                break;
            }
            case 3: {
                this.target.incrementDecrementor.latitudeMinutesOneDecrement();
                break;
            }
            case 4: {
                this.target.incrementDecrementor.latitudeSecondTenDecrement();
                break;
            }
            case 5: {
                this.target.incrementDecrementor.latitudeSecondsOneDecrement();
                break;
            }
            case 6: {
                this.target.incrementDecrementor.latitudeSecondTenthDecrement();
                break;
            }
            case 7: {
                this.target.incrementDecrementor.latitudeHemisphereDecrement();
                break;
            }
            case 8: {
                this.target.incrementDecrementor.longitudeDegreeHundredDecrement();
                break;
            }
            case 9: {
                this.target.incrementDecrementor.longitudeDegreeTenDecrement();
                break;
            }
            case 10: {
                this.target.incrementDecrementor.longitudeDegreeOneDecrement();
                break;
            }
            case 11: {
                this.target.incrementDecrementor.longitudeMinuteTenDecrement();
                break;
            }
            case 12: {
                this.target.incrementDecrementor.longitudeMinutesOneDecrement();
                break;
            }
            case 13: {
                this.target.incrementDecrementor.longitudeSecondTenDecrement();
                break;
            }
            case 14: {
                this.target.incrementDecrementor.longitudeSecondsOneDecrement();
                break;
            }
            case 15: {
                this.target.incrementDecrementor.longitudeSecondTenthDecrement();
                break;
            }
            case 16: {
                this.target.incrementDecrementor.longitudeHemisphereDecrement();
                break;
            }
            case 255: {
                this.logger.trace("DigitToBeDecreased is set to Proeprty 'C17_UNUSED', nothing will happen");
                break;
            }
        }
    }

    private void handleCoordinateIncrement(EventGeneric eventGeneric) {
        this.logger.trace("handleIncrementCoordinate()");
        int n = eventGeneric.getInt(0);
        switch (n) {
            case 0: {
                this.target.incrementDecrementor.latitudeDegreeTenIncrement();
                break;
            }
            case 1: {
                this.target.incrementDecrementor.latitudeDegreeOneIncrement();
                break;
            }
            case 2: {
                this.target.incrementDecrementor.latitudeMinutesTenIncrement();
                break;
            }
            case 3: {
                this.target.incrementDecrementor.latitudeMinutesOneIncrement();
                break;
            }
            case 4: {
                this.target.incrementDecrementor.latitudeSecondTenIncrement();
                break;
            }
            case 5: {
                this.target.incrementDecrementor.latitudeSecondsOneIncrement();
                break;
            }
            case 6: {
                this.target.incrementDecrementor.latitudeSecondTenthIncrement();
                break;
            }
            case 7: {
                this.target.incrementDecrementor.latitudeHemisphereIncrement();
                break;
            }
            case 8: {
                this.target.incrementDecrementor.longitudeDegreeHundredIncrement();
                break;
            }
            case 9: {
                this.target.incrementDecrementor.longitudeDegreeTenIncrement();
                break;
            }
            case 10: {
                this.target.incrementDecrementor.longitudeDegreeOneIncrement();
                break;
            }
            case 11: {
                this.target.incrementDecrementor.longitudeMinuteTenIncrement();
                break;
            }
            case 12: {
                this.target.incrementDecrementor.longitudeMinuteOneIncrement();
                break;
            }
            case 13: {
                this.target.incrementDecrementor.longitudeSecondTenIncrement();
                break;
            }
            case 14: {
                this.target.incrementDecrementor.longitudeSecondsOneIncrement();
                break;
            }
            case 15: {
                this.target.incrementDecrementor.longitudeSecondTenthIncrement();
                break;
            }
            case 16: {
                this.target.incrementDecrementor.longitudeHemisphereIncrement();
                break;
            }
            case 255: {
                this.logger.trace("DigitToBeIncreased is set to Proeprty 'C17_UNUSED', nothing will happen");
                break;
            }
        }
    }

    private void handleDefault(EventGeneric eventGeneric) {
        this.logger.trace("handleDefault()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
        this.target.initTarget();
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleHSMStart() {
        this.logger.trace("handleHSMStart()");
    }

    private void handleInit(EventGeneric eventGeneric) {
        this.logger.trace("handleInit()");
        this.logger.trace("initWindowValues()");
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        int n4 = eventGeneric.getInt(3);
        this.target.updateWindowValues(n, n2, n4, n3);
        this.target.transStateInit();
    }

    private void handleMoveMapToNewCoordinate(EventGeneric eventGeneric) {
        this.logger.trace("handleMoveMapToNewCoordinate()");
        this.target.transStateMoveMapToNewCoordinates();
    }

    private void handleSaveMapInput() {
        this.logger.trace("handleSaveMapInput()");
        NavLocation navLocation = this.target.datapool.getLocationCurrent().getLocation();
        this.target.datapool.setMapInputLocation(navLocation);
        this.target.datapool.setDestInputLocation(navLocation);
    }

    private void handleSetClickInMainMapClicked(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMainMapClicked()");
        this.target.updateXandY(eventGeneric);
        this.target.transStateSetClickInMapClicked();
    }

    private void handleSetClickInMainMapDefault() {
        this.logger.trace("handleSetClickInMainMapDefault()");
    }

    private void handleSetClickInMainMapDragged(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMainMapDragged()");
        int n = eventGeneric.getInt(1);
        int n2 = eventGeneric.getInt(2);
        this.target.datapool.setDraggedX(n);
        this.target.datapool.setDraggedY(n2);
        this.target.transStateSetClickInMapDragged();
    }

    private void handleSetClickInMainMapPressed(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMainMapPressed()");
        this.target.updateXandY(eventGeneric);
    }

    private void handleSetClickInMainMapUnused() {
        this.logger.trace("handleSetClickInMainMapUnused()");
    }

    private void handleSetClickInMap(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMap()");
        int n = eventGeneric.getInt(0);
        switch (n) {
            case 0: {
                this.handleSetClickInMainMapPressed(eventGeneric);
                break;
            }
            case 1: {
                this.handleSetClickInMainMapDragged(eventGeneric);
                break;
            }
            case 2: {
                this.handleSetClickInMainMapDefault();
                break;
            }
            case 3: {
                this.handleSetClickInMainMapClicked(eventGeneric);
                break;
            }
            case 255: {
                this.handleSetClickInMainMapUnused();
                break;
            }
            default: {
                this.handleSetClickInMainMapDefault();
            }
        }
    }

    private void handleSetScope(EventGeneric eventGeneric) {
        this.logger.trace("handleSetScope()");
        this.target.datapool.setScope(eventGeneric.getInt(0));
    }

    private void handleZoomIn() {
        this.logger.trace("handleZoomIn()");
        int n = MapViewerUtils.calculateZoomListIndexNew(-1);
        this.target.notifierModel.presetZoomLevel(n);
        this.target.notifierDSI.setZoomIndex(n);
    }

    private void handleZoomOut() {
        this.logger.trace("handleZoomOut()");
        int n = MapViewerUtils.calculateZoomListIndexNew(1);
        this.target.notifierModel.presetZoomLevel(n);
        this.target.notifierDSI.setZoomIndex(n);
    }
}

