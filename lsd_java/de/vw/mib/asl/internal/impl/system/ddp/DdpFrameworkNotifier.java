/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

import de.vw.mib.asl.api.system.DriverDistractionPreventionThresholdListener;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.driverdistractionprevention.DriverDistractionPreventionHandler;

public class DdpFrameworkNotifier
implements DriverDistractionPreventionThresholdListener {
    private final DriverDistractionPreventionHandler ddpFrameworkListener;

    public DdpFrameworkNotifier(DriverDistractionPreventionHandler driverDistractionPreventionHandler) {
        Preconditions.checkArgumentNotNull(driverDistractionPreventionHandler, "DDP framework listener must not be null!");
        this.ddpFrameworkListener = driverDistractionPreventionHandler;
    }

    @Override
    public void onDriverDistractionPreventionRequired(boolean bl) {
        if (bl) {
            this.ddpFrameworkListener.onThresholdExceeded();
        } else {
            this.ddpFrameworkListener.onThresholdClear();
        }
    }
}

