/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.DriverDistractionPreventionThresholdListener;

public class DdpGetterNhtsaSpeedLimitExceeded
implements DriverDistractionPreventionThresholdListener {
    private final ASLPropertyManager aslPropertyManager;

    public DdpGetterNhtsaSpeedLimitExceeded(ASLPropertyManager aSLPropertyManager) {
        this.aslPropertyManager = aSLPropertyManager;
    }

    @Override
    public void onDriverDistractionPreventionRequired(boolean bl) {
        this.aslPropertyManager.valueChangedBoolean(1261576192, bl);
    }
}

