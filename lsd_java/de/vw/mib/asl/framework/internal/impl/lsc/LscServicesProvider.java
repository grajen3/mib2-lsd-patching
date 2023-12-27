/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.lsc;

import de.vw.mib.asl.framework.internal.impl.lsc.LscServicesImpl;
import de.vw.mib.asl.framework.internal.lsc.LscServices;

public final class LscServicesProvider {
    private static LscServices services;

    private LscServicesProvider() {
    }

    public static LscServices getLscServices() {
        if (services == null) {
            services = new LscServicesImpl();
        }
        return services;
    }

    public static void setLscServices(LscServices lscServices) {
        services = lscServices;
    }
}

