/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen.overlays;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.transformer.OverlaysDataCollector;
import org.dsi.ifc.global.ResourceLocator;

public class OverlaysNotifierModel {
    OverlaysDataCollector overlaysDataCollector = OverlaysDataCollector.getInstance();
    private boolean verbose = false;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[OverlaysTargetHSM - OverlaysNotifierModel]");

    public void notifyKanbanActiveChanged(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(233836544, bl);
    }

    public void notifyManeuverDetailViewActiveChanged(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(0xFF01000, bl);
    }

    public void notifyMotorwayInfoActiveChanged(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(250613760, bl);
    }

    public void notifyOverlayCountChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(200282112, n);
    }

    public void notifyOverlayIndexChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(217059328, n);
    }

    public void notifyOverlayDisplayed(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(636489728, n);
    }

    public void notifyHeadlineIconVisibility(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1206915072, bl);
    }

    public void notifyHeadlineIconChanged(ResourceLocator resourceLocator) {
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(1190137856, resourceLocator);
    }

    public void notifyCurrentOverlayNameChanged(String string) {
        ServiceManager.aslPropertyManager.valueChangedString(972034048, string);
    }

    public void notifyCurrentOverlaySignPostInfoChanged(String string) {
        ServiceManager.aslPropertyManager.valueChangedString(2129661952, string);
    }

    public void notifyExitNumberVisibility(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1005588480, bl);
    }

    public void notifyExitNumberChanged(String string) {
        ServiceManager.aslPropertyManager.valueChangedString(988811264, string);
    }

    public void notifyDistanceToManeuverChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1022365696, n);
    }

    public void notifyColorIndicatorIconChanged(ResourceLocator resourceLocator) {
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(1039142912, resourceLocator);
    }

    public void notifyLaneDirectionsChanged(int[] nArray) {
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(1089474560, nArray);
    }

    public void notifyLaneInfosChanged(int[] nArray) {
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(1106251776, nArray);
    }

    public void notifyLaneMarkingsLeftChanged(int[] nArray) {
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(1123028992, nArray);
    }

    public void notifyLaneMarkingsRightChanged(int[] nArray) {
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(1139806208, nArray);
    }

    public void notifyLaneNumberChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1156583424, n);
    }

    public void notifyLaneGuidanceAvailable(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1173360640, bl);
    }

    public void notifyAdditionalGuidanceInformation() {
        this.logger.trace(new StringBuffer("notifyAdditionalGuidanceInformation  DTM: ").append(this.overlaysDataCollector.dtm).toString());
        this.notifyHeadlineIconVisibility(this.overlaysDataCollector.trafficLightIconVisibility);
        this.notifyHeadlineIconChanged(this.overlaysDataCollector.headlineIcon);
        this.notifyCurrentOverlayNameChanged(this.overlaysDataCollector.name);
        this.notifyCurrentOverlaySignPostInfoChanged(this.overlaysDataCollector.signPost);
        this.notifyExitNumberVisibility(this.overlaysDataCollector.trafficLightIconVisibility);
        this.notifyExitNumberChanged(this.overlaysDataCollector.exitNumber);
        this.notifyDistanceToManeuverChanged(this.overlaysDataCollector.dtm);
        this.notifyColorIndicatorIconChanged(this.overlaysDataCollector.colorIndicatorIcon);
        this.notifyLaneDirectionsChanged(this.overlaysDataCollector.laneDirections);
        this.notifyLaneInfosChanged(this.overlaysDataCollector.laneInfos);
        this.notifyLaneMarkingsLeftChanged(this.overlaysDataCollector.laneMarkingsLeft);
        this.notifyLaneMarkingsRightChanged(this.overlaysDataCollector.laneMarkingsRight);
        this.notifyLaneNumberChanged(this.overlaysDataCollector.numberOfLanes);
        this.notifyLaneGuidanceAvailable(this.overlaysDataCollector.laneGuidanceAvailableOverlays);
        if (this.verbose) {
            this.printOverlaysDataCollectorContent();
        }
    }

    private void printOverlaysDataCollectorContent() {
        StringBuffer stringBuffer = new StringBuffer("Overlays: Additional Icon Data For Model: ");
        stringBuffer.append(this.overlaysDataCollector);
        this.logger.trace(stringBuffer.toString());
    }
}

