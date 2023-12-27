/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.startup.internal;

import de.vw.mib.startup.internal.ServiceManager;
import de.vw.mib.startup.internal.StartupManager;
import org.osgi.framework.BundleException;

class StartupManager$1
implements Runnable {
    private final /* synthetic */ StartupManager this$0;

    StartupManager$1(StartupManager startupManager) {
        this.this$0 = startupManager;
    }

    @Override
    public void run() {
        try {
            this.this$0.mibOsgi.startLateloadBundles();
        }
        catch (BundleException bundleException) {
            StartupManager.logger.error(4, "Error while starting lateload bundles!", bundleException);
        }
        ServiceManager.startupEventDispatcher.createAndSubmitStartupEvent(9);
    }
}

