/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife.common;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public class NoVideoAvailableHandler
implements Runnable {
    @Override
    public void run() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1248275456);
    }
}

