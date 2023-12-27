/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public class JPNWarningSignsSetupNotifierModel {
    public void notifyMergingTrafficActiveChanged(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1192226816, bl);
    }

    public void notifyRailwayCrossingActiveChanged(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1209004032, bl);
    }

    public void notifyReduceLaneActiveChanged(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1175449600, bl);
    }

    public void notifySpeedCameraWarningTypeChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(-1225781248, n);
    }

    public void notifyWarningsEnabledDisabled(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(2146439168, bl);
    }
}

