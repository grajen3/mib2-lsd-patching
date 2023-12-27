/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup;

import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSetupHsmTarget;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSignsSetupDatapool;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSignsSetupNotifierDSI;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSignsSetupNotifierModel;

public class JPNWarningSignsSetupHandling {
    private JPNWarningSignsSetupNotifierDSI jpnWarningSignsNotifierDSI;
    private JPNWarningSignsSetupNotifierModel jpnWarningSignsNotifierModel;
    private JPNWarningSignsSetupDatapool jpnWarningSignsDatapool;
    JPNWarningSetupHsmTarget target;

    public JPNWarningSignsSetupHandling(JPNWarningSetupHsmTarget jPNWarningSetupHsmTarget) {
        this.target = jPNWarningSetupHsmTarget;
        this.jpnWarningSignsNotifierDSI = new JPNWarningSignsSetupNotifierDSI(jPNWarningSetupHsmTarget);
        this.jpnWarningSignsNotifierModel = new JPNWarningSignsSetupNotifierModel();
        this.jpnWarningSignsDatapool = new JPNWarningSignsSetupDatapool();
    }

    public void notifyMergingTrafficChanged(boolean bl) {
        this.target.traceState(new StringBuffer("JPNWarningSignsSetupHandling.notifyMergingTrafficChanged: ").append(bl).toString());
        this.jpnWarningSignsNotifierModel.notifyMergingTrafficActiveChanged(bl);
        if (bl) {
            this.jpnWarningSignsNotifierDSI.enableMergingTraffic();
        } else {
            this.jpnWarningSignsNotifierDSI.disableMergingTraffic();
        }
        this.jpnWarningSignsDatapool.setMergingTraffic(bl);
    }

    public void notifyRailwayCrossingChanged(boolean bl) {
        this.target.traceState(new StringBuffer("JPNWarningSignsSetupHandling.notifyRailwayCrossingChanged: ").append(bl).toString());
        this.jpnWarningSignsNotifierModel.notifyRailwayCrossingActiveChanged(bl);
        if (bl) {
            this.jpnWarningSignsNotifierDSI.enableRailwayCrossing();
        } else {
            this.jpnWarningSignsNotifierDSI.disableRailwayCrossing();
        }
        this.jpnWarningSignsDatapool.setRailwayCrossing(bl);
    }

    public void notifyReduceLaneChanged(boolean bl) {
        this.target.traceState(new StringBuffer("JPNWarningSignsSetupHandling.notifyReduceLaneChanged: ").append(bl).toString());
        this.jpnWarningSignsNotifierModel.notifyReduceLaneActiveChanged(bl);
        if (bl) {
            this.jpnWarningSignsNotifierDSI.enableReduceLanes();
        } else {
            this.jpnWarningSignsNotifierDSI.disableReduceLanes();
        }
        this.jpnWarningSignsDatapool.setReduceLane(bl);
    }

    public void notifySpeedCameraWarningTypeChanged(int n) {
        this.target.traceState(new StringBuffer("JPNWarningSignsSetupHandling.notifySpeedCameraWarningTypeChanged: ").append(n).toString());
        this.jpnWarningSignsNotifierModel.notifySpeedCameraWarningTypeChanged(n);
        this.setDSISpeedCameraWarningTypeSwitch(n);
        this.jpnWarningSignsDatapool.setSpeedCameraWarningSignType(n);
    }

    private void setDSISpeedCameraWarningTypeSwitch(int n) {
        switch (n) {
            case 0: {
                this.jpnWarningSignsNotifierDSI.disableSpeedCamera();
                break;
            }
            case 1: {
                this.jpnWarningSignsNotifierDSI.muteSpeedCamera();
                break;
            }
            case 2: {
                this.jpnWarningSignsNotifierDSI.enableSpeedCamera();
                break;
            }
        }
    }

    public void initWarningMenu() {
        this.target.traceState("JPNWarningSignsSetupHandling.initWarningMenu");
        this.notifyMergingTrafficChanged(this.jpnWarningSignsDatapool.isMergingTraffic());
        this.notifyRailwayCrossingChanged(this.jpnWarningSignsDatapool.isRailwayCrossing());
        this.notifyReduceLaneChanged(this.jpnWarningSignsDatapool.isReduceLane());
        this.notifySpeedCameraWarningTypeChanged(this.jpnWarningSignsDatapool.getSpeedCameraWarningType());
    }

    public void notifyWarningSignsEnableDisable(boolean bl) {
        this.target.traceState(new StringBuffer("JPNWarningSignsSetupHandling.notifyWarningSignsEnableDisable: ").append(bl).toString());
        if (!bl) {
            this.jpnWarningSignsNotifierDSI.disableMergingTraffic();
            this.jpnWarningSignsNotifierDSI.disableRailwayCrossing();
            this.jpnWarningSignsNotifierDSI.disableReduceLanes();
        } else {
            if (this.jpnWarningSignsDatapool.isMergingTraffic()) {
                this.jpnWarningSignsNotifierDSI.enableMergingTraffic();
            }
            if (this.jpnWarningSignsDatapool.isRailwayCrossing()) {
                this.jpnWarningSignsNotifierDSI.enableRailwayCrossing();
            }
            if (this.jpnWarningSignsDatapool.isReduceLane()) {
                this.jpnWarningSignsNotifierDSI.enableReduceLanes();
            }
        }
        this.jpnWarningSignsNotifierModel.notifyWarningsEnabledDisabled(bl);
    }
}

