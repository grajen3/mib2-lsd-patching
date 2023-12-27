/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.entertainmentmanager.contextlistener;

import de.vw.mib.asl.framework.api.entertainmentmanager.contextlistener.EntertainmentContextListener;

public interface EntertainmentContextListenerService {
    default public void registerEntertainmentContextListener(EntertainmentContextListener entertainmentContextListener) {
    }

    default public void unregisterEntertainmentContextListener(EntertainmentContextListener entertainmentContextListener) {
    }
}

