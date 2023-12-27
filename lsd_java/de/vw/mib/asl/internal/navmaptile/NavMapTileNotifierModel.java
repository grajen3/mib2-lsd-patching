/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navmaptile;

import de.vw.mib.asl.api.navigation.IGuidanceLaneGuidance;
import de.vw.mib.asl.api.navigation.IGuidanceVZAVZEIcons;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navmaptile.transformer.NavMapTileGuidanceVZEVZAIconsCollector;
import de.vw.mib.asl.internal.navmaptile.util.MapTileLogger;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navmaptile.guidance.ASLNavMapTileGuidancePropertyManager;
import generated.de.vw.mib.asl.internal.navmaptile.guidance.transformer.NavMapTileGuidanceLaneGuidanceCollector;

public class NavMapTileNotifierModel {
    private MapTileLogger logger;
    private NavMapTileGuidanceVZEVZAIconsCollector[] iconsCollector = new NavMapTileGuidanceVZEVZAIconsCollector[]{new NavMapTileGuidanceVZEVZAIconsCollector()};
    private NavMapTileGuidanceLaneGuidanceCollector[] laneGuidanceCollector = new NavMapTileGuidanceLaneGuidanceCollector[]{new NavMapTileGuidanceLaneGuidanceCollector()};

    public NavMapTileNotifierModel() {
        this.logger = new MapTileLogger(256, "[NavMapTileNotifierModel]");
    }

