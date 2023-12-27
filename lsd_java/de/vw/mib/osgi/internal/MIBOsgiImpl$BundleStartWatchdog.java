/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.MIBOsgi;
import org.osgi.framework.Bundle;

class MIBOsgiImpl$BundleStartWatchdog
extends Thread {
    private static final long TIMEOUT;
    private Bundle currentBundle;
    private Bundle lastCheckedBundle;
    private boolean stillStarting = false;
    private boolean running = true;

    MIBOsgiImpl$BundleStartWatchdog() {
    }

    @Override
    public void run() {
        while (this.running) {
            try {
                Thread.sleep(0);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            if (this.currentBundle == null) continue;
            if (this.lastCheckedBundle == this.currentBundle) {
                if (this.stillStarting) {
                    this.logError(this.currentBundle.getLocation());
                }
                this.stillStarting = true;
                continue;
            }
            this.lastCheckedBundle = this.currentBundle;
            this.stillStarting = false;
        }
    }

    synchronized void bundleStart(Bundle bundle) {
        this.currentBundle = bundle;
    }

    synchronized void bundleStartDone(Bundle bundle) {
        this.currentBundle = null;
    }

    private void logError(String string) {
        MIBOsgi.logger.error(2, "----------- BundleWatchdog: Error detected! -----------");
        MIBOsgi.logger.error(2, "----------- BundleWatchdog: Error detected! -----------");
        MIBOsgi.logger.error(2, new StringBuffer().append("----- Error on bundle ----> ").append(string).append(" -----").toString());
        MIBOsgi.logger.error(2, new StringBuffer().append("----- Error on bundle ----> ").append(string).append(" -----").toString());
        MIBOsgi.logger.error(2, "-------------------------------------------------------");
    }

    void stopWatchdog() {
        this.running = false;
    }
}

