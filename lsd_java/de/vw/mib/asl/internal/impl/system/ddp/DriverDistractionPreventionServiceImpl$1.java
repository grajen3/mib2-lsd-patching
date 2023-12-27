/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

import de.vw.mib.asl.api.system.DriverDistractionPreventionThresholdListener;
import de.vw.mib.asl.internal.impl.system.ddp.DriverDistractionPreventionServiceImpl;

class DriverDistractionPreventionServiceImpl$1
implements Runnable {
    private final /* synthetic */ DriverDistractionPreventionThresholdListener val$listener;
    private final /* synthetic */ boolean val$isDdpRequired;
    private final /* synthetic */ DriverDistractionPreventionServiceImpl this$0;

    DriverDistractionPreventionServiceImpl$1(DriverDistractionPreventionServiceImpl driverDistractionPreventionServiceImpl, DriverDistractionPreventionThresholdListener driverDistractionPreventionThresholdListener, boolean bl) {
        this.this$0 = driverDistractionPreventionServiceImpl;
        this.val$listener = driverDistractionPreventionThresholdListener;
        this.val$isDdpRequired = bl;
    }

    @Override
    public void run() {
        this.val$listener.onDriverDistractionPreventionRequired(this.val$isDdpRequired);
    }
}

