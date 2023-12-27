/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup;

import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSetupHsmTarget;

public class JPNWarningSignsSetupNotifierDSI {
    protected JPNWarningSetupHsmTarget target;

    public JPNWarningSignsSetupNotifierDSI(JPNWarningSetupHsmTarget jPNWarningSetupHsmTarget) {
        this.target = jPNWarningSetupHsmTarget;
    }

    public void enableMergingTraffic() {
        this.target.jpnWarningSetupServices.getDsiTrafficRegulation().setWarningStatus(4, true, true, 0);
    }

    public void disableMergingTraffic() {
        this.target.jpnWarningSetupServices.getDsiTrafficRegulation().setWarningStatus(4, false, false, 0);
    }

    public void enableRailwayCrossing() {
        this.target.jpnWarningSetupServices.getDsiTrafficRegulation().setWarningStatus(2, true, true, 0);
    }

    public void disableRailwayCrossing() {
        this.target.jpnWarningSetupServices.getDsiTrafficRegulation().setWarningStatus(2, false, false, 0);
    }

    public void enableReduceLanes() {
        this.target.jpnWarningSetupServices.getDsiTrafficRegulation().setWarningStatus(3, true, true, 0);
    }

    public void disableReduceLanes() {
        this.target.jpnWarningSetupServices.getDsiTrafficRegulation().setWarningStatus(3, false, false, 0);
    }

    public void enableSpeedCamera() {
        this.target.jpnWarningSetupServices.getDsiTrafficRegulation().setWarningStatus(6, true, true, 0);
    }

    public void disableSpeedCamera() {
        this.target.jpnWarningSetupServices.getDsiTrafficRegulation().setWarningStatus(6, false, false, 0);
    }

    public void muteSpeedCamera() {
        this.target.jpnWarningSetupServices.getDsiTrafficRegulation().setWarningStatus(6, true, false, 0);
    }
}

