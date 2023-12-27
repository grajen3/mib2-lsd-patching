/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

import de.vw.mib.asl.internal.impl.system.ddp.DdpFrameworkNotifier;
import de.vw.mib.asl.internal.impl.system.ddp.DdpFrameworkNotifierInstaller;
import de.vw.mib.asl.internal.impl.system.ddp.DdpFrameworkNotifierInstaller$1;
import de.vw.mib.driverdistractionprevention.DriverDistractionPreventionHandler;

class DdpFrameworkNotifierInstaller$1$1
implements Runnable {
    private final /* synthetic */ DriverDistractionPreventionHandler val$service;
    private final /* synthetic */ DdpFrameworkNotifierInstaller$1 this$1;

    DdpFrameworkNotifierInstaller$1$1(DdpFrameworkNotifierInstaller$1 ddpFrameworkNotifierInstaller$1, DriverDistractionPreventionHandler driverDistractionPreventionHandler) {
        this.this$1 = ddpFrameworkNotifierInstaller$1;
        this.val$service = driverDistractionPreventionHandler;
    }

    @Override
    public void run() {
        DdpFrameworkNotifierInstaller.access$100(DdpFrameworkNotifierInstaller$1.access$000(this.this$1)).addDriverDistractionPreventionListener(new DdpFrameworkNotifier(this.val$service));
    }
}

