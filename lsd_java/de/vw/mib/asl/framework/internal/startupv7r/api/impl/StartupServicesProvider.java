/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.api.impl;

import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.api.impl.StartupServicesImpl;

public final class StartupServicesProvider {
    private static StartupServices services;

    private StartupServicesProvider() {
    }

    public static StartupServices getStartupServices() {
        if (services == null) {
            services = new StartupServicesImpl();
        }
        return services;
    }

    public static void setStartupServices(StartupServices startupServices) {
        services = startupServices;
    }
}

