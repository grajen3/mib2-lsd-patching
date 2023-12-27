/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.vza.HsmTargetVZA;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;

public class VZAHandlingJPN {
    protected HsmTargetVZA target;

    public VZAHandlingJPN(HsmTargetVZA hsmTargetVZA) {
        this.target = hsmTargetVZA;
    }

    public int[] getWarningSigns(TrafficSignInformation trafficSignInformation) {
        int[] nArray = new int[]{trafficSignInformation.warningSignOne, trafficSignInformation.warningSignTwo, trafficSignInformation.warningSignThree};
        if (!this.containsSpeedCameraWarningSign(trafficSignInformation)) {
            this.stopDisplayWarningIcon();
        } else {
            this.displayWarningIcon();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                nArray[i2] = this.replaceSpeedCameraSignWithNoSign(nArray[i2]);
            }
        }
        return nArray;
    }

    private int replaceSpeedCameraSignWithNoSign(int n) {
        return this.isSpeedCameraWarningSign(n) ? 0 : n;
    }

    private boolean containsSpeedCameraWarningSign(TrafficSignInformation trafficSignInformation) {
        return this.isSpeedCameraWarningSign(trafficSignInformation.warningSignOne) || this.isSpeedCameraWarningSign(trafficSignInformation.warningSignTwo) || this.isSpeedCameraWarningSign(trafficSignInformation.warningSignThree);
    }

    private boolean isSpeedCameraWarningSign(int n) {
        return n >= 618 && n <= 683;
    }

    private void displayWarningIcon() {
        this.target.traceState("displayWarningIcon");
        ServiceManager.aslPropertyManager.valueChangedBoolean(1592791040, true);
        this.target.getGuidanceAPINotifier().sendEvSpeedCameraIconUpdate(true);
    }

    public void stopDisplayWarningIcon() {
        this.target.traceState("stopDisplayWarningIcon");
        ServiceManager.aslPropertyManager.valueChangedBoolean(1592791040, false);
        this.target.getGuidanceAPINotifier().sendEvSpeedCameraIconUpdate(false);
    }
}

