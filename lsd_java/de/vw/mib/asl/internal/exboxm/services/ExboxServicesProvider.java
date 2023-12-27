/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.services;

import de.vw.mib.asl.internal.exboxm.services.ExboxServices;
import de.vw.mib.asl.internal.exboxm.services.ExboxServicesImpl;

public final class ExboxServicesProvider {
    private static ExboxServices services;

    public static ExboxServices getExBoxServices() {
        if (services == null) {
            services = new ExboxServicesImpl();
        }
        return services;
    }

    public static void setExBoxServices(ExboxServices exboxServices) {
        services = exboxServices;
    }
}

