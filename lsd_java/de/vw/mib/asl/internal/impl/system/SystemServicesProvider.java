/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system;

import de.vw.mib.asl.internal.impl.system.SystemServicesImpl;
import de.vw.mib.asl.internal.system.SystemServices;

public final class SystemServicesProvider {
    private static SystemServices systemServices;

    private SystemServicesProvider() {
    }

    public static SystemServices getSystemServices() {
        if (systemServices == null) {
            systemServices = new SystemServicesImpl();
        }
        return systemServices;
    }

    public static void setSystemServices(SystemServices systemServices) {
        SystemServicesProvider.systemServices = systemServices;
    }
}

