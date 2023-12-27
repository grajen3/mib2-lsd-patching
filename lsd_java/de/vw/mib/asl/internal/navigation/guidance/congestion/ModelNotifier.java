/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.congestion;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public class ModelNotifier {
    public void notifyCongestionDefined(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(816, bl);
    }

    public void notifyCongestionAheadLength(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(2322, n);
    }

    public void notifyNaviCoreReadyForBlock(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3005, bl);
    }

    public void notifyCongestionAheadLengthKmValue(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(3150, n);
    }
}

