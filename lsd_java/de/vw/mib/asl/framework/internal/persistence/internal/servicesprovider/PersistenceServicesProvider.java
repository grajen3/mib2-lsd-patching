/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider;

import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServicesImpl;

public class PersistenceServicesProvider {
    private static PersistenceServices persistenceServices;

    private PersistenceServicesProvider() {
    }

    public static PersistenceServices getPersistenceServices() {
        if (persistenceServices == null) {
            persistenceServices = new PersistenceServicesImpl();
        }
        return persistenceServices;
    }

    public static void setPersistenceServices(PersistenceServices persistenceServices) {
        PersistenceServicesProvider.persistenceServices = persistenceServices;
    }
}

