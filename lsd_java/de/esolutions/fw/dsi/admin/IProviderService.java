/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.admin;

import de.esolutions.fw.dsi.comm.IDSIServiceWorker;

public interface IProviderService {
    default public boolean checkAndClearStopFlag(String string, int n) {
    }

    default public void stopServiceWorker(IDSIServiceWorker iDSIServiceWorker) {
    }
}

