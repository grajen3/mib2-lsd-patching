/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system;

import de.vw.mib.asl.api.system.systemstate.SystemStateService;
import de.vw.mib.asl.internal.impl.system.SystemServicesImpl;
import de.vw.mib.asl.internal.impl.system.SystemServicesProvider;

public class SystemServicesInstaller {
    public void installSystemStateService(SystemStateService systemStateService) {
        SystemServicesImpl systemServicesImpl = (SystemServicesImpl)SystemServicesProvider.getSystemServices();
        systemServicesImpl.setSystemStateService(systemStateService);
    }
}

