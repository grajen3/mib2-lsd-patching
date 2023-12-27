/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen.overlays;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.internal.navigation.splitscreen.OverlayData;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.transformer.OverlaysDataCollector;
import de.vw.mib.genericevents.EventGeneric;

public class OverlaysNotifierInternalAPI {
    OverlaysDataCollector overlaysDataCollector = OverlaysDataCollector.getInstance();

    void notifyOverlayDataUpdate() {
        OverlayData overlayData = new OverlayData();
        overlayData.setColorIndicatorIcon(this.overlaysDataCollector.colorIndicatorIcon);
        overlayData.setDistanceToManeuver(this.overlaysDataCollector.dtm);
        overlayData.setExitNumber(this.overlaysDataCollector.exitNumber);
        overlayData.setExitNumberVisibility(this.overlaysDataCollector.exitNumber != null && !this.overlaysDataCollector.exitNumber.equals(""));
        overlayData.setHeadlineIcon(this.overlaysDataCollector.headlineIcon);
        overlayData.setHeadlineIconVisibility(this.overlaysDataCollector.trafficLightIconVisibility);
        overlayData.setLaneDirections(this.overlaysDataCollector.laneDirections);
        overlayData.setLaneGuidanceAvailable(this.overlaysDataCollector.laneGuidanceAvailableOverlays);
        overlayData.setLaneInfos(this.overlaysDataCollector.laneInfos);
        overlayData.setLaneMarkingsLeft(this.overlaysDataCollector.laneMarkingsLeft);
        overlayData.setLaneMarkingsRight(this.overlaysDataCollector.laneMarkingsRight);
        overlayData.setLaneNumber(this.overlaysDataCollector.numberOfLanes);
        overlayData.setName(this.overlaysDataCollector.name);
        overlayData.setSignPostInfo(this.overlaysDataCollector.signPost);
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-1086049024);
        eventGeneric.setObject(0, overlayData);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void notifyOverlayIndexUpdate(int n) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-1035717376);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void notifyOverlayContentUpdate(int n) {
        switch (n) {
            case 0: {
                n = 0;
                break;
            }
            case 1: {
                n = 1;
                break;
            }
            case 2: {
                n = 2;
                break;
            }
            case 3: {
                n = 3;
                break;
            }
            case 4: {
                n = 4;
                break;
            }
            case 5: {
                n = 5;
                break;
            }
            default: {
                n = 0;
            }
        }
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-1069271808);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void notifyOverlayCountUpdate(int n) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-1052494592);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }
}