    public void notifyHeadingValueChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyHeadingValueChanged(heading=").append(n).append(" )").log();
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(1369921536, n);
    }

    public void notifyZoomValueChanged(int n) {
        AbstractASLHsmTarget.writeIntegerToDatapool(1403475968, n);
    }

    public void notifyAutozoom(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyAutozoom(state=").append(bl).append(" )").log();
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(1722243072, bl);
    }

    public void notifyAltitudeValueChanged(int n) {
        AbstractASLHsmTarget.writeIntegerToDatapool(1487362048, n);
    }

    public void notifyMapTypeChanged(int n) {
        AbstractASLHsmTarget.writeIntegerToDatapool(1604802560, n);
    }

    public void notifyLastMapTypeChanged(int n) {
        AbstractASLHsmTarget.writeIntegerToDatapool(1638356992, n);
    }

    public void notifyPerspectiveChanged(int n) {
        int n2 = 0;
        if (n == 3) {
            return;
        }
        if (n == 5) {
            n2 = 0;
        } else if (n == 4) {
            n2 = 1;
        } else if (n == 6) {
            n2 = 3;
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(1470584832, n2);
    }

    public void notifySpeedCameraWarningDefault() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1520916480, false);
    }

    public void notifySpeedCameraWarning(boolean bl) {
        if (bl) {
            this.notifySpeedCameraWarningTrue();
        } else {
            this.notifySpeedCameraWarningFalse();
        }
    }

    private void notifySpeedCameraWarningTrue() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1520916480, true);
    }

    private void notifySpeedCameraWarningFalse() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1520916480, false);
    }

    public void updateCollectorVZAVZEIconsToDefaults() {
        this.iconsCollector[0].setAdditionalIconActive(false);
        this.iconsCollector[0].setAdditionalIconString("");
        this.iconsCollector[0].setMainIconActive(false);
        this.iconsCollector[0].setMainIconString("");
        this.iconsCollector[0].setSpeedIconActive(false);
        this.iconsCollector[0].setSpeedIconString("");
    }

    public void updateCollectorVZAVZEIcons(IGuidanceVZAVZEIcons[] iGuidanceVZAVZEIconsArray) {
        this.iconsCollector = new NavMapTileGuidanceVZEVZAIconsCollector[iGuidanceVZAVZEIconsArray.length];
        for (int i2 = 0; i2 < iGuidanceVZAVZEIconsArray.length; ++i2) {
            this.iconsCollector[i2] = new NavMapTileGuidanceVZEVZAIconsCollector();
            this.iconsCollector[i2].setAdditionalIconActive(iGuidanceVZAVZEIconsArray[i2].getAdditionalIconActive());
            this.iconsCollector[i2].setAdditionalIconString(iGuidanceVZAVZEIconsArray[i2].getAdditionalIcon());
            this.iconsCollector[i2].setMainIconActive(iGuidanceVZAVZEIconsArray[i2].getMainIconActive());
            this.iconsCollector[i2].setMainIconString(iGuidanceVZAVZEIconsArray[i2].getMainIcon());
            this.iconsCollector[i2].setSpeedIconActive(iGuidanceVZAVZEIconsArray[i2].getSpeedIconActive());
            this.iconsCollector[i2].setSpeedIconString(iGuidanceVZAVZEIconsArray[i2].getSpeedIcon());
        }
        this.updateListVZAVZEIcons();
    }

    public void updateListVZAVZEIcons() {
        try {
            ListManager.getGenericASLList(1571248128).updateList(this.iconsCollector);
        }
        catch (NullPointerException nullPointerException) {
            this.logger.makeInfo().append("***NullPointerException Caught!!***").log();
            for (int i2 = 0; i2 < this.iconsCollector.length; ++i2) {
                this.logger.makeInfo().append(this.iconsCollector[i2].toString()).log();
            }
        }
    }

    public void updateCollectorLaneGuidanceToDefaults() {
        this.laneGuidanceCollector[0].navmaptile_guidance_lane_guidance_direction = ASLNavMapTileGuidancePropertyManager.LANE_GUIDANCE__LANE_GUIDANCE_DIRECTION__DEFAULT_VALUE;
        this.laneGuidanceCollector[0].navmaptile_guidance_lane_guidance_info = ASLNavMapTileGuidancePropertyManager.LANE_GUIDANCE__LANE_GUIDANCE_INFO__DEFAULT_VALUE;
        this.laneGuidanceCollector[0].navmaptile_guidance_lane_guidance_is_data_valid = false;
        this.laneGuidanceCollector[0].navmaptile_guidance_lane_guidance_lane_marking_left = ASLNavMapTileGuidancePropertyManager.LANE_GUIDANCE__LANE_GUIDANCE_LANE_MARKING_LEFT__DEFAULT_VALUE;
        this.laneGuidanceCollector[0].navmaptile_guidance_lane_guidance_lane_marking_right = ASLNavMapTileGuidancePropertyManager.LANE_GUIDANCE__LANE_GUIDANCE_LANE_MARKING_RIGHT__DEFAULT_VALUE;
    }

    public void updateCollectorLaneGuidance(IGuidanceLaneGuidance[] iGuidanceLaneGuidanceArray) {
        this.laneGuidanceCollector = new NavMapTileGuidanceLaneGuidanceCollector[iGuidanceLaneGuidanceArray.length];
        for (int i2 = 0; i2 < iGuidanceLaneGuidanceArray.length; ++i2) {
            this.laneGuidanceCollector[i2] = new NavMapTileGuidanceLaneGuidanceCollector();
            this.laneGuidanceCollector[i2].navmaptile_guidance_lane_guidance_direction = iGuidanceLaneGuidanceArray[i2].getLGDirection();
            this.laneGuidanceCollector[i2].navmaptile_guidance_lane_guidance_info = iGuidanceLaneGuidanceArray[i2].getLGInfo();
            this.laneGuidanceCollector[i2].navmaptile_guidance_lane_guidance_is_data_valid = iGuidanceLaneGuidanceArray[i2].getLGisDataValid();
            this.laneGuidanceCollector[i2].navmaptile_guidance_lane_guidance_lane_marking_left = iGuidanceLaneGuidanceArray[i2].getLGMarkingLeft();
            this.laneGuidanceCollector[i2].navmaptile_guidance_lane_guidance_lane_marking_right = iGuidanceLaneGuidanceArray[i2].getLGMarkingRight();
        }
        this.updateListLaneGuidance();
    }

    public void updateListLaneGuidance() {
        ListManager.getGenericASLList(1537693696).updateList(this.laneGuidanceCollector);
    }

    public void notifyOverviewOn() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1420253184, true);
    }

    public void notifyOverviewOff() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1420253184, false);
    }

    public void notifyNavNotReady() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1655134208, false);
    }

    public void notifyNavReady() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1655134208, true);
    }

    public void notifyTrafficSignAnnouncementOff() {
        ServiceManager.aslPropertyManager.valueChangedInteger(1554470912, 0);
    }

    public void notifyTrafficSignAnnouncementOn() {
        ServiceManager.aslPropertyManager.valueChangedInteger(1554470912, 1);
    }

    public void notifyGoogleEarthDataStatusChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1671911424, n);
    }

    public void notifyMapSwitchRunningChanged(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1621579776, bl);
    }
}

