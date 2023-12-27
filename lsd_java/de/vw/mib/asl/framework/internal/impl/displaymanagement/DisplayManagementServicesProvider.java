/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.displaymanagement;

import de.vw.mib.asl.framework.internal.displaymanagement.DisplayManagementServices;
import de.vw.mib.asl.framework.internal.impl.displaymanagement.DisplayManagementServicesImpl;

public class DisplayManagementServicesProvider {
    private static DisplayManagementServices services;

    public static DisplayManagementServices getServices() {
        if (services == null) {
            services = new DisplayManagementServicesImpl();
        }
        return services;
    }

    public static void setServices(DisplayManagementServices displayManagementServices) {
        services = displayManagementServices;
    }
}

