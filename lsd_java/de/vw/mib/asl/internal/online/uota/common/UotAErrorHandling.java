/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.common;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public class UotAErrorHandling {
    private final String _classname = super.getClass().getName();

    public boolean checkUotAResult(int n) {
        boolean bl = false;
        switch (n) {
            case 0: {
                bl = true;
                break;
            }
            case 1: {
                this.sendResultFailure(1);
                break;
            }
            case 2: {
                this.sendResultFailure(2);
                break;
            }
            case 3: {
                this.sendResultFailure(3);
                break;
            }
            case 4: {
                this.sendResultFailure(4);
                break;
            }
        }
        return bl;
    }

    public void sendResultFailure(int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".sendResultFailure()-> ERROR").log();
        }
        int n2 = 0;
        switch (n) {
            case 1: {
                n2 = 956109568;
                break;
            }
            case 2: {
                n2 = 956109568;
                break;
            }
            case 3: {
                n2 = 956109568;
                break;
            }
            case 4: {
                n2 = 956109568;
                break;
            }
        }
        if (n2 > 0) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n2);
        }
    }

    public void sendDownloadFailure(int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".sendDownloadFailure()-> ERROR").log();
        }
        int n2 = 0;
        switch (n) {
            case 3: {
                break;
            }
            case 10: {
                n2 = 939332352;
                break;
            }
            case 11: {
                n2 = 939332352;
                break;
            }
            case 12: {
                n2 = 939332352;
                break;
            }
            case 13: {
                n2 = 939332352;
                break;
            }
        }
        if (n2 > 0) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n2);
        }
    }
}

